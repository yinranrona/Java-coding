package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class EmpLicenBean implements Serializable {

	private String employeeCode;
	private String licenseName;
	private Date licenseDate;
	
	public EmpLicenBean() {}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getLicenseName() {
		return licenseName;
	}

	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	
	public Date getLicenseDate() {
		return licenseDate;
	}

	public void setLicenseDate(Date licenseDate) {
		this.licenseDate = licenseDate;
	}

	

}
