package nov16;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;

@WebServlet("/volunteer/boardUpdate")
public class VolunteerBoardUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int volBoardNo = Integer.parseInt(request.getParameter("no"));

      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(volBoardNo);

      if (volunteerBoardDTO == null) {
        throw new Exception("[  해당 게시글이 없습니다.  ]");
      }

      volunteerBoardDTO.setTitle(request.getParameter("title"));
      volunteerBoardDTO.setContent(request.getParameter("content"));
      //    volunteerBoardDTO.setFileUpload(request.getParameter("file"));

      volunteerBoardDao.update(volunteerBoardDTO);
      //      volunteerBoardDao.deleteFile(volunteerBoardDTO);
      //
      //      for (VolunteerBoardAttachedFile volunteerBoardAttachedFile : volunteerBoardDTO.getFileUpload()) {
      //        volunteerBoardDao.insertFile(volunteerBoardDTO.getNo(), volunteerBoardAttachedFile.getFilepath());
      //      }
      sqlSession.commit();

      response.setHeader("Refresh", "1;url=boardList");

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}





