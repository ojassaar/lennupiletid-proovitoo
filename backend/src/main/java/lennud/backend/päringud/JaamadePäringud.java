package lennud.backend.päringud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lennud.backend.mudel.Lennujaam;

@Repository
public interface JaamadePäringud extends JpaRepository<Lennujaam, Long>{
    
}
