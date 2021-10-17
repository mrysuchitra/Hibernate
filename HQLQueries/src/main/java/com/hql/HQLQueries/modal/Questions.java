package com.hql.HQLQueries.modal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questions {
	
	@Id
	@Column(name = "question_id")
	private int questionId;
    private String question;	
    
    @OneToMany(mappedBy = "ques")
	private List<Answers> ans;
	
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
	public List<Answers> getAns() {
		return ans;
	}
	public void setAns(List<Answers> ans) {
		this.ans = ans;
	}
	
}
