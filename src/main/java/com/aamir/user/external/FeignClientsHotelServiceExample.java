package com.aamir.user.external;

import com.aamir.user.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE") // service registry name
public interface FeignClientsHotelServiceExample {

    @GetMapping("hotelService/hotels/findByHotelId/{hotelId}")
    Hotel findHotels(@PathVariable Long hotelId);

}
