package com.lin.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by lys on 2018/10/11.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
@Entity
public class Score {
	private int id;
	private Integer score;
	private String name;
	private String remark;
	private Integer classId;
	private Integer keId;

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "score")
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Basic
	@Column(name = "class_id")
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Basic
	@Column(name = "ke_id")
	public Integer getKeId() {
		return keId;
	}

	public void setKeId(Integer keId) {
		this.keId = keId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Score score1 = (Score) o;
		return id == score1.id &&
				Objects.equals(score, score1.score) &&
				Objects.equals(name, score1.name) &&
				Objects.equals(remark, score1.remark) &&
				Objects.equals(classId, score1.classId) &&
				Objects.equals(keId, score1.keId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, score, name, remark, classId, keId);
	}
}
