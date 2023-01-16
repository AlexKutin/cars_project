package autoracing;

public enum MechanicServiceType {
    CAR("Легковые"), TRUCK("Грузовые"), BUS("Автобусы"), ALL("Все");
    private final String name;

    MechanicServiceType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
