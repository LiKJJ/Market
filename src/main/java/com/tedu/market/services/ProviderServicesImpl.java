package com.tedu.market.services;

import com.tedu.market.dao.SmbmsProviderDao;
import com.tedu.market.dao.SmbmsUserDao;
import com.tedu.market.pojo.SmbmsProvider;
import com.tedu.market.utill.MyBatisUtill;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商接口实现类
 */
public class ProviderServicesImpl implements ProviderServices {
    @Override
    public List<SmbmsProvider> getProviderByNoSize(int no, int size) {
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsProviderDao mapper = sqlSession.getMapper(SmbmsProviderDao.class);

        Map<String ,Integer> map = new HashMap<>();
        map.put("no",(no-1)*size);
        map.put("size",size);
        List<SmbmsProvider> data = mapper.getProviderByNOSize(map);
        MyBatisUtill.close(sqlSession);

        return data;
    }
    @Override
    public int getCount() {
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsProviderDao mapper = sqlSession.getMapper(SmbmsProviderDao.class);
        int count = mapper.getCount();
        MyBatisUtill.close(sqlSession);
        return count;
    }
    @Override
    public List<SmbmsProvider> getProviderByProvider(SmbmsProvider smbmsProvider) {
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsProviderDao mapper = sqlSession.getMapper(SmbmsProviderDao.class);
        List<SmbmsProvider> data = mapper.getProviderByProvider(smbmsProvider);
        MyBatisUtill.close(sqlSession);
        return data;
    }
    @Override
    public int getCountByProvider(SmbmsProvider smbmsProvider) {
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsProviderDao mapper = sqlSession.getMapper(SmbmsProviderDao.class);
        int data = mapper.getCountByProvider(smbmsProvider);
        MyBatisUtill.close(sqlSession);
        return data;
    }
    @Override
    public SmbmsProvider getProvicesById(int id) {
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsProviderDao mapper = sqlSession.getMapper(SmbmsProviderDao.class);
        SmbmsProvider provider=mapper.getProviderById(id);
        MyBatisUtill.close(sqlSession);
        return provider;
    }
    @Override
    public int deleteById(int id) {
        //调用dao层方法
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsUserDao mapper = sqlSession.getMapper(SmbmsUserDao.class);
       int res= mapper.deleteById(id);
       sqlSession.commit();
        MyBatisUtill.close(sqlSession);
        return res;
    }

}
