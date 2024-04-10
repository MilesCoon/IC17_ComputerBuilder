import java.text.NumberFormat;

// Outer Class (encompassing class)
public class Computer {

    private CPU cpu;
    private RAM ram;
    private Storage storage;
    private VideoCard videoCard;

    private static NumberFormat c = NumberFormat.getCurrencyInstance();

    public CPU getCpu() {
        return cpu;
    }
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public RAM getRam() {
        return ram;
    }
    public void setRam(RAM ram) {
        this.ram = ram;
    }
    public Storage getStorage() {
        return storage;
    }
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    public VideoCard getVideoCard() {
        return videoCard;
    }
    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public double calculateCost() {
        double cost = 0.0;
        if (cpu != null)
            cost += cpu.price;
        if (ram != null)
            cost += ram.price;
        if (storage != null)
            cost += storage.price;
        if (videoCard != null)
            cost += videoCard.price;

        return cost;
    }

    public String toString() {
        return "~~~Gaming Computer Specifications\n" +
                cpu + "\n" +
                ram + "\n" +
                storage + "\n" +
                videoCard + "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Total Cost as Configured: " + c.format(calculateCost());
    }

    class CPU {
        private String manufacturer, core;
        private double speed, price;
        // Constructor
        public CPU(String manufacturer, String core, double speed, double price) {
            // "this" refers to the current CPU object
            this.manufacturer = manufacturer;
            this.core = core;
            this.speed = speed;
            this.price = price;
            // Initialize the CPU field of Computer class
            Computer.this.cpu = this;
        }
        // toString()
        @Override
        public String toString() {
            return "CPU [" +
                    manufacturer + " " +
                    core + " " +
                    speed + " GHz " +
                    c.format(price) + "]";
        }
    }

    class RAM {
        // Fields
        private String manufacturer;
        private double capacity, price, speed;
        // Constructor
        RAM (String manufacturer, double capacity, double speed, double price) {
            this.manufacturer = manufacturer;
            this.capacity = capacity;
            this.price = price;
            this.speed = speed;

            Computer.this.ram = this;
        }
        // toString()
        @Override
        public String toString() {
            return "RAM [" +
                    manufacturer + " " +
                    capacity + " " +
                    speed + " MHz " +
                    c.format(price) + "]";
        }
    }

    class Storage {
        // Fields
        private String manufacturer, type;
        private double capacity, price;
        // Constructor
        Storage (String manufacturer, double capacity, String type, double price) {
            this.manufacturer = manufacturer;
            this.type = type;
            this.capacity = capacity;
            this.price = price;

            Computer.this.storage = this;
        }
        // toString()
        @Override
        public String toString() {
            return "Storage [" +
                    manufacturer + " " +
                    capacity + " TB " +
                    type + " " +
                    c.format(price) + "]";
        }
    }

    class VideoCard {
        // Fields
        private String manufacturer, maxRes;
        private double capacity, price;
        // Constructor
        VideoCard (String manufacturer, double capacity, String maxRes, double price) {
            this.manufacturer = manufacturer;
            this.maxRes = maxRes;
            this.capacity = capacity;
            this.price = price;

            Computer.this.videoCard = this;
        }
        // toString()
        @Override
        public String toString() {
            return "Video Card [" +
                    manufacturer + " " +
                    capacity + " " +
                    maxRes + " pixels " +
                    c.format(price) + "]";
        }
    }
}
