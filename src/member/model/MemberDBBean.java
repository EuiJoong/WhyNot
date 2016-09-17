package member.model;

public class MemberDBBean {
	int mnum;
	String id;
	String password;
	String name;
	String gender;
	String birth;
	String interest;
	int mileage;
	int grade;
	String joindate;
	int acstagte;
	int ppnum; // 프로필사진번호...

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public int getAcstagte() {
		return acstagte;
	}

	public void setAcstagte(int acstagte) {
		this.acstagte = acstagte;
	}

	public int getPpnum() {
		return ppnum;
	}

	public void setPpnum(int ppnum) {
		this.ppnum = ppnum;
	}

}
