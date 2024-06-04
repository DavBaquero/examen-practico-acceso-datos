package edu.badpals;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
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
        return this.loadWizard(wizard.getName());
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
                return items.isPresent() ? Optional.of(items.get()) : createItem(item); 
            }
        }
        return Optional.empty();
    }

    public Optional<MagicalItem> loadItem(MagicalItem item){
        List<MagicalItem> todosItems = itemRepo.listAll();
        for (MagicalItem it: todosItems){
            String id = it.getId() + "";
            if (it.getName().equals(item.getName()) 
                && it.getQuality() == item.getQuality()
                && it.getType().equals(item.getType())){
                    Optional<MagicalItem> items = itemRepo.findByIdOptional(id);
                    return items.isPresent() ? Optional.of(items.get()) : createItem(item.getName(), item.getQuality(), item.getType());
                }
        }
        return Optional.empty();
    }

    public List<MagicalItem> loadItems(String name){
        List<MagicalItem> todosItems = itemRepo.listAll();
        List<MagicalItem> itemNombres = new ArrayList<>();
        for (MagicalItem item: todosItems){
            String nombre = item.getName();
            if (nombre.equals(name)){
                itemNombres.add(item);
            }
        }
        return itemNombres;
    }

    public Optional<MagicalItem> createItem(MagicalItem item){
        itemRepo.persist(item);
        return this.loadItem(item.getName());
    }

    public void deleteItem(String nombre){
        itemRepo.deleteById(nombre);
    }

    @Transactional
    public Optional<MagicalItem> createItem(String item_nom, int quality, String type){
        MagicalItem item = new MagicalItem(item_nom, quality, type);
        itemRepo.persist(item);
        return this.loadItem(item);
    }

    @Transactional
    public void createItems(List<MagicalItem> items){
        this.itemRepo.persist(items);
    }

    @Transactional
    public Optional<Order> placeOrder(String wizard, String item){
        Order order = null;
        Optional<Wizard> wizards = this.wizardRepo.findByIdOptional(wizard);
        Optional<MagicalItem> items = loadItem(item);
        if (wizards.isPresent() && items.isPresent()
            && ! wizards.get().getPerson().equals(Person.MUDBLOOD)){
            order = new Order();
            order.setWizard(wizards.get());
            order.setItem(items.get());
            this.orderRepo.persist(order);
        }
        return Optional.ofNullable(order);
    }

}