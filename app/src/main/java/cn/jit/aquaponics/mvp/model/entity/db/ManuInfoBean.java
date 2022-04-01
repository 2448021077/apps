package cn.jit.aquaponics.mvp.model.entity.db;

import java.util.List;

public class ManuInfoBean {

    /**
     * id : 0
     * manu : string
     * products : ["string"]
     * type : string
     */

    private int id;
    private String manu;
    private String type;
    private List<String> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
