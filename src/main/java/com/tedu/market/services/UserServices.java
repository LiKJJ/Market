package com.tedu.market.services;

import com.tedu.market.pojo.SmbmsRole;
import com.tedu.market.pojo.SmbmsUser;

import java.util.List;

/**
 * 用户模块的服务层接口
 */
public interface UserServices {

    /**
     * 登陆
     * @param name
     * @param pwd
     * @return
     */
    public SmbmsUser login(String name,String pwd);
    /**
     * 获取全部是用户信息（分页）
     * @return
     */
    List<SmbmsUser> getAllUser();
    List<SmbmsUser> getUserByNameRole(String name, String role);
    /**
     * 通过id获取用户的详情
     * @param id
     * @return
     */
    SmbmsUser getUserById(String id);
    /**
     * 注册用户
     * @param user
     * @return
     */
    int addUser(SmbmsUser user);
    List<SmbmsUser>  getUserByCode(String userCode);
    /**
     * 通过id删除用户
     * @param uid
     * @return
     */
    int deleteUserById(String uid);
}
