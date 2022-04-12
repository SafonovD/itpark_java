package lesson_28;

import lesson_28.service.ArchiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class UnzipRun {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Укажите параметры запуска программы и перезапустите ее");
            return;
        }
        System.out.println("Архивация началась");
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(ZipRun.class);
        final ArchiveService archiveService = applicationContext.getBean(ArchiveService.class);
        Arrays.stream(args).findFirst().ifPresentOrElse(file ->{
                    final String zip = archiveService.unzip(file, args.length == 2 ? args[1] : null ).orElseThrow(() -> new IllegalStateException("Не возможно выпонить разархивацию"));
                    System.out.printf("Разархивация завершена успешна. Файл %s",zip);
                },
                ()-> {
                    System.out.println("Укажите файл для архивации");
                    System.exit(0);
                }
        );
    }
}
