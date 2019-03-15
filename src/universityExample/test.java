package universityExample;

public class test {
    public static void main(String[] args) {
        Prof prof = new Prof();
        Admin admin = new Admin();

        Object obj = new Employee();

        System.out.println(admin.calSalary(prof));
        System.out.println(admin.calSalary((Employee) obj));
    }
}