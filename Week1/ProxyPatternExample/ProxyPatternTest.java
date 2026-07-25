public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("vacation_photo.jpg");

        System.out.println("Image object created. Not loaded yet.");

        System.out.println("---");
        image.display(); // first call - actually loads from server

        System.out.println("---");
        image.display(); // second call - uses cached version, no reload
    }
}
