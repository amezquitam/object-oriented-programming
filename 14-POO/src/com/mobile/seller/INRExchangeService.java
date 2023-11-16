package com.mobile.seller;

import java.math.BigDecimal;
import java.util.Optional;

public class INRExchangeService implements ExchangeService {
    @Override
    public Optional<BigDecimal> rate(String currency) {
        return Optional.empty();
    }
}
