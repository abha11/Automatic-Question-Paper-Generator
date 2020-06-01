/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Abha Suntwal
 */
public class utilConstant {
    
    public static String DB_NAME ="questionGenerator.db";
    public static String DB_HOST="localhost";
    public static String DB_USER="root";
    public static String DB_PASS ="";
    public static String SQLS_CREATE[] = 
	{
		"create table if not exists app_users (id INTEGER PRIMARY KEY, name text NOT NULL, designation text NOT NULL, subject text NOT NULL, password text NOT NULL, email text NOT NULL, phone_no text NOT NULL)",	
		"create table if not exists admin(id INTEGER PRIMARY KEY, admin_name text, phone_no text NOT NULL, password text NOT NULL, security_code text NOT NULL)",	
                "create table if not exists question_bank (id INTEGER PRIMARY KEY, question text NOT NULL, discrimination INT, time INT, difficulty INT, marks INT, relevancy INT, frequency INT, year INT)",
                /*"insert into question_bank (id INT NOT NULL AUTO_INCREMENT, question varchar(100), discrimination INT, time INT, difficulty INT, marks INT, relevancy INT, frequency INT, year INT, PRIMARY KEY (id))"
                /*"create table company (id INT NOT NULL AUTO_INCREMENT, com_name varchar(45),com_country varchar(40), com_email varchar(40), com_addr varchar(40), com_phone varchar(40),PRIMARY KEY (id))",
                "create table purchased_medicine (s_no INT NOT NULL AUTO_INCREMENT, m_id INT NOT NULL, med_name varchar(45), med_category varchar(45), quant_purchased int, price_unit double, price_total double, PRIMARY KEY (s_no))",
       */ };
    public static String SQLS_INSERT[] = 
    {
		"insert into app_users (name, designation, subject, password, email, phone_no) values ('robin', 'faculty', 'cryptography', 'abc123','robin@123', '9999999999')",	
		"insert into admin(admin_name, phone_no, password, security_code) values ('admin', '7458745878', 'admin', '1234')",

    };
}
