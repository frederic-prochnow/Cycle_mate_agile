package fr.iutinfo.skeleton.servlet;
/**
* @author team9
* SERVLET D AFFICHAGE DE REPONSE
*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/GetXML"})
public class GetData extends HttpServlet{
	static String bddurl = "src/main/resources/data.db";
	String type;
	String resp;
	String table;
	String cond;
	//CONVENTION : tous parametres en minuscules
	
	String query = "";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml;charset=UTF-8");
		PrintWriter fxml = res.getWriter();
		Connection connection = null;
		try{
		
			type = req.getParameter("type");
			resp = req.getParameter("resp");
			table = req.getParameter("table");
			cond = req.getParameter("cond"); // SANS "where"

			//analyse "select"
			switch (type) {
			case "select":
				query += "select";
				break;
				/*case "insert":
			query += "insert";
			break;
		case "update":
			query += "update";
			break;
		case "delete":
			query += "delete";
			break;*/
			default:
				System.out.println("[ERROR] Erreur de requete : \"select\"");
				res.sendError(HttpServletResponse.SC_BAD_REQUEST);
				res.sendRedirect("./Error?cause=xmlselect");
				break;
			}
			//analyse response type null ?
			if (resp==null || resp.equals("") || resp.equals("null")){
				System.out.println("[ERROR] Erreur de requete : \"response type\"");
				res.sendError(HttpServletResponse.SC_BAD_REQUEST);
				res.sendRedirect("./Error?cause=xmlresptype");
			}
			//analyse table null ?
			if (table == null || table.equals("") || table.equals("null")){
				System.out.println("[ERROR] Erreur de requete : \"table undefined\"");
				res.sendError(HttpServletResponse.SC_BAD_REQUEST);
				res.sendRedirect("./Error?cause=xmltableset");
			}
			//analyse cond null ?
			if (cond == null || cond.equals("") || cond.equals("null")){
				cond = "";
			} else {
				String tmp = cond;
				cond += "where "+tmp;
			}

			query = query + " " + resp + " from " + table + " " + cond;

			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+bddurl);
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			fxml.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			int nb_col;
			int line = 0;
			String colname;
			while(rs.next()){
				nb_col = rs.getMetaData().getColumnCount();
				line ++;
				fxml.println("<data"+line+">");
				for (int i = 1; i<=nb_col; i++){
					colname = rs.getMetaData().getColumnLabel(i);
					fxml.println("<"+colname+">"+rs.getString(i)+"</"+colname+">");
				}
				fxml.println("</data"+line+">");
			}
			

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
