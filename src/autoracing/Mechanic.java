package autoracing;

import java.util.Objects;

public class Mechanic {
    private final String firstName;
    private final String lastName;
    private String companyName;
    private MechanicServiceType serviceType;

    public Mechanic(String firstName, String lastName, String companyName, MechanicServiceType serviceType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.serviceType = serviceType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public MechanicServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(MechanicServiceType serviceType) {
        this.serviceType = serviceType;
    }

    // Провести техобслуживание указанного транспорта
    public void performMaintenance(Transport transport) {
        System.out.printf("Механик %s %s проводит диагностику %s\n", firstName, lastName, transport);
        transport.passDiagnostics();
    }

    // Починить машину указанную в параметре
    public void repairTransport(Transport transport) {
        System.out.printf("Механик %s %s проводит ремонт %s\n", firstName, lastName, transport);
    }

    @Override
    public String toString() {
        return String.format("Механик {%s %s (%s), обслуживает авто: %s}", firstName, lastName, companyName, serviceType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(firstName, mechanic.firstName) && Objects.equals(lastName, mechanic.lastName) &&
                Objects.equals(companyName, mechanic.companyName) && serviceType == mechanic.serviceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, companyName, serviceType);
    }
}
