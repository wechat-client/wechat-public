package com.wechat.common.utils;

import com.wechat.common.exception.WechatEcxeption;

/**
 * @ file_name Page.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月17日下午2:38:10
 * @ description
 * @ reviewed_by 
 */
public class Pagination {

	public static final int PAGE_SMALL_SIZE = 10;
	public static final int PAGE_DEFAULT_SIZE = 15;
	public static final int PAGE_LARGE_SIZE = 20;
	
	private int page;
	
	private int pageSize;
	
	public Pagination() throws WechatEcxeption {
		this(1);
	}
	
	public Pagination(int page) throws WechatEcxeption {
		this(page, PAGE_DEFAULT_SIZE);
	}
	public Pagination(int page,int pageSize) throws WechatEcxeption {
		if(page<1){
			throw new WechatEcxeption("页码必须大于1");
		}
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getFirstResult(){
		return (page-1)*pageSize;
	}
	
	public int getMaxResult(){
		return this.pageSize;
	}

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
	
	
}
