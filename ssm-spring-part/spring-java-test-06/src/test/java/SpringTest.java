import com.ls.configuration.MainConfig;
import com.ls.service.B;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(MainConfig.class)
public class SpringTest {

    @Autowired
    private B b;
    @Test
    public void test() {
        b.hello();
    }
}
