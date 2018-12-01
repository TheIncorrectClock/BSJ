package com.theincorrectclock.bsj

import spock.lang.Specification

class SafeStrategySpec extends Specification {

    def 'provides strategy details' () {
        given:
            def style = new SafeStrategy()

        when:
            def info = style.info

        then:
            0.2 == info[InvestmentFundType.DOMESTIC]
            0.75 == info[InvestmentFundType.FOREIGN]
            0.05 == info[InvestmentFundType.FINANCIAL]
    }
}
