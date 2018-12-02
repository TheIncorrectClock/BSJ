package com.theincorrectclock.bsj;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class InvestmentStrategy {

    private Map<InvestmentFundType, Double> strategyDetails;

    InvestmentStrategy(List<Pair<InvestmentFundType, Double>> list) {
        strategyDetails = createStrategyDetails(list);
    }

    Map<InvestmentFundType, Double> getInfo() {
        return Collections.unmodifiableMap(strategyDetails);
    }

    Map<InvestmentFund, Double> invest(List<InvestmentFund> funds, double amount) {
        Map<InvestmentFund, Double> investment
                = distributeBetweenFunds(
                        funds,
                        distributionByFundTypes(funds, amount),
                        countFundsByTypes(funds));

        double notInvested = calculateNotInvestedAmount(amount, investment);
        if(notInvested > 0.0) {
            investment.put(InvestmentFund.NOT_INVESTED, notInvested);
        }

        return Collections.unmodifiableMap(investment);
    }

    private Map<InvestmentFundType, Double> createStrategyDetails(List<Pair<InvestmentFundType, Double>> list) {
        return list.stream().
                collect(Collectors.toMap(
                        Pair::getFirst,
                        Pair::getSecond
                ));
    }
    private Double getInfo(InvestmentFundType type) {
        return strategyDetails.get(type);
    }

    private double calculateNotInvestedAmount(double amount, Map<InvestmentFund, Double> investment) {
        return amount - investment.entrySet().stream().mapToDouble(Map.Entry::getValue).sum();
    }

    private Map<InvestmentFund, Double> distributeBetweenFunds(List<InvestmentFund> funds, Map<InvestmentFundType, Double> distribution, Map<InvestmentFundType, Long> fundTypes) {
        return funds.stream().
                map(f -> Pair.pair(f, Math.floor(distribution.get(f.getType()) / fundTypes.get(f.getType())))).
                collect(Collectors.toMap(
                        Pair::getFirst,
                        Pair::getSecond
                ));
    }

    private Map<InvestmentFundType, Long> countFundsByTypes(List<InvestmentFund> funds) {
        return funds.stream().
                collect(Collectors.groupingBy(InvestmentFund::getType, Collectors.counting()));
    }

    private Map<InvestmentFundType, Double> distributionByFundTypes(List<InvestmentFund> funds, double amount) {
        return funds.stream().
                map(InvestmentFund::getType).
                distinct().
                map(f -> Pair.pair(f, Math.floor(getInfo(f) * amount))).
                collect(Collectors.toMap(
                        Pair::getFirst,
                        Pair::getSecond
                ));
    }
}
