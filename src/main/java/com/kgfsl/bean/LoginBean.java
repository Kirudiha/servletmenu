package com.kgfsl.bean;

//LoginBean.java

public class LoginBean {

private String userName;
private String password;
private String emailid;
private String role;
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}

public String getEmail() {
    return emailid;
    }
    public void setEmail(String emailid) {
    this.emailid = emailid;
    }

    public String getRole() {
        return role;
        }
        public void setRole(String role) {
        this.role = role;
        }
}