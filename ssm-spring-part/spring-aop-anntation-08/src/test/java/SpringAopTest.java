import com.ls.config.MainConfig;
import com.ls.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(value = MainConfig.class)
public class SpringAopTest {
    //aop - 代理 -jdk -接口- 代理类，代理对象和目标对象,只能用接口接值
    //这里不能用实现类接值。因为使用了jdk代理技术，代理的实现是接口实现，目标类和代理类无直接关系。
    @Autowired
    private Calculator calculator;

    @Test
    public void test1(){
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }

}
