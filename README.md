
# Banking Management System

The Banking Management System is a Java-based Terminal application connected to a MySQL database via JDBC. It simulates essential banking operations such as user registration, login, money transactions, and balance inquiry. This project aims to provide a secure and user-friendly platform for managing basic banking tasks efficiently.


## Features

##### User Registration and Login: 
- Register a new user account with secure credentials.
- Log in with your credentials to access the system.
##### Debit and Credit Money
- Debit money from your account for purchases or withdrawals.
- Credit money to your account from deposits or transfers.
##### Fund Transfer
- Transfer money between your accounts or to other users securely.
##### Balance Inquiry
- Instantly check your account balance and transaction details.
##### Secure Logout
- Log out safely to protect your account information.



## Technologies Used
- Java: For implementing the core functionalities and user      interface.
- JDBC: To handle database operations and ensure data integrity.
- MySQL: For storing user data, account information, and transaction history.

## Setup and Installation

 Clone the project

```bash
  git clone https://github.com/Navneetsingh04/Banking-System
```
### Database Setup
- Install MySQL and create a new database named banking_system.
- Import the provided SQL file to set up the required tables.

### Download JDBC Driver

- Download the MySQL JDBC Driver (e.g., mysql-connector-java.jar) from MySQL Connector/J.
- Add the downloaded JDBC jar file to your IDE’s project build path.

### Configure Database Connection

- Update the JDBC connection string in the Java code to match your MySQL credentials
```
String url = "jdbc:mysql://localhost:3306/banking_system";
String user = "your_mysql_username";
String password = "your_mysql_password";
```
### Compile and Run:

- Compile the Java files using your preferred IDE or command line.
- Run the Main class to start the application.


## Usage

### Welcome Screen
```
==========================================================
===           WELCOME TO BANKING SYSTEM                ===
==========================================================

```
- Register: Create a new account to access the banking system.
- Login: Use your credentials to log in to your account.
- Exit: Close the application

### User Interface

##### Once logged in, the following options are available

- Debit Money: Withdraw funds from your account.
- Credit Money: Deposit funds into your account.
- Transfer Money: Transfer money to another account.
- Check Balance: View the current balance in your account.
- Log Out: Safely log out from the system.
## Contributing

Contributions are always welcome!

`
If you'd like to contribute to this project, please fork the repository and use a feature branch. Pull requests are welcome.
`

Please adhere to this project's `code of conduct`.


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

[MIT](https://github.com/Navneetsingh04/Banking-System/blob/main/LICENSE)

