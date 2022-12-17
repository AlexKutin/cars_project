import transport.Car;
import transport.Car.TyresType;

public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("Lada", "Granta", 1.7, "желтый", 2015, "Россия",
                "Manual", "Хэтчбек", "ABC0987654321", 5, null);
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германия");
        Car bmwZ8 = new Car("BMW", "Z8", 3.0, "черный", 2021, "Германия");
        Car kiaSportage = new Car("Kia", "Sportage 4 поколение", 2.4, "красный", 2018, "Южная Корея");
        Car hyundaiAvante = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея");
        Car kiaSorento = new Car("Kia", "Sorento", 2.5, " ", -600, "Южная Корея",
                "Auto Transmission", "Универсал", "XJV1234567890", 7, TyresType.WINTER);

        System.out.println(ladaGranta);
        System.out.println(audiA8);
        System.out.println(bmwZ8);
        System.out.println(kiaSportage);
        System.out.println(hyundaiAvante);
        System.out.println(kiaSorento);

        System.out.println("Устанавливаем летние шины...");
        kiaSorento.changeTyresTypeBySeason(6);
        System.out.println(kiaSorento);
    }
}