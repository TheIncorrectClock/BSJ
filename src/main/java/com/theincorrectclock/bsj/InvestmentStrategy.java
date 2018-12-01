package com.theincorrectclock.bsj;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class InvestmentStrategy {

    private Map<InvestmentFundType, Double> strategyDetails;

    InvestmentStrategy(List<Pair<InvestmentFundType, Double>> list) {
        if(isHundredPercent(list)) {
            strategyDetails = createStrategyDetails(list);
        } else {
            throw new RuntimeException();
        }

    }

    private Map<InvestmentFundType, Double> createStrategyDetails(List<Pair<InvestmentFundType, Double>> list) {
        return list.stream().
                collect(Collectors.toMap(
                        Pair::getFirst,
                        Pair::getSecond
                ));
    }

    private boolean isHundredPercent(List<Pair<InvestmentFundType, Double>> list) {
        double s = list.stream().
                map(Pair::getSecond).
                reduce(0.0, (sum, val) -> sum + val);
        return Math.abs(1.0 - s) < 0.00001;
    }

    Map<InvestmentFundType, Double> getInfo() {
        return Collections.unmodifiableMap(strategyDetails);
    }

    Double getInfo(InvestmentFundType type) {
        return strategyDetails.get(type);
    }
}
