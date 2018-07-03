package com.kgfsl.dao;

//LoginDao.java

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kgfsl.bean.LoginBean;
import com.kgfsl.util.DBConnection;

public class LoginDao {
public String authenticateUser(LoginBean loginBean)
{
String userName = loginBean.getUserName();
// System.out.println("dddddddddddddd"+userName);
String password = loginBean.getPassword();
Connection con = null;
Statement statement = null;
ResultSet resultSet = null;
String userNameDB = "";
String passwordDB = "";
String roleDB = "";
try
{
con = DBConnection.createConnection();
statement = con.createStatement();
resultSet = statement.executeQuery("select userName,password,role from menu");
while(resultSet.next())
{
userNameDB = resultSet.getString("userName");
passwordDB = resultSet.getString("password");
roleDB = resultSet.getString("role");
if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
return "Admin_role";
else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
return "Editor_role";
else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
return "User_role";
}
}
catch(SQLException e)
{
e.printStackTrace();
}
return "Invalid user credentials";
}
}