package com.maq.ecom.model;


import java.io.Serializable;

public class CartItem implements Serializable {
    public String category, variants, itemName,  unit, price, image, mWt, itemCode;
    int qty;

    public CartItem(String category, String variants, String itemName, String unit, String price, String image, String mWt, String itemCode, int qty) {
        this.category = category;
        this.variants = variants;
        this.itemName = itemName;
        this.unit = unit;
        this.price = price;
        this.image = image;
        this.mWt = mWt;
        this.itemCode = itemCode;
        this.qty = qty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVariants() {
        return variants;
    }

    public void setVariants(String variants) {
        this.variants = variants;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getmWt() {
        return mWt;
    }

    public void setmWt(String mWt) {
        this.mWt = mWt;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
