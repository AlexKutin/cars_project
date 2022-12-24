package autoracing;

public class Driver {
    private final String fullName;
    private boolean driverLicense;
    private int experience;

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

    public Driver(String fullName, boolean driverLicense, int experience) {
        this.fullName = fullName;
        this.driverLicense = driverLicense;
        this.experience = experience;
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
        return String.format("Водитель: %s, стаж: %d", getFullName(), getExperience());
    }
}
