package lennud.backend.kontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lennud.backend.mudel.Istekoht;
import lennud.backend.päringud.IstekohtadePäringud;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class IstekohtadeKontroller {

    @Autowired
    private final IstekohtadePäringud istekohtadePäringud;

    public IstekohtadeKontroller(IstekohtadePäringud istekohtadePäringud) {
        this.istekohtadePäringud = istekohtadePäringud;
    }

    @PostMapping("/api/lennud/istekohad")
    public ResponseEntity<?> broneeriKohad(@RequestBody List<Istekoht> kohad) {
        for (Istekoht koht : kohad) {
            System.out.println("Broneeritud koht: " + koht.getId());
        }
        return ResponseEntity.ok("Broneeritud edukalt!");
    }

} 
