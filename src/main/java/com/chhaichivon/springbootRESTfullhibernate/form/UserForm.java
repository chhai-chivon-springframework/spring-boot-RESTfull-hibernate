package com.chhaichivon.springbootRESTfullhibernate.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/26/2017
 * TIME   : 1:15 PM
 */
@Data
public class UserForm implements Serializable {
    @JsonProperty("USER_NAME")
    public String userName;
    @JsonProperty("EMAIL")
    public String email;
    @JsonProperty("PASSWORD")
    public String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}