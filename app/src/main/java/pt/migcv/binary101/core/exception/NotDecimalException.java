package pt.migcv.binary101.core.exception;

public class NotDecimalException extends ConverterException {

    public NotDecimalException(String decimalNumber) {
        super(decimalNumber);
    }

    @Override
    public String getMessage() {
        return "EXCEPTION - NotDecimalException: The number \"" + number + "\" isnt a decimal number!";
    }
}
