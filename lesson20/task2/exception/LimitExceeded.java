package lesson20.task2.exception;

import lesson20.task1.exception.BadRequestException;

public class LimitExceeded extends BadRequestException {

    public LimitExceeded(String message) {
        super(message);
    }
}
