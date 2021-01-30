package com.tedu.market.dao;

import com.tedu.market.pojo.SmbmsRole;

import java.util.List;

public interface SmbmsRoleDao {

    /**
     * 通过id获取用户的角色
     * @param id
     * @return
     */
    SmbmsRole getRoleById(int id);

    List<SmbmsRole> getRoleListByName(String name);

    /**
     * 获取全部用户角色
     * @return
     */
    List<SmbmsRole> getAllRoleListe();

}
