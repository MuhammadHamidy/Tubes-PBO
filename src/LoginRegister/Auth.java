package LoginRegister;

public interface Auth {
    void register();
    boolean login(String email, String password);
    void resetPassword();
}