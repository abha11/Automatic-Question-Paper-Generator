/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import static Utils.utilConstant.*;
import java.sql.Statement;

/**
 *
 * @author Abha Suntwal
 */
public class InstallDB {

    public static void main(String[] args) {
        createDB();
        for (String sql : SQLS_CREATE) {
            runSQLCreate(sql);
        }
        for (String sql : SQLS_INSERT) {
            runSQLInsert(sql);
        }
    }

    public static void createDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:question_db.sqlite");
            if (con != null) {
                System.out.println("Database created successfully!");

            }
            //String sql = "drop schema if exists "  + DB_NAME;
            //PreparedStatement st = con.prepareStatement(sql);
            //st.executeUpdate();
            //System.out.println(DB_NAME + " dropped");
            /*sql = "create schema " + DB_NAME;
			st = con.prepareStatement(sql);
			st.executeUpdate();*/
            con.close();
            //System.out.println(DB_NAME + " created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runSQLCreate(String sql) {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:question_db.sqlite");
            System.out.println("Database opened successfully!");
            Statement st = con.createStatement();
            st.execute(sql);
            con.close();
            System.out.println("table created!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runSQLInsert(String sql) {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:question_db.sqlite");
            System.out.println("Database opened successfully!");
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
            con.close();
            System.out.println("Data inserted!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
