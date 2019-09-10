
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		String Name = request.getParameter("name");
		String Email = request.getParameter("emailid");
		String ConactNum = request.getParameter("num");
		String Gender = request.getParameter("num1");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("Hello this is sanjay");
		out.print("<br>");
		out.println("Field Can't be empty");

		try {
			Class.forName("org.postgresql.Driver");
			try

			(Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/CRUD", "postgres",
					"2809")) {

				java.sql.Statement stmt = null;
				stmt = conn.createStatement();
				if (conn != null) {
					System.out.println("Connected to the database!");
					// DATA INSERTON
					java.sql.PreparedStatement pmt = null;

					String query = "INSERT INTO public.\"Sanjay\"(\"UserName\",\"Email\",\"Gender\",\"ContactNum\") VALUES(?,?,?,?)";
					pmt = conn.prepareStatement(query);
					pmt.setString(1, Name);
					pmt.setString(2, Email);
					pmt.setString(3, Gender);
					pmt.setString(4, ConactNum);
					pmt.executeUpdate();
					System.out.println(Email);
					System.out.println(Name);
					System.out.println(Gender);
					System.out.println(ConactNum);

				} else
					System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("org.postgresql.Driver");
			try

			(Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/CRUD", "postgres",
					"2809")) {
				java.sql.Statement stmt = null;
				stmt = conn.createStatement();
				if (conn != null) {
					System.out.println("Connected to the database!");
					// RETRIVING DATA FROM DATBASE
					ResultSet rs1 = stmt.executeQuery("SELECT * FROM public.\"Sanjay\"");
					while (rs1.next()) {
						
						System.out.print(rs1.getString(1));
						System.out.println(rs1.getString(2));
						System.out.println(rs1.getString(3));
						System.out.println(rs1.getString(4));
											
			}
				} else
					System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//	
//	//DELETION OF THE DATA CODE STARTS FROM HERE FROM THE DATABASE POSTGRESQL THAT HAS THE TABLE NAME SANJAY
////	@WebServlet("/Remove")
////	 class Remove extends HttpServlet {
////	private static final long serialVersionUID = 1L;
//
//	protected void doPost1(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
//		 response1.setContentType("text/html");
//		    PrintWriter out = response1.getWriter();
//
//		try {
//			Class.forName("org.postgresql.Driver");
//			try
//
//			(Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/CRUD", "postgres",
//					"2809")) {
//
//				java.sql.Statement stmt1 = null;
//				stmt1 = conn.createStatement();
//				if (conn != null) {
//					System.out.println("Connected to the database!");
//					 //DELETE DATA FROM DATABASE
//					String query1 = "DELETE FROM public.\"Sanjay\" WHERE \"UserName\" = 'maja' ";
//					Statement stmt11 = null;
//					stmt11 = conn.createStatement();
//					stmt11.execute(query1);
//				}
//				else 
//					System.out.println("Failed to make connection!");
//			}
//	}
//				catch (SQLException e) {
//					e.printStackTrace();
//				} catch (Exception e) {
//					e.printStackTrace();
//
//				}
//		}
//	public static void main(String[] args) {
//		
//	}

//
//					// RETRIVING DATA FROM DATBASE
//					ResultSet rs1 = stmt.executeQuery("SELECT * FROM public.\"Sanjay\"");
//					while (rs1.next()) {
//						System.out.println(rs1.getString(1));
//						System.out.println(rs1.getString(2));
//						
//						
//						out.println(
//								"<table align=\"center\" width=40% style=\"font-family:'Exo', sans-serif;;border: 4px solid gray;color:#F7DC6F;\">");
//						out.println("<tr><th>Name </th></th> " + "<th>Email</th>" + "<th>Gender</th>" + "<th>ContactNum</th>" + "</tr>" );
//						
//						while (rs1.next()) {
//
//							out.println("<tr><td align=\"center\" width=\"25%\">" + "<b>" + rs1.getString(1) + "</b>"
//									+ "</td>");
//
//							out.println("<td align=\"center\" width=\"25%\">" + "<b>" + rs1.getString(2) + "</b>"
//									+ "</td>");
//
//							out.println("<td align=\"center\" width=\"25%\">" + "<b>" + rs1.getString(3) + "</b>"
//									+ "</td>");
//
//							out.println("<td align=\"center\" width=\"25%\">" + "<b>" + rs1.getString(4) + "</b>"
//									+ "</td>" + "</tr>");
//							
//						}
//					}
//					
//
//					// UPDATE DATA FROM DATABASE
//					String query2 = "UPDATE public.\"Sanjay\" SET \"Email\" = 'adi@gmail.com' WHERE \"Gender\" = 'b'  ";
//					Statement stmt111 = null;
//					stmt111 = conn.createStatement();
//					stmt111.execute(query2);
