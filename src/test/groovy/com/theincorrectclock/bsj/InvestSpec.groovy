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
            6 == investment.size()
            1000.0 == investment[polishFund1]
            1000.0 == investment[polishFund2]
            2500.0 == investment[foreignFund1]
            2500.0 == investment[foreignFund2]
            2500.0 == investment[foreignFund2]
            500.0 == investment[financialFund1]
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
            7 == investment.size()
            1000.0 == investment[polishFund1]
            1000.0 == investment[polishFund2]
            2500.0 == investment[foreignFund1]
            2500.0 == investment[foreignFund2]
            2500.0 == investment[foreignFund2]
            500.0 == investment[financialFund1]
            1.0 == investment[InvestmentFund.NOT_INVESTED]
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
            7 == investment.size()
            667.0 == investment[polishFund1]
            667.0 == investment[polishFund2]
            667.0 == investment[polishFund3]
            3751.0 == investment[foreignFund1]
            3751.0 == investment[foreignFund2]
            500.0 == investment[financialFund1]
            2.0 == investment[InvestmentFund.NOT_INVESTED]
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
            7 == investment.size()
            1000.0 == investment[polishFund1]
            1000.0 == investment[polishFund2]
            1000.0 == investment[polishFund3]
            3001.0 == investment[foreignFund1]
            3001.0 == investment[foreignFund2]
            1000.0 == investment[financialFund1]
            3.0 == investment[InvestmentFund.NOT_INVESTED]
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
            7 == investment.size()
            1334.0 == investment[polishFund1]
            1334.0 == investment[polishFund2]
            1334.0 == investment[polishFund3]
            1000.0 == investment[foreignFund1]
            1000.0 == investment[foreignFund2]
            4002.0 == investment[financialFund1]
            1.0 == investment[InvestmentFund.NOT_INVESTED]
    }

    def 'does not invest negative amount' () {
        given:
            def amount = -500.0
            def funds = [
                    polishFund1,
                    polishFund2
            ]
            def invest = new Invest()

        when:
            def investment = invest.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            -500.0 == investment[InvestmentFund.NOT_INVESTED]
    }

    def 'does not invest when no funds are given' () {
        given:
            def amount = 1000.0
            def funds = []
            def invest = new Invest()

        when:
            def investment = invest.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            1000.0 == investment[InvestmentFund.NOT_INVESTED]
    }

    def 'throws exception when funds are null' () {
        given:
            def amount = 1000.0
            def funds = null
            def invest = new Invest()

        when:
            invest.invest(funds, InvestmentStrategyType.SAFE, amount)

        then:
            thrown(NullPointerException)
    }

    def 'throws exception when strategy is null' () {
        given:
            def amount = 1000.0
            def funds = [polishFund1, foreignFund1]
            def invest = new Invest()

        when:
            invest.invest(funds, null, amount)

        then:
            thrown(NullPointerException)
    }

}
