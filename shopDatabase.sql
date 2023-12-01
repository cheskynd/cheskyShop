Use CheskyStore;

CREATE TABLE IF NOT EXISTS shoe(
	shoeID INT PRIMARY KEY AUTO_INCREMENT, 
	size INT NOT NULL,
	brand VARCHAR(255) NOT NULL,
	price DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS electronics (
	electronicID INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS customers(
	customerID INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
    
);

CREATE TABLE IF NOT EXISTS purchases (
	purchaseID INT PRIMARY KEY AUTO_INCREMENT,
    customerID INT NOT NULL,
    shoeID INT ,
    electronicID INT,
    purchaseDate DATETIME NOT NULL,
    quantity INT NOT NULL,
    TotalPrice DECIMAL(10,2),
    FOREIGN KEY (customerID) REFERENCES customers(customerID),
    FOREIGN KEY(shoeID) REFERENCES shoe(shoeID),
    FOREIGN KEY(electronicID) REFERENCES electronics(electronicID)
);



00:49:22	CREATE TABLE IF NOT EXISTS purchases (  purchaseID INT PRIMARY KEY AUTO_INCREMENT,     customerID INT NOT NULL,     shoeID INT ,     electronicID INT,     purchaseDate DATETIME NOT NULL,     quantity INT NOT NULL,     TotalPrice DECIMAL(10,2),     FOREIGN KEY (customerID) REFERENCES customers(customerID),     FOREIGN KEY(shoeID) REFERENCES shoe(shoeID),     FOREIGN KEY(electronicID) REFERENCES electronics(electronicID) )	Error Code: 1824. Failed to open the referenced table 'customers'	0.00071 sec
