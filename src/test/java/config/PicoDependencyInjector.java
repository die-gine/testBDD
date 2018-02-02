package config;

import cucumber.runtime.java.picocontainer.PicoFactory;
import browser.SharedDriver;


public class PicoDependencyInjector extends PicoFactory {

    public PicoDependencyInjector() {
        addClass(SharedDriver.class);
    }
}
