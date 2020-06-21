package model.dao;

import java.sql.SQLException;

import model.entity.ListEmp;
import model.entity.PageBean;

public class PageDAO {
	
	public PageBean pageInfo(int currentPage, int pageSize) throws ClassNotFoundException, SQLException {
		
		EmpDAO empdao = new EmpDAO();
		
		int count = empdao.paginationCount();
		int totalPage = (int)Math.ceil((double)count/pageSize);
		ListEmp pagelist = empdao.selectPagination(currentPage, pageSize);
		
		PageBean pagebean = new PageBean();
		pagebean.setCurrentPage(currentPage);
		pagebean.setPageSize(pageSize);
		pagebean.setCount(count);
		pagebean.setTotalPage(totalPage);
		pagebean.setEmpBean(pagelist);
		
		return pagebean;
	}

}
