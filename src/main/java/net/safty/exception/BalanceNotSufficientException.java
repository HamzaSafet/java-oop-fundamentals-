package net.safty.exception;

public class BalanceNotSufficientException extends Exception {
    public BalanceNotSufficientException(String message){
        super(message);
    }
}
