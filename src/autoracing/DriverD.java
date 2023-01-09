package autoracing;

public class DriverD extends Driver {

    public DriverD(String fullName, boolean driverLicense, int experience) {
        super(fullName, driverLicense, experience);
    }

    public DriverD(String fullName, boolean driverLicense, int experience, TypeDriverLicence typeDriverLicense) {
        super(fullName, driverLicense, experience, typeDriverLicense);
    }

    @Override
    public String toString() {
        return super.toString() + ", заявлена категория: D";
    }

    @Override
    public boolean isDriverLicenceCorrect() {
        return super.isDriverLicenceCorrect() && getTypeDriverLicense() != TypeDriverLicence.D;
    }
}
