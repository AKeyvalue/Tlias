package com.tlias.mapper;


import com.tlias.pojo.dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<dept> list();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime}, #{updateTime})")
    void insert(dept dept1);

    @Select("select * from dept where id = #{id}")
    dept selectDept(Integer id);

    @Update("update dept set name = #{name} where id = #{id}")

    void updateDept(dept dept2);
}
