/*
 * WebApp_ex0501
 * model.entity.EmployeeBean.java
 */
package model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 従業員を表します。
 * m_employeeのDTOであり、Beanオブジェクトです。
 * @author emBex Education
 */
public class EmpBean implements Serializable {

	/**
	 * 従業員コード
	 */
	private String employeeCode;

	/**
	 * 氏
	 */
	private String lastName;

	/**
	 * 名
	 */
	private String firstName;

	/**
	 * 氏かな
	 */
	private String lastKanaName;

	/**
	 * 名かな
	 */
	private String firstKanaName;

	/**
	 * 性別
	 */
	private int gender;

	/**
	 * 生年月日
	 */
	private Date birthDay;

	/**
	 * 部署
	 */
	private String sectionCode;

	/**
	 * 入社日
	 */
	private Date hireDate;

	/**
	 * 更新日時
	 */
	private Timestamp updateDatetime;

	/**
	 * EmployeeBeanを構築します。
	 */
	public EmpBean() {

	}

	/**
	 * フィールドemployeeCodeの値を返します。
	 * @return employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * フィールドemployeeCodeの値を設定します。
	 * @param employeeCode
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	/**
	 * フィールドlastNameの値を返します。
	 * @return 氏
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * フィールドlastNameの値を設定します。
	 * @param lastName 氏
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * フィールドfirstNameの値を返します。
	 * @return 名
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * フィールドfirstNameの値を設定します。
	 * @param firstName 名
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * フィールドlastKanaNameの値を返します。
	 * @return 氏かな
	 */
	public String getLastKanaName() {
		return lastKanaName;
	}

	/**
	 * フィールドlastKanaNameの値を設定します。
	 * @param lastKanaName 氏かな
	 */
	public void setLastKanaName(String lastKanaName) {
		this.lastKanaName = lastKanaName;
	}

	/**
	 * フィールドfirstKanaNameの値を返します。
	 * @return 名かな
	 */
	public String getFirstKanaName() {
		return firstKanaName;
	}

	/**
	 * フィールドfirstKanaNameの値を設定します。
	 * @param firstKanaName 名かな
	 */
	public void setFirstKanaName(String firstKanaName) {
		this.firstKanaName = firstKanaName;
	}

	/**
	 * フィールドgenderの値を返します。
	 * @return 性別
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * フィールドgenderの値を設定します。
	 * @param gender 性別
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * フィールドbirthDayの値を返します。
	 * @return 生年月日
	 */
	public Date getBirthDay() {
		return birthDay;
	}

	/**
	 * フィールドbirthDayの値を設定します。
	 * @param birthDay 生年月日
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * フィールドsectionCodeの値を返します。
	 * @return 部署
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	/**
	 * フィールドsectionCodeの値を設定します。
	 * @param sectionCode 部署
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * フィールドhireDateの値を返します。
	 * @return 部署
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * フィールドhireDateの値を設定します。
	 * @param hireDate 部署
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * フィールドupdateDatetimeの値を返します。
	 * @return 更新日時
	 */
	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	/**
	 * フィールドupdateDatetimeの値を設定します。
	 * @param updateDatetime 更新日時
	 */
	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}






}
