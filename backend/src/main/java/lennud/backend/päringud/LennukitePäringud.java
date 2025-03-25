package lennud.backend.päringud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lennud.backend.mudel.Lennuk;

@Repository
public interface LennukitePäringud extends JpaRepository<Lennuk, Long>{   
}