package com.theincorrectclock.bsj


import spock.lang.Specification

class InvestSpec extends Specification {

    def polishFund1 = new InvestmentFund('pl01', 'Fundusz Polski 1', InvestmentFundType.DOMESTIC)
    def polishFund2 = new InvestmentFund('pl02', 'Fundusz Polski 1', InvestmentFundType.DOMESTIC)
    def polishFund3 = new InvestmentFund('pl03', 'Fundusz Polski 1', InvestmentFundType.DOMESTIC)
    def foreignFund1 = new InvestmentFund('zg01', 'Fundusz Zagraniczny 1', InvestmentFundType.FOREIGN)
    def foreignFund2 = new InvestmentFund('zg02', 'Fundusz Zagraniczny 1', InvestmentFundType.FOREIGN)
    def foreignFund3 = new InvestmentFund('zg03', 'Fundusz Zagraniczny 1', InvestmentFundType.FOREIGN)
    def financialFund1 = new InvestmentFund('fn01', 'Fundusz Pieniężny 1', InvestmentFundType.FINANCIAL)

    def 'invest 10000 safely' () {
        given:
            def amount = 10000
            def funds = [
                    polishFund1,
                    polishFund2,
                    foreignFund1,
                    foreignFund2,
                    foreignFund3,
                    financialFund1
            ]
            def invest = new Invest()

        when:
            def investment = invest.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            investment
    }

    def 'invest 10001 safely' () {
        given:
            def amount = 10001
            def funds = [
                    polishFund1,
                    polishFund2,
                    foreignFund1,
                    foreignFund2,
                    foreignFund3,
                    financialFund1
            ]
            def invest = new Invest()

        when:
            def investment = invest.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            investment
    }

    def 'invest 10005 safely' () {
        given:
            def amount = 10005
            def funds = [
                    polishFund1,
                    polishFund2,
                    polishFund3,
                    foreignFund1,
                    foreignFund2,
                    financialFund1
            ]
            def invest = new Invest()

        when:
            def investment = invest.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            investment
    }

    def 'invest 10005 balanced' () {
        given:
            def amount = 10005
            def funds = [
                    polishFund1,
                    polishFund2,
                    polishFund3,
                    foreignFund1,
                    foreignFund2,
                    financialFund1
            ]
            def invest = new Invest()

        when:
            def investment = invest.invest(funds, InvestmentStrategyType.BALANCED, amount)

        then:
            investment
    }

    def 'invest 10005 aggressively' () {
        given:
            def amount = 10005
            def funds = [
                    polishFund1,
                    polishFund2,
                    polishFund3,
                    foreignFund1,
                    foreignFund2,
                    financialFund1
            ]
            def invest = new Invest()

        when:
            def investment = invest.invest(funds, InvestmentStrategyType.AGGRESSIVE, amount)

        then:
            investment
    }

}
