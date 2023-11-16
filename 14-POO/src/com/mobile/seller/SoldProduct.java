package com.mobile.seller;

import java.math.BigDecimal;

public class SoldProduct {
    String modelName;
    BigDecimal price;
    String currency;

    public SoldProduct(String modelName, BigDecimal price, String currency) {
        this.modelName = modelName;
        this.price = price;
        this.currency = currency;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
