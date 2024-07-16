package app.springbootproject3web.Farm.Pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.springbootproject3web.Farm.FarmDTO.FarmDTO;
import app.springbootproject3web.Farmer.Pojo.Farmer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nameFarm;

    @Column(length = 128, nullable = false)
    private String city;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Farmer> farmers;

    public Farm() {
    }

    public Farm(String nameFarm, String city) {
        setNameFarm(nameFarm);
        setCity(city);
    }

    public Farm(FarmDTO FarmDTO) {
        updateFarm(FarmDTO);
    }

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

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void updateFarm(FarmDTO FarmDTO) {
        setNameFarm(FarmDTO.getNameFarm());
        setCity(FarmDTO.getCity());
    }

    @Override
    public String toString() {
        return "Farm: " + getNameFarm() + ", " + getCity() + ", ID: " + getId();
    }

}
