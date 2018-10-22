package com.domain.entities.OneToManyBidirectional.v1.entity;

/*
Owner -- ???
 */

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "solar_system")
public class SolarSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solarSystem")
    private List<Planet> planets;

    @Override
    public String toString() {
        return "SolarSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
