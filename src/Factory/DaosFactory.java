package Factory;

import DAOS.AdminDao;
import DAOS.AnswerDao;
import DAOS.QuestionDao;
import DAOS.ReportDao;
import DAOS.SurveyDao;
import DAOS.UserAnswerDao;
import DAOS.UserDao;

public class DaosFactory {

	
	public UserDao getUserDao(){
		return new UserDao();
	}
	public AdminDao getAdminDao()
	{
		return new AdminDao();
	}
	public AnswerDao getAnswerDao()
	{
		return new AnswerDao();
	}
	public QuestionDao getQuestionDao ()
	{
		return new QuestionDao();
	}
	public ReportDao getReportDao ()
	{
		return new ReportDao();
	}
	public SurveyDao getSurveyDao()
	{
		return new SurveyDao();
	}
	public UserAnswerDao getUserAnswerDa() 
	{
		return new UserAnswerDao();
	}
}
