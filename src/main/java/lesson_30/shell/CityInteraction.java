package lesson_30.shell;


import lesson_30.model.City;
import lesson_30.sevice.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Slf4j
@ShellComponent
@RequiredArgsConstructor
public class CityInteraction {

    private final CityService cityService;

    @ShellMethod(value = "Create city", key = "cc")
    public void createCity(
        @ShellOption({"-c", "--code"}) Integer cityCode,
        @ShellOption({"-n", "--name"}) String cityName,
        @ShellOption({"-ne", "--nameEn"}) String cityNameEn,
        @ShellOption(value = {"-p", "--pop"}, defaultValue = "null") Long cityPopulation){

        final City city = new City(cityCode,cityName,cityNameEn);
        city.setPopulation(cityPopulation);
        cityService.save(city);
        log.debug("Успешно создан город {}",city);
    }

    @ShellMethod(value = "Create city", key = "uc")
    public void updateCity(
            @ShellOption({"-c", "--code"}) Integer cityCode,
            @ShellOption({"-n", "--name"}) String cityName,
            @ShellOption({"-ne", "--nameEn"}) String cityNameEn,
            @ShellOption(value = {"-p", "--pop"}, defaultValue = "null") Long cityPopulation){

        cityService.findByCode(cityCode).ifPresent(city -> {
            city.setName(cityName);
            city.setNameEn(cityNameEn);
            if(cityPopulation != null){
                city.setPopulation(cityPopulation);
            }
            cityService.save(city);
            log.debug("Успешно обновлен город {}",city);
        });

    }

    @ShellMethod(value = "Create city", key = "dc")
    public void deleteCity(
            @ShellOption({"-c", "--code"}) Integer cityCode){
       cityService.deleteByCode(cityCode);
        log.debug("Город с кодом {} успешно удален",cityCode);
    }

    @ShellMethod(value = "Create city", key = "fc")
    public void findCity(
            @ShellOption({"-c", "--code"}) Integer cityCode){
        cityService.findByCode(cityCode).ifPresentOrElse(
                city -> log.info("Найденный город {}",city),
                ()->log.warn("Указанный город с кодом {} не найден в базе",cityCode)
        );
    }
}
