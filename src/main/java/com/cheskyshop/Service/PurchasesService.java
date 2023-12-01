package com.cheskyshop.Service;
import com.cheskyshop.dao.PurchasesDAO;
import com.cheskyshop.utils.ConnectionManager;
import com.cheskyshop.models.Purchases;
import java.util.List;


public class PurchasesService {
    private PurchasesDAO purchasesDAO;

    public PurchasesService() {
        this.purchasesDAO = new PurchasesDAO(ConnectionManager.getConnection());
    }
    
    public PurchasesService(PurchasesDAO purchasesDAO) {
        this.purchasesDAO = purchasesDAO;
    }

    public boolean insertPurchases(int shoeID, int userID, int size,int quantity, double totalPrice) {
        Purchases purchases = new Purchases(shoeID, userID, size, quantity, totalPrice);
        return purchasesDAO.insertPurchase(purchases);
    }

    public Purchases getPurchasesByID(int purchaseID) {
        return purchasesDAO.getPurchaseByID(purchaseID);
    }
    public List<Purchases> getAllPurchases() {
        return purchasesDAO.getAllPurchases();
    }
    public List<Purchases> getAllPurchasesByCustomerID(int customerID) {
        return purchasesDAO.getAllPurchasesByCustomerID(customerID);
    }
    

}
