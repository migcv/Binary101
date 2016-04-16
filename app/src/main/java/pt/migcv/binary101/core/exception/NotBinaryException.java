package pt.migcv.binary101.core.exception;

public class NotBinaryException extends ConverterException {

    public NotBinaryException(String binaryNumber) {
        super(binaryNumber);
    }

    public String getMessage() {
        return "EXCEPTION - NotBinaryException: The number \"" + number + "\" isnt a binary number!";
    }
}
