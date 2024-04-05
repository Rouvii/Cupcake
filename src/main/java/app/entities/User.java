package app.entities;

public class User
{
    private int userId;
    private String email;
    private String password;
    private boolean admin;

    public User(int userId, String email, String password, boolean admin)
    {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.admin = admin;
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

    @Override
    public String toString()
    {
        return "User{" +
                "userId=" + userId +
                ", userName='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + admin + '\'' +
                '}';
    }
}