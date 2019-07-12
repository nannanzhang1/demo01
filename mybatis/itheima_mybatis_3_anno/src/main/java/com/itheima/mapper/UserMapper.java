package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from tab_user")
    public List<User> findAll();
    @Select("select * from tab_user where id=#{id}")
    public User findById(int id);
    @Insert("insert into tab_user values (#{id} ,#{username},#{password}")
    public void add(User user);
    @Delete("delete from tab_user where id=#{id}")
    public void delete(int id);
    @Update("update tab_user set id=#{id},username=#{username},password=#{password}")
    public void update(User user);

}
