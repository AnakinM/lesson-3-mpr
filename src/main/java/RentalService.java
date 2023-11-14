import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

public class RentalService {
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;
    private final double BASE_PRICE = 20.5d;

    public RentalService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }
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
    private boolean isBetween(LocalDate periodStart, LocalDate periodEnd, LocalDate checkingDate) {
        return checkingDate.isAfter(periodStart) && checkingDate.isBefore(periodEnd);
    }

    public boolean isAvailable(String vin, LocalDate startDate, LocalDate endDate) {
        Car car = carStorage.getCarByVin(vin).orElseThrow();
        List<Rental> rentalsForVin = rentalStorage.getRentalsForVin(vin);
        if (rentalsForVin.isEmpty())
            return true;

//        for (Rental rental : rentalsForVin) {
//            if (isBetween())
//        }
        return true;
    }

    public void rentCar(int clientId, String vin, LocalDate startDate, LocalDate endDate) {
        Car car = carStorage.getCarByVin(vin).orElseThrow();
        if (isAvailable(vin, startDate, endDate)) {
            Rental rental = new Rental(new Client(clientId), car, endDate);
            rentalStorage.addRental(rental);
        }
    }

    public double estimatePrice(String vin, LocalDate startDate, LocalDate endDate) {
        Car car = carStorage.getCarByVin(vin).orElseThrow();
        long days = DAYS.between(startDate.atStartOfDay(), endDate.atStartOfDay());
        return days * BASE_PRICE * car.getStandard().multiplier;
    }
}
