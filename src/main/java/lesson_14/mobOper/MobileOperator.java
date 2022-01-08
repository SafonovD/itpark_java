package lesson_14.mobOper;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
public enum MobileOperator {
    BEELINE(List.of("903","905","906","909","951","953","960","961","962","963")),
    MEGAFONE("920","921","922","923","924","925","926","927","928","929"),
    MTS("910","911","912","913","914","915","916","917","918","919"),
    TELE2("951","953","958","977","991","992","993","994","995","996");
    static {
        ALLCOD = Arrays.stream(values()).map(MobileOperator::getPhoneCode).flatMap(List::stream).collect(Collectors.toList());

    }
    private static final List<String> ALLCOD;

    private final List<String> phoneCode;

    MobileOperator(List<String> phoneCode) {
        this.phoneCode = phoneCode;
    }
    MobileOperator(String... phoneCode) {
        this.phoneCode = Arrays.asList(phoneCode);
    }
    public static String generateCodOper(){
        return ALLCOD.get(new Random().nextInt(ALLCOD.size()));
    }
}
