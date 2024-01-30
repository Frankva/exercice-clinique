package beans;

public class Service {
    private int id;
    private int code;
    private String name;
    private int building_id;
    private int doctor_id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBuilding_id() {
        return building_id;
    }
    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }
    public int getDoctor_id() {
        return doctor_id;
    }
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }
}
