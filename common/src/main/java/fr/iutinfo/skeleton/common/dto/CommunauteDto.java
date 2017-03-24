package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class CommunauteDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(CommunauteDto.class);

    private char[] Nom = new char[20];
    
	@Override
	public String getName() {
		return Nom.toString();
	}

	public char[] getNom() {
		return Nom;
	}

	public void setNom(char[] nom) {
		Nom = nom;
	}
    
    
    
}
