package BankingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/banking_system";
    private static final String username = "root";
    private static final String password = "admin123";

    public static void main(String[] args) throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Scanner scanner = new Scanner(System.in);
            User user = new User(connection,scanner);
            Accounts accounts = new Accounts(connection,scanner);
            AccountManager accountManager = new AccountManager(connection,scanner);

            String email;
            long account_number;
            while(true){
                System.out.println("==========================================================");
                System.out.println("===           WELCOME TO BANKING SYSTEM                ===");
                System.out.println("==========================================================");
                System.out.println();
                System.out.println("1. Register");
                System.out.println("2. login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice1 = scanner.nextInt();
                switch (choice1){
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email = user.login();
                        if(email != null){
                            System.out.println();
                            System.out.println("User Logged in Successfully");
                            if(!accounts.account_exist(email)){
                                System.out.println();
                                System.out.println("1. Open New Bank Account");
                                System.out.println("2. Exit");
                                System.out.print("Enter your choice from above: ");
                                int choice = scanner.nextInt();
                                if(choice == 1){
                                    account_number = accounts.open_account(email);
                                    System.out.println("Account Created Successfully: ");
                                    System.out.println("Your Account number is: "+account_number);
                                }
                                else{
                                    break;
                                }
                            }
                            account_number = accounts.getAccount_number(email);
                            int choice2 = 0;
                            while(choice2 != 5){
                                System.out.println();
                                System.out.println("1. Debit Money");
                                System.out.println("2. Credit Money");
                                System.out.println("3. Transfer Money");
                                System.out.println("4. check Balance");
                                System.out.println("5. log out");
                                System.out.print("Enter your choice: ");
                                choice2 = scanner.nextInt();
                                switch (choice2){
                                    case 1:
                                        accountManager.debit_money(account_number);
                                        break;
                                    case 2:
                                        accountManager.credit_money(account_number);
                                        break;
                                    case 3:
                                        accountManager.transfer_money(account_number);
                                        break;
                                    case 4:
                                        accountManager.getBalance(account_number);
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Enter Valid Choice");
                                        break;
                                }
                            }
                        }
                        else{
                            System.out.println("Incorrect Email or password");
                        }
                    case 3:
                        System.out.println("Thank you for using banking System");
                        System.out.println("Exiting System");
                        return;
                    default:
                        System.out.println("Enter valid choice");
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
