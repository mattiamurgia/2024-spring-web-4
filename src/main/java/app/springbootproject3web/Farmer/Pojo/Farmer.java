package app.springbootproject3web.Farmer.Pojo;

import java.util.List;

import app.springbootproject3web.Farm.Pojo.Farm;
import app.springbootproject3web.Farmer.FarmerDTO.FarmerDTO;
import app.springbootproject3web.Specialization.Pojo.Specialization;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 128, nullable = false)
    private String surname;

    @Column(length = 128, nullable = false)
    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    @ManyToMany
    private List<Specialization> specializations;

    public Farmer() {
    }

    public Farmer(String name, String surname, Integer age, Farm farm, List<Specialization> specializations) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setFarm(farm);
        setSpecializations(specializations);
    }

    public Farmer(FarmerDTO FarmerDTO) {
        updateFarmer(FarmerDTO);
    }

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

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public void addSpecialization(Specialization specialization) {
        getSpecializations().add(specialization);
    }

    public void updateFarmer(FarmerDTO FarmerDTO) {
        setName(FarmerDTO.getName());
        setSurname(FarmerDTO.getSurname());
        setAge(FarmerDTO.getAge());
    }

    @Override
    public String toString() {
        return "Farmer: " + getName() + " " + getSurname() + ", " + getAge() + " years old, " + " Farm: " + getFarm() + " ID:" + getId();
    }
}
