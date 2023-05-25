package com.dev.application.domain.enums;

public enum Choice {
    YES("Y"),
    NO("N"),
    REPORT("R"),
    HIT("1"),
    STAND("2");

    private final String option;

    Choice(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
