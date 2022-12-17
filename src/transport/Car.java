package transport;

public class Car {
    public enum TyresType { SUMMER ("Летние"), WINTER ("Зимние");
        private final String tyresName;

        TyresType(String tyresName) {
            this.tyresName = tyresName;
        }

        @Override
        public String toString() {
            return tyresName;
        }
    }

    private final String brand; // Марка
    private final String model; // Модель
    private double engineVolume;    // Объем двигателя в литрах
    private String color;   // Цвет кузова
    private final int productionYear;   // Год производства
    private final String productionCountry; // Страна сборки
    private String gearBox; // Коробка передач
    private final String bodyType;  // Тип кузова
    private String registrationNumber;  // Регистрационный номер»
    private final int seatsNumber;  // Количество мест
    private TyresType tyresType;    // тип резины «Летняя» или «Зимняя»

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry) {
        this(brand, model, engineVolume, color, productionYear, productionCountry, "", "Sedan", "", 4, TyresType.SUMMER);
    }

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry,
               String gearBox, String bodyType, String registrationNumber, int seatsNumber, TyresType tyresType) {
        this.brand = checkIsNotEmptyAndFill(brand);
        this.model = checkIsNotEmptyAndFill(model);
        this.engineVolume = checkAndFillEngineVolume(engineVolume);
        this.color = checkColorAndFill(color);
        this.productionYear = checkAndFillProductionYear(productionYear);
        this.productionCountry = checkIsNotEmptyAndFill(productionCountry);

        this.gearBox = checkGearBoxAndFill(gearBox);
        this.seatsNumber = checkSeatsNumberAndFill(seatsNumber);
        this.bodyType = checkBodyTypeAndFill(bodyType);
        this.registrationNumber = checkIsNotEmptyAndFill(registrationNumber);
        this.tyresType = checkTyresTypeAndFill(tyresType);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d год выпуска, страна сборки: %s, цвет кузова: %s, объем двигателя: %.1f литра\n" +
                        "    КПП: %s, количество место: %d, тип кузова: %s, рег. номер: %s, тип шин: %s",
                brand, model, productionYear, productionCountry, color, engineVolume, gearBox, seatsNumber, bodyType, registrationNumber, tyresType);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public TyresType getTyresType() {
        return tyresType;
    }

    public void setTyresType(TyresType tyresType) {
        this.tyresType = tyresType;
    }

    public void changeTyresTypeBySeason(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("The month number should be from 1 to 12: " + month);
        }
        if (month >= 5 && month <= 10) {
            tyresType = TyresType.SUMMER;
        } else {
            tyresType = TyresType.WINTER;
        }
    }

    private String checkIsNotEmptyAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Default";
        }
        return str;
    }

    private double checkAndFillEngineVolume(double engineVolume) {
        if (engineVolume > 0) {
            return engineVolume;
        }
        return 1.5;
    }

    private String checkColorAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Белый";
        }
        return str;
    }

    private int checkAndFillProductionYear(int productionYear) {
        if (productionYear > 1900) {
            return productionYear;
        }
        return 2000;
    }

    private String checkGearBoxAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Manual Transmission";
        } else {
            return str;
        }
    }

    private String checkBodyTypeAndFill(String str) {
        if (str == null || str.isBlank()) {
            return "Sedan";
        }
        return str;
    }

    private TyresType checkTyresTypeAndFill(TyresType tyresType) {
        if (tyresType == null) {
            return TyresType.SUMMER;
        }
        return tyresType;
    }

    private int checkSeatsNumberAndFill(int seatsNumber) {
        return Math.max(seatsNumber, 2);
    }
}
