package com.theincorrectclock.bsj

import spock.lang.Specification

class AggressiveStrategySpec extends Specification {

    def 'provides strategy details' () {
        given:
            def style = new AggressiveStrategy()

        when:
            def info = style.info

        then:
            0.4 == info[InvestmentFundType.DOMESTIC]
            0.2 == info[InvestmentFundType.FOREIGN]
            0.4 == info[InvestmentFundType.FINANCIAL]
    }
}
