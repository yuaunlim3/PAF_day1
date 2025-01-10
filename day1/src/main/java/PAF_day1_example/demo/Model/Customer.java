package PAF_day1_example.demo.Model;

public class Customer {
    private int id;
    private String customerName;
    private String email;
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String  customerName) {
        this. customerName =  customerName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Customer [id=" + id + ",  customerName=" +  customerName + ", email=" + email + "]";
    }
    
}
