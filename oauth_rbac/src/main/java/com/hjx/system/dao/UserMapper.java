package com.hjx.system.dao;

import java.util.List;

import com.hjx.system.model.User;
import com.hjx.system.model.UserAddModel;
import com.hjx.system.model.UserPage;
import com.hjx.system.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<User> findTByPage(UserPage user);

    int findTCountByT(UserPage user);

    void deleteBy(String[] id);

    User findTByT(User user);

    User findTByTOne(User user);

    void updateNoPasswordByPrimaryKey(UserAddModel user);

    UserVO selectVOByPrimaryKey(String id);


}