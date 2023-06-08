package com.briup.bean;

/**
 * 产品
 * 
 * @author briup
 *
 */
public class Product {
	/* 书籍编号 */
	private Long id;
	/* 书籍名字 */
	private String name;
	/* 书籍价钱 */
	private Double price;
	/* 书籍出版社 */
	private String publish;
	/* 书籍图片 eg:大图#小图 */
	private String img;
	/* 书籍规格参数 */
	private String parameter;
	/* 书籍介绍 */
	private String introduction;
	/* 书籍清单 */
	private String wraplist;
	/* 书籍状态，1热卖：每中类型最多4本热卖书籍，0为非热卖 */
	private Integer hot;
	/* 书籍库存 */
	private Integer remain;
	/* 书籍销量 */
	private Integer sellnum;
	/* 书籍点击率 */
	private Integer clickrate;
	/* 书籍上架时间,毫秒数 */
	private Long publishdate;
	/* 书籍分类 */
	private CategoryDetail cate_detail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getWrapist() {
		return wraplist;
	}

	public void setWrapist(String wrapist) {
		this.wraplist = wrapist;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getRemain() {
		return remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	public Integer getSellnum() {
		return sellnum;
	}

	public void setSellnum(Integer sellnum) {
		this.sellnum = sellnum;
	}

	public Integer getClickrate() {
		return clickrate;
	}

	public void setClickrate(Integer clickrate) {
		this.clickrate = clickrate;
	}

	public Long getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Long publishdate) {
		this.publishdate = publishdate;
	}

	public CategoryDetail getCate_detail() {
		return cate_detail;
	}

	public void setCate_detail(CategoryDetail cate_detail) {
		this.cate_detail = cate_detail;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", publish=" + publish + ", img=" + img
				+ ", parameter=" + parameter + ", introduction=" + introduction + ", wrapist=" + wraplist + ", hot="
				+ hot + ", remain=" + remain + ", sellnum=" + sellnum + ", clickrate=" + clickrate + ", publishdate="
				+ publishdate + ", cate_detail=" + cate_detail + "]";
	}

}
