package autoracing;

public class DriverB extends Driver {

    public DriverB(String fullName, boolean driverLicense, int experience) {
        super(fullName, driverLicense, experience);
    }

    public DriverB(String fullName, boolean driverLicense, int experience, TypeDriverLicence typeDriverLicense) {
        super(fullName, driverLicense, experience, typeDriverLicense);
    }

    @Override
    public String toString() {
        return super.toString() + ", заявлена категория: B";
    }

    @Override
    public boolean isDriverLicenceCorrect() {
        return super.isDriverLicenceCorrect() && getTypeDriverLicense() != TypeDriverLicence.B;
    }
}
