package fasttrackit.trip_shop.service;

import fasttrackit.trip_shop.domain.Hotel;
import fasttrackit.trip_shop.exception.ResourceNotFound;
import fasttrackit.trip_shop.persistence.HotelRepository;
import fasttrackit.trip_shop.transfer.GetHotelRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class HotelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);
    private final HotelRepository hotelRepository;
@Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Page<Hotel> getHotels(GetHotelRequest request, Pageable pageable) {
         LOGGER.info(" Searching hotel {}", request);
      Hotel hotel = new Hotel();
      hotel.setCity(request.getCity());
      hotel.setCountry(request.getCountry());
      hotel.getId(request.getId());
      hotel.getName(request.getName());
      hotel.setWhen(request.getWhen());

        Page<Hotel> hotels = hotelRepository.findAll(hotel, pageable);
        return hotels;


    }

}
