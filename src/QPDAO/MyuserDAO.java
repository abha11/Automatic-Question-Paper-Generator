/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QPDAO;

import Utils.BaseDAO;
import static Utils.BaseDAO.closeCon;
import static Utils.BaseDAO.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import QPBean.myUser;

/**
 *
 * @author Abha Suntwal
 */
public class MyuserDAO extends BaseDAO {

    public static myUser validate_login(String uname, String passw) {
        myUser res = null;
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from app_users where name = ? and password = ?";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, uname);
            st.setString(i++, passw);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                myUser m1 = new myUser();
                m1.setId(rs.getString("id"));
                m1.setName(rs.getString("name"));
                m1.setDesignation(rs.getString("designation"));
                m1.setSubject(rs.getString("subject"));
                m1.setPassword(rs.getString("password"));
                m1.setEmail(rs.getString("email"));
                m1.setPhone_no(rs.getString("phone_no"));
                res = m1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }

    public static int insert(myUser m1) {
        Connection con = null;
        try {
            con = getCon();
            String sql = "insert into app_users (name, designation, subject, password, email, phone_no) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
//name, designation, subject, password, email, phone_no
            int i = 1;
            st.setString(i++, m1.getName());
            st.setString(i++, m1.getDesignation());
            st.setString(i++, m1.getSubject());
            st.setString(i++, m1.getPassword());
            st.setString(i++, m1.getEmail());
            st.setString(i++, m1.getPhone_no());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeCon(con);
        }
        return 1;

    }

    public static myUser searchById(String id) {
        Connection con = null;
        myUser res = null;
        try {
            con = getCon();
            String query = "select * from app_users where id=?";
            PreparedStatement st = con.prepareStatement(query);
            int i = 1;
            st.setString(i, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                myUser m1 = new myUser();
                m1.setId(rs.getString("id"));
                m1.setName(rs.getString("name"));
                m1.setDesignation(rs.getString("designation"));
                m1.setSubject(rs.getString("subject"));
                m1.setPassword(rs.getString("password"));
                m1.setEmail(rs.getString("email"));
                m1.setPhone_no(rs.getString("phone_no"));
                res = m1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;

    }

    public static void update(myUser m1) {
        Connection con = null;
        try {
            con = getCon();
            //name, designation, subject, password, email, phone_no
            String query = " update app_users set name = ?, designation = ?, subject = ? , email = ?, phone_no = ? where id = ? ";
            //System.out.println("Query processed...update function");
            PreparedStatement st = con.prepareStatement(query);
            int i = 1;
            System.out.println(m1.getName());
            st.setString(i++, m1.getName());
            st.setString(i++, m1.getDesignation());
            st.setString(i++, m1.getSubject());
            st.setString(i++, m1.getEmail());
            st.setString(i++, m1.getPhone_no());
            st.setString(i++, m1.getId());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeCon(con);
        }
    }

}
