package com.example.api.service;

import com.example.api.dao.ApiUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 这个是配置用户详情查询的，用于查询用户，给security用的
 */
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {
    // 这个是我们自己的业务类，用来查数据库
    @Resource
    private ApiUserServiceImpl userService;

    /**
     * 这个方法是一定要重写的，spring security会根据页面传回来的用户名去查这个用户的权限和密码
     * */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ApiUser user = userService.getUserByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("账号不存在");
        }
        Set<String> authritiesSet = new HashSet<>(user.getPermissions().size() + user.getRoles().size());

        authritiesSet.addAll(user.getPermissions());
        // 这里需要注意，security里面角色和权限都是存在一个字段里面的，但是其角色会自动加上ROLE_前缀来将角色和权限进行区分，
        // 以便在进行判断是否有某角色时可以进行判断，但是我们一般使用是可以不用加前缀的，如@PreAuthorize("hasRole('role2')")，但是你加也没问题
        authritiesSet.addAll(user.getRoles().stream().map(role -> "ROLE_" + role).collect(Collectors.toList()));

        UserDetails userDetails = User.withUsername(user.getUserName())
                .password(user.getPassword())
                .authorities(authritiesSet.toArray(new String[authritiesSet.size()]))
                .build();
        return userDetails;
    }

}
