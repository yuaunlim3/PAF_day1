package PAF_day1_example.demo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import PAF_day1_example.demo.Model.Customer;
import PAF_day1_example.demo.Model.Room;
import PAF_day1_example.demo.Model.exception.ResourceNotFoundException;
import PAF_day1_example.demo.Utils.sql;

@Repository
public class RoomRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Room> getRooms(int limit, int offset) {
        List<Room> rooms = new ArrayList<>();

        SqlRowSet results = template.queryForRowSet(sql.allRooms_LimitOffset, limit, offset);
        while (results.next()) {
            Room room = new Room();
            room.setId(results.getInt("id"));
            room.setRoomType(results.getString("room_type"));
            room.setPrice(results.getFloat("price"));
            rooms.add(room);
        }
        return rooms;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();

        SqlRowSet results = template.queryForRowSet(sql.allRooms);
        while (results.next()) {
            Room room = new Room();
            room.setId(results.getInt("id"));
            room.setRoomType(results.getString("room_type"));
            room.setPrice(results.getFloat("price"));
            rooms.add(room);
        }
        return rooms;
    }

    public Room getRoombyId(int id) {

        Room room = null;
        try {
            room = template.queryForObject(sql.rooms_byID, BeanPropertyRowMapper.newInstance(Room.class), id);

            return room;
        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException(String.format("Room with id %d is not in database", id));
        }
    }

    public Boolean update(int id, String roomType, float price) {
        int temp = template.update(sql.updateCustomer, roomType, price, id);

        if (temp > 0) {
            return true;
        }
        return false;
    }

    public Boolean delete(int id) {
        int temp = template.update(sql.deleteRoom, id);

        if (temp > 0) {
            return true;
        }
        return false;
    }

    public Boolean insert(String roomType, float price) {
        int temp = template.update(sql.insertCustomer, roomType, price);

        if (temp > 0) {
            return true;
        }
        return false;
    }
}
