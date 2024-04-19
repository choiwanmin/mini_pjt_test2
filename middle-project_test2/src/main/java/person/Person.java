package person;

public class Person {
//	private Mem mem;
	private int num;
	private String userid;
	private String usertel;
	private String email;
	private String education;
	private String career;
	private String skill;
	private String gender;
	private String age;
	private String jobCd;
	private String jobNm;

	public Person() {
	}

	

	public String getJobNm() {
		return jobNm;
	}



	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}



	public Person(int num, String userid, String usertel, String email, String education, String career, String skill,
			String gender, String age, String jobCd, String jobNm) {
		super();
		this.num = num;
		this.userid = userid;
		this.usertel = usertel;
		this.email = email;
		this.education = education;
		this.career = career;
		this.skill = skill;
		this.gender = gender;
		this.age = age;
		this.jobCd = jobCd;
		this.jobNm = jobNm;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsertel() {
		return usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getJobCd() {
		return jobCd;
	}

	public void setJobCd(String jobCd) {
		this.jobCd = jobCd;
	}



	@Override
	public String toString() {
		return "Person [num=" + num + ", userid=" + userid + ", usertel=" + usertel + ", email=" + email
				+ ", education=" + education + ", career=" + career + ", skill=" + skill + ", gender=" + gender
				+ ", age=" + age + ", jobCd=" + jobCd + ", jobNm=" + jobNm + "]";
	}

	
	
	

}
