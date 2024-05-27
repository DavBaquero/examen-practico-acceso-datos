package edu.badpals.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="t_items")
public class MagicalItem extends PanacheEntityBase{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "item_id", unique = true)
        private Long item;

        @Column(name = "item_name")
        private String nombre ="";

        @Column(name = "item_quality")
        private int quality;

        @Column(name = "item_type")
        private String tipo = "";


        public MagicalItem() {
        }

        public Long getId() {
            return item;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

    public String toString(){
        return this.getId() + " "+ this.getNombre() + " " + this.getQuality() + " " + this.getTipo();
    }

}
