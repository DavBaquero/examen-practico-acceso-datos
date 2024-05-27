package edu.badpals.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_wizards")
public class Wizard extends PanacheEntityBase{
    @Id
    @Column(name = "wizard_name", unique = true)
    private String nombre = "";

    @Column(name = "wizard_dexterity")
    private int destreza;

    @Column(name = "wizard_person")
    @Enumerated(EnumType.STRING)
    private person person;

    public Wizard() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public String toString(){
        return this.getNombre() + " " + this.getDestreza() + " " + this.getPerson();
    }

    public person getPerson() {
        return person;
    }

    public void setPerson(person person) {
        this.person = person;
    }

}
