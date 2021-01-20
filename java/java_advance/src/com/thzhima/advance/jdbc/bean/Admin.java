package com.thzhima.advance.jdbc.bean;

public class Admin {

	private Integer ID;
	
	private String adminName;
	
	private String PWD;
	
	private boolean active;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Admin(Integer id, String adminName, String PWD, boolean active) {
		super();
		this.ID = id;
		this.adminName = adminName;
		this.PWD = PWD;
		this.active = active;
	}

	public Admin() {
		
	}

	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", adminName=" + adminName + ", PWD=" + PWD + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((PWD == null) ? 0 : PWD.hashCode());
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (PWD == null) {
			if (other.PWD != null)
				return false;
		} else if (!PWD.equals(other.PWD))
			return false;
		if (active != other.active)
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		return true;
	}

	
	
	
	
}
