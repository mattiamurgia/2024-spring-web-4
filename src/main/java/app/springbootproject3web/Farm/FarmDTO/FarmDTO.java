package app.springbootproject3web.Farm.FarmDTO;

public class FarmDTO {
    private String nameFarm;
    private String city;



    public String getNameFarm() {
        return nameFarm;
    }

    public void setNameFarm(String nameFarm) {
        this.nameFarm = nameFarm;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "FarmDTO: " + getNameFarm() + ", " + getCity();
    }

}
