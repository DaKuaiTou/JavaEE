package com.dkt.domain;

/**
 * @author: dkt
 * @Pcakage: com.dkt.domain.User
 * @Date: 2022年10月09日 16:16
 * @Description:
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String address;
    private String nickname;
    private String gender;
    private String email;
    private String status;

    @Override
    public String toString () {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getNickname () {
        return nickname;
    }

    public void setNickname (String nickname) {
        this.nickname = nickname;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public User(Integer id, String username, String password, String address, String nickname, String gender, String email, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.nickname = nickname;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }

    public User() {
    }
}
