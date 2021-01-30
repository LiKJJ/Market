package com.tedu.market.web;


import com.alibaba.fastjson.JSON;
import com.tedu.market.pojo.SmbmsRole;
import com.tedu.market.pojo.SmbmsUser;
import com.tedu.market.services.SmbmsRoleServies;
import com.tedu.market.services.SmbmsRoleServiesImpl;
import com.tedu.market.services.UserServices;
import com.tedu.market.services.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户模块
 */
public class UserHttpServlet extends HttpServlet {

    UserServices userServices;
    SmbmsRoleServies smbmsRoleServies;
    /**
     * 处理用户的请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
        System.out.println("欢迎进入用户的servlet"+name);
        //使用utf-8乱码处理
        //对于post
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //对于get的请求
        userServices = new UserServicesImpl();
        smbmsRoleServies = new SmbmsRoleServiesImpl();
        if (name!=null&&name.equals("login")){
            //获取页面传递数据
            String userCode  = req.getParameter("userCode");
            String password  = req.getParameter("userPassword");
            if(userCode!=null&&!userCode.equals("")&&password!=null&&!password.equals(""))
            {
                //执行登陆方法
                //调用服务层方法，进行登陆
                SmbmsUser smbmsUser = userServices.login(userCode, password);
                //把登陆成功的用户保存session
                if (smbmsUser==null){
                    //返回登陆失败
                    req.setAttribute("error","你输入的用户名，密码错误，请重新登陆");
                    //转发？重定向？
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                    return;
                }
                HttpSession session = req.getSession();
                session.setAttribute("longinuser",smbmsUser);
                //重定向项目首页
                resp.sendRedirect("/jsp/frame.jsp");

            }else
            {
                //返回登陆失败
                req.setAttribute("error","你输入的用户名，密码为空，请重新登陆");
                //转发？重定向？
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }

        }else if(name!=null&&name.equals("query")){//查询用户，进入用户模块
            //获取全部的用户信息
            List<SmbmsUser> data = userServices.getAllUser();
            //获取用户角色信息
            List<SmbmsRole> allRole = smbmsRoleServies.getAllRole();
            //把数据data 发送到页面
            req.setAttribute("roleList",allRole);
//            System.out.println(allRole);
            req.setAttribute("userList",data);
            //转发到用户列表
            req.getRequestDispatcher("/jsp/userlist.jsp").forward(req,resp);
        }else  if(name!=null&&name.equals("queryName")){
            //通过用户名，用户角色进行模拟查询

            //获取用户的输入查询条件
            String string  = req.getParameter("username");
            String userName = null;
            if(string !=null)
            {
                userName = new String( string.getBytes("iso8859-1"),"UTF-8");
            }
            String queryUserRole = req.getParameter("queryUserRole");
            System.out.println("你查询的条件是："+userName+"---------------------"+queryUserRole);

            List<SmbmsUser> data = userServices.getUserByNameRole(userName,queryUserRole);
            //获取用户角色信息
            List<SmbmsRole> allRole = smbmsRoleServies.getAllRole();
            //把数据data 发送到页面
            req.setAttribute("roleList",allRole);
//            System.out.println(allRole);
            req.setAttribute("userList",data);
            //转发到用户列表
            req.getRequestDispatcher("/jsp/userlist.jsp").forward(req,resp);
        }else if(name!=null&&name.equals("viewuser"))  {
            //查询用户的详情
            String id = req.getParameter("userid");
            //调用服务  获取该用户的详情
            SmbmsUser user = userServices.getUserById(id);
            System.out.println(user);
            //发送到客户端
            req.setAttribute("user",user);
            //转发
            req.getRequestDispatcher("/jsp/userview.jsp").forward(req,resp);
        }else if(name!=null&&name.equals("getrolelist")){
            //json文本返回数据
            //获取用户角色信息
            List<SmbmsRole> allRole = smbmsRoleServies.getAllRole();
            //发送到页面，  ajax
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/json;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            //把对象---json
            String json = JSON.toJSONString(allRole);
            writer.println(json);
            System.out.println(json);
            writer.flush();
        }else if(name!=null&&name.equals("adduser")){
            System.out.println("注册用户，1.获取页面的数据2.调用服务注册  3.返回结果");
            String usercode = req.getParameter("usercode");
            String username = req.getParameter("username");
            String userpassword = req.getParameter("userpassword");
            String gender = req.getParameter("gender");
            String birthday = req.getParameter("birthday");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            String userRole = req.getParameter("userRole");
            SmbmsUser user = new SmbmsUser(1,usercode,username,userpassword
            ,Integer.parseInt(gender),birthday,phone,address,Integer.parseInt(userRole),
                    0,null,1,null,"",null);
            System.out.println(user);
            //调用服务层方法，添加
            int i = userServices.addUser(user);
            //返回
            if(i>0)
            {
//cg
            //登陆
            resp.sendRedirect("/login.jsp");
            }else{
            //失败
                resp.sendRedirect("/jsp/useradd.jsp");
            }
        }else if(name!=null&&name.equals("getuserbycode")){//通过用户编码验证用户是否存在
            String userCode = req.getParameter("userCode");
            //调用服务层  查询该用户是否存在
            if(userCode!=null){
                List<SmbmsUser> data = userServices.getUserByCode(userCode);
                System.out.println(data);
                if(data.size()>0)
                {
                    Map<String ,String> map = new HashMap<>();
                    map.put("userCode","exist");
                    String json = JSON.toJSONString(map);
                    PrintWriter writer = resp.getWriter();
                    writer.println(json);
                    writer.flush();
                }else
                {
                    Map<String ,String> map = new HashMap<>();
                    map.put("userCode","isnouser");
                    String json = JSON.toJSONString(map);
                    PrintWriter writer = resp.getWriter();
                    writer.println(json);
                    writer.flush();
                }
            }else {
                //用户编码不存在
                Map<String ,String> map = new HashMap<>();
                map.put("userCode","isnouser");
                String json = JSON.toJSONString(map);
                PrintWriter writer = resp.getWriter();
                writer.println(json);
                writer.flush();

            }
        }else if(name!=null&&name.equals("deluser")){//删除用户
            //获取用户的id
            String uid = req.getParameter("uid");
            //调用服务的删除方法
            int i = userServices.deleteUserById(uid);
            //把删除的结果发送页面
            if(i>0){//删除成功
                Map<String ,String> map = new HashMap<>();
                map.put("delResult","true");
                String json = JSON.toJSONString(map);
                PrintWriter writer = resp.getWriter();
                writer.println(json);
                writer.flush();
            }else{
                Map<String ,String> map = new HashMap<>();
                map.put("delResult","false");
                String json = JSON.toJSONString(map);
                PrintWriter writer = resp.getWriter();
                writer.println(json);
                writer.flush();
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req,resp);
    }
}
