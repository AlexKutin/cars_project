package autoracing;

public class DriverC extends Driver{

    public DriverC(String fullName, boolean driverLicense, int experience) {
        super(fullName, driverLicense, experience);
    }

    @Override
    public String toString() {
        return super.toString() + ", категория: C";
    }
}
