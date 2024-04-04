package app.entities;

public class User
{
    private int userId;
    private String userName;
    private String password;
    private boolean admin;

    public User(int userId, String userName, String password, boolean admin)
    {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }


    public int getUserId()
    {
        return userId;
    }

    public String getUserName()
    {
        return userName;
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
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + admin + '\'' +
                '}';
    }
}