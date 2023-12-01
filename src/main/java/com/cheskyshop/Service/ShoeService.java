package com.cheskyshop.Service;
import java.util.List; 
import com.cheskyshop.models.Shoe;
import com.cheskyshop.dao.ShoeDAO;
import com.cheskyshop.utils.ConnectionManager;

public class ShoeService {
    private ShoeDAO shoeDAO;
    

    public ShoeService() {
        this.shoeDAO = new ShoeDAO(ConnectionManager.getConnection()); 
    }

    public ShoeService(ShoeDAO shoeDAO) {
        this.shoeDAO = shoeDAO;
    }

    public boolean inserShoe(String brand, int size, double price) {
        Shoe shoe = new Shoe(brand, size, price);
        return shoeDAO.insertShoe(shoe);
    }

    public Shoe getShoeByID(int shoeID) {
        return shoeDAO.getShoeByID(shoeID);
    }
    public List<Shoe> getAllShoes() {
        return shoeDAO.getAllShoes();
    }
    public boolean updateShoe(Shoe shoe) {
        return shoeDAO.updateShoe(shoe);
    }
    public boolean deleteShoe(int shoeID) {
        return shoeDAO.deleteShoe(shoeID);
    }
    public List<Shoe> getShoesByBrand(String brand) {
        return shoeDAO.getShoesByBrand(brand);
    }

    public List<Shoe> getShoesBySize(int size) {
        return shoeDAO.getShoesBySize(size);
    }

}
