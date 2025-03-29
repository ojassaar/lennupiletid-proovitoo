package lennud.backend.päringud;

import org.springframework.data.jpa.repository.JpaRepository;

import lennud.backend.mudel.Istekoht;

public interface IstekohtadePäringud extends JpaRepository<Istekoht, Long> {
    
}
