package lesson_28;

import lesson_28.service.ArchiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class ZipRun {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Укажите параметры запуска программы и перезапустите ее");
            return;
        }
        System.out.println("Архивация началась");
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(ZipRun.class);
        final ArchiveService archiveService = applicationContext.getBean(ArchiveService.class);
        Arrays.stream(args).findFirst().ifPresentOrElse(file ->{
                    final String zip = archiveService.zip(file).orElseThrow(() -> new IllegalStateException("Не возможно выпонить архивацию"));
                    System.out.printf("Архивация завершена успешна. Файл %s",zip);
                },
                ()-> {
                    System.out.println("Укажите файл для архивации");
                    System.exit(0);
                }
        );

    }

}
