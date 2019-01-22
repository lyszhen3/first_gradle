package com.lin.data.entity;

import javax.persistence.*;

/**
 * Created by lys on 2018/10/1.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long testId;
	private String name;
	private Integer age;
	@Column(name = "test_type")
	private Integer testType;


	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getTestType() {
		return testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}
}
