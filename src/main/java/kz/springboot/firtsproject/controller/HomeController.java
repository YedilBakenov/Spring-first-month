package kz.springboot.firtsproject.controller;

import kz.springboot.firtsproject.db.DBManager;
import kz.springboot.firtsproject.db.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

//    @GetMapping(value = "/") // @WebServlet(value = "/") protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {// request.getRequestDispatcher("main.jsp).forward(request, response)
//    public String mainPage(Model model){
//       model.addAttribute("films", DBManager.getAllFilms()); // request.setAttribute("films", DBManager.getAllFilms());
//       return "main";
//    }

    @GetMapping(value = "/")
    public String secondMainPage(Model model){
        model.addAttribute("films", DBManager.getAllFilms());
        return "main2";
    }

    @GetMapping(value = "/details-film/{id}")
    public String getFilmById(Model model, @PathVariable int id){
        model.addAttribute("film", DBManager.getFilmById(id));
        System.out.println(DBManager.getFilmById(id).getDescription());
        return "details-film";
    }

    @GetMapping(value = "/add-film-page")
    public String addFilmPage(){
        return "add-film-page";
    }

    @PostMapping(value = "/update-film")
    public String updateFilm(Film film){
        DBManager.updateFilm(film);
        return "redirect:/";
    }

//    @GetMapping(value = "/another-page")
//    public String anotherPage(){
//        return "secondPage";
//    }

    @PostMapping(value = "/add-film")
    public String addFilm(Film film){
        DBManager.addFilm(film);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-film")
    public String deleteFilmById(@RequestParam int id){
        DBManager.deleteFilm(id);
        return "redirect:/";
    }

    @PostMapping(value = "/add-film2")
    public String addFilm2(@RequestParam String name,
                           @RequestParam int year,
                           @RequestParam double rating,
                           @RequestParam String description
                           ) {
        Film film = new Film();
        film.setName(name);
        film.setYear(year);
        film.setRating(rating);
        film.setDescription(description);
        DBManager.addFilm(film);

        return "redirect:/";
    }
}
