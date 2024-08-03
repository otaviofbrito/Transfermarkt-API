package com.api.tfmkt.enums;

import lombok.Getter;

@Getter
public enum TransferTypeEnum {
    NOT_LOAN(0),
    LOAN(1),
    END_OF_LOAN(2),
    UNKNOWN(3);

    private final Integer value;
    TransferTypeEnum(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return switch (this) {
            case NOT_LOAN -> "Not Loan";
            case LOAN -> "Loan";
            case END_OF_LOAN -> "End of Loan";
            default -> "Unknown";
        };
    }

}
