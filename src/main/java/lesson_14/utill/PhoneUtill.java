package lesson_14.utill;

import lesson_14.mobOper.MobileOperator;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneUtill {

    public static String generatePhone(){
        String suffix = IntStream.range(0,7).boxed().map(value ->new Random().nextInt(10)+"").collect(Collectors.joining());
        return "7"+ MobileOperator.generateCodOper()+ suffix;
    }

}
