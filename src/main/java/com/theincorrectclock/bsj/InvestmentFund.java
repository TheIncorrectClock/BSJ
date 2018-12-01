package com.theincorrectclock.bsj;

class InvestmentFund {

    private String id;
    private String name;
    private InvestmentFundType type;

    InvestmentFund(String id, String name, InvestmentFundType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    InvestmentFundType getType() {
        return type;
    }
}
