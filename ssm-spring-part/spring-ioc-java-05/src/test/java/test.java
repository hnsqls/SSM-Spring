import com.ls.config.MainConfiguration;
import com.ls.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

        UserService bean = context.getBean(UserService.class);
        System.out.println(bean);

    }
}
