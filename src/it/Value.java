package it;

import java.util.ArrayList;

public enum Value {
    ACE(11, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K");
    
    private final int value;
    private final String symbol;

    Value(final int value, String symbol) {
        this.value = value;
        this.symbol= symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol(){
        return symbol;
    }
}

