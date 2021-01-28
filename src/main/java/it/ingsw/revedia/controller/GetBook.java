package it.ingsw.revedia.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import it.ingsw.revedia.model.User;
import it.ingsw.revedia.utilities.Permissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import it.ingsw.revedia.daoInterfaces.BookDao;
import it.ingsw.revedia.database.DatabaseManager;
import it.ingsw.revedia.model.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class GetBook {

	@GetMapping("/books")
	public ModelAndView getBooks(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("books");

		HttpSession session = request.getSession();
		if(session.getAttribute("nickname") != null)
		{
			User user = new User();
			user.setNickname(session.getAttribute("nickname").toString());
			user.setPermissions(Permissions.valueOf(session.getAttribute("permissions").toString()));
			model.addObject("user",user);
			model.addObject("hideuser","");
			model.addObject("signupbutton","display: none");
		}
		else
		{
			model.addObject("hideuser","display: none");
			model.addObject("signupbutton"," ");
		}

		try {

			BookDao bookDao = DatabaseManager.getIstance().getDaoFactory().getBookJDBC();

			ArrayList<Book> book = bookDao.getHighRateBooks();
			model.addObject("list", book);

			ArrayList<Book> latestBooks = bookDao.getLatestBooks();
			model.addObject("latestList", latestBooks);

			ArrayList<String> genre = bookDao.getRandomGenres();
			model.addObject("genreList", genre);

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return model;
	}

}
