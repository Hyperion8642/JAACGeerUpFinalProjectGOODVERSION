import java.util.Scanner;
import java.text.DecimalFormat;

public class FinanceCalculator {
    private static DecimalFormat df = new DecimalFormat("#.##");
    public static void main (String[] args) {
        System.out.print("Enter your total amount: $");
        Scanner total = new Scanner(System.in);
        String[] items = {"food? $", "housing? $", "clothing? $", "your automobile? $","appliances? $","services? $",};
        double totalAmount = total.nextDouble();
        double sum = 0;

        for (int i = 0; i < items.length; i++) {
            System.out.print("How much did you spend on " + items[i]);
            Scanner itemInputCost = new Scanner(System.in);
            double itemCost = itemInputCost.nextDouble();
            sum = sum + itemCost;
            double deductions = totalAmount - sum;
            System.out.println("Your leftover balance is $" + df.format(deductions));
        }
        double balance = totalAmount - sum;
        System.out.println();
        System.out.println("Final Balance: $" + df.format(balance));
        if (balance < 100.00){
            System.out.println("You're broke! Manage your finances better!");
        }else {
            System.out.println("Great job keeping your finances in check!");
        }
    }
}
