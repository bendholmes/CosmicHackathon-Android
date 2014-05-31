from django.db import connection
import json

def query(queryStr):
    cursor = connection.cursor()
    cursor.execute(queryStr)
    resultDict = [dict((cursor.description[i][0], value) for i, value in enumerate(row)) for row in cursor.fetchall()]
    return resultDict

def jsonQuery(queryStr):
	return json.dumps(query(queryStr))

def getAnswers():
	return jsonQuery("SELECT * FROM answers")

def getCards():
	pass

def getQuestions(quizId):
	return jsonQuery("""SELECT cosmic_questions.*
                     FROM cosmic_questions
                     LEFT JOIN cosmic_quiz_questions
                     ON cosmic_questions.id = cosmic_quiz_questions.question_id
                     WHERE cosmic_quiz_questions.quiz_id = """ + quizId)

def getQuizzes():
	pass

def getQuestionAnswers(questionId):
	pass

def getQuestionCards(questionId):
    pass

def getQuestionAnswersAndCards(questionId):
    pass

def getUsers():
	pass

def getUserAnswers(quizId):
    pass
