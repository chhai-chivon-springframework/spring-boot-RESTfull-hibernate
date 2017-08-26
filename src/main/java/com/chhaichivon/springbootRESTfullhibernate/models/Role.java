package com.chhaichivon.springbootRESTfullhibernate.models;

import com.chhaichivon.springbootRESTfullhibernate.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by chhaichivon on 8/26/17.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_roles")
public class Role extends BaseEntity{
	@JsonProperty("ROLE_NAME")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
