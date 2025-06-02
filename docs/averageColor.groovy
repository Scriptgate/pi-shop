import javax.imageio.ImageIO
import java.awt.Color
import java.awt.image.BufferedImage

def image = 'donuts.png'

ByteArrayInputStream inputStream = new ByteArrayInputStream(new File("C:\\Programming\\IntelliJ\\pi-shop\\backend\\src\\main\\resources\\assets\\images\\${image}").bytes)
BufferedImage bitmap = ImageIO.read(inputStream)


long redBucket = 0;
long greenBucket = 0;
long blueBucket = 0;
long pixelCount = 0;

for (int y = 0; y < bitmap.getHeight(); y++)
{
    for (int x = 0; x < bitmap.getWidth(); x++)
    {
        int color = bitmap.getRGB(x, y);

// Components will be in the range of 0..255:
        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;

        if(blue >250 && red > 250 && green > 250) {
            continue
        }

        pixelCount++;
        redBucket += red
        greenBucket += green
        blueBucket += blue
        // does alpha matter?
    }
}

int averageRed = redBucket / pixelCount
int averageGreen = greenBucket / pixelCount
int averageBlue = blueBucket / pixelCount

println "$averageRed, $averageBlue, $averageGreen"

print '#'
print Integer.toHexString(averageRed)
print Integer.toHexString(averageGreen)
print Integer.toHexString(averageBlue)
println ''

