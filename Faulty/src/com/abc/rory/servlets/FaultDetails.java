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
 * Servlet implementation class FaultDetails
 */
@WebServlet("/FaultDetails")
public class FaultDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;

		String faultId = request.getParameter("faultId");
		
		String stmt = "SELECT * FROM fault WHERE idfault=?";
    	
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Faultdb","root","Cl1m8t3;");
            //Statement stmt = con.createStatement();
            ps = con.prepareStatement(stmt);
        	ps.setString(1, faultId);
        	
        	System.out.println(faultId);
        	
        	
            rs=ps.executeQuery();
            
            if (rs.next()) {
                // redirect to error page
            	String faultDetails = rs.getString("details");
            	String faultSummary = rs.getString("summary");
                
            	
            	request.setAttribute("faultDetails", faultDetails);
            	request.setAttribute("faultSummary", faultSummary);
            	
            	RequestDispatcher rd = request.getRequestDispatcher("/FaultDetails.jsp"); 

        		rd.forward(request, response);
                //response.sendRedirect("/FaultDetails.jsp"); 
                
               
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
