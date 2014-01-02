package org.guili.ecshop.bean.spider;

/**
 * 好产品
 * @ClassName:   GoodProduct 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-2 下午4:32:47 
 */
public class GoodProduct {
	private long   id;		 	//产品主键
	private String url;		 	//好产品链接
	private String productName; //好产品名称
	private String realPrice;	//卖价
	private String prePrice; 	//之前价格
	private String quanUrl;	 	//券链接
	private String quanDesc; 	//券描述
	private	String isSoldout;	//是否售罄   1 未售罄，0，售罄
	private String productDesc;	//产品描述
	private String email;      	//发布者邮箱地址
	private String productResource;//产品渠道
	private String username;   	//推荐人
	private String reason;		//推荐原因
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(String realPrice) {
		this.realPrice = realPrice;
	}
	public String getPrePrice() {
		return prePrice;
	}
	public void setPrePrice(String prePrice) {
		this.prePrice = prePrice;
	}
	public String getQuanUrl() {
		return quanUrl;
	}
	public void setQuanUrl(String quanUrl) {
		this.quanUrl = quanUrl;
	}
	public String getQuanDesc() {
		return quanDesc;
	}
	public void setQuanDesc(String quanDesc) {
		this.quanDesc = quanDesc;
	}
	public String getIsSoldout() {
		return isSoldout;
	}
	public void setIsSoldout(String isSoldout) {
		this.isSoldout = isSoldout;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProductResource() {
		return productResource;
	}
	public void setProductResource(String productResource) {
		this.productResource = productResource;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
