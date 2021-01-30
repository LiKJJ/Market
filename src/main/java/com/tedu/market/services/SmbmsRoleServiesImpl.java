package com.tedu.market.services;

import com.tedu.market.dao.SmbmsRoleDao;
import com.tedu.market.pojo.SmbmsRole;
import com.tedu.market.utill.MyBatisUtill;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 用户角色模块
 */
public class SmbmsRoleServiesImpl implements SmbmsRoleServies {
    @Override
    public List<SmbmsRole> getAllRole() {
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsRoleDao mapper = sqlSession.getMapper(SmbmsRoleDao.class);
        List<SmbmsRole> allRoleListe = mapper.getAllRoleListe();
        MyBatisUtill.close(sqlSession);
        return allRoleListe;
    }
}
