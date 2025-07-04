package net.scriptgate.pi.shop;

import net.scriptgate.engine.Application;
import net.scriptgate.engine.lwjgl.OpenGLApplicationHandler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PiShopNativeApplication implements Application, ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        new OpenGLApplicationHandler().start(new PiShopNativeApplication());
    }

    
}
