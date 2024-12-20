package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.domain.Room;
import com.tpe.repository.RoomRepository;
import java.util.Scanner;

import static com.tpe.controller.HotelManagementSystem.scanner;


public class RoomService {

    private final RoomRepository roomRepository;

    private  final HotelService hotelService;

    public RoomService(RoomRepository roomRepository,HotelService hotelService) {
        this.roomRepository = roomRepository;
    }

    //4-b alinan bilglier  ile odayi kaydetme

    public void saveRoom() {
        Room room=new Room();
        System.out.println("Enter room ID: ");
        room.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter room number: ");
        room.setNumber(scanner.next());

        System.out.println("Enter room capacity: ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();

        //id si  verilen oteli bulma
        //hotelService.findById();=null
        //tekrar kontrol yapmaya gerek yok
        //hotelservice


        Hotel hotel=hotelService.findById(hotelId);

        if(hotel==null){
            room.setHotel(hotel);

           // hotel.getRooms().add(room);//mappedBy ile baglantı kuruldu


            roomRepository.save(room);
            System.out.println("Room saved successfully.");Room id: "+room.getId());
            return;
        }else {
            System.out.println("Room could not be saved. Hotel not found.");
        }

    }
}