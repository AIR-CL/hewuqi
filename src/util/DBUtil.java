package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
//    连接数据库的类
    private  static  String username;
    private  static  String password;
    private   static String url;
    private  static  String driver;

    static {
        try {
            InputStream in = DBUtil.class.getResourceAsStream("db.properties");
            Properties p=new Properties();
            p.load(in);
            username = p.getProperty("db.username");
            password=p.getProperty("db.password");
            url=p.getProperty("db.url");
            driver=p.getProperty("db.driver");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection conn=null;
        //加载驱动
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
