package com.abc.rory.models;
import java.util.LinkedList;

import javax.sql.DataSource;

import java.sql.*;

import com.abc.rory.stores.*;
public class DeveloperModel {
	private DataSource _ds = null;
	public DeveloperModel(){

	}

	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in Model"+_ds.toString());
	}

    public LinkedList<UserStore> getDevelopers(){
		LinkedList<UserStore> p = new LinkedList<UserStore>();
		Connection Conn;
		UserStore ps = null;
		ResultSet rs = null;
		try {
			Conn = _ds.getConnection();
		} catch (Exception et) {

			System.out.println("No Connection in Faults Model");
			return null;
		}

		//PreparedStatement pmst = null;
		Statement stmt = null;
		String sqlQuery = "select name, section from author where permission='developer'";
		
		System.out.println("User Query " + sqlQuery);
		try {
			try {
				// pmst = Conn.prepareStatement(sqlQuery);
				stmt = Conn.createStatement();
			} catch (Exception et) {
				System.out.println("Can't create prepare statement");
				return null;
			}
			System.out.println("Created prepare");
			try {
				// rs=pmst.executeQuery();
				rs = stmt.executeQuery(sqlQuery);
			} catch (Exception et) {
				System.out.println("Can not execut query " + et);
				return null;
			}
			System.out.println("Statement executed");
			if (rs.wasNull()) {
				System.out.println("result set was null");
			} else {
				System.out.println("Well it wasn't null");
			}
			while (rs.next()) {
				System.out.println("Getting RS");
				ps = new UserStore();
				ps.setUsername(rs.getString("name"));
				ps.setSection(rs.getString("section"));
				
				p.add(ps);
			}
		} catch (Exception ex) {
			System.out.println("Opps, error in query " + ex);
			return null;
		}

		try {

			Conn.close();
		} catch (Exception ex) {
			return null;
		}
		return p;

	}
}
