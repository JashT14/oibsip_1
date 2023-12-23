//Task 1 - ATM Interface - by Jash Thakkar

import java.util.*;

public class ATM{
    private static double balance = 10000; //initial balance
    private static final String USER_ID = "12345"; //User Id
    private static final String USER_PIN = "9876"; //User Pin
    static ArrayList<String> transactions = new ArrayList<String>(); //ArrayList Declaration to store transactions

    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Welcome to the ATM");

            // User authentication
            System.out.print("Enter user id: ");
            String userId = scanner.next();
            System.out.print("Enter user pin: ");
            String userPin = scanner.next();

            if(!userId.equals(USER_ID) || !userPin.equals(USER_PIN)){
                System.out.println("Invalid user id or pin. Access denied.");
                return;
            }
            System.out.print("Welcome to ATM\n");
            while(true){                                              //True until System.exit(0);
                System.out.println("1. Transactions History");//To check transaction History
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");//Added functionality to check balance of account
                System.out.println("6. Quit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("Transaction History: \n");
                        displayTransactionHistory();
                        break;
                    case 2://withdraw
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        if(withdrawAmount > balance) {
                            System.out.println("Insufficient balance. Deposit some Amount!");
                            transactions.add("Not Enough Balance. Withdraw Operation was not Initiated");
                        }
                        else{
                            balance -= withdrawAmount;
                            System.out.println("Successfully withdrawn: " + withdrawAmount);
                            System.out.println("Current balance: " + balance + "\n");
                            transactions.add("Withdrawn: "+withdrawAmount);//To store Transaction in ArrayList
                        }
                        break;
                    case 3://deposit
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        balance += depositAmount;
                        System.out.println("Successfully deposited: " + depositAmount);
                        System.out.println("Current balance: " + balance + "\n");
                        transactions.add("Deposited: " + depositAmount);//To store Transaction in ArrayList
                        break;
                    case 4:// Transfer
                        System.out.print("Enter the amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        if(transferAmount > balance){
                            System.out.println("Insufficient funds for transfer.");
                            transactions.add("Not Enough Balance. Transfer was not Initiated");
                        }
                        else{
                            System.out.print("Enter the recipient's account number: ");
                            String recipientAccount = scanner.next();
                            // Perform the transfer operation here
                            balance -= transferAmount;
                            System.out.println("Transfer successful. Remaining balance: " + balance + "\n");
                            transactions.add("Transferred " + transferAmount + " in the " + recipientAccount + " Account Number");//To store Transaction in ArrayList
                        }
                        break;
                    case 5:
                            System.out.println("The balance in your Account is: "+ balance);
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option");
                }
            }
        }
        }
            
            private static void displayTransactionHistory(){
                if(transactions.isEmpty()){
                    System.out.println("No transactions to display.");
                }
                else{
                    System.out.println("Transaction History:");
                    for (String transaction : transactions) {
                        System.out.println(transaction);
                    }
                }
            }
}
