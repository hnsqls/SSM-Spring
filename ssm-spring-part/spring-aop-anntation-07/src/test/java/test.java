import com.ls.CalculatorPureImpl;
import com.ls.CalculatorStaticProxy;

public class test {
    public static void main(String[] args) {
        CalculatorPureImpl taget = new CalculatorPureImpl();
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(taget);
        int add = calculatorStaticProxy.add(1, 1);
        System.out.println(add);
    }
}
