package com.model;

import javax.persistence.*;

@Entity
@Table(name = "user_accounts1")
public class UserAccount {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username")
    private String userName;

    private String email;

    private String password;

    private String enabled ;
    private String role ;

    public UserAccount() {

    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String isEnabled()
    {
        return enabled;
    }

    public void setEnabled(String enabled)
    {
        this.enabled = enabled;
    }


}
