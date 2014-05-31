package cosmic.hackathon.models;

import java.util.Collection;

public class Question {

	private String questionText;
	private Collection<AnswerCard> applicableAnswerCards;
	
	public Question(String questionText, Collection<AnswerCard> applicableAnswerCards) {
		this.questionText = questionText;
		this.applicableAnswerCards = applicableAnswerCards;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public Collection<AnswerCard> getApplicableAnswerCards() {
		return applicableAnswerCards;
	}
	
	public int getChosenAnswerImage(int[] pixels) {
	    for(AnswerCard answerCard : applicableAnswerCards) {
	        if(answerCard.isAPictureOfThisCard(pixels)) {
	            return answerCard.getImageResourceId();
	        }
	    }
	    
	    return 0;
	}
}
