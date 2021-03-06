package com.theincorrectclock.bsj;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Invest {

    public Map<InvestmentFund, Double> invest(List<InvestmentFund> funds, InvestmentStrategyType strategyType, double amount) {
        Objects.requireNonNull(funds);
        Objects.requireNonNull(strategyType);

        InvestmentStrategy strategy = strategyType.get();

        if(amount < 0.0) {
            return Collections.singletonMap(InvestmentFund.NOT_INVESTED, amount);
        } else if(funds.isEmpty()) {
            return Collections.singletonMap(InvestmentFund.NOT_INVESTED, amount);
        }
        return strategy.invest(funds, amount);
    }
}
