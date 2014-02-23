package com.abc.rory.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateFault
 */
@WebServlet("/UpdateFault")
public class UpdateFault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFault() {
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

		//String fault = request.getParameter("faults");
		String id = request.getParameter("id");
		
		int sectionId = 0;
		
		HttpSession session = request.getSession(true); 
		String reporter=session.getAttribute("id").toString();
		
		
		String summary= request.getParameter("summary"); 
		String details= request.getParameter("details");
		String section= request.getParameter("section");
		
		if(summary.equals(""))
		{
			summary = null;
		}
		if(details.equals(""))
		{
			details = null;
		}
		if(section.equals(""))
		{
			section = null;
		}
		
		if(section.equals("cassandra"))
		{
			sectionId = 1;
		}
		else if(section.equals("hadoop"))
		{
			sectionId = 2;
		}
		else if(section.equals("debian"))
		{
			sectionId = 3;
		}
		else
		{
			response.sendRedirect("Form.jsp");
		}
		
		
		int reporterId= Integer.parseInt(reporter); 
		//int sectionId = Integer.parseInt(section);
		String severity= request.getParameter("severity"); 
		
		
		
		//String id = request.getSession(false).getAttribute("id").toString();
		
		String stmt ="UPDATE"
						+" fault"
					+" SET"
						+" summary = COALESCE(?, summary),"
						+" details = COALESCE(?, details),"
						+" author_idauthor = COALESCE(? ,author_idauthor),"
						+" section_idsection = COALESCE(? ,section_idsection),"
						+" severity = COALESCE(? ,severity)"
					+" WHERE"
						+" idfault=?";
    	
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
            //Statement stmt = con.createStatement();
            ps = con.prepareStatement(stmt);
            ps.setString(1, summary);
        	ps.setString(2, details);
        	ps.setInt(3, reporterId);
        	ps.setInt(4, sectionId);
        	ps.setString(5, severity);
        	ps.setString(6, id);
        	
        	
        	
        	
        	ps.executeUpdate();
                
               
             
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
        
        response.sendRedirect("/Faulty/Faults");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
