package com.kgfsl.controller;

import java.io.IOException;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgfsl.util.DBConnection;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class UploadServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        Connection con = null;
        Statement statement = null;

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String emailid = request.getParameter("emailid");
        String role = request.getParameter("role");
        try {

            con = DBConnection.createConnection();
            statement = con.createStatement();
            PreparedStatement statement1 = con
                    .prepareStatement("INSERT INTO menu(userName,password,emailid,role) values (?, ?, ?,?)");
            statement1.setString(1, userName);
            statement1.setString(2, password);
            statement1.setString(3, emailid);
            statement1.setString(4, role);
            int i= statement1.executeUpdate();
 
      
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/success.html").forward(request, response);
        // getServletContext().getRequestDispatcher("/success.html").forward(request, response);
    }
}
