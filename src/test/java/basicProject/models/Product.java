package basicProject.models;

import lombok.Data;

@Data
public class Product {
    String productName;
    String productPrice;

    public String setProductName() {
        this.productName = "Bezvadu austiņas Beats Studio3 Wireless, zila";
        return null;
    }

    public String setProductPrice() {
        this.productPrice = "288,97 €";
        return null;
    }
}