package Factory;

import DAOS.AdminDao;
import DAOS.AnswerDao;
import DAOS.QuestionDao;
import DAOS.ReportDao;
import DAOS.SurveyDao;
import DAOS.UserAnswerDao;
import DAOS.UserDao;

public class DaosFactory {

	
	UserDao getUserDao(){
		return new UserDao();
	}
	AdminDao getAdminDao()
	{
		return new AdminDao();
	}
	AnswerDao getAnswerDao()
	{
		return new AnswerDao();
	}
	QuestionDao getQuestionDao ()
	{
		return new QuestionDao();
	}
	ReportDao getReportDao ()
	{
		return new ReportDao();
	}
	SurveyDao getSurveyDao()
	{
		return new SurveyDao();
	}
	UserAnswerDao getUserAnswerDa() 
	{
		return new UserAnswerDao();
	}
}
