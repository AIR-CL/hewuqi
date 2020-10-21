package controller;

import dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="RegisterServlet",urlPatterns = "/reg")//注解开发
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//在启动前按照自己指定的字符编码进行解码
        resp.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String tel = req.getParameter("tel");
        System.out.println(username);
        System.out.println(pwd);
        System.out.println(tel);
        //dao 数据访问对象 对数据库进行增删改查
        //创建表
        //连接数据库
        UserDao userDao=new UserDao();
        int row=userDao.addUserInfo(username,pwd,tel);


        //向浏览器响应内容,通过响应对象获取输出流
        PrintWriter pw=resp.getWriter();
        //告诉浏览器输出内容格式和编码
        resp.setContentType("text/html:charset=utf-8");
        if(row>=1){
            //注册成功,跳转到登陆页面
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            //在转发过程中需要携带两个对象
            requestDispatcher.forward(req,resp);
//另一种写法 req.getRequestDispatcher("login.jsp").forward(req,resp);

            //注册成功,跳转到登录页面
            pw.println("添加数据成功");


        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(req,resp);

            pw.println("添加数据失败");
            //注册失败,跳转错误页面

        }
    }
}
