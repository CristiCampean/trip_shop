package fasttrackit.trip_shop.persistence;

import fasttrackit.trip_shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
