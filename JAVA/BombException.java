public class BombException extends Exception{
    private static final long serialVersionUID = 1L;

    public BombException() {
}
    public BombException(String message) {
        super(message);
    }
}