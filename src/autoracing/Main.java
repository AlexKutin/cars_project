package autoracing;

public class Main {

    public static void main(String[] args) {
        Car<DriverB> ladaGranta = new Car<>("Lada", "Granta", 1.7);
        Car<DriverB> audiA8 = new Car<>("Audi", "A8 50 L TDI quattro", 3.0);
        Car<DriverB> bmwZ8 = new Car<>("BMW", "Z8", 3.0);
        Car<DriverB> kiaSportage = new Car<>("Kia", "Sportage 4 поколение", 2.4);

        System.out.println("Легковые автомобили:");
        System.out.println(ladaGranta);
        System.out.println(audiA8);
        System.out.println(bmwZ8);
        System.out.println(kiaSportage);
        System.out.println();

        Truck<DriverC> kamaz = new Truck<>("Kamaz", "5490", 12.0);
        Truck<DriverC> ural = new Truck<>("Ural", "4320", 10.8);
        Truck<DriverC> isuzu = new Truck<>("Isuzu", "Forward", 7.7);
        Truck<DriverC> iveco = new Truck<>("Iveco", "EuroCargo ML100E18", 4.0);

        System.out.println("Грузовые автомобили:");
        System.out.println(kamaz);
        System.out.println(ural);
        System.out.println(isuzu);
        System.out.println(iveco);
        System.out.println();

        Bus<DriverD> mercedesSprinter = new Bus<>("Mercedes", "Sprinter", 3.5);
        Bus<DriverD> fordTransit = new Bus<>("Ford", "Transit", 2.7);
        Bus<DriverD> liaz = new Bus<>("Liaz", "6213", 4.2);
        Bus<DriverD> scania = new Bus<>("Scania", "Higer A80", 5.3);

        System.out.println("Автобусы:");
        System.out.println(mercedesSprinter);
        System.out.println(fordTransit);
        System.out.println(liaz);
        System.out.println(scania);
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
