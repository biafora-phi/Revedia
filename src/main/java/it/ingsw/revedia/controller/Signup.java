package it.ingsw.revedia.controller;

import it.ingsw.revedia.database.DatabaseManager;
import it.ingsw.revedia.model.User;
import it.ingsw.revedia.utilities.PasswordManager;
import it.ingsw.revedia.utilities.Permissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class Signup
{
    @GetMapping("/signup")
    public String signup(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("nickname") != null)
            return "redirect:/";
        return "signup";
    }

    @PostMapping("/register")
    public ModelAndView register(HttpServletRequest request, @RequestParam("username") String username,
                                 @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
                                 @RequestParam("password") String password, @RequestParam("mail") String mail)
    {
        User user = new User();
        user.setNickname(username);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setMail(mail);
        user.setPermissions(Permissions.STANDARD);


        String MD5Password = PasswordManager.getMD5(password);
        ModelAndView model = new ModelAndView();
        try
        {
            DatabaseManager.getIstance().getDaoFactory().getUserJDBC().insertUser(user, MD5Password);
            HttpSession session = request.getSession();
            session = request.getSession(true);
            session.setAttribute("nickname", user.getNickname());
            session.setAttribute("mail",user.getMail());
            session.setAttribute("firstname",user.getFirstName());
            session.setAttribute("lastname",user.getLastName());
            session.setAttribute("permissions",user.getPermissions().toString());

            model.setViewName("redirect:/");
        }
        catch (SQLException throwables)
        {
            //throwables.printStackTrace();
            model.setViewName("signup");
            model.addObject("usernotavaible", "Nome utente non disponibile, riprova");
        }

        return model;
    }

    /*@PostMapping("/qualcosa")
    @ResponseBody
    public String qualcosa()
    {
        return "ciao";
    }

    @PostMapping("/altracosa")
    public void altraCosa(@RequestBody Album album)
    {

    }*/
}
