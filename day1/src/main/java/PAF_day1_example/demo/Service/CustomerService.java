package PAF_day1_example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PAF_day1_example.demo.Model.Customer;
import PAF_day1_example.demo.Repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomer(int limit, int offset){
        return customerRepository.getCustomer(limit,offset);
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.getAllCustomer();
    }

    public Customer getCustomerById(int id){
        return customerRepository.getcCustomerById(id);
    }

    public Boolean deleteCustomer(int id){
        return customerRepository.deleteCustomer(id);
    }

    public Boolean updateCustomer(int id,String name, String email){
        return customerRepository.updateCustomer(id,name,email);
    }
    public Boolean insertCustomer(String name,String email){
        return customerRepository.insertCustomer(name, email);
    }
}
