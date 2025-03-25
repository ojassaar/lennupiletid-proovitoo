package lennud.backend.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lennud.backend.mudel.Lennuk;
import lennud.backend.päringud.LennukitePäringud;
import lennud.backend.päringud.JaamadePäringud;
import lennud.backend.mudel.A220;
import lennud.backend.mudel.Lennujaam;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private LennukitePäringud lennukid;

    @Autowired
    private JaamadePäringud jaamad;

    @Override
    public void run(String... args) throws Exception {
        Lennuk lennuk1 = new A220("ABCDE");
        lennukid.save(lennuk1);

        List<Lennujaam> jaamalist =  List.of(
            new Lennujaam("tallinn", "TLN"), 
        new Lennujaam("riia", "RGX"), 
        new Lennujaam("vilnius", "VNO"), 
        new Lennujaam("helsingi", "HEL"),
        new Lennujaam("frankfurt", "FRA"),
        new Lennujaam("new york", "JFK"));

        for (Lennujaam jaam : jaamalist) {
            jaamad.save(jaam);
        }
    }
    
}
