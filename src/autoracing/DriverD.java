package autoracing;

public class DriverD extends Driver {

    public DriverD(String fullName, boolean driverLicense, int experience) {
        super(fullName, driverLicense, experience);
    }

    @Override
    public String toString() {
        return super.toString() + ", категория: D";
    }
}
