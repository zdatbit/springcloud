import com.zdatbit.tx.TxConfig;
import com.zdatbit.tx.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TxTest {

    @Test
    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.insertUser();
    }
}
