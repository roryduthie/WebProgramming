package com.abc.rory.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.abc.rory.lib.DButils;

/**
 * Servlet implementation class RegisterCheck
 */
@WebServlet(
		urlPatterns = { 
				"/RegisterCheck" 			
		}, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/Faultdb")
		})
public class RegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource _ds = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCheck() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init(ServletConfig config) throws ServletException {
  		// TODO Auto-generated method stub
  		DButils db = new DButils();
  		db.createSchema();
          _ds=db.assemble(config);
  	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;

		String username = request.getParameter("username");
		//String password = request.getParameter("password");
		
		String stmt = "SELECT * FROM author WHERE name=?";
    	
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
            //Statement stmt = con.createStatement();
            ps = con.prepareStatement(stmt);
        	ps.setString(1, username);
        	//ps.setString(2, password);
        	//ps.getString(3, id);
        	
            rs=ps.executeQuery();
            
            if (rs.next()) {
                // redirect to error page
            	
            	response.sendRedirect("Register.jsp");
               
            } 
            else {
                // fetch the session from request, create new session if session
                // is not present in the request
            	 registerUser(request, response);
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
	
	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Connection con = null;
		 PreparedStatement ps = null;
		try{
		
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Faultdb","root","Cl1m8t3;");
	    
	    //ResultSet doSubmit = null;
	   
	    
	    String username= request.getParameter("username");
	    String password= request.getParameter("password");
	    String permission= request.getParameter("permission");
	   
	    System.out.println(permission);
	    
	    
	    	String sqlOption= "INSERT INTO author (name, passwrd, permission) VALUES (?,?,?)";
	    	
	    	ps = con.prepareStatement(sqlOption);
	    	ps.setString(1, username);
	    	ps.setString(2, password);
	    	ps.setString(3, permission);
	    	
	    	
	    	ps.executeUpdate();
	    	
	    	 response.sendRedirect("Login.jsp");
	    	
		}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	try{
	    		
	    		if(con!=null)
	    		{
	    			con.close();
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	}
	

}
