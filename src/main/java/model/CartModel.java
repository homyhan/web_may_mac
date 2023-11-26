package model;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CartModel  {
    private final Map<Integer, CartItem> map = new HashMap<>();
    private int id;
    private int count;
    private double totalPrice;
    private int voucher =0;
    private int ship =0;
    private double totalShip;
    private double totalPriceVoucher;
    private String timeShip;
    private int idUser;
    private int inShip;
    private Timestamp createTime;
    private List<Order> orders;

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        count = 0;
        map.forEach((id, item) -> count += item.getQuantity());
        return count;    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalPrice() {
        totalPrice = 0;
        map.forEach((id, item) -> totalPrice += item.getProduct().getPrice() * item.getQuantity());
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }

    public int getShip() {
        return ship;
    }

    public void setShip(int ship) {
        this.ship = ship;
    }

    public double getTotalShip() {
        return getTotalPrice() + ship;
    }

    public void setTotalShip(double totalShip) {
        this.totalShip = totalShip;
    }

    public double getTotalPriceVoucher() {
        return getTotalShip() - voucher;
    }

    public void setTotalPriceVoucher(double totalPriceVoucher) {
        this.totalPriceVoucher = totalPriceVoucher;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getInShip() {
        return inShip;
    }

    public void setInShip(int inShip) {
        this.inShip = inShip;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addProduct(Product product, int quantity) {
        CartItem item = map.containsKey(product.getIdproduct()) ? map.get(product.getIdproduct()) : new CartItem(product);
        item.setQuantity(item.getQuantity() + quantity);
        map.put(product.getIdproduct(), item);
    }

    public void removeProduct(Product p) {
        CartItem item = map.get(p.getIdproduct());
        if (item.getQuantity() == 1) map.remove(p.getIdproduct());
        else item.setQuantity(item.getQuantity() - 1);
    }

    public void deleteProductById(int id) {
        map.remove(id);
    }

    public void deleteProduct(Product p) {
        map.remove(p.getIdproduct());
    }
}
