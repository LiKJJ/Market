package com.test;

import com.tedu.market.dao.SmbmsRoleDao;
import com.tedu.market.pojo.SmbmsRole;
import org.apache.ibatis.io.Resources;
import com.tedu.market.dao.SmbmsUserDao;
import com.tedu.market.pojo.SmbmsUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Test {

    @org.junit.Test
    public void roleById() throws IOException {
        //加載mybatis的配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        SmbmsRoleDao mapper = sqlSession.getMapper(SmbmsRoleDao.class);
        SmbmsRole roleById = mapper.getRoleById(3);
        System.out.println(roleById);

    }

    @org.junit.Test
    public  void getUserRoleByNAME() throws IOException {
        //加載mybatis的配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        SmbmsUserDao mapper = sqlSession.getMapper(SmbmsUserDao.class);
//        System.out.println(mapper.getRoleListByNameRole("张","3"));
        SmbmsUser user = new SmbmsUser();
        user.setUserName("张戈");
        user.setId(1);
        mapper.updateByUser(user);
        System.out.println(mapper.getUserByUser(user));
        sqlSession.commit();

    }
}
