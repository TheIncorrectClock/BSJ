package com.theincorrectclock.bsj;

import java.util.Collections;
import java.util.Map;

public class InvestmentStrategy {

    private Map<InvestmentFundType, Double> strategyDetails;

    public InvestmentStrategy(Map<InvestmentFundType, Double> strategyDetails) {
        this.strategyDetails = strategyDetails;
    }

    public Map<InvestmentFundType, Double> getInfo() {
        return Collections.unmodifiableMap(strategyDetails);
    }
}
