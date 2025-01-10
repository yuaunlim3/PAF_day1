package PAF_day1_example.demo.Model;

public class Customer {
    private int id;
    private String fullName;
    private String email;
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Customer [id=" + id + ", fullName=" + fullName + ", email=" + email + "]";
    }
    
}
