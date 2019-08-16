import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.*;

public class FinanceCalculator {
    private static DecimalFormat df = new DecimalFormat("#.##");
    public static void main (String[] args) {
        System.out.print("Enter your total amount: $");
        Scanner total = new Scanner(System.in);
        String[] items = {"food?", "housing?", "clothing?", "your automobile?","appliances?","services?",};
        double totalAmount = total.nextDouble();
        double sum = 0;
        double [] itemsPrice = new double [6];

        for (int i = 0; i < items.length; i++) {
            System.out.print("How much did you spend on " + items[i]+"s");
            Scanner itemInputCost = new Scanner(System.in);
            double itemCost = itemInputCost.nextDouble();
            sum = sum + itemCost;
            double deductions = totalAmount - sum;
            itemsPrice[i] = itemCost;
            System.out.println("Your leftover balance is $" + df.format(deductions));
        }
        System.out.println();
        System.out.print("Items");
        System.out.print("          Percentage");
        System.out.println();
        for(int x=0;x< items.length; x++){
            double percentage = Math.round(((itemsPrice[x]/sum)*10000));
            System.out.println(items[x]);
            System.out.print("                  "+percentage*0.01+"%");
            System.out.println();
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

