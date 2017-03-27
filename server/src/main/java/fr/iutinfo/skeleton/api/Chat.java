package fr.iutinfo.skeleton.api;
/**
* @author team9
* GESTION UTILISATEURS
*/

import fr.iutinfo.skeleton.common.dto.ChatDto;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chat {

	final static Logger logger = LoggerFactory.getLogger(Chat.class);
    
	private int id;
    private String nom;
    private String message;
    private Date time;
    
    public Chat(Integer id, String nom, String msg, Date date) {
    	this.id = id;
    	this.nom = nom;
    	this.message = msg;
    	this.time = date;
	}
    
    public Chat() {}

    public void initFromDto(ChatDto dto) {
    	this.setId(dto.getId());
    	this.setNom(dto.getNom());
    	this.setMessage(dto.getMessage());
    	this.setTime(dto.getTime());
    }

    public ChatDto convertToDto() {
        ChatDto dto = new ChatDto();
        dto.setId(this.getId());
        dto.setNom(this.nom);
        dto.setMessage(this.getMessage());
        dto.setTime(this.getTime());
        return dto;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

    

}
