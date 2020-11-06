package fasttrackit.trip_shop.persistence;

import fasttrackit.trip_shop.domain.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository  extends JpaRepository<Hotel, Long> {
    Page<Hotel> findAll(Hotel hotel, Pageable pageable);
}
