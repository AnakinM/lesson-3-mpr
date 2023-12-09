import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RentalServiceTest {
    private final CarStorage carStorage = CarStorage.getInstance();
    private final RentalStorage rentalStorage = new RentalStorage();
    private final RentalService rentalService = new RentalService(carStorage, new RentalStorage());

    public static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(Standard.PREMIUM, 574.0),
                Arguments.of(Standard.BUDGET, 574.0),
                Arguments.of(Standard.COMMON, 574.0)
        );
    }


    @ParameterizedTest
    @MethodSource("inputData")
    void shouldEstimatePrice(Standard standard, double expectedPrice) {
        String vin = "123456789";
        LocalDate startDate = LocalDate.of(2023, 11, 11);
        LocalDate endDate = LocalDate.of(2023, 11, 18);
        carStorage.addCar(new Car("xyz", "abc", "123456789", standard));

        double estimatedPrice = rentalService.estimatePrice(vin, startDate, endDate);

        assertThat(estimatedPrice).isEqualTo(expectedPrice);
    }

    @Test
    void shouldRentCar() {
        String vin = "123456789";
        Car car = new Car("xyz", "abc", vin, Standard.PREMIUM);
        carStorage.addCar(car);
        LocalDate startDate = LocalDate.of(2023, 11, 11);
        LocalDate endDate = LocalDate.of(2023, 11, 18);

        rentalService.rentCar(1, vin, startDate, endDate);

        assertThat(rentalStorage.getRentalsForVin(vin)).isNotEmpty();
    }

    @Test
    void shouldBeAvailable() {
        String vin = "123456789";
        LocalDate startDate = LocalDate.of(2023, 11, 11);
        LocalDate endDate = LocalDate.of(2023, 11, 18);
        Car car = new Car("xyz", "abc", "123456789", Standard.PREMIUM);
        carStorage.addCar(car);
        rentalStorage.addRental(new Rental(new Client(1), car, endDate));

        double estimatedPrice = rentalService.estimatePrice(vin, startDate, endDate);

        assertThat(estimatedPrice).isEqualTo(574.00);
    }
}