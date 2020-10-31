package fasttrackit.trip_shop.persistence;

import fasttrackit.trip_shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
