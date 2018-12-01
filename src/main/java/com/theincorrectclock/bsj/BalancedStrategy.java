package com.theincorrectclock.bsj;

import java.util.Arrays;

class BalancedStrategy extends InvestmentStrategy {

    BalancedStrategy() {
        super(Arrays.asList(
                Pair.pair(InvestmentFundType.DOMESTIC, 0.3),
                Pair.pair(InvestmentFundType.FOREIGN, 0.6),
                Pair.pair(InvestmentFundType.FINANCIAL, 0.1)
        ));
    }
}
