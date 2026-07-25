public class Computer {
    // Attributes
    private String CPU;
    private String RAM;
    private String storage;

    // Private constructor - takes Builder as parameter
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    public void showConfig() {
        System.out.println("Computer Config -> CPU: " + CPU + ", RAM: " + RAM + ", Storage: " + storage);
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        // build() method returns an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}
