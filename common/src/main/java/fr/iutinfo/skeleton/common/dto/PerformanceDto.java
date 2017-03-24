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
    
    private int puissancemoy;
    private int caloriesmoy;
    private int vitessemoy;
    private int freqcardmoy;
	@Override
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

	public int getPuissancemoy() {
		return puissancemoy;
	}

	public void setPuissancemoy(int puissancemoy) {
		this.puissancemoy = puissancemoy;
	}

	public int getCaloriesmoy() {
		return caloriesmoy;
	}

	public void setCaloriesmoy(int caloriesmoy) {
		this.caloriesmoy = caloriesmoy;
	}

	public int getVitessemoy() {
		return vitessemoy;
	}

	public void setVitessemoy(int vitessemoy) {
		this.vitessemoy = vitessemoy;
	}

	public int getFreqcardmoy() {
		return freqcardmoy;
	}

	public void setFreqcardmoy(int freqcardmoy) {
		this.freqcardmoy = freqcardmoy;
	}
}
