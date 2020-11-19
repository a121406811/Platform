package com.example.api.service;

import com.example.api.dao.ApiUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class ApiUserServiceImpl {
    // 正经的业务代码
    public ApiUser getUserByUserName(String userName){
        if(userList == null){
            return null;
        }
        ApiUser user = userList.get(userName);
        return user;
    }

    // 用来模拟数据库的一个Map
    private static Map<String,ApiUser> userList;


    public ApiUserServiceImpl(){
        initUserList();
    }


    private String password = new BCryptPasswordEncoder().encode("123456");
    /**
     * 模拟数据库用户
     * */
    private void initUserList(){
        if (userList == null){
            userList = new HashMap<>(3);
            userList.put("admin",new ApiUser(1,"admin",password,"管理员"
                    , Arrays.asList("admin"),Arrays.asList("p1","p2","p3")));
            userList.put("cuntian",new ApiUser(2,"cuntian",password,"cuntian"
                    , Arrays.asList("CUNTIAN"),Arrays.asList("p1","p2")));
            userList.put("liangpan",new ApiUser(3,"liangpan",password,"梁攀"
                    , Arrays.asList("LIANGPAN"),Arrays.asList("p3","p2")));
        }
    }
}
