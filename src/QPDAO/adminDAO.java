/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QPDAO;

import QPBean.admin;
import static Utils.BaseDAO.closeCon;
import static Utils.BaseDAO.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Abha Suntwal
 */
public class adminDAO {
    
    public static admin validate_login(String uname, String passw, String code){
        admin res = null;
        Connection con = null;
        try {
            con = getCon();
            String sql = "select * from admin where admin_name = ? and (password = ? and security_code = ?)";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, uname);
            st.setString(i++, passw);
            st.setString(i++, code);
           ResultSet rs =  st.executeQuery();
           while(rs.next()){
               admin a1 = new admin();
               a1.setId(rs.getString("id"));
               a1.setAdmin_name(rs.getString("admin_name"));
               a1.setPhone_no(rs.getString("phone_no"));
               a1.setPassword(rs.getString("password"));
               a1.setSecurity_code(rs.getString("security_code"));
               res = a1;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
         finally{
           closeCon(con);
       }
        return res;
    }
    
}
