package com.maq.ecom.model;

public class Order {

    private String orderId, orderDate,orderAmount,nag , crate, weight, status;
    private String milk, dahi,customerCode , customerName, route;

    public Order(String orderId, String orderDate, String orderAmount, String nag, String crate, String weight, String status, String milk, String dahi) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.nag = nag;
        this.crate = crate;
        this.weight = weight;
        this.status = status;
        this.milk = milk;
        this.dahi = dahi;
    }

    public Order(String orderId, String orderDate, String orderAmount, String nag, String crate, String weight, String status, String milk, String dahi, String customerCode, String customerName, String route) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.nag = nag;
        this.crate = crate;
        this.weight = weight;
        this.status = status;
        this.milk = milk;
        this.dahi = dahi;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.route = route;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public String getNag() {
        return nag;
    }

    public String getCrate() {
        return crate;
    }

    public String getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    public String getMilk() {
        return milk;
    }

    public String getDahi() {
        return dahi;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoute() {
        return route;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
