package com.tlias.mapper;

import com.tlias.pojo.emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
@Mapper

public interface EmpMapper {

//    @Select("select count(*) from emp")
//    public long count();
//
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<emp> page(Integer start, Integer pageSize);

//    @Select("select * from emp where name like concat('%', #{}, '%')")
    public List<emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);


    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
            void add(emp emp1);

    @Select("select * from emp where id = #{id}")
    emp getById(Integer id);

    void update(emp emp1);


    @Select("select * from emp where username = #{username} and password = #{password}")
    emp getByUsernameandPassword(emp emp1);

    @Delete("delete from emp where dept_id = #{id}")
    void deleteByDeptId(Integer id);
}
