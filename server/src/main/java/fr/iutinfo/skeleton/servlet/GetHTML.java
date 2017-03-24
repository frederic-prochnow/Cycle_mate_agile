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
@WebServlet(urlPatterns={"/GetHTML"})
public class GetHTML extends HttpServlet{
	static String bddurl = "src/main/resources/data.db";
	String table;
	String column;
	String data;
	boolean hascond = false;
	//CONVENTION : tous parametres en minuscules
	
	String query = "";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter page = res.getWriter();
		Connection connection = null;
		table = req.getParameter("table");
		column = req.getParameter("column");
		data = req.getParameter("data");
		try{
			//analyse table null ?
			if (table == null || table.equals("") || table.equals("null")){
				System.out.println("[ERROR] Erreur de requete : \"table undefined\"");
				res.sendError(HttpServletResponse.SC_BAD_REQUEST);
				res.sendRedirect("./Error?cause=htmltableset");
			}
			
			query = "Select * from " + table;
			if (column!=null && !column.equals("") && !column.equals("null")){
				query += " where " + column+"=?";
				hascond=true;
			}
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+bddurl);
			System.out.println("[SERVER INFO] request from "+req.getRemoteAddr());
			System.out.println("[SGBD SQLite DEBUG] retour en HTML de la requete "+query);
			PreparedStatement stmt = connection.prepareStatement(query);
			if (hascond){
				stmt.setString(1, data);
				System.out.println("[SGBD SQLite DEBUG] Added "+ data +" on the ? no 1");
			}
			ResultSet rs = stmt.executeQuery();
			
			page.println("<!DOCTYPE html><html lang=\"fr\">");
			page.println("<head>\n"
					+ "  <meta http-equiv=\"Content-Type\" content=\"text.html; charset=utf8\" />\n"
					+ "  <title>HTMLview</title>\n"
					+ "  <meta name=\"auteur\" content=\"Anthony Mathon\"\n"
					+ "</head>\n"
					+ "<body><center>");
			
			page.println("  <h1>"+table+"</h1>");
			int nb_col=0;
			String colname = "";
			page.print("  <table class='table table-bordered table-striped'>\n"
					+ "    <thread>\n      <tr>\n");
			nb_col = rs.getMetaData().getColumnCount();
			for(int p = 1; p<= nb_col; p++){
				colname = rs.getMetaData().getColumnLabel(p);
				page.println("        <th>"+colname+"</th>");
			}
			page.println("      </tr>\n    </thread>\n    <tbody>");
			while(rs.next()){
				page.println("      <tr>");
				for (int i = 1; i<=nb_col; i++){
					page.println("        <td>"+rs.getString(i)+"</td>");
				}
				page.println("      </tr>");
			}
			page.println("    </tbody>\n  </table>\n</body>\n</html>");

			connection.close();
		}catch (Exception e){
			System.out.println("[ERROR] "+e.getMessage());
			e.printStackTrace();
			res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			res.getWriter().println("<html><head></head><body><h1>Erreur 500.</h1><h2>Contactez l'administrateur.</h2></body></html>");
		}finally{
			try{
				page.close();
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
