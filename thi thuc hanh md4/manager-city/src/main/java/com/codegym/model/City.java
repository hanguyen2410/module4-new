package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.math.BigDecimal;



@Entity
@Table(name = "citys")
public class City extends BaseEntity implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", nullable = false)
    private String nameCity;

    private String nation;

    @Column(precision = 12, scale = 0, nullable = false, updatable = false)
    private BigDecimal area;

    private BigDecimal population;

    @Column(precision = 12, scale = 0, nullable = false, updatable = false)
    private BigDecimal GDP;

    private String descrip;

    @Override
    public boolean supports(Class<?> aClass) {
        return City.class.isAssignableFrom(aClass);
    }

    public City() {
    }

    public City(Long id, String nameCity, String nation, BigDecimal area, BigDecimal population, BigDecimal GDP, String descrip) {
        this.id = id;
        this.nameCity = nameCity;
        this.nation = nation;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.descrip = descrip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }

    public BigDecimal getGDP() {
        return GDP;
    }

    public void setGDP(BigDecimal GDP) {
        this.GDP = GDP;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Override
    public void validate(Object target, Errors errors) {
        City city = (City) target;

        String fullName = city.getNameCity();

        if (fullName.length() < 5){
            errors.rejectValue("fullName", "fullName.length.min");
        }

        if (fullName.length() > 20){
            errors.rejectValue("fullName", "fullName.length.max");
        }
    }
}
