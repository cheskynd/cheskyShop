package com.cheskyshop.Service;
import com.cheskyshop.dao.ElectronicsDAO;
import com.cheskyshop.models.Electronics;   
import com.cheskyshop.utils.ConnectionManager;  
import java.util.List; 

public class ElectronicsService {

    private ElectronicsDAO electronicsDAO;
    public ElectronicsService() {
        this.electronicsDAO = new ElectronicsDAO(ConnectionManager.getConnection());
    }
    public  ElectronicsService(ElectronicsDAO electronicsDAO) {
        this.electronicsDAO = electronicsDAO;
    }   
    public boolean insertElectronics(String brand, String model, double price) {
        Electronics electronics = new Electronics(brand,model, price);
        return electronicsDAO.insertElectronic(electronics);
    } 
    public boolean updateElectronics(int electronicID, String brand, String model, double price) {
        Electronics electronics = new Electronics(electronicID, brand, model, price);
        return electronicsDAO.updateElectronic(electronics);
    }
    public boolean deleteElectronics(int electronicID) {
        return electronicsDAO.deleteElectronic(electronicID);
    }
    public List<Electronics> getAllElectronics() {
        return electronicsDAO.getAllElectronics();
    }
    public Electronics getElectronicByID(int electronicID) {
        return electronicsDAO.getElectronicByID(electronicID);
    }
    
    
}
