package cosmic.hackathon.models;

import java.util.ArrayList;
import java.util.List;

import cosmic.hackathon.images.Colours;

public class Questionaire {

	private Question wasThereEnoughEntertainmentQuestion; 

	public Questionaire() {
		AnswerCard booksAnswerCard = new AnswerCard("Books", null, Colours.BLUE);
		AnswerCard gamesAnswerCard = new AnswerCard("Games", null, Colours.GREEN);
		AnswerCard toysAnswerCard = new AnswerCard("Toys", null, Colours.YELLOW);
		AnswerCard televisionAnswerCard = new AnswerCard("Television", null, Colours.RED);
	
		List<AnswerCard> answerCards = new ArrayList<AnswerCard>();
		answerCards.add(booksAnswerCard);
		answerCards.add(gamesAnswerCard);
		answerCards.add(toysAnswerCard);
		answerCards.add(televisionAnswerCard);
		
		wasThereEnoughEntertainmentQuestion = new Question("Was there enough entertainment?", answerCards);
	}
	
	public Question getNextQuestion() {
		return wasThereEnoughEntertainmentQuestion;
	}

}
