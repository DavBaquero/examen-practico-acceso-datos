package edu.badpals.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigInteger;

@Entity
@Table(name = "t_orders")
public class Order extends PanacheEntityBase{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ord_id")
        private BigInteger id;

        @ManyToOne
        @JoinColumn(name = "ord_wizard")
        private String wizard = "";

        @OneToOne
        @JoinColumn(name = "ord_item")
        private BigInteger id_item;

        public Order() {
        }

        public Order(String wizard, BigInteger id_item) {
            this.wizard = wizard;
            this.id_item = id_item;
        }

        public BigInteger getId() {
            return id;
        }

        public void setId(BigInteger id) {
            this.id = id;
        }

        

        public String getWizard() {
            return wizard;
        }

        public void setWizard(String wizard) {
            this.wizard = wizard;
        }

        public BigInteger getId_item() {
            return id_item;
        }

        public void setId_item(BigInteger id_item) {
            this.id_item = id_item;
        }
        
        @Override
        public String toString(){
            return this.getWizard() + " " + this.getId_item();
        }
}
