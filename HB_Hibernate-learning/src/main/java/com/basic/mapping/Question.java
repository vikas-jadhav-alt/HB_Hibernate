package com.basic.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;

	private String question;

	/**
	 * The @JoinColumn annotation combined with a @OneToOne mapping indicates that a
	 * given column in the owner entity refers to a primary key in the reference
	 * entity.
	 */
	//For Uni-Directional
	@OneToOne // foreign key (a_id) references Answer (answer_id)
	@JoinColumn(name = "a_id")
	private Answer answer; // unique (a_id) due to @OneToOne

	/**
	 * Due to OneToOne mapping over answer: CONSTRAINT: UNIQUE (i.e: Can't be
	 * Duplicate but one NULL allowed)
	 */

	public Question() {
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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answer=" + answer + "]";
	}

}
