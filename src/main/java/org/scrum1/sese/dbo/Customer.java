package org.scrum1.sese.dbo;

public interface Customer extends User {

	public String getCompanyName();

	public void setCompanyName(String companyName);

	public String getFax();

	public void setFax(String fax);

	public String getWeb();

	public void setWeb(String web);

	public String getNote();

	public void setNote(String note);

	// TODO discount, datatype?

}
