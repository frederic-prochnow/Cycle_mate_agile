package fr.iutinfo.skeleton.api;
/**
* @author team9
* GESTION UTILISATEURS
*/

import fr.iutinfo.skeleton.common.dto.PerformanceDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Performance {
    final static Logger logger = LoggerFactory.getLogger(Performance.class);
    
    private int id = 1;
    private int puissance;
    private int calories;
    private int vitesse;
    private int freqcard;
    private int periode;

    public Performance(int id, int puissance, int calories, int vitesse, int freqcard,int periode) {
    	this.id = id;
    	this.puissance = puissance;
    	this.calories = calories;
    	this.vitesse = vitesse;
    	this.freqcard = freqcard;
    	this.setPeriode(periode);
    }

    public Performance() {}

    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        Performance user = (Performance) arg;
        return id==user.id;
    }

    @Override
    public String toString() {
        return id + ": " + puissance + ", " + calories + ", " + vitesse + ", " + freqcard + "," + periode;
    }

    public void initFromDto(PerformanceDto dto) {
        this.setId(dto.getId());
        this.setPuissance(dto.getPuissance());
        this.setVitesse(dto.getVitesse());
        this.setCalories(dto.getCalories());
        this.setFreqcard(dto.getFreqcard());
        this.setPeriode(dto.getPeriode());
    }

    public PerformanceDto convertToDto() {
        PerformanceDto dto = new PerformanceDto();
        dto.setId(this.getId());
        dto.setPuissance(this.getPuissance());
        dto.setVitesse(this.getVitesse());
        dto.setCalories(this.getCalories());
        dto.setFreqcard(this.getFreqcard());
        dto.setPeriode(this.getPeriode());
        return dto;
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
