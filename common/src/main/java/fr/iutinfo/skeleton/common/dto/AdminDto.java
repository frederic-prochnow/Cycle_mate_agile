package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminDto {
    final static Logger logger = LoggerFactory.getLogger(AdminDto.class);

    private int AdMinId = 0;
    private String Login;
    private String Password;
    
	public int getAdMinId() {
		return AdMinId;
	}
	public void setAdMinId(int adMinId) {
		AdMinId = adMinId;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
}
