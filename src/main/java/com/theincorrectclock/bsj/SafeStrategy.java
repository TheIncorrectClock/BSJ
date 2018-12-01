package com.theincorrectclock.bsj;

import java.util.Arrays;

class SafeStrategy extends InvestmentStrategy {

    SafeStrategy() {
        super(Arrays.asList(
                Pair.pair(InvestmentFundType.DOMESTIC, 0.2),
                Pair.pair(InvestmentFundType.FOREIGN, 0.75),
                Pair.pair(InvestmentFundType.FINANCIAL, 0.05)
        ));
    }
}
