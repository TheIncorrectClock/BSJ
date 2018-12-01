package com.theincorrectclock.bsj

import spock.lang.Specification

class InvestmentFundSpec extends Specification {

    def 'provides basic information' () {
        given:
            InvestmentFund fund = new InvestmentFund('id001', 'Polski Fundusz 1', InvestmentFundType.DOMESTIC)

        when:
            def id = fund.id
            def name = fund.name
            def type = fund.type

        then:
            'id001' == id
            'Polski Fundusz 1' == name
            InvestmentFundType.DOMESTIC == type
    }
}
