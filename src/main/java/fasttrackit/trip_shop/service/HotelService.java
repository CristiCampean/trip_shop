package fasttrackit.trip_shop.service;

import fasttrackit.trip_shop.domain.Hotel;
import fasttrackit.trip_shop.exception.ResourceNotFound;
import fasttrackit.trip_shop.persistence.HotelRepository;
import fasttrackit.trip_shop.transfer.GetHotelRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class HotelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);
    private final HotelRepository hotelRepository;
@Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

  //  public Page<Hotel> getHotels(GetHotelRequest request, Pageable pageable) {
   //  LOGGER.info(" Searching hotel {}", request);
  //    Hotel hotel = new Hotel();
  //    hotel.setCity(request.getCity());
  //    hotel.setCountry(request.getCountry());
  //    hotel.getId(request.getId());
  //    hotel.getName(request.getName());
  //    hotel.setWhen(request.getWhen());

   //     Page<Hotel> hotels = hotelRepository.findAll(hotel, pageable);
   //     return hotels;

 public Page<GetHotelRequest>getHotels(GetHotelRequest request, Pageable pageable) {
     LOGGER.info(" Searching hotel {}", request);
     Hotel exampleHotel = new Hotel();
     exampleHotel.setCity(request.getCity());
     exampleHotel.setCountry(request.getCountry());
     exampleHotel.setName(request.getName());
     exampleHotel.setStars(request.getStars());
     Example<Hotel> example = Example.of(exampleHotel);
     Page<Hotel> hotelPage = hotelRepository.findAll(example, pageable);
     List<GetHotelRequest> productsDtos = new ArrayList<>();

     for (Hotel hotel : hotelPage.getContent()) {
         GetHotelRequest getHotelRequest = mapProdactResponse(hotel);
         productsDtos.add(getHotelRequest);
     }
      return new PageImpl<>(productsDtos , pageable, hotelPage.getTotalElements());
 }
  private GetHotelRequest mapProdactResponse (Hotel hotel){
    GetHotelRequest getHotelRequest = new GetHotelRequest();
       getHotelRequest.setCity(hotel.getCity());
       getHotelRequest.setCountry(hotel.getCountry());
       getHotelRequest.setName(hotel.getName());
       getHotelRequest.setStars(hotel.getStars());
       getHotelRequest.setPrice(hotel.getPrice());
       return getHotelRequest;
  }

}
