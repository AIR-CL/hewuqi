package test;

import util.DBUtil;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn= DBUtil.getConn();
        System.out.println(conn);
    }
}
