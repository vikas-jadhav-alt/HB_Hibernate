package com.basic.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int answerId;

	private String answer;

	/**
	 * If we use below @OneToOne and @JoinColumn together: then one new column for
	 * foreign key will be created.
	 * 
	 * @OneToOne() @JoinColumn(name = "q_id")
	 * 
	 *             For Bi-Directional;
	 */

	/**
	 * mappedBy: if we don't want to tore Question.question_Id column as foreign key
	 * in "answer" table.
	 * 
	 * Mapped by should be used in inverse (non-owning) side of the association.
	 * 
	 * don't use @JoinColumn together
	 */
	@OneToOne(mappedBy = "answer") // value of mappedBy is name of field in Question.class i.e : "answer"
	private Question question;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + ", question=" + question + "]";
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
