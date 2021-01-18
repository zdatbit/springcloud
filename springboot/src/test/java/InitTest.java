import com.zdatbit.config.Config;
import com.zdatbit.entity.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitTest {
    @Test
    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Pet pet = (Pet)context.getBean("pet");
        System.out.println(pet);
    }
}
