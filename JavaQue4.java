import java.util.Scanner;
class BankAccount 
{
    private double balance;
    public BankAccount() 
    {
        balance=0.0;
    }
    public void deposit(double amount) 
    {
        if (amount>=100) 
        {
            balance=balance+amount;
            System.out.println("Deposit successful and Current balance:" + balance);
        } 
        else 
        {
            System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(double amount)
    {
        if (amount>=100) 
        {
            if (balance>=amount) 
            {
                balance=balance-amount;
                System.out.println("Withdrawal successful and Current balance:" + balance);
            } 
            else 
            {
                System.out.println("Insufficient amount");
            }
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount");
        }
    }
    public double getBalance() 
    {
        return balance;
    }
}
public class JavaQue4 {
	public static void main(String[] args)
	{
		int ch;
		BankAccount ba = new BankAccount();
        Scanner scan = new Scanner(System.in);
        do
        {
        	System.out.println("Bank Account Simulation");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            ch = scan.nextInt();

            switch(ch) 
            {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount=scan.nextDouble();
                    ba.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount=scan.nextDouble();
                    ba.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current balance:" + ba.getBalance());
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(ch>=1&&ch<=3);
        System.out.println();
     }
}


