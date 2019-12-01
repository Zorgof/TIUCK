package com.company.engine.scanner.validation;

import com.company.resources.Configuration;

public class ScannerValidation {

    public static Integer validateSizeBoard(int value) {
        if (Configuration.MIN_BOARD_SIZE <= value && value <= Configuration.MAX_BOARD_SIZE) {
            return value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Integer validateShot(int value, int max) {
        if (isCorrectShotSizeValue(value, max)) {
            return value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCorrectShotSizeValue(int value, int max) {
        return 0 <= value && value <= max;
    }
}
