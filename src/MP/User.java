package MP;

public abstract class User {
    protected String firstName;
    protected String lastName;
    protected String birthDate;
    protected String email;
    protected String password;
    protected String phoneNumber;

    public User(String firstName, String lastName, String birthDate, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User() {
        // Default constructor
    }

    public abstract void register();
    public abstract boolean login(String email, String password);
}