public class ProxyImage implements Image {
    private RealImage realImage; // starts as null - not created yet
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        // Lazy initialization: only create RealImage the first time display() is called
        if (realImage == null) {
            realImage = new RealImage(fileName);
        } else {
            System.out.println("Using cached image: " + fileName);
        }
        realImage.display();
    }
}
