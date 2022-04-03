package g13c.cw2;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private final int age = getAge().getYears();
    private Address address;
    private Book book;

    //---------- Methods ---------- //
        public void publishBook(){

        }

    //---------- Getters & Setters ---------- //
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Period getAge()
        {
            return Period.between(dateOfBirth,LocalDate.now());
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
}
