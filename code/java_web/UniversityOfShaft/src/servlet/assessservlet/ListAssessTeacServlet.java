package servlet.assessservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssessDao;
import util.DBUtil;

/**
 * 2017-6-7 11:19:40
 * 
 * 教师对学生的评价列表，用于页面跳转时显示
 * 
 * @author guowenhao
 * @version 2.0
 */
@WebServlet("/listAssessTeac.do")
public class ListAssessTeacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			AssessDao assDao = new AssessDao();
			String tno = DBUtil.getCookieno(req);
			// 学生列表
			String[][] stuArrayAss = assDao.selectAllStuAssTeac(tno);
			req.setAttribute("sAA", stuArrayAss);

			req.getRequestDispatcher("/jsp/EvaluateTeac.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
