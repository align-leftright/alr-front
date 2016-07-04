package org.weaver.alr.front.common.model;

import java.util.List;

public class Page <M>{
	private Integer from;
	private Integer size;
	private Integer total;
	private Integer count;
	private List<M> items;

	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<M> getItems() {
		return items;
	}
	public void setItems(List<M> items) {
		this.items = items;
	}
	
}
