package com.hrishi.healthscience.covid19tracker20.bean;

public class GeographicalLocation {

	private String state;
	
	private String country;
	
	private String totalCasesForTheDay;
	
	private String totalPreviousDayCases;
	
	private String casesInLast24Hours;
	
	private String lastAvailableDate;

	public String getLastAvailableDate() {
		return lastAvailableDate;
	}

	public void setLastAvailableDate(String lastAvailableDate) {
		this.lastAvailableDate = lastAvailableDate;
	}

	public String getCasesInLast24Hours() {
		return casesInLast24Hours;
	}

	public void setCasesInLast24Hours(String casesInLast24Hours) {
		this.casesInLast24Hours = casesInLast24Hours;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTotalCasesForTheDay() {
		return totalCasesForTheDay;
	}

	public void setTotalCasesForTheDay(String totalCasesForTheDay) {
		this.totalCasesForTheDay = totalCasesForTheDay;
	}

	public String getTotalPreviousDayCases() {
		return totalPreviousDayCases;
	}

	public void setTotalPreviousDayCases(String totalPreviousDayCases) {
		this.totalPreviousDayCases = totalPreviousDayCases;
	}

	@Override
	public String toString() {
		return "GeographicalLocation [state=" + state + ", country=" + country + ", totalCasesForTheDay="
				+ totalCasesForTheDay + ", totalPreviousDayCases=" + totalPreviousDayCases + ", casesInLast24Hours="
				+ casesInLast24Hours + "]";
	}

}
