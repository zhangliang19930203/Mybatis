package com.itcast.dao;

import com.itcast.domin.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*用户的持久性接口*/
public interface UserDao {
    /*查询所有操作*/
     /*  将UserDao中定义的接口使用注解
        @Select("select * from user")
          List<User> findAll();
        然后在mybatis主要配置文件中的<mappers 将resource 换成class>配置
       <mappers>  使用注解的话必须得这样写。UserDao.xml文件可以删除
        <mapper class="com.itcase.dao.UserDao"/>
      </mappers>
    */
    List<User> findAll();
}
