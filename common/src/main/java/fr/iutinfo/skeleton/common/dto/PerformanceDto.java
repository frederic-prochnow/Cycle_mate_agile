package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class PerformanceDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(PerformanceDto.class);
    private int id;
    private int puissance;
    private int calories;
    private int vitesse;
    private int freqcard;
    private int periode;

    
	public String getName() {
		return ""+id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getFreqcard() {
		return freqcard;
	}

	public void setFreqcard(int freqcard) {
		this.freqcard = freqcard;
	}

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}
}
