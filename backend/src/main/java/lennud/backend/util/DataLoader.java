package lennud.backend.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lennud.backend.mudel.Lennuk;
import lennud.backend.päringud.LennukitePäringud;
import lennud.backend.päringud.JaamadePäringud;
import lennud.backend.päringud.LendudePäringud;
import lennud.backend.mudel.A220;
import lennud.backend.mudel.CRJ900;
import lennud.backend.mudel.E190;
import lennud.backend.mudel.Lend;
import lennud.backend.mudel.Lennujaam;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private LennukitePäringud lennukid;

    @Autowired
    private JaamadePäringud jaamad;

    @Autowired
    private LendudePäringud lennud;

    @Override
    public void run(String... args) throws Exception {

        List<Lennuk> lennukilist = List.of(
            new A220("ABCDE"),
            new A220("QWERTY"),
            new CRJ900("ASDF"),
            new E190("FDGDFG")
        );
        for (Lennuk lennuk : lennukilist) lennukid.save(lennuk);

        List<Lennujaam> jaamalist =  List.of(
            new Lennujaam("tallinn", "TLN"), 
        new Lennujaam("riia", "RGX"), 
        new Lennujaam("vilnius", "VNO"), 
        new Lennujaam("helsingi", "HEL"),
        new Lennujaam("frankfurt", "FRA"),
        new Lennujaam("new york", "JFK"));

        Map<String, Lennujaam> jaamaMap = new HashMap<>();
        for (Lennujaam jaam : jaamalist) jaamaMap.put(jaam.getKood(), jaam);

        for (Lennujaam jaam : jaamalist) {
            jaamad.save(jaam);
        }

        List<Lend> lennulist = List.of(
            new Lend(jaamaMap.get("TLN"), jaamaMap.get("HEL"), LocalDateTime.of(2025, 3, 26, 12, 0, 0), LocalDateTime.of(2025, 3,26, 14,0,0), lennukilist.get(0), 100.0),
            new Lend(jaamaMap.get("TLN"), jaamaMap.get("HEL"), LocalDateTime.of(2025, 3, 26, 16, 30, 0), LocalDateTime.of(2025, 3,26, 18,30,0), lennukilist.get(1), 120.0),
            new Lend(jaamaMap.get("TLN"), jaamaMap.get("HEL"), LocalDateTime.of(2025, 3, 27, 16, 30, 0), LocalDateTime.of(2025, 3,27, 18,30,0), lennukilist.get(0), 120.0),
            new Lend(jaamaMap.get("RGX"), jaamaMap.get("HEL"), LocalDateTime.of(2025, 3, 26, 10, 30, 0), LocalDateTime.of(2025, 3,26, 13,30,0), lennukilist.get(2), 120.0)
        );
        for (Lend lend : lennulist) lennud.save(lend);
    }
    
}
