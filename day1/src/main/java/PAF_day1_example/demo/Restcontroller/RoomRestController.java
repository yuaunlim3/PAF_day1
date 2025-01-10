package PAF_day1_example.demo.Restcontroller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PAF_day1_example.demo.Model.Customer;
import PAF_day1_example.demo.Model.Room;
import PAF_day1_example.demo.Service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/limit")
    public ResponseEntity<List<Room>> getRooms(@RequestParam("limit") int limit,@RequestParam("offset")int offset){
        List<Room> rooms = roomService.getRooms(limit,offset);

        return ResponseEntity.ok(rooms);
    }

    @GetMapping("")
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms = roomService.getAllRooms();

        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoombyID(@PathVariable("id")int id){
        Room room = roomService.getRoombyID(id);

        return ResponseEntity.ok(room);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<List<Room>> update(@PathVariable("id")int id,@RequestBody Room room){
        Boolean updateSuccess = roomService.update(id, room.getRoomType(), room.getPrice());

        if (updateSuccess) {
            List<Room> rooms = roomService.getAllRooms();

            return ResponseEntity.ok(rooms);
        }

        return ResponseEntity.status(404).body(Collections.emptyList());
    }

    @PutMapping("insert")
    public ResponseEntity<List<Room>> update(@RequestBody Room room){
        Boolean updateSuccess = roomService.insert(room.getRoomType(), room.getPrice());

        if (updateSuccess) {
            List<Room> rooms = roomService.getAllRooms();

            return ResponseEntity.ok(rooms);
        }

        return ResponseEntity.status(404).body(Collections.emptyList());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int id){
        Boolean updateSuccess = roomService.delete(id);

        if (updateSuccess) {


            return ResponseEntity.ok("Room Deleted");
        }

        return ResponseEntity.status(404).body("Not found");
    }
}
