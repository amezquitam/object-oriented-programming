package com.mobile.seller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public class SoldProductsAggregator{
    private final INRExchangeService exchangeService;

    SoldProductsAggregator(INRExchangeService INRExchangeService){
        this.exchangeService = INRExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products){
        products.map(
                soldProduct -> new SimpleSoldProduct(soldProduct.modelName, soldProduct.getPrice().multiply(exchangeService.rate(soldProduct.currency)))
        );
    }
}
