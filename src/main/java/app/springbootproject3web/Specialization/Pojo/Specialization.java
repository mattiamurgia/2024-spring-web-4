package app.springbootproject3web.Specialization.Pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.springbootproject3web.Farmer.Pojo.Farmer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nameSpecialization;

    @JsonIgnore
    @ManyToMany(mappedBy = "specializations")
    private List<Farmer> farmers;

    public Specialization() {

    }

    public Specialization(String nameSpecialization) {
        setNameSpecialization(nameSpecialization);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSpecialization() {
        return nameSpecialization;
    }

    public void setNameSpecialization(String nameSpecialization) {
        this.nameSpecialization = nameSpecialization;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    @Override
    public String toString() {
        return "Specialization: " + getNameSpecialization() + " " + " ID: " + getId();
    }
}
