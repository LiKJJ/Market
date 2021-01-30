package com.tedu.market.services;

import com.tedu.market.dao.SmbmsUserDao;
import com.tedu.market.pojo.SmbmsRole;
import com.tedu.market.pojo.SmbmsUser;
import com.tedu.market.utill.MyBatisUtill;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务层  实现类
 */
public class UserServicesImpl implements UserServices {

    @Override
    public SmbmsUser login(String name, String pwd) {
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsUserDao smbmsUserDao = sqlSession.getMapper(SmbmsUserDao.class);
        SmbmsUser user = new SmbmsUser();
        user.setUserCode(name);
        user.setUserPassword(pwd);
        List<SmbmsUser> userByUser = smbmsUserDao.getUserByUser(user);
        if (userByUser.size()==0)
        {
            return  null;
        }
        //释放资源
        MyBatisUtill.close(sqlSession);
        return userByUser.get(0);
    }

    @Override
    public List<SmbmsUser> getAllUser() {
        //调用dao层方法
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsUserDao mapper = sqlSession.getMapper(SmbmsUserDao.class);
        List<SmbmsUser> allUser = mapper.getAllUser();
        System.out.println(allUser);
        MyBatisUtill.close(sqlSession);
        return allUser;
    }

    @Override
    public List<SmbmsUser> getUserByNameRole(String name, String role) {
        //调用dao层方法
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsUserDao mapper = sqlSession.getMapper(SmbmsUserDao.class);
        List<SmbmsUser> data = null;
        Map<String,String > map = new HashMap<>();
       if(role.equals("0"))//不查询用户角色
       {
           map.put("name",name);
           map.put("userRole",null);
           data =  mapper.getRoleListByNameRole(map);
       }else {
           map.put("name",name);
           map.put("userRole",role);
           data = mapper.getRoleListByNameRole(map);
       }
       MyBatisUtill.close(sqlSession);
        return data;
    }

    @Override
    public SmbmsUser getUserById(String id) {
        //调用dao层方法
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsUserDao mapper = sqlSession.getMapper(SmbmsUserDao.class);

        return  mapper.getUserById(id);
    }

    @Override
    public int addUser(SmbmsUser user) {
        //调用dao层方法
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsUserDao mapper = sqlSession.getMapper(SmbmsUserDao.class);
        int i = mapper.addUser(user);
        sqlSession.commit();
        MyBatisUtill.close(sqlSession);
        System.out.println("-------==========="+i);
        return i;
    }

    /**
     * 通过用户编程
     * @param userCode
     */
    @Override
    public List<SmbmsUser>  getUserByCode(String userCode) {
        //调用dao层方法
        SqlSession sqlSession = MyBatisUtill.getSqlSession();
        SmbmsUserDao mapper = sqlSession.getMapper(SmbmsUserDao.class);
       SmbmsUser user = new SmbmsUser();
       user.setUserCode(userCode);
        List<SmbmsUser> userByUser = mapper.getUserByUser(user);

        MyBatisUtill.close(sqlSession);

        return userByUser;
    }


    @Override
    public int deleteUserById(String uid) {

        try{
            int id = Integer.parseInt(uid);
            //调用dao层方法
            SqlSession sqlSession = MyBatisUtill.getSqlSession();
            SmbmsUserDao mapper = sqlSession.getMapper(SmbmsUserDao.class);
            int i = mapper.deleteById(id);
            sqlSession.commit();
            MyBatisUtill.close(sqlSession);
            return i;
        }catch (Exception e){
            return 0;
        }

    }
}
