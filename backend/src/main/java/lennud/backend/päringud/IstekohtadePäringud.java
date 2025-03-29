package lennud.backend.päringud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lennud.backend.mudel.Istekoht;

public interface IstekohtadePäringud extends JpaRepository<Istekoht, Long> {

    @Query(value = "SELECT * from Istekoht WHERE id = ?1", nativeQuery = true)
    Istekoht findIdJärgi(long i);
    
}
