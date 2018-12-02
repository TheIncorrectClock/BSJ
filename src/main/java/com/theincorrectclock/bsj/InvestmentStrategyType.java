package com.theincorrectclock.bsj;

public enum InvestmentStrategyType {

    SAFE(SafeStrategy.class),
    BALANCED(BalancedStrategy.class),
    AGGRESSIVE(AggressiveStrategy.class);

    InvestmentStrategyType(Class<?> cls) {
        this.strategy = create(cls);
    }

    InvestmentStrategy get() {
        return strategy;
    }

    private InvestmentStrategy strategy;

    private InvestmentStrategy create(Class<?> cls) {
        try {
            return cls.asSubclass(InvestmentStrategy.class).newInstance();
        } catch(IllegalAccessException | InstantiationException e) {
            throw new RuntimeException();
        }
    }
}
