package model.entity;

public class PageBean {
	private int currentPage;
	private int pageSize;
	private int count;
	private int totalPage;
	private ListEmp empbean;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public ListEmp getEmpBean() {
		return empbean;
	}
	public void setEmpBean(ListEmp empbean) {
		this.empbean = empbean;
	}
	
	
}
