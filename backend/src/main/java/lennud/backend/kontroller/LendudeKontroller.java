package lennud.backend.kontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lennud.backend.dto.Lennufilter;
import lennud.backend.mudel.Lend;
import lennud.backend.päringud.LendudePäringud;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LendudeKontroller {
    
    @Autowired
    private final LendudePäringud lendudePäringud;

    public LendudeKontroller(LendudePäringud lendudePäringud) {
        this.lendudePäringud = lendudePäringud;
    }

    @PostMapping("/api/lennud/filtreeri")
    public List<Lend> getFiltreeritudLennud(@RequestBody Lennufilter filter) {
        return lendudePäringud.findFiltreeritud(filter.getAlgpunkt(), filter.getSihtpunkt(), filter.getAeg());
    }
}
