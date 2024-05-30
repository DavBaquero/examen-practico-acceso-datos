package edu.badpals;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

import edu.badpals.dominio.*;
import edu.badpals.repository.MagicalItemRepository;
import edu.badpals.repository.OrderRepository;
import edu.badpals.repository.WizardRepository;

@ApplicationScoped
public class Repositorio {

    @Inject
    MagicalItemRepository itemRepo;

    @Inject
    WizardRepository wizardRepo;

    @Inject
    OrderRepository orderRepo;


    public Repositorio(){}

    public Optional<Wizard> loadWizard(String wizard){
        Optional<Wizard> wizards = wizardRepo.findByIdOptional(wizard);
        return wizards.isPresent() ? Optional.of(wizards.get()) : Optional.empty();
    }

    public Optional<Wizard> crearWizard(Wizard wizard){
        wizardRepo.persist(wizard);
        return this.loadWizard(wizard.getNombre());
    }

    public void deleteWizard(String wizard){
        wizardRepo.deleteById(wizard);
    }

    public Optional<MagicalItem> loadItem(String item_nom){
        List<MagicalItem> todosItems = itemRepo.listAll();
        for (MagicalItem item: todosItems){
            String name = item.getName();
            String id = item.getId() + "";
            if (name.equals(item_nom)){
                Optional<MagicalItem> items = itemRepo.findByIdOptional(id);
                return items.isPresent() ? Optional.of(items.get()) : crearItem(item); 
            }
        }
        return Optional.empty();
    }

    public Optional<MagicalItem> crearItem(MagicalItem item){
        itemRepo.persist(item);
        return this.loadItem(item.getName());
    }

    public void deleteItem(String nombre){
        itemRepo.deleteById(nombre);
    }

}
