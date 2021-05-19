package com.infy.oms.dto;

import java.math.BigDecimal;

public class ProductDTO {

	Long prodId;
	
	String brand;
	
	String category;
	
	String description;
	
	String image;
	
	BigDecimal price;
	
	String productName;
	
	Long rating;
	
	Long sellerId;
	
	Long stock;
	
	String subcategory;

	public ProductDTO(Long prodId, String brand, String category, String description, String image, BigDecimal price,
			String productName, Long rating, Long sellerId, Long stock, String subcategory) {
		this.prodId = prodId;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.image = image;
		this.price = price;
		this.productName = productName;
		this.rating = rating;
		this.sellerId = sellerId;
		this.stock = stock;
		this.subcategory = subcategory;
	}

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductDTO [prodId=" + prodId + ", brand=" + brand + ", category=" + category + ", description="
				+ description + ", image=" + image + ", price=" + price + ", productName=" + productName + ", rating="
				+ rating + ", seller=" + sellerId + ", stock=" + stock + ", subcategory=" + subcategory + "]";
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
}
