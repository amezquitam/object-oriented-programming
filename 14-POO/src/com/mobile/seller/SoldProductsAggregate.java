package com.mobile.seller;

import java.math.BigDecimal;
import java.util.List;

class SoldProductsAggregate{
    List<SimpleSoldProduct> products;
    BigDecimal total;

    public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
        this.products = products;
        this.total = total;
    }

    public List<SimpleSoldProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SimpleSoldProduct> products) {
        this.products = products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
