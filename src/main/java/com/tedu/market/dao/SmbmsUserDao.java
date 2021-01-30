package com.tedu.market.dao;

import com.tedu.market.pojo.SmbmsRole;
import com.tedu.market.pojo.SmbmsUser;

import java.util.List;
import java.util.Map;

/**
 * 用户的dao层接口
 */
public interface SmbmsUserDao {

    /**
     * 通过id删除用户数据
     * @param id
     * @return
     */
    public int deleteById(int id);

    /**
     * 通过用户对象，对该对象进行修改
     * @param smbmsUser 修改后的对象，id相同,,属性==null 则不修改
     * @return
     */
    public int updateByUser(SmbmsUser smbmsUser);

    /**
     * 添加一个用户
     * @param smbmsUser
     * @return
     */
    public int addUser(SmbmsUser smbmsUser);

    /**
     * 数据库的条数
     * @return
     */
    public int count();

    /**
     * 通过用户对象进行查询
     * @param smbmsUser userCode = #{userCode}
     *  and userName = #{userName}
     *  and userPassword = #{userPassword}
     *  and gender = #{gender}
     *  and  userRole = #{userRole}
     * @return
     */
    public List<SmbmsUser> getUserByUser(SmbmsUser smbmsUser);
    /**
     * 获取全部用户信息
     * @return
     */
    public List<SmbmsUser> getAllUser();
    /**
     * 通过用户名获取用户信息（包含用户角色）
     * @param name
     * @return
     */
    public List<SmbmsUser> getUserByName(String name);
    /**
     * 通过用户名称，用户角色名称  模糊查询
     * @return
     */
    List<SmbmsUser> getRoleListByNameRole(Map<String,String > map);
    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    SmbmsUser getUserById(String id);
}
