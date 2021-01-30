package com.tedu.market.services;

import com.tedu.market.pojo.SmbmsRole;

import java.util.List;

public interface SmbmsRoleServies {

    /**
     * 获取全部的用户角色
     * @return
     */
    public List<SmbmsRole> getAllRole();
}
