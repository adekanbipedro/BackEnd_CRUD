

import br.adk.dao.CustomerMapDAO;
import br.adk.dao.ICustomerDAO;
import br.adk.domain.Customer;

import java.awt.Component;
import javax.swing.JOptionPane;

public class App {
    private static ICustomerDAO ICustomerDAO;

    public App() {
    }

    public static void main(String[] args) {
        ICustomerDAO = new CustomerMapDAO();

        String option;
        for(option = JOptionPane.showInputDialog((Component)null, "Put 1 to Register, 2 to show, 3 to delete, 4 to change or 5 to exit.", "Register", 1); !isValidOption(option); option = JOptionPane.showInputDialog((Component)null, "Invalid Option, please put below 1 to Register, 2 to show, 3 to delete, 4 to change or 5 to exit.", "INVALID OPTION", 1)) {
            if ("".equals(option)) {
                exit();
            }
        }

        for(; isValidOption(option); option = JOptionPane.showInputDialog((Component)null, "Put 1 to Register, 2 to show, 3 to delete, 4 to change or 5 to exit.", "Register", 1)) {
            if (isOptionExit(option)) {
                exit();
            } else {
                String data;
                if (optionRegister(option)) {
                    data = JOptionPane.showInputDialog((Component)null, "Please put the infos below separated per ',' in the respective sequence: Name, ID, Phone Number, Address, Number, City and State", "Register", 1);
                    register(data);
                } else if (optionShow(option)) {
                    data = JOptionPane.showInputDialog((Component)null, "Insert ID:", "Consult", 1);
                    review(data);
                }
            }
        }

    }

    private static void review(String data) {
        Customer customer = ICustomerDAO.check(Long.parseLong(data));
        if (customer != null) {
            JOptionPane.showMessageDialog((Component)null, "Customer Found: " + customer.toString(), "Success", 1);
        } else {
            JOptionPane.showMessageDialog((Component)null, "Customer not found, please put the Customer ID again!", "Customer Not Found", 1);
            System.out.println();
        }

    }

    private static void register(String data) {
        String[] separatedData = data.split(",");
        Customer customer = new Customer(separatedData[0], separatedData[1], separatedData[2], separatedData[3], separatedData[4], separatedData[5], separatedData[6]);
        Boolean isRegistered = ICustomerDAO.register(customer);
        if (isRegistered) {
            JOptionPane.showMessageDialog((Component)null, "Customer successful registered!", "Success!", 1);
        }

        JOptionPane.showMessageDialog((Component)null, "Customer already registered", "Error", 1);
    }

    private static boolean isOptionExit(String option) {
        return "5".equals(option);
    }

    private static void exit() {
        JOptionPane.showMessageDialog((Component)null, "Thanks for you time", "EXIT", 1);
        System.exit(0);
    }

    private static boolean isValidOption(String option) {
        return "1".equals(option) || "2".equals(option) || "3".equals(option) || "4".equals(option) || "5".equals(option);
    }

    private static boolean optionRegister(String option) {
        return "1".equals(option);
    }

    private static boolean optionShow(String option) {
        return "2".equals(option);
    }

    private static boolean optionChange(String option) {
        return "4".equals(option);
    }
}

