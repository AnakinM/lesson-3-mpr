import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentalStorage {
    private static RentalStorage INSTANCE;
    private List<Rental> rentals = new ArrayList<>();

    public static RentalStorage getInstance() {
        if (INSTANCE == null)
            INSTANCE = new RentalStorage();

        return INSTANCE;
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> Rentals) {
        this.rentals = Rentals;
    }

    public void addRental(Rental Rental) {
        this.rentals.add(Rental);
    }

    public void removeRental(Rental Rental) {
        this.rentals.remove(Rental);
    }

    public List<Rental> getRentalsForVin(String vin) {
        return rentals.stream().filter(rental -> rental.getCar().getVin().equals(vin)).toList();
    }
}
