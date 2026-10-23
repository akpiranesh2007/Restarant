import com.rest.CLI.MenuCli;
import com.rest.CLI.OrderCli;
import com.rest.CLI.PaymentCli;
import com.rest.CLI.TableCli;
import com.rest.service.MenuServices;
import com.rest.service.OrderServices;
import com.rest.service.PaymentServices;
import com.rest.service.TableServices;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TableServices tableServices = new TableServices();
        MenuServices menuServices = new MenuServices();
        OrderServices orderServices = new OrderServices(tableServices, menuServices);
        PaymentServices paymentServices = new PaymentServices();

        TableCli tableCli = new TableCli(tableServices);
        MenuCli menuCli = new MenuCli(menuServices);
        OrderCli orderCli = new OrderCli(orderServices);
        PaymentCli paymentCli = new PaymentCli(paymentServices);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Restaurant Management");
            System.out.println("1. Tables");
            System.out.println("2. Menu");
            System.out.println("3. Orders");
            System.out.println("4. Payments");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    tableCli.start();
                    break;
                case 2:
                    menuCli.start();
                    break;
                case 3:
                    orderCli.start();
                    break;
                case 4:
                    paymentCli.start();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}