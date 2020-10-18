package mainclass;

import java.util.*;

interface Account
{
     
}

        
class BankAccount {

        private final String accountNumber;
        private final String accountName;
        private double balance;
      

        public BankAccount(String accNumber,String accName) {
            accountNumber = accNumber;
            accountName = accName;
            balance = 0;
           
        }


        public String getAccountName() {
            return accountName;
        }



        public String getAccountNumber() {
            return accountNumber;
        }


        public double getBalance() {
            return balance;
        }
        
        
        public boolean deposit(double amount) {
            if (amount > 0) {
                    balance = balance + amount;
                   
                return true;
            } else {
                return false;
            }
        }

        public boolean withdraw(double amount) {
            if (amount > balance) {
                return false;
            } else {
                balance = balance - amount;
                return true;
            }
        }
}

class CheckingAccount extends BankAccount {
    private int transactionCount;
    private static final int NUM_FREE = 3;
    private static final double TRANS_FEE = 2.0;

    public CheckingAccount(String accNumber, String accName) {
        super(accNumber, accName);
        transactionCount = 0;
    }

    @Override
    public boolean deposit(double amount) {
        if (super.deposit(amount)) {
            transactionCount++;
            return true;
        }
        return false;
    }


    @Override
    public boolean withdraw(double amount) {
    if (super.withdraw(amount)) {
        transactionCount++;
        return true;
    }
        return false;
    }


    public void deductFees() {
        if (transactionCount > NUM_FREE) {
            double fees = TRANS_FEE * (transactionCount - NUM_FREE);
            if (super.withdraw(fees)) {
            transactionCount = 0;
            }
        }
    }
}

        
        
        
    
 class Customer
{
    
    int phone_no;
    String email;
    String address;
    Customer(String email_id,String addr,int phn_no)
    {
        email=email_id;
        address=addr;
        phone_no=phn_no;
    }    
    void display()
    {
        System.out.println("Enter email_id:" +email);
        System.out.println("Enter address" +address);
        System.out.println("Enter phn_no"+phone_no);
    }
}

    class SavingsAccount extends BankAccount implements Account {
        
    private double interestRate;
    
    public SavingsAccount(String accNumber, String accName, int rate) {
        super(accNumber, accName);
        interestRate = rate;
    }
 
       
     public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
     
    }
   
    



    
    

    



   
    
 public class Mainclass{

public static void main(String[] args) {
    System.out.println("********WELCOME TO STATE BANK *******");
    System.out.println("1.Register");
    System.out.println("2.Login");
    System.out.println("3.EXIT");
   
     boolean quit = false;  
   
    do
    {
        System.out.println("enter an option");
    Scanner s=new Scanner(System.in);
   
    int choose=s.nextInt();
    switch (choose)
    {
        
   case 1:
   String name,gender;
   int age,Aadhar_no;
   String account_type,address,email;     
   System.out.println("REGISTER YOUR ACCOUNT");   
   System.out.println("REGISTRATION FORM****");
   Scanner input=new Scanner(System.in);
   System.out.println("Name:");
   name=input.nextLine();
   Scanner sc9=new Scanner(System.in);
   System.out.println("Age:");   
   //age=sc9.nextInt();
   age=input.nextInt();
   System.out.println("address:");
   address=input.nextLine();
   System.out.println("Email");
   email=sc9.nextLine();
   System.out.println("gender:");
   gender=input.nextLine();
   
   
   if(gender.toUpperCase().equals("MALE")||gender.toUpperCase().equals("FEMALE"))
       
           {
              System.out.println("Selected  " +gender.toUpperCase());
           }
   else
   {
       System.out.println("Incorrect gender specifier");
   }
   System.out.println("account_type");
   account_type=input.nextLine();
   
   System.out.println("Registered successfully");
   break;
   
   case 2:
     
   Scanner scan =new Scanner(System.in);
   String uname,pass;
   System.out.println("Enter your username:");
   uname=scan.nextLine();
   System.out.println("Enter your password:");
   pass=scan.nextLine();
   if(uname.equals("admin")&&pass.equals("admin"))
    {
        System.out.println("Welcome admin");
        System.out.println("*****BANK ACCOUNTS CREDENTIALS ******");
    System.out.println("Enter the Account Number");
    Scanner sc3= new Scanner(System.in);
    String acc =sc3.next();
    System.out.println("Enter the Name of the Accountant");
    Scanner sc4= new Scanner(System.in);
    String accname =sc4.next();
    BankAccount account = new BankAccount(acc, accname);
       
        boolean exit =false;
        do{
        System.out.println("CHOOSE YOUR SERVICE");
      
        System.out.println("1.deposit");
        System.out.println("2.withdraw");
        System.out.println("3.balance");
        System.out.println("4.savings acc details:");
        System.out.println("5.Interest");
        System.out.println("6.TransactionCount");
        System.out.println("7.EXIT");
        Scanner s1 =new Scanner(System.in);
        int choose1 = s1.nextInt();
        switch(choose1){
           
            case 1:
    System.out.println("Enter the deposit amount 1");
    Scanner sc= new Scanner(System.in);
    int dep =sc.nextInt();
    boolean deposit;
    deposit = account.deposit(dep);
    System.out.println("Enter the deposit amount 2");
    Scanner sc1= new Scanner(System.in);
    int dep1 =sc1.nextInt();
    account.deposit(dep1);
    System.out.println("Balance is: " + account.getBalance());
    break;
    case 2:
              {
                System.out.println("Enter the withdraw amount");
                Scanner sc2= new Scanner(System.in);
                int wit =sc2.nextInt();
                boolean withdraw = account.withdraw(wit);
                break;
              }
    case 3:
            {
                System.out.println("Balance is: " + account.getBalance());
                break;
            }
    case 4:
            {
                 System.out.println("The Account Number is " +acc);
                 System.out.println("The Account Name "+ " is " + accname);
                 break;
               
            }
    case 5:
    {
                System.out.println("Enter the Interest");
                Scanner sc5= new Scanner(System.in);
                int rate =sc5.nextInt();
                SavingsAccount saving = new SavingsAccount(acc,accname,rate);
   
                saving.deposit(account.getBalance());
                System.out.println("Balance Before Interest: " + saving.getBalance());

                saving.addInterest();
                System.out.println("Balance After Interest: " + saving.getBalance());
                break;
        }
            case 6:
            {
    System.out.println("*****TRANSACTION DETAILS OF SAVING'S ACCOUNT****");
    CheckingAccount checking = new CheckingAccount(acc,accname);
    System.out.println("The Account Number is " + acc);
    System.out.println("The Account Name is " + accname);
    checking.deposit(500);
    checking.withdraw(200);
    checking.deposit(700);
    checking.deductFees();
    System.out.println("transactions <= 3: " + checking.getBalance());
    checking.deposit(200);
    checking.deductFees();
    System.out.println("transactions > 3: " + checking.getBalance());
    break;
            }
            
            
            case 7:
            {
                exit = true;
            }
    }}while(!exit);}
    else
    {
        System.out.println("Incorrect username or password");
        break;
    }
    break;
   case 3:
   {
       quit = true;
   }
    }
    }while(!quit);
}

    

    
 }
