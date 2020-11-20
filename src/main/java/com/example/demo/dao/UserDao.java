package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Insert("insert into t_user (id,userName,password,createDate)" +
            " values (#{id},#{userName},#{password},#{createDate})")
    public int insertUser(User user);

    @Select("select * from t_user where userName = #{userName}")
    List<User> getUserList(User user);
}
