package data;

public class Error extends Response {

    private final String message;

    public Error(String message) {
        this.message = message;
    }

    public void displayResponse() {
        System.out.println(message);
    }
}
