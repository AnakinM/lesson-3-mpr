import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarStorageTest {
    CarStorage carStorage;

    @BeforeEach
    void startUp() {
        carStorage = new CarStorage();
    }

    @Test
    void shouldFindCarById() {
        String vin = "123456789";
        Car car = new Car("xyz", "abc", vin, Standard.PREMIUM);
        carStorage.addCar(car);

        Optional<Car> carByVin = carStorage.getCarByVin(vin);

        assertThat(carByVin).isPresent();
    }

    @Test
    void shouldNotFindCarById() {
        String vin = "123456789";
        Optional<Car> carByVin = carStorage.getCarByVin(vin);

        assertThat(carByVin).isEmpty();
    }
}