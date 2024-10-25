import java.util.*;
interface BankingAccount<T>
{
    void createAccount(String accountID,int initialDepositAmount);
    void depositMoney(int depositMoney);
    void withDrawMoney(int deductMoney);
    void transferFunds(Scanner scanner,ArrayList<T>al);
    void viewTransaction(String accountID,ArrayList<T>al);
}

class Bank implements BankingAccount<Bank>
{
    Bank(){}
    String accountID;
    ArrayList<String>al;//To keep transactions
    int totalMoney = 0;
    Bank(String accountID,int initialDepositAmount)
    {
        createAccount(accountID,initialDepositAmount);
    }
    public void createAccount(String accountID,int initialDepositAmount)
    {
        accountID = accountID.replace(" ","");
        this.accountID = accountID;
        this.al = new ArrayList<>();
        this.totalMoney = initialDepositAmount;
        System.out.println("Account created successfully");
    }

    public void depositMoney(int depositMoney)
    {
        if(depositMoney>0)
        {
            al.add("Money deposited:"+depositMoney+" to accountID:"+accountID);
            totalMoney += depositMoney;
        }
        else 
            System.out.println("Negative money cannot be added");
    }

    public void withDrawMoney(int deductMoney)
    {
        if(deductMoney>totalMoney)
            System.out.println("You don't have this much of funds to reduce");
        else 
        {
            totalMoney = totalMoney - deductMoney;
            al.add("Money deducted:"+deductMoney);
            System.out.println("Deducted money:"+deductMoney+" Total money:"+totalMoney);
        }
    }

    static boolean lookForID(String accountID,ArrayList<Bank>al)
    {
        Iterator<Bank> iterator = al.iterator();
        boolean accountExists = false;
        while(iterator.hasNext())
        {
            Bank b = (Bank)iterator.next();
            if(accountID.equals(b.accountID))
            {
                accountExists = true;
                break;
            }
        }
        return accountExists;
    }

    static Bank searchForID(String personAccountID,ArrayList<Bank>al)
    {
        Iterator<Bank> iterator = al.iterator();
        while(iterator.hasNext())
        {
            Bank b = (Bank)iterator.next();
            if(personAccountID.equals(b.accountID))
                return b;
        }
        return new Bank();//Writing this just to bypass the error, we are 100% sure that accountExists and if condition will become true forsure
    }

    public void transferFunds(Scanner scanner,ArrayList<Bank>al)
    {
        System.out.println("Enter the Sender accountID");
        String sender = scanner.nextLine();
        sender = sender.replace(" ","");
        System.out.println("Enter the Receiver accountID:");
        String receiver = scanner.nextLine();
        receiver = receiver.replace(" ","");  
        boolean senderIDExists = Bank.lookForID(sender,al);
        boolean receiverIDExists = Bank.lookForID(receiver,al);
        if(senderIDExists && receiverIDExists)
        {
            System.out.println("Enter the money you want to transfer:");
            int moneyToTransfer = scanner.nextInt();
            Bank receiverPersonDetails = Bank.searchForID(receiver,al);
            Bank senderPersonDetails = Bank.searchForID(sender,al);
            if(senderPersonDetails.totalMoney<moneyToTransfer)
                System.out.println("Money cannot be transfered because you don't have this much of money in account");
            else 
            {
                receiverPersonDetails.totalMoney = receiverPersonDetails.totalMoney + moneyToTransfer;
                receiverPersonDetails.al.add("Money:"+moneyToTransfer+" received from "+receiver);
                senderPersonDetails.totalMoney = senderPersonDetails.totalMoney - moneyToTransfer;
                senderPersonDetails.al.add("Money:"+moneyToTransfer+" transfered to "+sender);
                System.out.println("Transaction done successfully");
            }
        }
        else 
        {
            System.out.println("Either sender or receiver or both accountID doesn't exists in the database");
        }
    }

    public void viewTransaction(String accountID,ArrayList<Bank>al)
    {
        boolean accountExists = Bank.lookForID(accountID,al);
        if(accountExists)
        {
            Bank b = Bank.searchForID(accountID,al);
            Iterator<String> iterator = b.al.iterator(); 
            while(iterator.hasNext())
            {
                String myString = (String) iterator.next();
                System.out.print(myString+", ");
            }
            System.out.println("");
        }
        else 
            System.out.println("This account ID doesn't exists and hence cannot show transactions");
    }

}

class main20 
{
    
    public static void main(String[] args)
    {
        ArrayList<Bank> mainArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String accountID;
        boolean accountExists;
        int money;
        while(true)
        {
            System.out.println("1.Create Account 2.Deposit 3.Withdraw 4.Transfer funds 5.View transactions 6.Exit\nEnter choice:");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter Account ID:");
                    accountID = scanner.nextLine();
                    System.out.println("Enter initialDeposit");
                    int deposit = scanner.nextInt();
                    if(deposit >=0)
                        mainArrayList.add(new Bank(accountID,deposit));
                    else 
                        System.out.println("Cannot create account as the initialDeposit is negative");
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Enter account ID:");
                    accountID = scanner.nextLine();
                    System.out.println("Enter money to deposit:");
                    money = scanner.nextInt();
                    accountExists = Bank.lookForID(accountID,mainArrayList);
                    if(accountExists)
                    {
                        Bank b = Bank.searchForID(accountID,mainArrayList);
                        b.depositMoney(money);
                    }
                    else 
                        System.out.println("This accountID doesn't exists and hence cannot deposit money");                  
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Enter account ID:");
                    accountID = scanner.nextLine();
                    System.out.println("Enter money to withdraw:");
                    money = scanner.nextInt();
                    accountExists = Bank.lookForID(accountID,mainArrayList);
                    if(accountExists)
                    {
                        Bank b = Bank.searchForID(accountID,mainArrayList);
                        b.withDrawMoney(money);
                    }
                    else 
                        System.out.println("This accountID doesn't exists and hence cannot withdraw money");     
                    break;
                case 4:
                    Bank c = new Bank();
                    scanner.nextLine();
                    c.transferFunds(scanner,mainArrayList);
                    break;
                case 5:
                    System.out.println("Enter account ID:");
                    scanner.nextLine();
                    accountID  = scanner.nextLine();
                    Bank d = new Bank();
                    d.viewTransaction(accountID,mainArrayList);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("You have entered wrong input");
            }
        }
    }
}