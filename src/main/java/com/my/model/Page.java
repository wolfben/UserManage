package com.my.model;

public class Page {
	private int page;
	
	private int pageSize;
	
	private int pageCount;
	
	private int totalCount;
	
	private int start;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return (int)Math.ceil((double)this.totalCount/this.pageSize);
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStart() {
		return (this.page-1)*this.pageSize;
	}

	public void setStart(int start) {
		this.start = start;
	}
}
