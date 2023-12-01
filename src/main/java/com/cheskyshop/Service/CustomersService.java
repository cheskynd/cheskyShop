package com.cheskyshop.Service;
import com.cheskyshop.dao.CustomersDAO;
import com.cheskyshop.models.Customers;
import com.cheskyshop.utils.ConnectionManager; 
import java.util.List; 

public class CustomersService {

    private CustomersDAO customersDAO;
    public CustomersService() {
        this.customersDAO = new CustomersDAO(ConnectionManager.getConnection());
    }
    public  CustomersService(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }
    public boolean insertCustomer(String firstName, String lastName, String email, String phone, String address) {
        Customers customer = new Customers(firstName, lastName, email, phone, address);
        return customersDAO.insertCustomer(customer);
    }
    public Customers getCustomerByID(int customerID) {
        return customersDAO.getCustomerByID(customerID);
    }
    public List<Customers> getAllCustomers() {
        return customersDAO.getAllCustomers();
    }
    public boolean updateCustomer(Customers customer) {
        return customersDAO.updateCustomer(customer);
    }
    public boolean deleteCustomer(int customerID) {
        return customersDAO.deleteCustomer(customerID);
    }
    public Customers getCustomerByEmail(String email) {
        return customersDAO.getCustomerByEmail(email);
    }
    // public Customers getCustomerByEmailAndPassword(String email, String password) {
    //     return customersDAO.getCustomerByEmailAndPassword(email, password);
    // }

    
}
