package com.tedu.market.services;

import com.tedu.market.pojo.SmbmsProvider;

import java.util.List;

public interface ProviderServices {
    /**
     * 分页获取数据
     * @param no
     * @param size
     * @return
     */
    List<SmbmsProvider> getProviderByNoSize(int no, int size);

    /**
     * 获取供应商的数目
     * @return
     */
    int getCount();

    List<SmbmsProvider> getProviderByProvider(SmbmsProvider smbmsProvider);

    int getCountByProvider(SmbmsProvider smbmsProvider);

    SmbmsProvider getProvicesById(int id);

    int deleteById(int id);
}
