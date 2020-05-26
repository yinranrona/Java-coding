/*
 * WebApp_ex0501
 * model.entity.ListEmpBean.java
 */
package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 従業員リストを表します。
 * m_employeeリストのDTOであり、Beanオブジェクトです。
 * @author emBex Education
 */
public class ListEmpBean implements Serializable {
	/**
	 * 従業員リスト
	 */
	private List<EmpBean> listEmpBean;

	/**
	 * ListEmployeeBeanを構築します。
	 */
	public ListEmpBean() {
		listEmpBean = new ArrayList<EmpBean>();


/*
		// リストを生成する
		EmpBean eb;
		while (rs.next()) {
			eb = new EmpBean();
			eb.setEmployeeCode(rs.getString(1));
			eb.setLastName(rs.getString(2));
			eb.setFirstName(rs.getString(3));
			eb.setLastKanaName(rs.getString(4));
			eb.setFirstKanaName(rs.getString(5));
			eb.setGender(rs.getInt(6));
			eb.setBirthDay(rs.getDate(7));
			eb.setSectionCode(rs.getString(8));
			eb.setHireDate(rs.getDate(9));
			eb.setUpdateDatetime(rs.getTimestamp(10));

			listEmpBean.add(eb);
		}
			*/

	}
	/**
	 * フィールドlistEmpBeanの値を返します。
	 * @return listEmpBean
	 */
	public List<EmpBean> getListEmpBean() {
		return listEmpBean;
	}

	/**
	 * フィールドlistEmpBeanの値を設定します。
	 * @param listEmpBean
	 */
	public void setListEmpBean(List<EmpBean> listEmpBean) {
		this.listEmpBean = listEmpBean;
	}

	/**
	 * フィールドlistEmpBeanにempBeanをaddします。
	 * @param empBean
	 */
	public void add(EmpBean empBean) {
		this.listEmpBean.add(empBean);
	}

	/**
	 * フィールドlistEmpBeanからインデクス指定でempBeanを返します。
	 * @param idx
	 */
	public EmpBean getEmpBean(int idx) {
		return this.listEmpBean.get(idx);
	}

}
