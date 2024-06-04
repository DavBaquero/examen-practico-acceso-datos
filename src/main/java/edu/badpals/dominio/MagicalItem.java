package edu.badpals.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="t_items")
public class MagicalItem{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "item_id", unique = true)
        private Long item;

        @Column(name = "item_name")
        private String name ="";

        @Column(name = "item_quality")
        private int quality;

        @Column(name = "item_type")
        private String type = "";


        public MagicalItem() {
        }

        public MagicalItem(String nombre, int quality, String tipo) {
            this.name = nombre;
            this.quality = quality;
            this.type = tipo;
        }

        public Long getId() {
            return item;
        }

        public String getName() {
            return name;
        }

        public void setName(String nombre) {
            this.name = nombre;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public String getType() {
            return type;
        }

        public void setType(String tipo) {
            this.type = tipo;
        }

    public String toString(){
        return this.getId() + " "+ this.getName() + " " + this.getQuality() + " " + this.getType();
    }

}
