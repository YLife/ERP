package com.yl.entity;
/**
 * 员工角色信息
 * @author Mr.Yang
 *
 */
public class EmpRole {
	private int roleId;
	private String roleName;
	
	public EmpRole() {
		super();
	}

	public EmpRole(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
