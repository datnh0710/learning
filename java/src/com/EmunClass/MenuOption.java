package com.EmunClass;

public enum MenuOption {
    ZERO_BALANCE(1),
    CREDIT_BALANCE(2),
    DEBiT_BALANCE(3),
    END(4);

    MenuOption(int value) {
        this.value = value;
    }

    private final int value;


}
