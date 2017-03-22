package fr.iutinfo.skeleton.servlet;
/**
* @author team9
* SERVLET D AFFICHAGE DE REPONSE
*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.selectItem_return;

import java.io.*;
import java.sql.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/Error"})
public class Error extends HttpServlet{
	static String bddurl = "src/main/resources/data.db";
	String type;
	//CONVENTION : tous parametres en minuscules
	
	String query = "";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter page = res.getWriter();
		page.println("<html><head></head><body>");
		try{
			type = req.getParameter("cause");
			
			switch (type) {
			case "xmlselect":
				page.println("<h1>Erreur 400 : Bad Request</h1><br><div>Vous avez tenté d'effectuer un select sans utiliser le mot clé \"select\".</div>");
				break;
			case "xmlresptype":
				page.println("<h1>Erreur 400 : Bad Request</h1><br><div>Vous avez tenté d'afficher un type de donnée inconnu.</div>");
				break;
			case "xmltableset":
				page.println("<h1>Erreur 400 : Bad Request</h1><br><div>Vous avez tenté d'afficher une table invalide.</div>");
				break;
			default:
				break;
			}
			
		}catch (Exception e){
			System.out.println("[ERROR] "+e.getMessage());
			e.printStackTrace();
		}finally{
			page.println("</body></html>");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		service(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		service(request, response);
	}

}