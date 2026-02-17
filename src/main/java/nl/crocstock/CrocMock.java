package nl.crocstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrocMock {

    public static void main(String[] args) {
        SpringApplication.run(CrocMock.class, args);
        System.out.println("""
                                    .-._   _ _ _ _ _ _ _ _
                         .-''-.__.-'00  '-' ' ' ' ' ' ' ' '-.
                         '.___ '    .   .--_'-' '-' '-' _'-' '._
                          V: V 'vv-'   '_   '.       .'  _..' '.'.
                            '=.____.=_.--'   :_.__.__:_   '.   : :
                                    (((____.-'        '-.  /   : :
                                                      (((-'  .' /
                                                    _____..'  .'
                                                   '-._____.-'
                           ******** CROC_MOCK IS RUNNING ********
                """);
    }
}
