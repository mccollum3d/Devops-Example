package com.revature.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.ConnectionFactory;

/**
 * Servlet implementation class JDBCTestServlet
 */
public class JDBCTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Step 1:  Set up the printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// Step 2:  Get a connection to the database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = ConnectionFactory.getConnection();
			
			// Step 3:  Create a SQL statements
			String sql = "select * from TODOS";
			myStmt = myConn.createStatement();
			
			// Step 4:  Execute SQL query
			myRs = myStmt.executeQuery(sql);
			
			// Step 5:  Process the result set
			while (myRs.next()) {
				String temp = myRs.getString("title");
				out.println(temp);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}