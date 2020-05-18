package com.hjx.system.service;

import com.hjx.common.model.GetEasyUIData;
import com.hjx.common.model.Result;
import com.hjx.system.model.User;
import com.hjx.system.model.UserAddModel;
import com.hjx.system.model.UserPage;
import com.hjx.system.model.UserRole;
import com.hjx.system.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User selectByPrimaryKey(String id);

    void insertUser(UserAddModel muser);

    void updateUser(UserAddModel muser);

    void deleteUser(String[] id);

    void updatePassword(UserAddModel u);

    GetEasyUIData findTByPage(UserPage user);

    UserVO selectVOByPrimaryKey(String id);

    User findTByT(User user);

    void deleteByT(UserRole[] u);


}
