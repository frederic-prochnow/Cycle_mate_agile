package fr.iutinfo.skeleton.api;
/**
* @author team9
* GESTION UTILISATEURS
*/

import fr.iutinfo.skeleton.common.dto.MoyenneDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Moyenne {

	final static Logger logger = LoggerFactory.getLogger(Moyenne.class);
    
	private int id;
    private int moyPuissance;
    private int moyCalories;
    private int moyVitesse;
    private int moyFreqcard;
    
    public Moyenne(Integer id, int moyPuissance, int moyCalories, int moyVitesse, int moyFreqcard) {
    	this.id = id;
		this.moyPuissance = moyPuissance;
		this.moyCalories = moyCalories;
		this.moyVitesse = moyVitesse;
		this.moyFreqcard = moyFreqcard;
	}
    
    public Moyenne() {}

    public void initFromDto(MoyenneDto dto) {
    	this.setId(dto.getId());
    	this.setMoyPuissance(dto.getMoyPuissance());
    	this.setMoyCalories(dto.getMoyCalories());
    	this.setMoyVitesse(dto.getMoyVitesse());
    	this.setMoyFreqcard(dto.getMoyFreqcard());
    }

    public MoyenneDto convertToDto() {
        MoyenneDto dto = new MoyenneDto();
        dto.setId(this.getId());
        dto.setMoyPuissance(this.getMoyPuissance());
        dto.setMoyCalories(this.getMoyCalories());
        dto.setMoyVitesse(this.getMoyVitesse());
        dto.setMoyFreqcard(this.getMoyFreqcard());
        return dto;
    }

	@Override
	public String toString() {
		return "IdMoyenne [moyPuissance=" + moyPuissance + ", moyCalories=" + moyCalories + ", moyVitesse=" + moyVitesse
				+ ", moyFreqcard=" + moyFreqcard + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moyenne other = (Moyenne) obj;
		if (moyCalories != other.moyCalories)
			return false;
		if (moyFreqcard != other.moyFreqcard)
			return false;
		if (moyPuissance != other.moyPuissance)
			return false;
		if (moyVitesse != other.moyVitesse)
			return false;
		return true;
	}

	public int getMoyPuissance() {
		return moyPuissance;
	}

	public void setMoyPuissance(int moyPuissance) {
		this.moyPuissance = moyPuissance;
	}

	public int getMoyCalories() {
		return moyCalories;
	}

	public void setMoyCalories(int moyCalories) {
		this.moyCalories = moyCalories;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
