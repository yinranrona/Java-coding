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
 * m_employeeリストのDTOです。
 * @author emBex Education
 */
public class ListEmp implements Serializable {
	/**
	 * 従業員リスト
	 */
	private List<EmpBean> listEmpBean;

	/**
	 * ListEmployeeBeanを構築します。
	 */
	public ListEmp() {
		listEmpBean = new ArrayList<EmpBean>();


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
