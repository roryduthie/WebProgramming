package com.abc.rory.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SelectUpdate
 */
@WebServlet("/SelectUpdate")
public class SelectUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUpdate() {
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

		
		
		String stmt = "SELECT * FROM fault WHERE author_idauthor=?";
		
		String author=request.getSession(false).getAttribute("id").toString();
		LinkedList<String> faults = new LinkedList<String>();
		LinkedList<String> id = new LinkedList<String>();
		String faultId = null;
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Faultdb","root","Cl1m8t3;");
            //Statement stmt = con.createStatement();
            ps = con.prepareStatement(stmt);
        	ps.setString(1, author);
        	
        	
        	
        	
            rs=ps.executeQuery();
            
           while (rs.next()) {
                // redirect to error page
            	String faultSummary = rs.getString("summary");
            	 faultId = rs.getString("idfault");
            	
            	
            	faults.add(faultSummary);
            	id.add(faultId);
            	
            	

        		
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
        
        
        request.setAttribute("faults", faults); //Set a bean with the list in it
        request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/UpdateSelect.jsp"); 

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
