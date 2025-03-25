package lennud.backend.päringud;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lennud.backend.mudel.Lend;
import lennud.backend.mudel.Lennujaam;

public interface LendudePäringud extends JpaRepository<Lend, Long>{

    @Query("SELECT l from Lend l WHERE CAST(t.väljumisaeg as DATE) = ?1 AND t.algpunkt = ?2 AND t.sihtpunkt = ?3")
    List<Lend> findFiltreeritud(LocalDate aeg, Lennujaam algpunkt, Lennujaam sihtpunkt);

} 
