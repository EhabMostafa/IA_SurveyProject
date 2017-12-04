package Factory;

import Models.Admin;
import Models.Answer;
import Models.Question;
import Models.Report;
import Models.Survey;
import Models.User;
import Models.UserAnswer;

public class ModelFactory {
	User  getUser (){
		return new User ();
	}
	Admin  getAdmin ()
	{
		return new Admin ();
	}
	Answer  getAnswer ()
	{
		return new Answer ();
	}
	Question  getQuestion  ()
	{
		return new Question ();
	}
	Report  getReport  ()
	{
		return new Report ();
	}
	Survey  getSurvey ()
	{
		return new Survey ();
	}
	UserAnswer  getUserAnswer()
	{
		return new UserAnswer();
	}
}
