import transport.Car;
import transport.Car.TyresType;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("Lada", "Granta", 1.7, "желтый", 2015, "Россия",
                "Manual", "Хэтчбек", "М670КУ199", 5, null);
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германия",
                240, "Auto Transmission", "Sedan", "X089MK199", 5, TyresType.WINTER,
                new Car.Key(true, true));
        Car bmwZ8 = new Car("BMW", "Z8", 3.0, "черный", 2021, "Германия");
        Car kiaSportage = new Car("Kia", "Sportage 4 поколение", 2.4, "красный", 2018, "Южная Корея");
        Car hyundaiAvante = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея");
        Car kiaSorento = new Car("Kia", "Sorento", 2.5, " ", -600, "Южная Корея",
                200, "Auto Transmission", "Универсал", "е001КХ199", 7,
                TyresType.WINTER, new Car.Key(true, false));

        ladaGranta.setInsurance(new Car.Insurance(LocalDate.now().plusDays(30), 4000, "765889"));

        System.out.println(ladaGranta);
        System.out.println(audiA8);
        System.out.println(bmwZ8);
        System.out.println("Change registration number...");
        bmwZ8.setRegistrationNumber("Л593МК199");
        System.out.println(bmwZ8);
        System.out.println(kiaSportage);
        System.out.println(hyundaiAvante);
        System.out.println(kiaSorento);

        System.out.println("Устанавливаем летние шины...");
        kiaSorento.changeTyresTypeBySeason(6);
        System.out.println(kiaSorento);
        System.out.println("Buy insurance...");
        kiaSorento.setInsurance(new Car.Insurance(LocalDate.now().plusMonths(10), 10_000, "XY1234567"));
        System.out.println(kiaSorento);
    }
}