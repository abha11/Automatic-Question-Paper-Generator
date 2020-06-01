/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.*;

/**
 *
 * @author Abha Suntwal
 */
public class BaseDAO extends utilConstant {
    public static Connection getCon(){
	 Connection con = null;
	 try {
             Class.forName("org.sqlite.JDBC");
             con = DriverManager.getConnection("jdbc:sqlite:question_db.sqlite");
             System.out.println("Database opened successfully!");
		//con = DriverManager.getConnection("jdbc:mysql://"+DB_HOST+":3306/"+DB_NAME, DB_USER, DB_PASS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;		
 }
 public static void closeCon(Connection con){
	 try {
		 con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
}
