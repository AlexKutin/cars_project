public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("Lada", "Granta", 1.7, "желтый", 2015, "России");
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германии");
        Car bmwZ8 = new Car("BMW", "Z8", 3.0, "черный", 2021, "Германии");
        Car kiaSportage = new Car("Kia", "Sportage 4 поколение", 2.4, "красный", 2018, "Южной Корее");
        Car hyundaiAvante = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южной Корее");

        System.out.println(ladaGranta);
        System.out.println(audiA8);
        System.out.println(bmwZ8);
        System.out.println(kiaSportage);
        System.out.println(hyundaiAvante);
    }
}