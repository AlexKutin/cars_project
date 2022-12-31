package autoracing;

public class DriverC extends Driver{

    public DriverC(String fullName, boolean driverLicense, int experience) {
        super(fullName, driverLicense, experience);
    }

    public DriverC(String fullName, boolean driverLicense, int experience, TypeDriverLicence typeDriverLicense) {
        super(fullName, driverLicense, experience, typeDriverLicense);
    }

    @Override
    public String toString() {
        return super.toString() + ", заявлена категория: C";
    }

    @Override
    public boolean isDriverLicenceCorrect() {
        return super.isDriverLicenceCorrect() && getTypeDriverLicense() != TypeDriverLicence.C;
    }
}
