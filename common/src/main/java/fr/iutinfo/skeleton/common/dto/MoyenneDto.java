package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class MoyenneDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(MoyenneDto.class);
    
    private int id;
    private int moyPuissance;
    private int moyCumulCalories;
    private int moyVitesse;
    private int moyFreqcard;
    
	public int getMoyPuissance() {
		return moyPuissance;
	}
	public void setMoyPuissance(int moyPuissance) {
		this.moyPuissance = moyPuissance;
	}
	public int getMoyCalories() {
		return moyCumulCalories;
	}
	public void setMoyCalories(int moyCalories) {
		this.moyCumulCalories = moyCalories;
	}
	public int getMoyVitesse() {
		return moyVitesse;
	}
	public void setMoyVitesse(int moyVitesse) {
		this.moyVitesse = moyVitesse;
	}
	public int getMoyFreqcard() {
		return moyFreqcard;
	}
	public void setMoyFreqcard(int moyFreqcard) {
		this.moyFreqcard = moyFreqcard;
	}
	@Override
	public String getName() {
		return null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
