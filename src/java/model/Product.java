/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private Double price;
    
    // Constructeur par défaut
    public Product() {
    }
    
    // Constructeur avec paramètres (optionnel)
    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    // Getter et Setter pour id
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    // Getter et Setter pour name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter et Setter pour price
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    // Redéfinition de toString() pour faciliter l'affichage
    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
