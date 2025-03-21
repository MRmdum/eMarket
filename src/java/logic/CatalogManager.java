/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import model.Product;
        
@Named
@ApplicationScoped
public class CatalogManager implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Product> catalog;
    
    // Constructeur par défaut
    public CatalogManager() {
        this.catalog = new ArrayList<>();
    }
    
    // Getter et Setter pour catalog
    public List<Product> getCatalog() {
        return catalog;
    }
    
    public void setCatalog(List<Product> catalog) {
        this.catalog = catalog;
    }
    
    // Méthode pour ajouter un produit au catalogue
    public void addProduct(Product product) {
        this.catalog.add(product);
    }
    
    // Méthode pour supprimer un produit du catalogue
    public void removeProduct(Product product) {
        this.catalog.remove(product);
    }
}
