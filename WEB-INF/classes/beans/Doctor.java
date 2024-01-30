package beans;

public class Doctor extends Person {
    private int doctorId;
    private int specialtyId;
    
    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public int getSpecialtyId() {
        return specialtyId;
    }
    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }
    public void setSpecialtyId(String specialtyId) throws Exception {
        this.specialtyId = Integer.parseInt(specialtyId);
    }
}
