package lennud.backend.kontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lennud.backend.dto.LendJaPiletid;
import lennud.backend.dto.Lennufilter;
import lennud.backend.mudel.Istekoht;
import lennud.backend.mudel.Lend;
import lennud.backend.päringud.IstekohtadePäringud;
import lennud.backend.päringud.LendudePäringud;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LendudeKontroller {
    
    @Autowired
    private final LendudePäringud lendudePäringud;

    @Autowired
    public IstekohtadePäringud istekohtadePäringud;

    public LendudeKontroller(LendudePäringud lendudePäringud, IstekohtadePäringud istekohtadePäringud) {
        this.lendudePäringud = lendudePäringud;
        this.istekohtadePäringud = istekohtadePäringud;
    }

    @PostMapping("/api/lennud/filtreeri")
    public List<Lend> getFiltreeritudLennud(@RequestBody Lennufilter filter) {
        return lendudePäringud.findFiltreeritud(filter.getAlgpunkt(), filter.getSihtpunkt(), filter.getAeg());
    }

    @PostMapping("/api/lennud/id")
    public List<Lend> getLendIdJärgi(@RequestBody Lennufilter filter) {
        return lendudePäringud.findIdJärgi(filter.getId());
    }

    @PostMapping("/api/broneeri")
    public ResponseEntity<?> broneeriKohad(@RequestBody LendJaPiletid lendJaPiletid) {
        Lend lend = lendudePäringud.findIdJärgi(lendJaPiletid.getLend()).get(0);
        List<Integer> indeksid = lendJaPiletid.getPiletid();
        for (int i : indeksid) {
            Istekoht koht = lend.getIstekohad().get(i);
            koht.märgiVõetuks();
            istekohtadePäringud.save(koht);
        }
        return ResponseEntity.ok("Broneeritud edukalt!");
    }
}
