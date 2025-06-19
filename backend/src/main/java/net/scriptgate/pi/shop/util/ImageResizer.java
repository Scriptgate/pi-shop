package net.scriptgate.pi.shop.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageResizer {

    private static final int MAXIMUM_SIZE = 150_000;

    public static String resized(byte[] data) {
        return "data:image/jpeg;base64,"+ Base64.getEncoder().encodeToString(resize(data));
    }

    public static byte[] resize(byte[] data) {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(data)) {
            BufferedImage original = ImageIO.read(inputStream);

            int scale = scaleFactor(original);

            if (scale > 1) {
                BufferedImage resized = resizeImage(original, original.getWidth() / scale, original.getHeight() / scale);
                try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                    ImageIO.write(resized, "png", outputStream);
                    return outputStream.toByteArray();
                }
            } else {
                return data;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BufferedImage resizeImage(BufferedImage original, int targetWidth, int targetHeight) {
        Image resized = original.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resized, 0, 0, null);
        return outputImage;
    }

    private static int scaleFactor(BufferedImage image) {
        int scale = 1;
        int width = image.getWidth();
        int height = image.getHeight();

        while (width * height > MAXIMUM_SIZE) {
            width /= 2;
            height /= 2;
            scale *= 2;
        }
        return scale;
    }

}
