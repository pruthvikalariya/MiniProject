package com.app.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class forgotpassword
 */
public class forgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

        try
            {
		        String newpswd;  
		        ServletRequest session = null;
		        HttpSession se=request.getSession();
		        /* Class.forName("com.mysql.jdbc.Driver"); */
		         
		      
		        newpswd =request.getParameter("fp1");
		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databsenm","root","");
		       
		        
				String email =(String)session.getAttribute("id");
		       System.out.println("Welcome:"+email);
		        
		        if(newpswd!=null)
		        {
			        PreparedStatement pst=con.prepareStatement("update userDetails set password='"+newpswd+"' where email='"+ email +"'");
			        int i=pst.executeUpdate();
			        if(i>0)
			        	{
			            System.out.println("Password has been updated");
			            response.sendRedirect("index.jsp");
			        	}
	          	}
            }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
