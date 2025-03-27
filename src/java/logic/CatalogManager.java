/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import facade.ProductFacade;
import java.io.Serializable;
import java.util.ArrayList;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import model.Product;

@Named
@ApplicationScoped
public class CatalogManager implements Serializable {

    private ArrayList<Product> catalog;

    private String newName;
    private Double newPrice;

    @EJB
    private ProductFacade productFacade;

    // Constructeur par défaut
    public CatalogManager() {
        this.catalog = new ArrayList<>();
    }

    @PostConstruct
    public void initCatalog() {
        catalog.addAll(productFacade.findAll());
    }

    // Getter et Setter pour catalog
    public ArrayList<Product> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Product> catalog) {
        this.catalog = catalog;
    }

    // Getter et Setter pour name
    public String getName() {
        return newName;
    }

    public void setName(String name) {
        this.newName = name;
    }

    // Getter et Setter pour price
    public Double getPrice() {
        return newPrice;
    }

    public void setPrice(Double price) {
        this.newPrice = price;
    }

    public String createProduct() {
        Product entity = new Product(catalog.size() + 1, this.newName, this.newPrice);
        catalog.add(entity);
        productFacade.create(entity);
        this.newName = null;
        this.newPrice = null;
        return "toCatalog";
    }
}
