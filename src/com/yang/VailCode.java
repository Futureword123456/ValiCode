package com.yang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VailCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到数据
        //验证
        String inCode=req.getParameter("inCode").toString().toLowerCase();
        String valicode=req.getSession().getAttribute("valiCode").toString().toLowerCase();
        if(inCode.equals(valicode)){
            resp.sendRedirect("index.jsp");
        }else {
            req.getSession().setAttribute("err","验证码错误，请重新输入");
            //返回上一页
            String url=req.getHeader("Referer");
            resp.sendRedirect(url);
        }
    }
}
