package com.theincorrectclock.bsj;

import java.util.Arrays;

class AggressiveStrategy extends InvestmentStrategy {

    AggressiveStrategy() {
        super(Arrays.asList(
                Pair.pair(InvestmentFundType.DOMESTIC, 0.4),
                Pair.pair(InvestmentFundType.FOREIGN, 0.2),
                Pair.pair(InvestmentFundType.FINANCIAL, 0.4)
        ));
    }
}
