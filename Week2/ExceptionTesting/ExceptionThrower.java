public class ExceptionThrower {
    public void throwException(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        System.out.println("Value is valid: " + value);
    }
}
