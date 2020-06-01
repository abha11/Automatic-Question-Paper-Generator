/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QPBean;

/**
 *
 * @author Abha Suntwal
 */
//admin_name, phone_no, security_code, password
public class admin {

    
    private String id;
    private String admin_name;
    private String phone_no;
    private String security_code;
    private String password;

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
