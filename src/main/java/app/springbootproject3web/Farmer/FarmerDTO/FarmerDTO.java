package app.springbootproject3web.Farmer.FarmerDTO;

import java.util.Arrays;
import java.util.List;

public class FarmerDTO {

    private String name;
    private String surname;
    private Integer age;
    private Integer farmId;
    private List<Integer> specs;

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

    public List<Integer> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Integer> specs) {
        this.specs = specs;
    }

    @Override
    public String toString() {
        return "FarmerDTO: " + getName() + " " + getSurname() + ", " + getAge() + " years old" + " specs: "
                + Arrays.toString(specs.toArray());
    }

}
