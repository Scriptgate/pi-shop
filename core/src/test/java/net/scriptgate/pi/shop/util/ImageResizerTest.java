package net.scriptgate.pi.shop.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.awt.Transparency.TRANSLUCENT;
import static org.assertj.core.api.Assertions.assertThat;

public class ImageResizerTest {

    @Test
    @DisplayName("A large image is reduced in size")
    void resizeLargeImage(@TempDir File temporaryFolder) throws IOException {

        File largeImage = createImage(temporaryFolder, "largeImage.png", 1824, 4000);

        byte[] resized = ImageResizer.resize(Files.readAllBytes(largeImage.toPath()));

        BufferedImage resizedImage = ImageIO.read(new ByteArrayInputStream(resized));

        assertThat(
                resizedImage
        ).extracting(
                BufferedImage::getWidth,
                BufferedImage::getHeight
        ).containsExactly(
                228, 500
        );
    }

    @Test
    @DisplayName("A smaller image is not reduced in size")
    void resizeSmallImage(@TempDir File temporaryFolder) throws IOException {
        File smallImage = createImage(temporaryFolder, "smallImage.png", 228, 500);

        byte[] resized = ImageResizer.resize(Files.readAllBytes(smallImage.toPath()));

        BufferedImage resizedImage = ImageIO.read(new ByteArrayInputStream(resized));

        assertThat(
                resizedImage
        ).extracting(
                BufferedImage::getWidth,
                BufferedImage::getHeight
        ).containsExactly(
                228, 500
        );
    }

    private File createImage(File parentDirectory, String fileName, int width, int height) throws IOException {
        File output = new File(parentDirectory, fileName);
        BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(width, height, TRANSLUCENT);
        ImageIO.write(image, "png", output);
        return output;
    }
}
