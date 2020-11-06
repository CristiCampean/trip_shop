package fasttrackit.trip_shop.transfer;

import java.util.Date;

public class GetHotelRequest {


    private String name;
    private String city;
    private String country;
    private int stars;
    private long price;






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "GetHotelRequest{" +

                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", stars=" + stars +
                ", price=" + price +

                '}';
    }
}
