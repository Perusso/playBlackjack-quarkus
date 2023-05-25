package com.dev.application.domain.enums;
public enum Figure {
        ACE("Ace", 11),
        TWO("Two", 2),
        THREE("Three", 3),
        FOUR("Four",4),
        FIVE("Five",5),
        SIX("Six",6),
        SEVEN("Seven",7),
        EIGHT("Eight",8),
        NINE("Nine",9),
        TEN("Ten",10),
        JACK("Jack",10),
        QUEEN("Queen",10),
        KING("King",10);

    private String figureName;

    private int figureValue;

    Figure(String name, int value) {
        this.figureName = name;
        this.figureValue = value;
    }

    public String getFigureName() {
        return figureName;
    }

    public int getFigureValue() {
        return figureValue;
    }

    @Override
    public String toString() {
        return figureName;
    }
}
