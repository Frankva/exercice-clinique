package beans;

import jakarta.servlet.http.HttpServletRequest;

public class Nurse extends Person {
    private int nurseId;
    private String rotation;
    private int salary;
    private int serviceId;

    public Nurse() {}
    public Nurse(HttpServletRequest request) throws Exception {
        setFirstname(request.getParameter("firstname"));
        setLastname(request.getParameter("lastname"));
        setAddress(request.getParameter("address"));
        setPhone(request.getParameter("phone"));
        setRotation(request.getParameter("rotation"));
        setSalary(request.getParameter("salary"));
        setServiceId(request.getParameter("serviceId"));
    }
    public int getNurseId() {
        return nurseId;
    }
    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }
    public String getRotation() {
        return rotation;
    }
    public void setRotation(String rotation) {
        this.rotation = rotation;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setSalary(String salary) throws Exception {
        this.salary = Integer.parseInt(salary);
    }
    public int getServiceId() {
        return serviceId;
    }
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = Integer.parseInt(serviceId);
    }
}
