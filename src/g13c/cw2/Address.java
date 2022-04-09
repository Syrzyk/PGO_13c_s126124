package g13c.cw2;

public class Address {
    private String country;
    private String city;
    private String street;
    private int house;
    private int flat;

        public Address(String country, String city, String street, int house, int flat){
            setCountry(country);
            setCity(city);
            setStreet(street);
            setHouse(house);
            setFlat(flat);
        }

    //---------- Getters & Setters ---------- //
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public String getStreet() {
            return street;
        }
        public void setStreet(String street) {
            this.street = street;
        }
        public int getHouse() {
            return house;
        }
        public void setHouse(int house) {
            this.house = house;
        }
        public int getFlat() {
            return flat;
        }
        public void setFlat(int flat) {
            this.flat = flat;
        }

}
