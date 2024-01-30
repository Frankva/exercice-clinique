package beans;

public class Specialty {
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) throws BeanException {
        if (id < 0) {
            throw new BeanException("Le nom est trop grand !");
        }
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

}
