package app.entities;

public class User
{
    private int userId;
    private String email;
    private String password;
    private boolean admin;

    private int balance;

    public User(int userId, String email, String password, boolean admin)
    {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public User(int userId, String email, boolean admin, int balance) {
        this.userId = userId;
        this.email = email;
        this.admin = admin;
        this.balance = balance;

    }


    public int getUserId()
    {
        return userId;
    }

    public String getUserName()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean getAdmin()
    {
        return admin;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", balance=" + balance +
                '}';
    }
}