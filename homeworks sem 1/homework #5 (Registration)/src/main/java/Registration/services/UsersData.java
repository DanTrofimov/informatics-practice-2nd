package Registration.services;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class UsersData {
    public static String dataFile = "D:\\GitHub\\rogue\\beginner-javascript\\snippets\\informatics-practice-2nd\\homeworks\\homework #5 (Registration)\\src\\main\\webapp\\data\\users.csv";

    public static void writeData(String name, String email, String password) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(dataFile, true));
        String userData = name + ',' + email + ',' + password;
        String [] record = userData.split(",");
        writer.writeNext(record);
        writer.close();
    }

    // looking for user in csv-file
    public static boolean isRegistered(String email) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(dataFile), ',');
        List<String[]> allRows = reader.readAll();
        //Read CSV line by line and use the string array
        if (allRows.isEmpty()) return false;
        for(String[] row : allRows) {
            if (Arrays.asList(row[1]).contains(email)) return true;
        }
        return false;
    }

    // getting user name
    public static String getUsername(String email) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(dataFile), ',');
        List<String[]> allRows = reader.readAll();
        if (allRows.isEmpty()) return null;
        //Read CSV line by line and use the string array
        for(String[] row : allRows) {
            if (Arrays.asList(row[1]).contains(email)) {
                return Arrays.asList(row[0]).toString().substring(1, Arrays.asList(row[0]).toString().length()-1);
            }
        }
        return null;
    }

    public static boolean checkPassword(String password) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(dataFile), ',');
        List<String[]> allRows = reader.readAll();
        if (allRows.isEmpty()) return false;
        //Read CSV line by line and use the string array
        for(String[] row : allRows) {
            if (Arrays.asList(row[2]).contains(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSigned(HttpServletRequest request) {
        return request.getSession().getAttribute("email") != null
                && request.getSession().getAttribute("name") != null;
    }

    public static void addToSession(String name, String email, HttpServletRequest request) {
        request.getSession().setAttribute("email", email);
        request.getSession().setAttribute("name", name);
    }

    public static void signOut(HttpServletRequest request) {
        request.getSession().removeAttribute("email");
        request.getSession().removeAttribute("name");
    }
}
