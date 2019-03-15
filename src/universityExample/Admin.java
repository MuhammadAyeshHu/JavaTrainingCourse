package universityExample;

public class Admin extends Employee implements Management{

    private String pvg;
    private String department;

    public String getPvg() {
        return pvg;
    }

    public void setPvg(String pvg) {
        this.pvg = pvg;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public double calSalary(Employee emp) {
        if( emp instanceof Prof) {
            return 3000;
        }
        return 0;
    }
}
