package com.chhaichivon.springbootRESTfullhibernate.models;

import com.chhaichivon.springbootRESTfullhibernate.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/26/2017
 * TIME   : 12:47 PM
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_users")
public class User extends BaseEntity {
    @JsonProperty("USERNAME")
    private String username;
    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("PASSWORD")
    private String password;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.stock", cascade= CascadeType.ALL)
    private Set<Role> role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
