Setup Instructions

1. Clone the repository

git clone https://github.com/RVE-vanoy/Dishtansya_test.git
cd Dishtansya_test

2. Configure database connection

Open `src/main/resources/application.properties` and update the database URL, username, password, and JWT secret key based on your local setup.

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/Dishtansya
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

jwt.secret-key=your_generated_secret_key
jwt.expiration=1800000

Create the database in MySQL:

CREATE DATABASE Dishtansya;

3. Run the application

Run the application using IntelliJ or Maven:

mvn spring-boot:run

The API will run at:

http://localhost:8080

4. Add sample products

The Order API requires products with available stock. Insert sample products into the `products` table before testing `/order`.

Example:

INSERT INTO products (product_name, stock)
VALUES ('Burger', 10);

INSERT INTO products (product_name, stock)
VALUES ('Hotdog', 5);

You can check the products using:

SELECT * FROM products;

5. Test the APIs

Use the included Postman collection to test the APIs.
