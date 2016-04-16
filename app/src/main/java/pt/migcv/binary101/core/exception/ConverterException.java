package pt.migcv.binary101.core.exception;

public abstract class ConverterException extends RuntimeException {

    protected String number;

    public ConverterException(String number) {
        this.number = number;
    }

    public abstract String getMessage();

}
