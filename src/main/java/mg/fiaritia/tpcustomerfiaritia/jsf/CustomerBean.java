/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.fiaritia.tpcustomerfiaritia.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import mg.fiaritia.tpcustomerfiaritia.entity.Customer;
import mg.fiaritia.tpcustomerfiaritia.service.CustomerManager;

/**
 * Backing bean de la page customerList.xhtml.
 *
 * @author raham
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    private List<Customer> customerList;

    @Inject
    private CustomerManager customerManager;

    /**
     * Créer une nouvelle instance de CustomerBean
     */
    public CustomerBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     *
     * @return List
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

    public void sortByStateAndCity() {
        customerList = customerList.stream()
                .sorted(Comparator.comparing(Customer::getState)
                        .thenComparing(Customer::getCity))
                .collect(Collectors.toList());
    }

}
