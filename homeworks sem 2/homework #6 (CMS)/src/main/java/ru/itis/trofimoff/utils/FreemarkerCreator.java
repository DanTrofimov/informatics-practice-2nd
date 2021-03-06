package ru.itis.trofimoff.utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

@Component
public class FreemarkerCreator implements FileCreator {
    private File directoryGenerateTo = new File("D:\\GitHub\\rogue\\beginner-javascript\\snippets\\servlets-examples\\informatics-practice-2nd\\homeworks sem 2\\homework #6 (CMS)\\src\\main\\webapp\\WEB-INF\\freemarker\\generated");
    private final String currentExtension = "ftl";
    private String freemarkerHeaderContent = "" +
            "<#import \"spring.ftl\" as spring/>\n" +
            "<#import \"../header.ftl\" as header/>\n" +
            "\n" +
            "<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\"\n" +
            "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
            "    <title>Document</title>\n" +
            "    <link rel=\"stylesheet\" href=\"<@spring.url '/styles/header.css' />\" type=\"text/css\">\n" +
            "    <link rel=\"stylesheet\" href=\"<@spring.url '/styles/pages.css' />\" type=\"text/css\">\n" +
            "</head>";

    // true - added, false - troubles
    public boolean addNewTemplate(String fileName, String fileText) {
        File newTemplate = new File(directoryGenerateTo, fileName + "." + this.currentExtension);
        try {
            if (newTemplate.createNewFile()) {
                System.out.println("File has created");
            } else {
                System.out.println("File can't be created");
                return false;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try(FileOutputStream fos = new FileOutputStream(newTemplate.getAbsolutePath());
            PrintStream printStream = new PrintStream(fos))
        {
            printStream.println(this.freemarkerHeaderContent);
            printStream.println("<body>");
            printStream.println("<@header.header />");
            printStream.println("<div class=\"page-content\">");
            printStream.println(fileText);
            printStream.println("</div>");
            printStream.println("</body>");
            printStream.println("</html>");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public String getTextPage(String pageContent) {
        String result = this.freemarkerHeaderContent;
        result += "<body>\n";
        result += "<@header.header />\n";
        result += "<div class=\"page-content\">\n";
        result += pageContent;
        result += "</div>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
