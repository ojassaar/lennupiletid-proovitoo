package lennud.backend.päringud;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lennud.backend.mudel.Lend;

public interface LendudePäringud extends JpaRepository<Lend, Long>{

    @Query(value = "SELECT * from Lend WHERE algpunkt_id = ?1 AND sihtpunkt_id = ?2 AND CAST(väljumisaeg AS DATE) = ?3", nativeQuery = true)
    List<Lend> findFiltreeritud(long algpunkt, long sihtpunkt, LocalDate aeg);

} 
