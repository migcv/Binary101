package pt.migcv.binary101.core.exception;

public class IsEmptyException extends ConverterException {

    public IsEmptyException(String number) {
        super(number);
    }

    @Override
    public String getMessage() {
        return "EXCEPTION - IsEmptyException: The number \"" + number + "\" is empty!";
    }
}
