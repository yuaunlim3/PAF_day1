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
import PAF_day1_example.demo.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/limit")
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam("limit") int limit,
            @RequestParam("offset") int offset) {
        List<Customer> customers = customerService.getCustomer(limit, offset);

        return ResponseEntity.ok(customers);

    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomer();

        return ResponseEntity.ok(customers);

    }

    @GetMapping("/byID/{Id}")
    public ResponseEntity<Customer> getCustomers(@PathVariable("Id") int id) {
        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok(customer);

    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("Id") int id) {
        boolean temp = customerService.deleteCustomer(id);
        if (temp) {
            return ResponseEntity.ok("Customer has been deleted");
        }

        return ResponseEntity.status(404).build();

    }

    @PutMapping("update/{Id}")
    public ResponseEntity<List<Customer>> updateCustomer(@PathVariable("Id") int id,
            @RequestBody Customer customer) {
                System.out.println(customer.toString());
        boolean updateSuccess = customerService.updateCustomer(id, customer.getFullName(), customer.getEmail());

        if (updateSuccess) {
            List<Customer> customers = customerService.getAllCustomer();
            return ResponseEntity.ok(customers);
        }

        return ResponseEntity.status(404).body(Collections.emptyList());
    }

    
    @PutMapping("/insert")
    public ResponseEntity<List<Customer>> insertCustomer(@RequestBody Customer customer) {
        boolean insertSuccess = customerService.insertCustomer(customer.getFullName(), customer.getEmail());

        if (insertSuccess) {
            List<Customer> customers = customerService.getAllCustomer();
            return ResponseEntity.ok(customers);
        }

        return ResponseEntity.status(404).body(Collections.emptyList());
    }

}
