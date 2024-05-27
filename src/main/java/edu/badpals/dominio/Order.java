package edu.badpals.dominio;

import java.math.BigInteger;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

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


@Entity
@Table(name = "t_orders")
public class Order extends PanacheEntityBase{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ord_id")
        private BigInteger id;

        @OneToOne
        @JoinColumn(name = "ord_wizard")
        private Wizard wizard;

        @OneToOne
        @JoinColumn(name = "ord_item", nullable = true, updatable = false)
        private Item item;

        public Order() {
        }

        public Order(Wizard wizard, Item item) {
            this.wizard = wizard;
            this.item = item;
        }

        public BigInteger getId() {
            return id;
        }
        

        public Wizard getWizard() {
            return wizard;
        }

        public void setWizard(Wizard wizard) {
            this.wizard = wizard;
        }

        public Item getItem() {
            return item;
        }
        
        @Override
        public String toString(){
            return this.getWizard() + " " + this.getItem();
        }
}
