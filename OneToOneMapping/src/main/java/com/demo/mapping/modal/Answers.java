package com.demo.mapping.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answers {
	
	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;
	
	@OneToOne(mappedBy = "ans")
	private Questions ques;

	public Answers() {
		super();
	}
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Questions getQues() {
		return ques;
	}
	public void setQues(Questions ques) {
		this.ques = ques;
	}
}
