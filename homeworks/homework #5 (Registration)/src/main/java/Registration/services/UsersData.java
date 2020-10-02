package Registration.services;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class UsersData {
    public static String dataFile = "users.csv";

    public static void writeData(String name, String email, String password) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(dataFile, true));
        String userData = name + ',' + email + ',' + password;
        String [] record = userData.split(",");
        writer.writeNext(record);
        writer.close();
    }
}
