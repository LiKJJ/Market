package com.test;

import com.tedu.market.dao.SmbmsProviderDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ProviderTest {

    @Test
    public void testId() throws IOException {
        //加載mybatis的配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        SmbmsProviderDao mapper = sqlSession.getMapper(SmbmsProviderDao.class);

        System.out.println(mapper.getProviderById(1));

    }
}
