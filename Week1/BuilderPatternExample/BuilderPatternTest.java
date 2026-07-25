public class BuilderPatternTest {
    public static void main(String[] args) {
      
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .build();
        gamingPC.showConfig();

        
        Computer officePC = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
        officePC.showConfig();
    }
}
