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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ord_id")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "ord_wizard")
        private Wizard wizard;

        @OneToOne
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

        public MagicalItem getItem() {
            return MagicalItem;
        }
        
        @Override
        public String toString(){
            return this.getWizard().getName() + " " + this.getItem().getName();
        }
}
