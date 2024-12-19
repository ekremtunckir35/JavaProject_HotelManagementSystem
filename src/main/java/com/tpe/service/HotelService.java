package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.repository.HotelRepository;

import java.util.Scanner;

public class HotelService {

    private Scanner scanner=new Scanner(System.in);

    private final HotelRepository hotelRepository;

    //paramli const.
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //1-c hoteli kaydeden bir metot -->save hotel

    public void saveHotel(){

        Hotel hotel=new Hotel();
        System.out.println("Enter hotel ID:");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();


        System.out.println("Enter hotel name:");
        hotel.setName(scanner.next());

        System.out.println("Enter hotel location:");
        hotel.setLocation(scanner.next());

        hotelRepository.save(hotel);

        System.out.println("Hotel saved successfully.Hotel ID:"+hotel.getId());

    }

}
