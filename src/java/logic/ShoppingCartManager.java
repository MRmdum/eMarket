/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import model.Product;
import model.ShoppingCartItem;

@Named
@SessionScoped
public class ShoppingCartManager implements Serializable {

    private ArrayList<ShoppingCartItem> shoppingCart;
    private Product prodToAdd;
    private ShoppingCartItem currentItem;

    public ShoppingCartItem getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(ShoppingCartItem currentItem) {
        this.currentItem = currentItem;
    }

    public Product getProdToAdd() {
        return prodToAdd;
    }

    public void setProdToAdd(Product prodToAdd) {
        this.prodToAdd = prodToAdd;
    }

    public ShoppingCartManager() {
        this.shoppingCart = new ArrayList<>();
    }

    public ArrayList<ShoppingCartItem> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<ShoppingCartItem> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String addToCart() {
        ShoppingCartItem newItem = new ShoppingCartItem();
        newItem.setId(this.shoppingCart.size());
        newItem.setQuantity(1);
        newItem.setProduct(this.prodToAdd);
        this.shoppingCart.add(newItem);
        return "toShoppingCart";
    }

    public void removeFromCart() {
        this.shoppingCart.remove(this.currentItem);
    }

    public void addQuantity(Integer q) {
        this.currentItem.setQuantity(this.currentItem.getQuantity() + q);
        if (this.currentItem.getQuantity() == 0) {
            this.removeFromCart();
        }
    }

    public Double getTotalPrice() {
        Double total = 0.0;
        for (ShoppingCartItem item : this.shoppingCart) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }
}
