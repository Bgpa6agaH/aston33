

//1. Создать класс "Товар" с полями:
// название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем.
//Конструктор класса должен заполнять эти поля при создании объекта.
//Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.

import java.util.Date;

public class Product {
    //название
    private String name;
    // дата производства
    private String dateOfManufacture;
    // производитель
    private String manufacturer;
    // страна происхождения
    private String countryOfOrigin;
    // цена
    private double price;
    // состояние бронирования покупателем
    private boolean bookingStatus;

    public Product(String name, String dateOfManufacture, String manufacturer, String countryOfOrigin, double price, boolean bookingStatus) {
        this.name = name;
        this.dateOfManufacture = dateOfManufacture;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                ", manufacturer='" + manufacturer + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", price=" + price +
                ", bookingStatus=" + bookingStatus +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
