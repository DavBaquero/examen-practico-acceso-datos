package edu.badpals.repository;


import edu.badpals.dominio.MagicalItem;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MagicalItemRepository implements PanacheRepositoryBase<MagicalItem,String>{
}
