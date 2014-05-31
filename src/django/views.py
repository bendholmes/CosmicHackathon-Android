from django.shortcuts import render
from django.http import HttpResponse
import json
import api

def index (request):
    return HttpResponse("Hackathon homepage!")

def answers (request):
    jsonStr = ""

    if request.method == 'GET':
        pass

    return HttpResponse(jsonStr, content_type='application/json')

def questions (request):
    jsonStr = ""

    if request.method == 'GET':
        quizId = request.GET["quizId"]
        jsonStr = api.getQuestions(quizId)

    return HttpResponse(jsonStr, content_type='application/json')