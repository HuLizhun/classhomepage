package com.textile083.entity;

/**
 * 分页对应的实体类
 * 
 * @author Administrator
 *
 */
public class Page {

	private int totalNumber;// 总条数
	private int currentPage;// 当前页数
	private int totalPage;// 总页数
	private int pageNumber = 5;// 每页显示的条数
	private int dbIndex;// 数据库中limit的参数，表示从第几条开始取
	private int dbNumber;// 数据库中limit的参数，表示一共取多少条

	public Page(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public void count() {
		// 计算总页数
		int totalPageTemp = this.totalNumber / this.pageNumber;// 总条数除以每页条数
		int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;// 如果不整除，需要加一页
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;
		// 设置当前页数
		// 总页数小于当前页数时，应将当前页数设置为总页数
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
		// 当千叶梳小于1时设置为1
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		// 设置limit的参数
		this.dbIndex = (this.currentPage - 1) * this.pageNumber;// 从当前页第一条开始取
		this.dbNumber = this.pageNumber;// 每页显示的条数
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		this.count();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
}
