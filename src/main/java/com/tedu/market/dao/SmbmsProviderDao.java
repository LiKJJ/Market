package com.tedu.market.dao;

import com.tedu.market.pojo.SmbmsProvider;

import java.util.List;
import java.util.Map;

public interface SmbmsProviderDao {

    /**
     * 通过id获取供应商详情；包括了订单信息
     * @param id
     * @return
     */
    public SmbmsProvider getProviderById(int id);

    /**
     * 分页获取
     * @return
     */
    List<SmbmsProvider> getProviderByNOSize(Map<String ,Integer> map);

    /**
     * 获取数目
     * @return
     */
    int getCount();

    /**
     * 通过供应商名称，编码  查询
     * @param smbmsProvider
     * @return
     */
    List<SmbmsProvider> getProviderByProvider(SmbmsProvider smbmsProvider);

    int getCountByProvider(SmbmsProvider smbmsProvider);
}
