package com.abc.rory.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.abc.rory.lib.DButils;
import com.abc.rory.models.AdminModel;
import com.abc.rory.models.UserModel;
import com.abc.rory.stores.UserStore;

/**
 * Servlet implementation class AdminSelect
 */
@WebServlet(
		urlPatterns = {"/ListAdmin"},
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/Faultdb")
		})
public class ListAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource _ds = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DButils db = new DButils();
        _ds=db.assemble(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Iterator<UserStore> iterator;
		AdminModel Users = new AdminModel();
		
		Users.setDatasource(_ds);
		LinkedList<UserStore> psl = Users.getAdmin();
		
		request.setAttribute("Users", psl);
		
		RequestDispatcher rd = request.getRequestDispatcher("/RenderAdmins.jsp"); 

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

