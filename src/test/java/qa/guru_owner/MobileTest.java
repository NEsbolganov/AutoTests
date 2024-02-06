package qa.guru_owner;

import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileTest {

    @Test
    public void testMobileWithIphone(){
        MobileConfig config = ConfigFactory.create(MobileConfig.class,System.getProperties());

        assertThat(config.getPlatformName()).isEqualTo("IOS");
        assertThat(config.getDevice()).isEqualTo("iPhone 15 Pro Max");
        assertThat(config.getPlatformVersion()).isEqualTo("15");
    }
    @Test
    public void testMobileWithPropertiesOverride(){
        System.setProperty("platform.version","12");
        MobileConfig config = ConfigFactory.create(MobileConfig.class,System.getProperties());

        assertThat(config.getPlatformVersion()).isEqualTo("12");
    }

    @Test
    public void testMobileWithSamsung(){
        System.setProperty("device","Samsung");
        MobileConfig config = ConfigFactory.create(MobileConfig.class,System.getProperties());

        assertThat(config.getPlatformName()).isEqualTo("Android");
        assertThat(config.getDevice()).isEqualTo("Samsung Galaxy Note");
        assertThat(config.getPlatformVersion()).isEqualTo("69");
    }
}
