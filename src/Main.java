import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.ArrayList;
import java.io.*;


public class Main extends JFrame {

    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        System.out.println("Hello");

//        Setting up the frame
        JFrame frame = new JFrame("Manage Your Spending");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 600);
        frame.setLocation(400, 50);

//        Setting up the menu bar
        JMenuBar jmb = new JMenuBar();
        JMenu jm1 = new JMenu("Save as");
        jmb.add(jm1);

//        Setting up the text areas
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        final JTextArea inputArea = new JTextArea();
        inputArea.setEditable(true);

//        Setting up the bottom panel
        JPanel jPanel = new JPanel();
        JButton button1 = new JButton("Calculate");
        JButton button2 = new JButton("Clear");

//        Adding the elements to the jpanel
        jPanel.add(button1);
        jPanel.add(button2);

//        Adding the items to the frame
        frame.getContentPane().add(jPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(jmb, BorderLayout.NORTH);
        frame.getContentPane().add(textArea, BorderLayout.WEST);
        frame.getContentPane().add(inputArea, BorderLayout.CENTER);

        frame.setVisible(true);

//        Asking for user input
        String[] items = {"food?", "housing?", "clothing?", "your automobile?", "appliances?", "services?",};

        textArea.setText("What was your previous balance $" + "\n");

        for (int i = 0; i < items.length; i++) {
            textArea.append("How much did you spend on " + items[i] + "\n");
        }

//        Getting user input
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double total = 0;
                double[] itemsPrice = new double [6];
                String txt = inputArea.getText();
                String[] arrayOfLines = txt.split("\n");
                String firstOfTxt = arrayOfLines[0];
                ArrayList<String> list1 = new ArrayList<String>();
                ArrayList<String> list = new ArrayList<String>();

                for (int x = arrayOfLines.length; x > 0; x--) {
                    list1.add(arrayOfLines[x - 1]);
                }

                for (int y = arrayOfLines.length; y > 0; y--) {
                    list.add(list1.get(y - 1));
                }

                list.remove(0);
                int listLength = list.size();

                for (int k = listLength; k > 0; k--) {
                    double itemCost = Double.parseDouble(list.get(k-1));
                    total = total + itemCost;
                    itemsPrice[k - 1] = itemCost;
                }

                inputArea.append("\n");
                textArea.append("\n" + "You spent $" + df.format(total) + "\n");
                textArea.append("\n");

                textArea.append("Items");
                textArea.append("          Percentage" + "\n");

                for (int b = 0; b < items.length; b++) {
                    double percentage =- Math.round(((itemsPrice[b]/total)*10000));
                    textArea.append(items[b] + "\n");
                    textArea.append("                  "+ df.format(percentage*0.01) +"%");
                    textArea.append("\n");
                }

//                Calculating Final
                textArea.append("\n");

                double balance = Double.parseDouble(firstOfTxt) - total;
                textArea.append("\n" + "Final Balance: $" + df.format(balance) + "\n");

                if (balance < 100.00) {
                    textArea.append("You're broke! Manage your finances better!");
                } else {
                    textArea.append("Great job keeping your finances in check!");
                }




            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText("What was your previous balance $" + "\n");

                for (int i = 0; i < items.length; i++) {
                    textArea.append("How much did you spend on " + items[i] + "\n");
                }

                inputArea.setText("");
            }
        });

        jm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
