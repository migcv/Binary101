package pt.migcv.binary101.src.exception;

public class IsEmptyException extends ConverterException {

    public IsEmptyException(String number) {
        super(number);
    }

    @Override
    public String getMessage() {
        return "EXCEPTION - IsEmptyException: The number \"" + number + "\" is empty!";
    }
}
