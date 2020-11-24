package com.maq.ecom.model;

public class Category {

    private String categoryId, categoryName, categoryBanner, categoryImage, status, products;

    public Category(String categoryId, String categoryName, String categoryBanner, String categoryImage, String status, String products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryBanner = categoryBanner;
        this.categoryImage = categoryImage;
        this.status = status;
        this.products = products;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryBanner() {
        return categoryBanner;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public String getStatus() {
        return status;
    }

    public String getProducts() {
        return products;
    }
}
