package model;

public class DeptPair {

	private String DeptNum;
	private String DeptName;

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

}
