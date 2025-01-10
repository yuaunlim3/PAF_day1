package PAF_day1_example.demo.Utils;

public class sql {
    public static final String allRooms = "SELECT * FROM room";
    public static final String allRooms_LimitOffset = "SELECT * FROM room LIMIT ? OFFSET ?";
    public static final String rooms_byID = "SELECT * FROM room WHERE ID = ?";
    public static final String deleteRoom = "DELETE FROM room WHERE id = ?";
    public static final String updateRoom = "UPDATE room set room_type = ?, price = ? WHERE id =?";
    public static final String insertRoom = "INSERT INTO customer(room_type,price) values(?,?)";


    public static final String allCustomers = "SELECT * FROM customer";
    public static final String allCustomersByID = "SELECT * FROM customer WHERE ID = ?";
    public static final String allCustomers_LimitOffset = "SELECT * FROM customer LIMIT ? OFFSET ?";
    public static final String deleteCustomer = "DELETE FROM customer WHERE id = ?";
    public static final String updateCustomer = "UPDATE customer set customer_name = ?, email = ? WHERE id =?";
    public static final String insertCustomer = "INSERT INTO customer(customer_name,email) values(? ,?)";
}
