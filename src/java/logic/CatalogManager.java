/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;
import java.util.ArrayList;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;
import model.Product;

@Named
@ApplicationScoped
public class CatalogManager implements Serializable {

    private ArrayList<Product> catalog;

    private Integer newId;
    private String newName;
    private Double newPrice;

    // Constructeur par défaut
    public CatalogManager() {
        this.catalog = new ArrayList<>();
    }

    @PostConstruct
    public void initCatalog() {
        catalog.add(new Product(10, "Chaussure", 28.62));
        catalog.add(new Product(11, "Fourchette", 5.2));
        catalog.add(new Product(12, "Papier", 1.8));
        catalog.add(new Product(13, "Table", 39.99));
    }

    // Getter et Setter pour catalog
    public ArrayList<Product> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Product> catalog) {
        this.catalog = catalog;
    }

    // Getter et Setter pour id
    public Integer getId() {
        return newId;
    }

    public void setId(Integer id) {
        this.newId = id;
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
        this.catalog.add(new Product(this.newId, this.newName, this.newPrice));
        this.newId = null;
        this.newName = null;
        this.newPrice = null;
        return "toCatalog";
    }
}
