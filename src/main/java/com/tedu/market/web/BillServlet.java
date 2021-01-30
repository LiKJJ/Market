package com.tedu.market.web;

import com.tedu.market.pojo.SmbmsBill;
import com.tedu.market.pojo.SmbmsProvider;
import com.tedu.market.services.BillServices;
import com.tedu.market.services.BillServicesImpl;
import com.tedu.market.services.ProviderServices;
import com.tedu.market.services.ProviderServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BillServlet extends HttpServlet {
    BillServices billServies;
    ProviderServices providerServices;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("欢迎你进入订单的后台服务器");
        billServies = new BillServicesImpl();
        providerServices = new ProviderServicesImpl();
        //获取前端页面传入的数据源
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String[] requrstURI = req.getRequestURI().split("/");
        //判断请求规则
        try {
            if (requrstURI[2] != null && requrstURI[2].equals("list")) {
                //分页显示订单的列表页
                System.out.println("当前页面" + requrstURI[3] + "大小" + requrstURI[4]);
                int no = Integer.parseInt(requrstURI[3]);
                int size = Integer.parseInt(requrstURI[4]);
                List<SmbmsBill> data = billServies.getAllBillBySize(no, size);
                //发送数据到页面
                List<SmbmsProvider> providerByProvider = providerServices.getProviderByProvider(new SmbmsProvider());
                req.setAttribute("billList", data);
                req.setAttribute("providerList", providerByProvider);
                //转发到订单的列表页
                req.getRequestDispatcher("/jsp/billlist.jsp").forward(req, resp);
            }else if (requrstURI[2]!=null&&requrstURI[2].equals("query.do")){
                //查询
                System.out.println("你正在查询");
                //查询条件
                String productname = new String(req.getParameter("productname").
                        getBytes("iso8859-1"),"UTF-8");
                String parameter =req.getParameter("provider.proname");
                String isPayment =req.getParameter("isPayment");
                System.out.println(productname+"--"+parameter+"你正在查询订单"+isPayment);
                int providerId =Integer.parseInt(parameter);
                int pay =Integer.parseInt(isPayment);
                //调用查询服务    查询
                SmbmsBill smbmsBill= new SmbmsBill();
                smbmsBill.setProductName(productname);
                smbmsBill.setProviderId(providerId);
                smbmsBill.setIsPayment(pay);
                //调用服务层
                List<SmbmsBill> data =billServies.getBillByBill(smbmsBill);
                //发送数据
                //发送数据到页
                List<SmbmsProvider> providerByProvider =providerServices.getProviderByProvider(new SmbmsProvider());
                req.setAttribute("billList",data);
                req.setAttribute("providerList",providerByProvider);

                req.setAttribute("totalCount","count");
                req.setAttribute("currentPageNo","Pageszie");
                req.setAttribute("totalPageCount",0);
                //转发到订单的列表页
                req.getRequestDispatcher("/jsp/billlist.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/error.jsp");
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}