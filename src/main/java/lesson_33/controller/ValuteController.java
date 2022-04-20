package lesson_33.controller;

import lesson_26.service.ValuteFetcher;
import lesson_33.dto.ValuteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ValuteController {

    private final ValuteFetcher valuteFetcher;

    @GetMapping("/currency")
    public ValuteDto getValue(@RequestPart String code){
        return new ValuteDto(code,valuteFetcher.getValuteByCode(code)
                .orElseThrow(()-> new IllegalArgumentException(String.format("Код не найден в системе", code))));

    }
}
