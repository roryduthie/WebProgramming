package com.abc.rory.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
System.out.println("I started");
        
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String stmt = "SELECT * FROM author WHERE name=? and passwrd=?";
    	
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Faultdb","root","Cl1m8t3;");
            //Statement stmt = con.createStatement();
            ps = con.prepareStatement(stmt);
        	ps.setString(1, username);
        	ps.setString(2, password);
        	//ps.getString(3, id);
        	
            rs=ps.executeQuery();
            
            if (rs.next()) {
                // redirect to error page
            	HttpSession session = request.getSession(true); 
                session.setAttribute("username", rs.getString("name"));
                session.setAttribute("id", rs.getInt("idauthor"));
                session.setAttribute("section", rs.getString("section"));
                String perms = rs.getString("permission");
               
                
                if(perms.equals("admin"))
    			{
    				System.out.println("You Have all the permissions");
    				response.sendRedirect("/Faulty/Faults"); 
    			}
                if(perms.equals("reporter"))
                {
                	
                }
    			else
    			{
    				System.out.println("nah");
    			}
                
                response.sendRedirect("/Faulty/Faults"); 
                
               
            } 
            else {
                // fetch the session from request, create new session if session
                // is not present in the request
            	 response.sendRedirect("LoginFailure.jsp");
            }
        } catch (Exception e)
        {
        System.out.println(e);
        }
        
        try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    // same logic
    
	}
}
