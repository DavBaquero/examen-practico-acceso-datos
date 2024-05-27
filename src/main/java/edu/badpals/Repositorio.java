package edu.badpals;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

import edu.badpals.dominio.*;

@ApplicationScoped
public class Repositorio {
    public Repositorio(){}

    public Wizard loadWizard(String wizard){
        Optional<Wizard> wizards = Wizard.findByIdOptional(wizard);
        return wizards.isPresent() ? wizards.get() : new Wizard();
    }

    public Optional<MagicalItem> loadItem(String item){
        Optional<MagicalItem> items = Wizard.findByIdOptional(item);
        if (items.isPresent()){
            items.get().getNombre();
        }
        return items;
    }
}
