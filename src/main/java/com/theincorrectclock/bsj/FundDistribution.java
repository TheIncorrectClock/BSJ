package com.theincorrectclock.bsj;

import java.util.List;
import java.util.Optional;

public class FundDistribution {

    public void invest(List<InvestmentFund> funds, InvestmentStrategyType strategyType, double amount) {
        Optional<InvestmentStrategy> strategy = strategyType.get();

        strategy.ifPresent(investmentStrategy -> investmentStrategy.invest(funds, amount));
    }

}
