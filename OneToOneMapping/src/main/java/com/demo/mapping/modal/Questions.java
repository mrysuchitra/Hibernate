package com.demo.mapping.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Questions {
	
	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;
	
	@OneToOne
	@JoinColumn(name = "ans_id")
	private Answers ans;

	public Questions() {
		super();
	}
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Answers getAns() {
		return ans;
	}
	public void setAns(Answers ans) {
		this.ans = ans;
	}
}
