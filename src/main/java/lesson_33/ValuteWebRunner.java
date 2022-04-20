package lesson_33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"lesson_26.service", "lesson_33"})
public class ValuteWebRunner {

    public static void main(String[] args) {
        SpringApplication.run(ValuteWebRunner.class, args);
    }


}
