
class CustomException extends Exception {
    private String message;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}


public class Activity8 {
    public static void exceptionTest(String value) throws CustomException {
        if (value == null) {
            throw new CustomException("String value is null!");
        } else {
            System.out.println("String value: " + value);
        }
    }

    public static void main(String[] args) {
        try {
            // Call with non-null string
            exceptionTest("Hello, World");

            // Call with null argument
            exceptionTest(null);
        } catch (CustomException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}