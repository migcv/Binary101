package pt.migcv.binary101.src.exception;

public abstract class ConverterException extends RuntimeException {

    protected String number;

    public ConverterException(String number) {
        this.number = number;
    }

    public abstract String getMessage();

}
