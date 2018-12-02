# BSJ

## Info
**Time:** about 6 hours

**Source:** Java 8\
**Tests:** Groovy 2.4 + Spock 1.2

**Startup:**\
```mvn clean test```

## Description
App allows to distribute given amount of money
between three types of Investment Funds:
* Domestic
* Foreign
* Financial

Three types of investment strategies are supported:
* Safe (20% Domestic, 75% Foreign, 5% Financial)
* Balanced (30% Domestic, 60% Foreign, 10% Financial)
* Aggressive (40% Domestic, 20% Foreign, 40% Financial)

## Detail
Public API includes ```Invest``` class with one method: ```invest```.

The ```invest``` method expects a list of investment funds (public ```InvestmendFund``` class), investment strategy (public ```InvestmentStrategyType``` enum) and amount to invest (```double```).

In return the caller will obtain an immutable map, where keys are the distinct investment funds and values are amounts invested in those funds.

There is a special kind of investment fund which represents **not invested** state. It is present whe some part of the amount couldn't be invested.

If caller gives negative amount then it will not be invested.

If caller gives empty list of funds then the amount will not be invested.

## Extending current solution
To add new investment strategy:
1. Add new class which extends ```InvestmentStrategy```
2. In its constructor define array of ```Pair``` where first element is ```InvestmentFundType``` and second element is percent of distribution
3. Add new entry in ```InvestmentStrategyType``` where parameter is new strategy class

To add new investment fund type:
1. Add new entry in ```InvestmentFundType```


