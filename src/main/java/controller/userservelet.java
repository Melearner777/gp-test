package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.User;


@WebServlet("/")
public class userservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO dao;
	
    public userservelet() {
        super();
        
    }
    
    public void init() {
    	dao=new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch(action) {
		case "/new":showNewForm(request, response);break;
		case"/insert":insertUser(request, response);break;
		case"/list":listUser(request, response);break;
		case"/login":login(request, response);break;
		case"/loginprocess":try {
				loginprocess(request,response);
			} catch (SQLException | ServletException | IOException e) {
			
				e.printStackTrace();
			}break;
		case"/logout":logout(request,response);break;
		}
	}
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	public void loginprocess(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDAO userDAO=new UserDAO();
		try(Connection connection=userDAO.getConnection()) {
			PreparedStatement preparedStatement=connection.prepareStatement("select*from users where email=? and password=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				httpSession httpSession=(controller.httpSession) request.getSession();
				httpSession.setAttribute("status","active");
				httpSession.setAttribute("email",email);
				RequestDispatcher dispatcher= request.getRequestDispatcher("welcome.jsp");
				dispatcher.forward(request, response);
			}
			else {
				httpSession httpSession=(controller.httpSession) request.getSession();
				httpSession.setAttribute("status","inactive");
				RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}

			
		}
	}
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		httpSession.invalidate();
		RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
	}

	public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
		
	}
	public void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		String password=request.getParameter("password");
		User user=new User(name,email,country,password);
		dao.insertUser(user);
		response.sendRedirect("list");
		
	}
	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users=dao.selectAllUsers();
		request.setAttribute("users", users);
		RequestDispatcher dispatcher=request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
