package com.theincorrectclock.bsj;

public class InvestmentFund {

    static final InvestmentFund NOT_INVESTED = new InvestmentFund("NIA", "Not Invested Amount", InvestmentFundType.NOT_INVESTED);

    private String id;
    private String name;
    private InvestmentFundType type;

    public InvestmentFund(String id, String name, InvestmentFundType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public InvestmentFundType getType() {
        return type;
    }
}
