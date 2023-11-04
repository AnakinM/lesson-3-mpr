import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarStorage {
    private static CarStorage INSTANCE;
    private List<Car> cars = new ArrayList<>();

    private CarStorage() {
    }

    public static CarStorage getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CarStorage();

        return INSTANCE;
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Optional<Car> getCarByVin(String vin) {
        return cars.stream().filter(car -> car.getVin().equals(vin)).findFirst();
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void removeCar(Car car) {
        this.cars.remove(car);
    }
}

