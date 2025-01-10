package PAF_day1_example.demo.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.catalina.util.CustomObjectInputStream;
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
public class CustomerRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Customer> getCustomer(int limit, int offset) {

        List<Customer> customers = template.query(sql.allCustomers_LimitOffset, (rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setEmail(rs.getString("email"));
            return customer;
        }, limit, offset);

        return (Collections.unmodifiableList(customers));
    }

    public List<Customer> getAllCustomer() {

        List<Customer> customers = template.query(sql.allCustomers, (rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setEmail(rs.getString("email"));
            return customer;
        });

        if(customers.isEmpty()){
            throw new ResourceNotFoundException("No record of Customers in database");
        }

        return (Collections.unmodifiableList(customers));
    }

    public Customer getCustomerById(int id) {
        Customer customer = null;
        try{
            customer = template.queryForObject(sql.allCustomersByID, BeanPropertyRowMapper.newInstance(Customer.class), id);
        
            return customer;
        }
        catch(DataAccessException ex){
            throw new ResourceNotFoundException(String.format("Customer with id %d is not in database", id));
        }

    }

    public Boolean deleteCustomer(int id) {
        int temp = template.update(sql.deleteCustomer, id);

        if (temp > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateCustomer(int id, String name, String email) {
        int temp = template.update(sql.updateCustomer, name, email, id);

        if (temp > 0) {
            return true;
        }
        return false;
    }

    public Boolean insertCustomer(String name, String email) {
        int temp = template.update(sql.insertCustomer, name, email);

        if (temp > 0) {
            return true;
        }
        return false;
    }

}
