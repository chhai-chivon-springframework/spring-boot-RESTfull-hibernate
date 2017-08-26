package com.chhaichivon.springbootRESTfullhibernate.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by chhaichivon on 8/26/17.
 */
@Data
public class RoleForm implements Serializable{
	@JsonProperty("ROLE_NAME")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
