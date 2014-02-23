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

import com.abc.rory.stores.FaultsStore;


/**
 * Servlet implementation class FaultDeveloper
 */
@WebServlet("/FaultDeveloper")
public class FaultDeveloper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaultDeveloper() {
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
		
		
		

		String section = request.getParameter("section").toString();
		
		String stmt = "SELECT * FROM fault WHERE section_idsection=?";
		LinkedList<FaultsStore> faults = new LinkedList<FaultsStore>();
		FaultsStore fs = null;
		
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
            //Statement stmt = con.createStatement();
            ps = con.prepareStatement(stmt);
        	ps.setString(1, section);
        	
        	 rs=ps.executeQuery();
             
             while(rs.next()) {
                 // redirect to error page
            	fs =  new FaultsStore();
             	String faultDetails = rs.getString("details");
             	String faultSummary = rs.getString("summary");
             	String faultId = rs.getString("idfault");
                 
             	fs.setFaultDetails(faultDetails);
             	fs.setFaultSummary(faultSummary);
             	
             	fs.setFaultid(faultId);
             	
             	
             	
             	faults.add(fs);
             	
             	
             	
             	
             	
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
         request.setAttribute("list", faults);
         RequestDispatcher rd = request.getRequestDispatcher("/RenderDevloperFaults.jsp"); 

 		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
