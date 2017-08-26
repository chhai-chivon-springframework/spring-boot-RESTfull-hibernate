package com.chhaichivon.springbootRESTfullhibernate.models;

import com.chhaichivon.springbootRESTfullhibernate.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

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
}
