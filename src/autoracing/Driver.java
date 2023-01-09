package autoracing;

public class Driver {

    enum TypeDriverLicence {B, C, D}

    private final String fullName;
    private boolean driverLicense;
    private int experience;

    private TypeDriverLicence typeDriverLicense;

    public String getFullName() {
        return fullName;
    }

    public boolean isDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(boolean driverLicense) {
        this.driverLicense = driverLicense;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public TypeDriverLicence getTypeDriverLicense() {
        return typeDriverLicense;
    }

    public void setTypeDriverLicense(TypeDriverLicence typeDriverLicense) {
        this.typeDriverLicense = typeDriverLicense;
    }

    public Driver(String fullName, boolean driverLicense, int experience) {
        this.fullName = fullName;
        this.driverLicense = driverLicense;
        this.experience = experience;
    }

    public Driver(String fullName, boolean driverLicense, int experience, TypeDriverLicence typeDriverLicense) {
        this.fullName = fullName;
        this.driverLicense = driverLicense;
        this.experience = experience;
        this.typeDriverLicense = typeDriverLicense;
    }

    public void startMoving(Transport auto) {
        auto.startMoving();
    }

    public void stopMoving(Transport auto) {
        auto.finishMoving();
    }

    public void refuelCar(Transport auto) {

    }

    @Override
    public String toString() {
        return String.format("Водитель: %s, стаж: %d, категория прав: %s", getFullName(), getExperience(),
                typeDriverLicense == null ? "нет" : getTypeDriverLicense().name());
    }

    public boolean isDriverLicenceCorrect() {
        return typeDriverLicense != null;
    }
}
