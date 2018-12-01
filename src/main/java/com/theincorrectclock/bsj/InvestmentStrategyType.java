package com.theincorrectclock.bsj;

import java.util.Optional;

public enum InvestmentStrategyType {

    SAFE(SafeStrategy.class),
    BALANCED(BalancedStrategy.class),
    AGGRESSIVE(AggressiveStrategy.class);

    InvestmentStrategyType(Class<?> cls) {
        this.strategy = cls;
    }

    private Class<?> strategy;

    Optional<InvestmentStrategy> get() {
        try {
            return Optional.of(strategy.asSubclass(InvestmentStrategy.class).newInstance());
        } catch(IllegalAccessException | InstantiationException e) {
            return Optional.empty();
        }
    }
}
