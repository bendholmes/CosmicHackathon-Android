from django.db import connection

def query(query) {
	cursor = connection.cursor()
	cursor.execute(query)
	return cursor.fetchall()
}

def jsonQuery(query) {
	return json.dumps(query(query))
}

def getAnswers() {
	
}

def getCards() {
	
}

def getQuestions(quizId) {
	
}

def getQuizzes() {
	
}

def getQuestionAnswers(questionId) {
	
}

def getQuestionCards(questionId) {
	
}

def getQuestionAnswersAndCards(questionId) {
	
}

def getUsers() {
	
}

def getUserAnswers(quizId) {
	
}