import com.zdatbit.apect.Config;
import com.zdatbit.apect.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectTest {

    @Test
    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        HelloWorld bean = context.getBean(HelloWorld.class);
        bean.run("hello world");
    }
}
