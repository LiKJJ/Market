package com.tedu.market.utill;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis的工具类
 */
public class MyBatisUtill {
    static  SqlSessionFactory sessionFactory;
    static {
        try {
            //加載mybatis的配置文件
            InputStream resourceAsStream = null;
            resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取mybatis的session对象
     * @return
     */
    public static SqlSession getSqlSession(){
        return sessionFactory.openSession();
    }

    public static void close(SqlSession sqlSession){
        sqlSession.close();
    }


}
