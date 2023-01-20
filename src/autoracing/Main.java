package autoracing;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Mechanic mechanicLeo = new Mechanic("Leo", "Zemano", "Favorite", MechanicServiceType.CAR);
        Mechanic mechanicJacob = new Mechanic("Jacob", "Johnson", "Motors 5", MechanicServiceType.BUS);
        Mechanic mechanicHarry = new Mechanic("Harry", "Potter", "Alpha", MechanicServiceType.ALL);
        Mechanic mechanicTomas = new Mechanic("Tomas", "Diesel", "Favorite", MechanicServiceType.ALL);
        Mechanic mechanicJack = new Mechanic("Jack", "Daniels", "Motor 5", MechanicServiceType.TRUCK);

        Car ladaGranta = new Car("Lada", "Granta", 1.7, 1, Car.BodyType.HATCHBACK);
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 3.0, 2);
        Car bmwZ8 = new Car("BMW", "Z8", 3.0, 3);
        Car kiaSportage = new Car("Kia", "Sportage 4 поколение", 2.4, 2, Car.BodyType.CROSSOVER);
        audiA8.setBodyType(Car.BodyType.SEDAN);
        bmwZ8.setBodyType(Car.BodyType.COUPE);

        ladaGranta.addMechanic(mechanicLeo);
        audiA8.addMechanic(mechanicHarry);
        audiA8.addMechanic(mechanicLeo);
        bmwZ8.addMechanic(mechanicHarry);

        System.out.println("Легковые автомобили:");
        System.out.println(ladaGranta);
        System.out.println(audiA8);
        audiA8.printType();
        System.out.println(bmwZ8);
        bmwZ8.printType();
        System.out.println(kiaSportage);
        kiaSportage.printType();
        System.out.println();

        Truck  kamaz = new Truck("Kamaz", "5490", 12.0, 2);
        Truck ural = new Truck("Ural", "4320", 10.8, 1, Truck.LoadCapacity.N3);
        Truck isuzu = new Truck("Isuzu", "Forward", 7.7, 3);
        Truck iveco = new Truck("Iveco", "EuroCargo ML100E18", 4.0, 3, Truck.LoadCapacity.N1);
        isuzu.setLoadCapacity(Truck.LoadCapacity.N2);

        iveco.addMechanic(mechanicTomas);
        iveco.addMechanic(mechanicJack);

        System.out.println("Грузовые автомобили:");
        System.out.println(kamaz);
        kamaz.printType();
        System.out.println(ural);
        System.out.println(isuzu);
        isuzu.printType();
        System.out.println(iveco);
        iveco.printType();
        System.out.println();

        Bus mercedesSprinter = new Bus("Mercedes", "Sprinter", 3.5, 2);
        Bus fordTransit = new Bus("Ford", "Transit", 2.7, 1, Bus.BusCapacity.SMALL);
        Bus liaz = new Bus("Liaz", "6213", 4.2, 2, Bus.BusCapacity.LARGE);
        Bus scania = new Bus("Scania", "Higer A80", 5.3, 3);
        mercedesSprinter.setBusCapacity(Bus.BusCapacity.SMALL);
        fordTransit.setBusCapacity(Bus.BusCapacity.ESPECIALLY_SMALL);
        scania.setBusCapacity(Bus.BusCapacity.ESPECIALLY_LARGE);

        liaz.addMechanic(mechanicHarry);
        liaz.addMechanic(mechanicJacob);

        System.out.println("Автобусы:");
        System.out.println(mercedesSprinter);
        mercedesSprinter.printType();
        System.out.println(fordTransit);
        fordTransit.printType();
        System.out.println(liaz);
        liaz.printType();
        System.out.println(scania);
        scania.printType();
        System.out.println();

        Driver<Car> alex = new Driver<>("Alex Dmitrievich", true, 12, Driver.TypeDriverLicence.B);
        Driver<Truck> andrey = new Driver<>("Andrey Olafsen", true, 21, Driver.TypeDriverLicence.C);
        Driver<Bus> antony = new Driver<>("Antony Blinken", true, 15, Driver.TypeDriverLicence.D);
        Driver<Bus> tommy = new Driver<>("Timmy Hilfiger", true, 1, Driver.TypeDriverLicence.C);

        System.out.println("Добавляем водителей...");
        Set<Driver<? extends Transport>> drivers = new HashSet<>();
        drivers.add(alex);
        drivers.add(andrey);
        drivers.add(antony);
        drivers.add(tommy);
        drivers.add(andrey);
        drivers.add(tommy);

        System.out.printf("Проверяем количество водителей: %s\n", drivers.size() == 4 ? "Ок" : "Error");
        Iterator<Driver<? extends Transport>> iter = drivers.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("-----------------------");

        System.out.println("Назначены водители для гонок:");
        bmwZ8.setDriver(alex);
        iveco.setDriver(andrey);
        liaz.setDriver(antony);
        System.out.println("Проверяем возможность управления в соответствии с их в/у...");
        checkDriversLicense(bmwZ8, iveco, liaz);
        System.out.println();

        Map<Transport, List<Mechanic>> transportMap = new HashMap<>();
        transportMap.put(bmwZ8, bmwZ8.getMechanics());
        transportMap.put(ladaGranta, ladaGranta.getMechanics());
        transportMap.put(iveco, iveco.getMechanics());
        transportMap.put(liaz, liaz.getMechanics());
        for (Map.Entry<Transport, List<Mechanic>> entry : transportMap.entrySet()) {
            entry.getKey().printFullInfo();
        }
    }

    private static void checkDriversLicense(Transport... transports) {
        for (Transport transport : transports) {
            Driver<? extends Transport> driver = transport.getDriver();
            try {
                transport.manage(driver);
            } catch (DriverLicenseException e) {
                System.out.println(e.getMessage() + " Он не может участвовать в гонке");
            }
        }
    }
}
