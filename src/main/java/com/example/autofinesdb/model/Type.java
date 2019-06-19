package com.example.autofinesdb.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Type.java
 * Model describing Type entity
 * @author Choonsky
 *
 */

@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String description;
    private Integer qty;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Fine> fines;

    public Type() {
    }

    public Type(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Fine> getFines() {
        return fines;
    }

    public void setFines(Set<Fine> fines) {
        this.fines = fines;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return getId() == type.getId() &&
                Objects.equals(getDescription(), type.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }
}