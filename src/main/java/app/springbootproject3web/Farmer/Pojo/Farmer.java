package app.springbootproject3web.Farmer.Pojo;

import app.springbootproject3web.Farm.Pojo.Farm;
import app.springbootproject3web.Farmer.FarmerDTO.FarmerDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    public Farmer() {
    }

    public Farmer(String name, String surname, Integer age, Farm farm) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setFarm(farm);
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

    public void updateFarmer(FarmerDTO FarmerDTO) {
        setName(FarmerDTO.getName());
        setSurname(FarmerDTO.getSurname());
        setAge(FarmerDTO.getAge());
    }

    @Override
    public String toString() {
        return "Farmer: " + getName() + " " + getSurname() + ", " + getAge() + " years old, " + " Farm: " + getFarm()
                + " ID:"
                + getId();
    }
}
