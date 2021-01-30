package com.tedu.market.web;

import com.alibaba.fastjson.JSON;
import com.tedu.market.pojo.SmbmsProvider;
import com.tedu.market.services.ProviderServices;
import com.tedu.market.services.ProviderServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProviderServlet extends HttpServlet {

    ProviderServices providerServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String[] requestURI = req.getRequestURI().split("/");
        for (int i = 0; i < requestURI.length ; i++) {
            System.out.println(requestURI[i]);
        }

        providerServices = new ProviderServicesImpl();
        try{
        if(requestURI[2]!=null&&requestURI[2].equals("list"))
        {

                //分页显示供应商列表
                String pageNo = requestURI[3];
                String pageSzie = requestURI[4].split("\\.")[0];//去掉。html  后缀

                //转为int
                int No = Integer.parseInt(pageNo);
                int size = Integer.parseInt(pageSzie);

                //调用业务
               List<SmbmsProvider> data = providerServices.getProviderByNoSize(No,size);
               //发送到yemian
                req.setAttribute("providerList",data);
                //1.页码数  当前页
                int count = providerServices.getCount();

                int allPageSize  = 0;
                if(count%size==0)
                {
                    allPageSize = count/size;
                }else
                {
                    allPageSize = count/size+1;
                }
                //转发
                req.setAttribute("totalCount",count);
                req.setAttribute("totalPageCount",allPageSize);
                req.setAttribute("currentPageNo",No);
                req.getRequestDispatcher("/jsp/providerlist.jsp").forward(req,resp);
                return;


        }
        else if(requestURI[2]!=null&&requestURI[2].equals("providerquery.do")){
//供应商的查询功能
            String queryProCode = req.getParameter("queryProCode");
            String queryProName = new String(
                    req.getParameter("queryProName").getBytes("iso8859-1"),
                    "UTF-8");
            SmbmsProvider smbmsProvider = new SmbmsProvider();
            smbmsProvider.setProCode(queryProCode);
            smbmsProvider.setProName(queryProName);
            //调用服务查询
            List<SmbmsProvider> data = providerServices.getProviderByProvider(smbmsProvider);

            //发送到yemian
            req.setAttribute("providerList",data);
            //1.页码数  当前页
            int count = providerServices.getCountByProvider(smbmsProvider);

            int allPageSize  = 0;

            //转发
            req.setAttribute("totalCount",count);
            req.setAttribute("totalPageCount",allPageSize);
            req.setAttribute("currentPageNo",0);
            req.getRequestDispatcher("/jsp/providerlist.jsp").forward(req,resp);
        }
        else if(requestURI[2]!=null&&requestURI[2].equals("view")){
            System.out.println("你请求的供应商id:"+requestURI[3]);
            int id=Integer.parseInt(requestURI[3]);
            SmbmsProvider smbmsProvider=providerServices.getProvicesById(id);
            //
            req.setAttribute("provider",smbmsProvider);
            req.getRequestDispatcher("/jsp/providerview.jsp").forward(req,resp);
        }
        else if(requestURI[2]!=null&&requestURI[2].equals("delete")){
            int id=Integer.parseInt(requestURI[3]);
            int res=0;
            Map<String,String> map=new HashMap<>();
            try {
                res = providerServices.deleteById(id);
                if (res > 0) {
                    map.put("delResult", "true");
                } else {
                    map.put("delResult", "false");
                }
            }catch(Exception e){
                map.put("delResult","notexist");
            }
           //发送数据到页面
            PrintWriter writer=resp.getWriter();
            String json= JSON.toJSONString(map);
            writer.println(json);
            writer.flush();

        }else if(requestURI[2]!=null&&requestURI[2].equals("modify")){
            int id=Integer.parseInt(requestURI[3]);
            SmbmsProvider providerById=providerServices.getProvicesById(id);
            req.setAttribute("provider",providerById);
            req.getRequestDispatcher("/jsp/providermodify.jsp").forward(req,resp);
        }


        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("/error.jsp");
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
