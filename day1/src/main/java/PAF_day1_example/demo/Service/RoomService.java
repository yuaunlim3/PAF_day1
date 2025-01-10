package PAF_day1_example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PAF_day1_example.demo.Model.Room;
import PAF_day1_example.demo.Repository.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRooms(int limit, int offset){
        return roomRepository.getRooms(limit,offset);
    }

    public List<Room> getAllRooms(){
        return roomRepository.getAllRooms();
    }

    public Room getRoombyID(int id){
        return roomRepository.getRoombyId(id);
    }

    public Boolean update(int id, String roomType, float price){
        return roomRepository.update(id, roomType, price);
    }

    public Boolean delete(int id){
        return roomRepository.delete(id);
    }

    public Boolean insert(String roomType, float price){
        return roomRepository.insert(roomType, price);
    }
}
