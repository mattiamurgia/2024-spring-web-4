package app.springbootproject3web.Farmer.FarmerDTO;

public class FarmerDTO {

    private Integer id;

    private String name;
    private String surname;
    private Integer age;
    private Integer farmId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFarmId() {
        return farmId;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    @Override
    public String toString() {
        return "FarmerDTO: " + getName() + " " + getSurname() + ", " + getAge() + " years old, " + " ID:" + getId();
    }

}
