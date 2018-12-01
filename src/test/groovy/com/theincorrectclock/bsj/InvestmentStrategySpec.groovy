package com.theincorrectclock.bsj

import spock.lang.Specification

class InvestmentStrategySpec extends Specification {

    def 'provides style details' () {
        given:
            def details = [:]
            details.put(InvestmentFundType.DOMESTIC, 0.2)
            details.put(InvestmentFundType.FOREIGN, 0.75)
            details.put(InvestmentFundType.FINANCIAL, 0.05)
            def style = new InvestmentStrategy(details)

        when:
            def info = style.info

        then:
            0.2 == info[InvestmentFundType.DOMESTIC]
            0.75 == info[InvestmentFundType.FOREIGN]
            0.05 == info[InvestmentFundType.FINANCIAL]
    }
}
