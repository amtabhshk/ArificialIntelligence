package dev.ai.valuesetters;

public class MapValueSetters {
	
	String MAPTYPE;//hybrid,roadmap,stellite
	String ZOOM;//upto 20
	String PLACE;//placess like pune...
	public String getMAPTYPE() {
		return MAPTYPE;
	}
	public void setMAPTYPE(String mAPTYPE) {
		MAPTYPE = mAPTYPE;
	}
	public String getZOOM() {
		return ZOOM;
	}
	public void setZOOM(String zOOM) {
		ZOOM = zOOM;
	}
	public String getPLACE() {
		return PLACE;
	}
	public void setPLACE(String pLACE) {
		PLACE = pLACE;
	}

}
