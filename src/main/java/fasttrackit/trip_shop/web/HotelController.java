package fasttrackit.trip_shop.web;

import fasttrackit.trip_shop.domain.Hotel;
import fasttrackit.trip_shop.service.HotelService;
import fasttrackit.trip_shop.transfer.GetHotelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class HotelController {

    private final HotelService hotelService;
@Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
@GetMapping
public ResponseEntity<Page<GetHotelRequest>>getHotels(GetHotelRequest request, Pageable pageable){
    Page<GetHotelRequest> hotels = hotelService.getHotels(request, pageable);
     return new ResponseEntity<>(hotels,HttpStatus.OK);
}
}
