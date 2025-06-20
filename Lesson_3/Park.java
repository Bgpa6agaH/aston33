import java.util.ArrayList;
import java.util.List;

public class Park {

    private String parkName;
    private final List<Attraction> attractions;

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public void removeAttraction(Attraction attraction) {
        this.attractions.remove(attraction);
    }

    public void displayAttractions() {
        System.out.println("Attractions in " + parkName + ":");
        for (Attraction attraction : attractions) {
            System.out.println(attraction); // Используем toString() для вывода информации
        }
    }

    // Внутренний класс Attraction
    public class Attraction {
        private String name;
        private String operatingHours;
        private double cost;

        public Attraction(String name, String operatingHours, double cost) {
            this.name = name;
            this.operatingHours = operatingHours;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOperatingHours() {
            return operatingHours;
        }

        public void setOperatingHours(String operatingHours) {
            this.operatingHours = operatingHours;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "name='" + name + '\'' +
                    ", operatingHours='" + operatingHours + '\'' +
                    ", cost=" + cost +
                    '}';
        }

    }

    public static void main(String[] args) {
        Park centralPark = new Park("Central Park");

        Attraction rollerCoaster = centralPark.new Attraction("The Thriller", "10:00 - 22:00", 5.00);
        Attraction carousel = centralPark.new Attraction("Merry-Go-Round", "11:00 - 20:00", 3.00);
        Attraction ferrisWheel = centralPark.new Attraction("Giant Wheel", "12:00 - 23:00", 7.00);

        centralPark.addAttraction(rollerCoaster);
        centralPark.addAttraction(carousel);
        centralPark.addAttraction(ferrisWheel);

        centralPark.displayAttractions();
    }
}
