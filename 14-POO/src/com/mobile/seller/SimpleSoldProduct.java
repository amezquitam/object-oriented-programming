package com.mobile.seller;

import java.math.BigDecimal;

class SimpleSoldProduct {
    String modelName;
    BigDecimal price;

    public SimpleSoldProduct(String modelName, BigDecimal price) {
        this.modelName = modelName;
        this.price = price;
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
}
