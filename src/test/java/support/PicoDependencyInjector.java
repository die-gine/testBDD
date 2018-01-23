package support;

import cucumber.runtime.java.picocontainer.PicoFactory;
import ui.SharedDriver;


public class PicoDependencyInjector extends PicoFactory {

    public PicoDependencyInjector() {
        addClass(SharedDriver.class);
    }
}
