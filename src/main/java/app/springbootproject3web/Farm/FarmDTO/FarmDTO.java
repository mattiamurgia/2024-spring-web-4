package app.springbootproject3web.Farm.FarmDTO;

public class FarmDTO {
    private Integer id;
    private String nameFarm;
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "FarmDTO: " + getNameFarm() + ", " + getCity() + ", ID: " + getId();
    }

}
