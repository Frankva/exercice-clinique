package beans;

public class Email {
    private int emailId;
    private String name;
    private int personId;

    public Email() {}
    public int getEmailId() {
        return emailId;
    }
    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
