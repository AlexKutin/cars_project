package transport;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

public class Car {
    private static final Pattern REG_NUMBER_PATTERN = Pattern.compile("[а-яА-Я]\\d{3}[а-яА-Я]{2}\\d{3}");  // х000хх000

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

    public static class Key {
        private final boolean isRemoteEngineStart;
        private final boolean isKeylessAccess;

        public Key(boolean isRemoteEngineStart, boolean isKeylessAccess) {
            this.isRemoteEngineStart = isRemoteEngineStart;
            this.isKeylessAccess = isKeylessAccess;
        }

        public boolean isRemoteEngineStart() {
            return isRemoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return isKeylessAccess;
        }

        @Override
        public String toString() {
            return "Удаленный запуск двигателя: " + booleanParamToString(isRemoteEngineStart) +
                    ", Бесключевой доступ: " + booleanParamToString(isKeylessAccess);
        }

        private String booleanParamToString(boolean param) {
            return param ? "есть" : "нет";
        }
    }

    public static class Insurance {
        private static final int INSURANCE_NUMBER_VALID_LENGTH = 9;
        private static final String DEFAULT_INSURANCE_NUMBER = "XXX777999";
        private final LocalDate insuranceValidityPeriod;
        private final int insuranceCost;
        private final String insuranceNumber;

        public Insurance(LocalDate insuranceValidityPeriod, int insuranceCost, String insuranceNumber) {
            if (insuranceValidityPeriod == null || insuranceValidityPeriod.isBefore(LocalDate.now())) {
                this.insuranceValidityPeriod = LocalDate.now().plusYears(1);
            } else {
                this.insuranceValidityPeriod = insuranceValidityPeriod;
            }
            this.insuranceCost = Math.max(1, insuranceCost);
            this.insuranceNumber = Objects.requireNonNullElse(insuranceNumber, DEFAULT_INSURANCE_NUMBER);
        }

        public LocalDate getInsuranceValidityPeriod() {
            return insuranceValidityPeriod;
        }

        public int getInsuranceCost() {
            return insuranceCost;
        }

        public String getInsuranceNumber() {
            return insuranceNumber;
        }

        public void checkInsurancePeriod() {
            if (isInsurancePeriodValid(insuranceValidityPeriod)) {
                System.out.println("Страховка просрочена! Нужно срочно ехать оформлять новую страховку");
            }
        }

        public String checkInsuranceNumber() {
            if (isInsuranceNumberValid(insuranceNumber)) {
                return "Ок";
            } else {
                return "Номер страховки некорректный!";
            }
        }

        @Override
        public String toString() {
            if (isInsurancePeriodValid(insuranceValidityPeriod)) {
                return String.format("Страховка {действует до: %s, стоимость: %d, номер страховки: %s (%s)}",
                        insuranceValidityPeriod, insuranceCost, insuranceNumber, checkInsuranceNumber());
            } else {
                return "Страховка просрочена!";
            }
        }

        private boolean isInsuranceNumberValid(String insuranceNumber) {
            return insuranceNumber.length() == INSURANCE_NUMBER_VALID_LENGTH;
        }

        private boolean isInsurancePeriodValid(LocalDate insuranceDate) {
            return LocalDate.now().compareTo(insuranceValidityPeriod) < 0;
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
    private final Key key;
    private Insurance insurance;

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry) {
        this(brand, model, engineVolume, color, productionYear, productionCountry, "", "Sedan", "", 4, TyresType.SUMMER);
    }

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry,
               String gearBox, String bodyType, String registrationNumber, int seatsNumber, TyresType tyresType) {
        this(brand, model, engineVolume, color, productionYear, productionCountry, gearBox, bodyType, registrationNumber,
                seatsNumber, tyresType, createDefaultKey());
    }

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry,
               String gearBox, String bodyType, String registrationNumber, int seatsNumber, TyresType tyresType, Key key) {
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
        this.key = checkCarKeyAndFill(key);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d год выпуска, страна сборки: %s, цвет кузова: %s, объем двигателя: %.1f литра, " +
                        "КПП: %s,\n количество мест: %d, тип кузова: %s, рег. номер: %s (%s), тип шин: %s, %s, %s",
                brand, model, productionYear, productionCountry, color, engineVolume, gearBox, seatsNumber,
                bodyType, registrationNumber, regNumberValidResult(), tyresType, key, insurance == null ? "страховка отсутствует" : insurance);
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

    public Key getKey() {
        return key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public boolean isRegistrationNumberValid(String regNumber) {
        return REG_NUMBER_PATTERN.matcher(regNumber).matches();
    }

    private String regNumberValidResult() {
        return isRegistrationNumberValid(registrationNumber) ? "Ok" : "Error";
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

    private Key checkCarKeyAndFill(Key key) {
        if (key == null) {
            return createDefaultKey();
        }
        return key;
    }

    private static Car.Key createDefaultKey() {
        return new Key(false, false);
    }
}
