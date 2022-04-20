package lesson_30.sevice;

import lesson_30.model.City;

import java.util.Optional;

public interface CityService {

    Optional<City> findByCode(Integer code);
    City save(City city);

    void deleteByCode(Integer code);

}
