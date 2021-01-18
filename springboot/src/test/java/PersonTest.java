import com.zdatbit.config.PersonConfig;
import com.zdatbit.entity.Person;
import com.zdatbit.entity.Person2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonTest {

    @Test
    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person = (Person)context.getBean("person");
        System.out.println(person);

        Person2 person2 = (Person2) context.getBean("person2");
        System.out.println(person2);
    }
}
