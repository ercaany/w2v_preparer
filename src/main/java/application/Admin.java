package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Created by ercan on 26.04.2017.
 */
public class Admin {
    private final static Logger logger = LoggerFactory.getLogger(Admin.class);

    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.run();
    }

    private void run() {
        logger.trace("sa");
        CommandSet commandSet = new CommandSet();
        boolean next = true;

        while(next) {
            Scanner in = new Scanner(System.in);
            System.out.print("Komut giriniz=>");
            String commandInput = in.nextLine();

            if(!commandInput.equals("exit"))
                commandSet.run(commandInput);
            else
                next = false;
        }
    }
}
