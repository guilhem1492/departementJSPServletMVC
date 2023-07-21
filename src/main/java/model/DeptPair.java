package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "dept.fetch", query = "SELECT d FROM DeptPair d WHERE d.DeptNum = :num")
public class DeptPair {
	@Id
	@GeneratedValue
	private long id;
	private String DeptNum;
	private String DeptName;

	public DeptPair() {
	}

	public DeptPair(String deptNum, String deptName) {
		DeptNum = deptNum;
		DeptName = deptName;
	}

	public String getDeptNum() {
		return DeptNum;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptNum(String deptNum) {
		DeptNum = deptNum;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	@Override
	public String toString() {
		return "DeptPair [DeptNum=" + DeptNum + ", DeptName=" + DeptName + "]";
	}

}
