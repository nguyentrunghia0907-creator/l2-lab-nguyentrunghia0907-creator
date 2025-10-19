CREATE DATABASE WebShop;
use WebShop;

CREATE TABLE Categories (
id VARCHAR(50) PRIMARY KEY,
name VARCHAR(100)
);

CREATE TABLE Products (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
image VARCHAR(255),
price DOUBLE,
createdate DATE DEFAULT (CURRENT_DATE),
available BOOLEAN,
categoryid VARCHAR(50),
FOREIGN KEY (categoryid) REFERENCES Categories(id)
);

CREATE TABLE Accounts (
username VARCHAR(50) PRIMARY KEY,
password VARCHAR(100),
fullname VARCHAR(100),
email VARCHAR(100),
photo VARCHAR(255),
activated BOOLEAN,
admin BOOLEAN
);

CREATE TABLE Orders (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
address VARCHAR(255),
createdate DATE DEFAULT (CURRENT_DATE),
username VARCHAR(50),
FOREIGN KEY (username) REFERENCES Accounts(username)
);

CREATE TABLE OrderDetails (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
price DOUBLE,
quantity INT,
productid INT,
orderid BIGINT,
FOREIGN KEY (productid) REFERENCES Products(id),
FOREIGN KEY (orderid) REFERENCES Orders(id)
);
