package fr.iutinfo.skeleton.servlet;
/**
* @author team9
* SERVLET D AFFICHAGE DE REPONSE
*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.validation.constraints.Null;

import java.io.*;
import java.sql.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/GetXML"})
public class GetXML extends HttpServlet{
	static String bddurl = "src/main/resources/data.db";
	String table;
	String column;
	String data;
	boolean hascond = false;
	//CONVENTION : tous parametres en minuscules
	
	String query = "";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml;charset=UTF-8");
		PrintWriter fxml = res.getWriter();
		Connection connection = null;
		table = req.getParameter("table");
		column = req.getParameter("column");
		data = req.getParameter("data");
		try{
			//analyse table null ?
			if (table == null || table.equals("") || table.equals("null")){
				System.out.println("[ERROR] Erreur de requete : \"table undefined\"");
				res.sendError(HttpServletResponse.SC_BAD_REQUEST);
				res.sendRedirect("./Error?cause=xmltableset");
			}
			
			query = "Select * from " + table;
			if (column!=null && !column.equals("") && !column.equals("null")){
				query += " where " + column+"=?";
				hascond=true;
			}
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+bddurl);
			System.out.println("[SERVER INFO] request from "+req.getRemoteAddr());
			System.out.println("[SGBD SQLite DEBUG] retour en XML de la requete "+query);
			PreparedStatement stmt = connection.prepareStatement(query);
			if (hascond){
				stmt.setString(1, data);
				System.out.println("[SGBD SQLite DEBUG] Added "+ data +" on the ? no 1");
			}
			ResultSet rs = stmt.executeQuery();
			
			fxml.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			fxml.println("<"+table+">");
			int nb_col;
			//int line = 0;
			String colname;
			while(rs.next()){
				nb_col = rs.getMetaData().getColumnCount();
				//line ++;
				fxml.println("  <user>");
				for (int i = 1; i<=nb_col; i++){
					colname = rs.getMetaData().getColumnLabel(i);
					fxml.println("    <info type=\""+colname+"\">"+rs.getString(i)+"</info>");
				}
				fxml.println("  </user>");
			}
			fxml.println("</"+table+">");
			//fxml.println("</xml>");
			fxml.close();
			connection.close();
		}catch (Exception e){
			System.out.println("[ERROR] "+e.getMessage());
			e.printStackTrace();
			res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			res.getWriter().println("<html><head></head><body><h1>Erreur 500.</h1><h2>Contactez l'administrateur.</h2></body></html>");
		}finally{
			try{
				fxml.close();
				connection.close();
			}catch(Exception e){}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		service(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		service(request, response);
	}

}
