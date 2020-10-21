package controller;

import dao.UserDao;
import pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setCharacterEncoding("utf-8");
    //接受参数
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");



        UserDao userDao=new UserDao();
        User user =userDao.judge(username);
        if (user==null){
            //如何将数据绑定jsp页面,1.HttpServletRequest对象
            req.setAttribute("msg","该用户没有注册");
            //将数据绑定到登录页面
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
//            requestDispatcher.forward(req,resp);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req,resp);
        }
        else {
            System.out.println(user);
            System.out.println(username);
            System.out.println(pwd);
            if (user.getName().equals(username)&&user.getPassword().equals(pwd)) {
                //用户名和密码匹配,跳转到主页
                req.setAttribute("name", username);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
                requestDispatcher.forward(req, resp);
            }else{
                //用户或密码错误
                //将提醒信息绑定到登录页面实现
                req.setAttribute("msg", "用户名或密码错误!");
                //将绑定的数据转发到登录页面
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
                requestDispatcher.forward(req, resp);
            }

        }



    }
}
