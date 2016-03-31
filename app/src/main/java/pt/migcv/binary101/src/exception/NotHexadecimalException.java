package pt.migcv.binary101.src.exception;

public class NotHexadecimalException extends ConverterException {

    public NotHexadecimalException(String hexadecimalNumber) {
        super(hexadecimalNumber);
    }

    @Override
    public String getMessage() {
        return "EXCEPTION - NotHexadecimalException: The number \"" + number + "\" isnt a hexadecimal number!";
    }
}
