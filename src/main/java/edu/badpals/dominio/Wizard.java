package edu.badpals.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_wizards")
public class Wizard{
    @Id
    @Column(name = "wizard_name", unique = true)
    private String nombre = "";

    @Column(name = "wizard_dexterity")
    private int destreza;

    @Column(name = "wizard_person")
    @Enumerated(EnumType.STRING)
    private Person person;

    public Wizard() {
    }

    public String getName() {
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
        return this.getName() + " " + this.getDestreza() + " " + this.getPerson();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
