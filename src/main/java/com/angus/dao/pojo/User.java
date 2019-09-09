package com.angus.dao.pojo;

public class User
{

    private String userName;

    private Integer Id;

    private String passWord;

    private Integer rightLevel;

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public Integer getId ()
    {
        return Id;
    }

    public void setId (Integer id)
    {
        Id = id;
    }

    public String getPassWord ()
    {
        return passWord;
    }

    public void setPassWord (String passWord)
    {
        this.passWord = passWord;
    }

    public Integer getRightLevel ()
    {
        return rightLevel;
    }

    public void setRightLevel (Integer rightLevel)
    {
        this.rightLevel = rightLevel;
    }
}
