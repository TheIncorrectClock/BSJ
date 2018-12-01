package com.theincorrectclock.bsj

import spock.lang.Specification

class FundDistributionSpec extends Specification {

    def 'investment scenario 1' () {
        given:
            def amount = 10000
            def funds = [
                    new InvestmentFund('pl01', 'Fundusz Polski 1', InvestmentFundType.DOMESTIC),
                    new InvestmentFund('pl02', 'Fundusz Polski 2', InvestmentFundType.DOMESTIC),
                    new InvestmentFund('zg01', 'Fundusz Zagraniczny 1', InvestmentFundType.FOREIGN),
                    new InvestmentFund('zg02', 'Fundusz Zagraniczny 2', InvestmentFundType.FOREIGN),
                    new InvestmentFund('zg03', 'Fundusz Zagraniczny 3', InvestmentFundType.FOREIGN),
                    new InvestmentFund('fn01', 'Fundusz Pieniężny 1', InvestmentFundType.FINANCIAL),
            ]
            def distribution = new FundDistribution()

        when:
            distribution.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            true
    }

    def 'investment scenario 2' () {
        given:
            def amount = 10001
            def funds = [
                new InvestmentFund('pl01', 'Fundusz Polski 1', InvestmentFundType.DOMESTIC),
                new InvestmentFund('pl02', 'Fundusz Polski 2', InvestmentFundType.DOMESTIC),
                new InvestmentFund('zg01', 'Fundusz Zagraniczny 1', InvestmentFundType.FOREIGN),
                new InvestmentFund('zg02', 'Fundusz Zagraniczny 2', InvestmentFundType.FOREIGN),
                new InvestmentFund('zg03', 'Fundusz Zagraniczny 3', InvestmentFundType.FOREIGN),
                new InvestmentFund('fn01', 'Fundusz Pieniężny 1', InvestmentFundType.FINANCIAL),
            ]
            def distribution = new FundDistribution()

        when:
            distribution.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            true
    }

    def 'investment scenario 3' () {
        given:
            def amount = 10005
            def funds = [
                new InvestmentFund('pl01', 'Fundusz Polski 1', InvestmentFundType.DOMESTIC),
                new InvestmentFund('pl02', 'Fundusz Polski 2', InvestmentFundType.DOMESTIC),
                new InvestmentFund('pl03', 'Fundusz Polski 3', InvestmentFundType.DOMESTIC),
                new InvestmentFund('zg01', 'Fundusz Zagraniczny 1', InvestmentFundType.FOREIGN),
                new InvestmentFund('zg02', 'Fundusz Zagraniczny 2', InvestmentFundType.FOREIGN),
                new InvestmentFund('fn01', 'Fundusz Pieniężny 1', InvestmentFundType.FINANCIAL),
            ]
            def distribution = new FundDistribution()

        when:
            distribution.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            true
    }

}
