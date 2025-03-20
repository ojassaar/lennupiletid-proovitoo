package lennud.backend.kontroller;

import lennud.backend.mudel.Lennujaam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/lennujaamad")
public class LennujaamadeKontroller {

    @GetMapping
    public List<Lennujaam> getLennujaamad() {
        return List.of(
            new Lennujaam("tallinn", "TLN"), 
            new Lennujaam("riia", "RGX"), 
            new Lennujaam("vilnius", "VNO"), 
            new Lennujaam("helsingi", "HEL"),
            new Lennujaam("frankfurt", "FRA"),
            new Lennujaam("new york", "JFK"));
    }

}
