package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@MultipartConfig(maxFileSize=16177215)
public class InsertServlet
extends HttpServlet {
    private static final long serialVersionUID = 1;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	String driver= "org.postgresql.Driver";
    	String dbURL = "jdbc:postgresql://localhost:5432/jk_gift";
        String dbUser = "postgres";
        String dbPass = "postgres";
        System.out.println("aaaaaaaaaaaaaa");
        InputStream inputStream = null;
        Part filePart = request.getPart("photo");
        System.out.println((Object)filePart);
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        Connection conn = null;
        String message = null;
        try {
            try {
                int row;
                Class.forName(driver);
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                System.out.println("connection created");
                String sql = "INSERT INTO photo  values (?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                if (inputStream != null) {
                    statement.setBytes(1, IOUtils.toByteArray(inputStream));
                }
                if ((row = statement.executeUpdate()) > 0) {
                    message = "File uploaded and saved into database";
                }
            }
            catch (SQLException | ClassNotFoundException ex) {
                message = "ERROR: " + ex.getMessage();
                ex.printStackTrace();
                
                request.setAttribute("Message", (Object)message);
                this.getServletContext().getRequestDispatcher("/message.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            request.setAttribute("Message", (Object)message);
            this.getServletContext().getRequestDispatcher("/message.jsp").forward((ServletRequest)request, (ServletResponse)response);
        }
    }
    
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException, IOException{
    	
    	String driver= "org.postgresql.Driver";
    	String dbURL = "jdbc:postgresql://localhost:5432/jk_gift";
        String dbUser = "postgres";
        String dbPass = "postgres";
        int row;
        Class.forName("org.postgresql.Driver");
        File file = new File("C:/Users/rahuls4/Pictures/487331_501297903240308_689957994_n.png");
        InputStream inputStream = new FileInputStream(file);
        byte[] images = IOUtils.toByteArray(inputStream);
       Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        System.out.println("connection created");
        String sql = "INSERT INTO photo  values (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        if (inputStream != null) {
            statement.setBytes(1, images);
        }
        if ((row = statement.executeUpdate()) > 0) {
            String message = "File uploaded and saved into database";
            System.out.println(message);
        }
    }
}