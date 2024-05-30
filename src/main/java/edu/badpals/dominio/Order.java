package edu.badpals.dominio;

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
public class Order{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ord_id")
        private Long id;

        @OneToOne
        @JoinColumn(name = "ord_wizard")
        private Wizard wizard;

        @ManyToOne
        @JoinColumn(name = "ord_item", nullable = true, updatable = false)
        private MagicalItem MagicalItem;

        public Order() {
        }

        public Order(Wizard wizard, MagicalItem MagicalItem) {
            this.wizard = wizard;
            this.MagicalItem = MagicalItem;
        }

        public Long getId() {
            return id;
        }
        

        public Wizard getWizard() {
            return wizard;
        }

        public void setWizard(Wizard wizard) {
            this.wizard = wizard;
        }

        public MagicalItem getMagicalItem() {
            return MagicalItem;
        }
        
        @Override
        public String toString(){
            return this.getWizard().getNombre() + " " + this.getMagicalItem().getName();
        }
}
