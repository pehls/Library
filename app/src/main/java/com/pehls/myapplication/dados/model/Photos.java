package com.pehls.myapplication.dados.model;

import java.util.Collection;
import java.util.List;

public class Photos {
	String page;
	String pages;
	String perpage;
	String total;
	Collection<Photo> photo;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getPerpage() {
		return perpage;
	}
	public void setPerpage(String perpage) {
		this.perpage = perpage;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Collection<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(Collection<Photo> photo) {
		this.photo = photo;
	}
	

}