package com.test;

import com.tedu.market.dao.SmbmsRoleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class RoleTest {
    @Test
    public void role() throws IOException {
        //加載mybatis的配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        SmbmsRoleDao mapper = sqlSession.getMapper(SmbmsRoleDao.class);
        System.out.println(mapper.getRoleById(1));

    }
}
