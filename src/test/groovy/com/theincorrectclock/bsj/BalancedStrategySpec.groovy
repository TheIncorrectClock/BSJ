package com.theincorrectclock.bsj

import spock.lang.Specification

class BalancedStrategySpec extends Specification {

    def 'provides strategy details' () {
        given:
            def style = new BalancedStrategy()

        when:
            def info = style.info

        then:
            0.3 == info[InvestmentFundType.DOMESTIC]
            0.6 == info[InvestmentFundType.FOREIGN]
            0.1 == info[InvestmentFundType.FINANCIAL]
    }
}
