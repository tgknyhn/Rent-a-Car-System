import java.io.FileNotFoundException;

public class MainUI {
    public static void main(String[] args) throws FileNotFoundException {
        Company myCompany = new Company();

        new MenuUI(myCompany);
    }
}
