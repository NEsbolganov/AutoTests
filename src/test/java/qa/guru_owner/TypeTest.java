package qa.guru_owner;

import config.Browser;
import config.TypeConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Проверить URL, File, Path, byte[]
public class TypeTest {

    @Test
    public void testInteger(){
        System.setProperty("integer","10");

        TypeConfig typeConfig = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(typeConfig.getInteger()).isEqualTo(10);
    }

    @Test
    public void testDouble(){
        System.setProperty("double","10.10");

        TypeConfig typeConfig = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(typeConfig.getDouble()).isEqualTo(10.10);
    }

    @Test
    public void testBoolean(){
        System.setProperty("boolean","true");

        TypeConfig typeConfig = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(typeConfig.getBoolean()).isEqualTo(true);
    }

    @Test
    public void testEnum(){
        System.setProperty("enum","Chrome");

        TypeConfig typeConfig = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(typeConfig.getBrowser()).isEqualTo(Browser.Chrome);
    }
}
