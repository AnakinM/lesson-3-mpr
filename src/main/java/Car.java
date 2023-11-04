public class Car {
    private String make;
    private String model;
    private String vin;
    private Standard standard;

    public Car(String brand, String model, String vin, Standard standard) {
        this.make = brand;
        this.model = model;
        this.vin = vin;
        this.standard = standard;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", standard=" + standard +
                '}';
    }
}
