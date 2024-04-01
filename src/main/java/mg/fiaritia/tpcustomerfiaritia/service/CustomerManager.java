/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.fiaritia.tpcustomerfiaritia.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.fiaritia.tpcustomerfiaritia.entity.Customer;

/**
 * Façade pour gérer les Customers.
 *
 * @author raham
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "fiaritiaCustomerPU")
    private EntityManager em;

    /**
     * Récuperer la liste des Customers : la requête correspond à un "select *"
     *
     * @return List
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    /**
     * Modification d'un customer Génèrera un UPDATE SQL
     *
     * @param customer
     * @return Customer
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    /**
     * Fait une nouvelle insertion: génèrera un INSERT SQL dans la base de
     * données
     *
     * @param customer
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    /**
     * Rechercher un customer suivant son identifiant
     * @param idCustomer
     * @return Customer
     */
    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
}
