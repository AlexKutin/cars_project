package autoracing;

public class Main {

    public static void main(String[] args) {
        Car<DriverB> ladaGranta = new Car<>("Lada", "Granta", 1.7);
        Car<DriverB> audiA8 = new Car<>("Audi", "A8 50 L TDI quattro", 3.0);
        Car<DriverB> bmwZ8 = new Car<>("BMW", "Z8", 3.0);
        Car<DriverB> kiaSportage = new Car<>("Kia", "Sportage 4 поколение", 2.4);
        audiA8.setBodyType(Car.BodyType.SEDAN);
        bmwZ8.setBodyType(Car.BodyType.COUPE);
        kiaSportage.setBodyType(Car.BodyType.CROSSOVER);

        System.out.println("Легковые автомобили:");
        System.out.println(ladaGranta);
        System.out.println(audiA8);
        audiA8.printType();
        System.out.println(bmwZ8);
        bmwZ8.printType();
        System.out.println(kiaSportage);
        kiaSportage.printType();
        System.out.println();

        Truck<DriverC> kamaz = new Truck<>("Kamaz", "5490", 12.0);
        Truck<DriverC> ural = new Truck<>("Ural", "4320", 10.8);
        Truck<DriverC> isuzu = new Truck<>("Isuzu", "Forward", 7.7);
        Truck<DriverC> iveco = new Truck<>("Iveco", "EuroCargo ML100E18", 4.0);
        isuzu.setLoadCapacity(Truck.LoadCapacity.N2);
        iveco.setLoadCapacity(Truck.LoadCapacity.N3);

        System.out.println("Грузовые автомобили:");
        System.out.println(kamaz);
        kamaz.printType();
        System.out.println(ural);
        System.out.println(isuzu);
        isuzu.printType();
        System.out.println(iveco);
        iveco.printType();
        System.out.println();

        Bus<DriverD> mercedesSprinter = new Bus<>("Mercedes", "Sprinter", 3.5);
        Bus<DriverD> fordTransit = new Bus<>("Ford", "Transit", 2.7);
        Bus<DriverD> liaz = new Bus<>("Liaz", "6213", 4.2);
        Bus<DriverD> scania = new Bus<>("Scania", "Higer A80", 5.3);
        mercedesSprinter.setBusCapacity(Bus.BusCapacity.SMALL);
        fordTransit.setBusCapacity(Bus.BusCapacity.ESPECIALLY_SMALL);
        scania.setBusCapacity(Bus.BusCapacity.LARGE);

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


        DriverB alex = new DriverB("Alex Dmitrievich", true, 12);
        DriverC andrey = new DriverC("Andrey Olafsen", true, 21);
        DriverD antony = new DriverD("Antony Blinken", true, 15);
        System.out.println("Водители:");
        System.out.println(alex);
        System.out.println(andrey);
        System.out.println(antony);
        System.out.println();

        System.out.println("Назначены водители для гонок:");
        bmwZ8.manage(alex);
        iveco.manage(andrey);
        liaz.manage(antony);
    }
}
