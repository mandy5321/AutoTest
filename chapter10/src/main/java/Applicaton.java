import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zhangjie on 2020/6/15.
 */
@SpringBootApplication
@ComponentScan("com.course")
public class Applicaton {
    public static void main(String[] args){
        SpringApplication.run(Applicaton.class,args);
    }
}
