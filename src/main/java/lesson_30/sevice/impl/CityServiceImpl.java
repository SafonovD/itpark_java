package lesson_30.sevice.impl;

import lesson_30.model.City;
import lesson_30.repository.CityRepository;
import lesson_30.sevice.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public Optional<City> findByCode(Integer code) {
        return cityRepository.findById(code);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteByCode(Integer code) {
        cityRepository.deleteById(code);

    }
}
