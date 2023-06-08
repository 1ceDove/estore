package com.briup.bean;

import java.util.Set;
/**
 * 书籍一级分类（大分类）
 * @author briup
 *
 */
public class Category implements Comparable<Category>{
	/*书籍大分类编号*/
	private long id;
	/*书籍大分类名字*/
	private String name;
	/*书籍大类型下包含的所有小类型*/
	private Set<CategoryDetail> detail;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<CategoryDetail> getDetail() {
		return detail;
	}
	public void setDetail(Set<CategoryDetail> detail) {
		this.detail = detail;
	}
	@Override
	public int compareTo(Category o) {
		return (this.getId()>o.getId())?1:-1;
	}
	
}
