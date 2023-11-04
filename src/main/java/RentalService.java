import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

public class RentalService {
    private CarStorage carStorage;
    private final double BASE_PRICE = 20.5d;
    // Singleton
    // void rentCar(clientId, vin, startDate, endDate)
    // boolean isAvailable(vin, startDate, endDate)
    // estimatePrice(vin, startDate, endDate)
    // estimatePrice(vin, int days)
    // Higher prices in weekends and holidays

    /*
    rentCar(clientId, vin, startDate, endDate) {
        czy auto istnieje
            czy auto dostepne
                true
                    dodajemu obiekt do rental storage
                    zwracamy rental
                flase
                    throw error
    }

    isAvailable(vin, startDate, endDate) {
        czy auto istnieje
        czy auto istnieje w rental storage w danym przedziale czasu
        15-20.09 -> rental ma takie daty
        17-22.09; 12-17.09; 17-19.09; 12-22.09;
    }
     */

    public double estimatePrice(String vin, LocalDate startDate, LocalDate endDate) {
        Optional<Car> car = carStorage.getCarByVin(vin);
        if (car.isPresent()) {
            long days = DAYS.between(startDate, endDate);
            return days * BASE_PRICE * car.get().getStandard().multiplier;
        }
        else
            throw new RuntimeException("Car could not be found.");
    }
}
