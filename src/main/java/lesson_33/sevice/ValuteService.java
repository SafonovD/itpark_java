package lesson_33.sevice;

import java.math.BigDecimal;
import java.util.Optional;

public interface ValuteService {

    Optional<BigDecimal> getValuteByCode(String code);
}
