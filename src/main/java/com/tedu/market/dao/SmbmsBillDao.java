package com.tedu.market.dao;

import com.tedu.market.pojo.SmbmsBill;

import java.util.List;
import java.util.Map;

public interface SmbmsBillDao {

    /**
     * 通过订单查询
     * @param smbmsBill
     * @return
     */
    public List<SmbmsBill> getBillByBill(SmbmsBill smbmsBill);


    List<SmbmsBill> getBillBySise(Map<String,Integer> map);
}
