package LoginRegister;

public abstract class User {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String email;
    protected String password;
    protected String phoneNumber;

    public User() {
    }

    public abstract void register();
    public abstract boolean login(String email, String password);
}