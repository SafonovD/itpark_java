package lesson_22.exception;

/**
 * Исключение когда параметр appID не указан при запуске программы
 */
public class ParameterSkippedException extends RuntimeException{

    public ParameterSkippedException(String message) {
        super(message);
    }
}
