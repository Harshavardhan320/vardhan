package practice3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="School")
public class School {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="Student_name")
	private String Student_name;
	
	@Column(name="Teacher_name")
	private String Teacher_name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudent_name() {
		return Student_name;
	}

	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}

	public String getTeacher_name() {
		return Teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		Teacher_name = teacher_name;
	}
	
	
	
	
}
