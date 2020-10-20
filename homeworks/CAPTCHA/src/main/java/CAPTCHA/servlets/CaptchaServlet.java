package CAPTCHA.servlets;

import CAPTCHA.services.FontValues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static CAPTCHA.services.FontValues.*;

@WebServlet("/captcha-servlet")
public class CaptchaServlet extends HttpServlet {

    private static final int CAPTCHA_HEIGHT = 300;
    private static final int CAPTCHA_WIDTH = 400;
    private static final int CAPTCHA_LENGTH = 5;
    private FontValues values = new FontValues();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String captcha = generateCaptchaString(CAPTCHA_LENGTH);
        request.getSession().setAttribute("captcha", captcha);

        BufferedImage bufferedImage = new BufferedImage(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, BufferedImage.OPAQUE);
        Graphics graphics = bufferedImage.createGraphics();
        int currentStart = 60;
        int currentMarginTop = 180;
        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRect(0, 0, CAPTCHA_WIDTH, CAPTCHA_HEIGHT);
        for (int i = 0; i < captcha.length(); i++) {
            graphics.setFont(new Font(values.getRandomValueOf(fonts), values.getRandomValueOf(fontStyles), 80));
            graphics.setColor(values.getRandomValueOf(colors));
            graphics.drawString(String.valueOf(captcha.charAt(i)), currentStart, currentMarginTop);
            currentStart+=50;
        };

        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(bufferedImage, FILE_TYPE, outputStream);
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private String generateCaptchaString(int captchaLength) {
        StringBuffer captchaBuffer = new StringBuffer();
        Random random = new Random();
        while(captchaBuffer.length() < captchaLength) {
            int index = (int) (random.nextFloat() * values.captchaSymbols.length());
            captchaBuffer.append(values.captchaSymbols.substring(index, index+1));
        }
        return captchaBuffer.toString();
    }
}