package com.yl.entity;
/**
 * 员工类型信息
 * @author Mr.Yang
 *
 */
public class EmpType {
	private int typeId;
	private String typeName;
	
	public EmpType() {
		super();
	}

	public EmpType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
