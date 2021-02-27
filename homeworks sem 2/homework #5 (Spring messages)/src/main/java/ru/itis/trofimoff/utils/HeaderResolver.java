package ru.itis.trofimoff.utils;

import org.springframework.stereotype.Component;

@Component
public class HeaderResolver {
    public String[] resolveLocale(String acceptLanguage) {
        return acceptLanguage.split(";")[0].split(",")[0].split("-");
    }
}
