package beans;

public class Person {
    private int personId;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;

    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) throws BeanException {
        if (firstname.length() > 100) {
            throw new BeanException("Le nom est trop grand !");
        } else {
            this.firstname = firstname;
        }
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
