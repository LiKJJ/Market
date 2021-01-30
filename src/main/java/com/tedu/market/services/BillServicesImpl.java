package com.tedu.market.services;

import com.tedu.market.dao.SmbmsBillDao;
import com.tedu.market.pojo.SmbmsBill;
import com.tedu.market.utill.MyBatisUtill;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillServicesImpl implements BillServices {
    @Override
    public List<SmbmsBill> getAllBillBySize(int no, int size) {
        SqlSession sqlSession= MyBatisUtill.getSqlSession();
        SmbmsBillDao mapper=sqlSession.getMapper(SmbmsBillDao.class);
        Map<String,Integer> map=new HashMap<>();
        map.put("no",(no-1)*size);
        map.put("size",size);
        List<SmbmsBill> data=mapper.getBillBySise(map);
        MyBatisUtill.close(sqlSession);
        return data;
    }

    @Override
    public List<SmbmsBill> getBillByBill(SmbmsBill smbmsBill) {
        SqlSession sqlSession= MyBatisUtill.getSqlSession();
        SmbmsBillDao mapper=sqlSession.getMapper(SmbmsBillDao.class);
        List<SmbmsBill> data=mapper.getBillByBill(smbmsBill);
        MyBatisUtill.close(sqlSession);
        return data;
    }
}
