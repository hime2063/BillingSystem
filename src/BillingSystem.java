import java.util.Scanner;

public class BillingSystem {
    public static void main(String[] args) {
        double VAT = 0.13;
        double totalamount = 0.0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter User Id: ");
        String Userid = input.nextLine();
        System.out.print("Enter the Password: ");
        String Password = input.nextLine();

        while (true) {
            System.out.print("Enter the price of the item (or type 'quit' to finish): ");
            String priceInput = input.nextLine();

            // Check if the user wants to quit
            if (priceInput.equalsIgnoreCase("quit")) {
                break;
            }

            // Convert the input to a double
            double price;
            try {
                price = Double.parseDouble(priceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the price.");
                continue;
            }

            // Add the price to the total amount
            totalamount += price;

            System.out.print("Do you want VAT or not? (type 'yes' or 'no'): ");
            String VATprice = input.nextLine();

            if (VATprice.equalsIgnoreCase("yes")) {
                totalamount += price * VAT; // Add VAT to the current item price
            }

            System.out.print("Enter discount rate: ");
            double discountrate = input.nextDouble();
            input.nextLine(); // Consume the newline character

            double discountamount = totalamount * (discountrate / 100);
            totalamount -= discountamount; // Apply the discount to the total amount

            System.out.println("You have to pay a total of Rs: " + totalamount);

            System.out.print("Enter your payment amount: ");
            double payment = input.nextDouble();
            input.nextLine(); // Consume the newline character

            double change = payment - totalamount;

            if (change < 0) {
                System.out.println("Insufficient payment. Please enter the correct amount.");
                continue;
            }

            int[] changes = {1000,500, 100, 50, 20, 10, 5};
            System.out.println("Your change: Rs " + change);

            for (int Change : changes) {
                int count = (int) (change / Change);
                if (count > 0) {
                    System.out.println("Rs " + Change + " x " + count);
                    change -= Change * count;
                }
            }
        }

       
    }
}
