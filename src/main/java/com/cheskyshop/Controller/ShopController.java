package com.cheskyshop.Controller;
import com.cheskyshop.Service.*;
import com.cheskyshop.models.*;
import com.cheskyshop.dao.*;
import java.util.List;
import static spark.Spark.*;

// we will use spark to create a web server and this is the link to the documentation: https://www.baeldung.com/spark-framework-rest-api 

public class ShopController {
    private ElectronicsService electronicsService = new ElectronicsService();
    private CustomersService customersService = new CustomersService();
    private PurchasesService purchasesService = new PurchasesService();
    private ShoeService shoeService = new ShoeService();

    public static void main(String[] args) {
 
        get("/hello", (req, res)->"Hello, world");
        
        get("/hello/:name", (req,res)->{
            return "Hello, "+ req.params(":name");
        });
    }
    
}
