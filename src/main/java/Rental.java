import java.time.LocalDate;

public class Rental {
    private Client client;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(Client client, Car car, LocalDate endDate) throws Exception {
        this.client = client;
        this.car = car;
        this.startDate = LocalDate.now();
//        if (this.startDate.isBefore(endDate))
//            this.endDate = endDate;
//        else
//            throw new Exception("Invalid end date");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "client=" + client +
                ", car=" + car +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
