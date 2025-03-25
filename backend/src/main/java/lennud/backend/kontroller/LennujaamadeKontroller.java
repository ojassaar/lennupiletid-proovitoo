package lennud.backend.kontroller;

import lennud.backend.mudel.Lennujaam;
import lennud.backend.päringud.JaamadePäringud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LennujaamadeKontroller {

    @Autowired
    private final JaamadePäringud jaamadePäringud;

    
    public LennujaamadeKontroller(JaamadePäringud jaamadePäringud) {
        this.jaamadePäringud = jaamadePäringud;
    }
    

    @GetMapping("/api/lennujaamad")
    public List<Lennujaam> getLennujaamad() {
        return jaamadePäringud.findAll();
    }

}
