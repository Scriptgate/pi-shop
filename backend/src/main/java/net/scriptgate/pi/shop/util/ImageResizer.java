package net.scriptgate.pi.shop.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageResizer {

    public static byte[] resize(byte[] data) {
        try(ByteArrayInputStream inputStream = new ByteArrayInputStream(data)) {
            BufferedImage original = ImageIO.read(inputStream);
            BufferedImage resized = resizeImage(original, original.getWidth() / 8, original.getHeight() / 8);
            try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                ImageIO.write(resized, "png", outputStream);
                return outputStream.toByteArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BufferedImage resizeImage(BufferedImage original, int targetWidth, int targetHeight) {
        Image resized = original.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resized, 0, 0, null);
        return outputImage;
    }

}
