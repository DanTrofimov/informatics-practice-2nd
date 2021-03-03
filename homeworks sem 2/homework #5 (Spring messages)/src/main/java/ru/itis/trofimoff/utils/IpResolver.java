package ru.itis.trofimoff.utils;
import com.ip2location.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

@Component
public class IpResolver {

    private String[] langs = new String[]{"en", "ru"};

    public String[] resolveLocale(String ipAddress) {
        String[] resultLocale = new String[2];
        resultLocale[0] = ""; // default
        resultLocale[1] = ""; // default
        IP2Location ip2Location = new IP2Location();
        String binFilePath = "D:\\GitHub\\rogue\\beginner-javascript\\snippets\\servlets-examples\\informatics-practice-2nd\\homeworks sem 2\\homework #5 (Spring messages)\\src\\main\\resources\\ip\\IP2LOCATION-LITE-DB1.BIN";
        try {
            ip2Location.Open(binFilePath, true);
            IPResult result = ip2Location.IPQuery(ipAddress);
            resultLocale[1] = result.getCountryShort();
            if (result.getStatus().equals("OK")) {
                Locale[] all = Locale.getAvailableLocales();
                for (Locale locale : all) {
                    String country = locale.getCountry();
                    if (country.equalsIgnoreCase(resultLocale[1])) {
                        if (Arrays.asList(this.langs).contains(locale.getLanguage())) {
                            resultLocale[0] = locale.getLanguage();
                            break;
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return resultLocale;
    }

    // test
    public static void main(String[] args) {
        IpResolver ipResolver = new IpResolver();
        System.out.println(Arrays.toString(ipResolver.resolveLocale("192.91.186.1"))); // RU
        System.out.println(Arrays.toString(ipResolver.resolveLocale("159.203.124.251"))); // US
    }
}
