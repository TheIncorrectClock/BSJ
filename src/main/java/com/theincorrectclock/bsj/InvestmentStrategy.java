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
        return Math.abs(1.0 - divisionSum(list)) < 0.00001;
    }

    private Double divisionSum(List<Pair<InvestmentFundType, Double>> list) {
        return list.stream().
                map(Pair::getSecond).
                reduce(0.0, (sum, val) -> sum + val);
    }

    Map<InvestmentFundType, Double> getInfo() {
        return Collections.unmodifiableMap(strategyDetails);
    }

    private Double getInfo(InvestmentFundType type) {
        return strategyDetails.get(type);
    }

    void invest(List<InvestmentFund> funds, double amount) {
        Map<InvestmentFundType, Double> distribution = funds.stream().
                map(InvestmentFund::getType).
                distinct().
                map(f -> Pair.pair(f, Math.floor(getInfo(f) * amount))).
                collect(Collectors.toMap(
                        Pair::getFirst,
                        Pair::getSecond
                ));



        Map<InvestmentFundType, Long> fundTypes = funds.stream().
                collect(Collectors.groupingBy(InvestmentFund::getType, Collectors.counting()));

        Map<String, Double> investment = funds.stream().
                map(f -> Pair.pair(f.getName(), Math.floor(distribution.get(f.getType()) / fundTypes.get(f.getType())))).
                collect(Collectors.toMap(
                        Pair::getFirst,
                        Pair::getSecond
                ));


        double uninvestable = amount - investment.entrySet().stream().mapToDouble(Map.Entry::getValue).sum();

        investment.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("not invested: " + uninvestable);
    }
}
