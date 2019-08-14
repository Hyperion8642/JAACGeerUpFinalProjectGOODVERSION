import java.util.Scanner;

public class FinanceCalculator {
    public static void main (String[] args) {
        System.out.println("Enter your total amount: ");
        Scanner total = new Scanner(System.in);
        String[] items = {"food", "housing", "clothing", "your automobile","appliances","services",};
        int totalAmount = total.nextInt();
        int sum = 0;

        for (int i = 0; i < items.length; i++) {
            /*System.out.println("How much did you spend on food?");*/
            /*myQuestion("food?");*/
            System.out.println("How much did you spend on " + items[i] + "? ");
            Scanner itemInputCost = new Scanner(System.in);
            int itemCost = itemInputCost.nextInt();
            sum = sum + itemCost;
        }
        System.out.print("hi");
        System.out.print("hi");
        System.out.println("Hello");

        for(int x=0;x< items.length; x++){
            System.out.println("");
        }
        int balance = totalAmount - sum;
        System.out.println("Your balance is: $" + balance);
        if (balance < 100){
            System.out.println("You're broke! Manage your finances better!");
        }else {
            System.out.println("Great job keeping your finances in check!");
        }
    }
}
