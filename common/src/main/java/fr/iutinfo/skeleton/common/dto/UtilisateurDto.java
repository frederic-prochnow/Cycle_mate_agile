package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class UtilisateurDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(UtilisateurDto.class);
    
    AdminDto adminDto = new AdminDto();
    CommunauteDto communauteDto = new CommunauteDto();
  
    private int UtilisateurId = 0;
    //private int AdminId = 0;
    private String FacebookId;
    private String Email;
    private String Prenom;
    //private char[] Communaute = new char[20];
    
	public int getUtilisateurId() {
		return UtilisateurId;
	}
	public void setUtilisateurId(int utilisateurId) {
		UtilisateurId = utilisateurId;
	}
	public int getAdminId() {
		return adminDto.getAdMinId();
	}
	public void setAdminId(int adminId) {
		adminDto.setAdMinId(adminId);
	}
	public String getFacebookId() {
		return FacebookId;
	}
	public void setFacebookId(String facebookId) {
		FacebookId = facebookId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public char[] getCommunaute() {
		return communauteDto.getNom();
	}
	public void setCommunaute(char[] communaute) {
		communauteDto.setNom(communaute);
	}
	@Override
	public String getName() {
		return ""+UtilisateurId;
	}
    
}
