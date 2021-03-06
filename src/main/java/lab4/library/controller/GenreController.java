package lab4.library.controller;

import lab4.library.exception.ResourceNotFoundException;
import lab4.library.genre.Genre;
import lab4.library.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/genre")
public class GenreController {

    private static final Logger LOG = LoggerFactory.getLogger(GenreController.class);

    @Autowired
    private GenreService genreService;

    @GetMapping(value = "/getsearchingbygenreform")
    public String getSearchingByGenreForm() {
        LOG.info("msg: return \"genre/searchingform\";");
        return "genre/searchingform";
    }

    @PostMapping(value = "/searchingbygenre")
    public String searchingByGenre(@RequestParam String genreName, Model model) {
        LOG.info("msg: Genre genre = genreService.findByGenreName(genreName);", genreName);
        Genre genre = genreService.findByGenreName(genreName);
        if (genre != null) {
            LOG.info("msg: if (genre != null) { model.addAttribute(\"books\", genre.getBooks()); }");
            model.addAttribute("books", genre.getBooks());
        } else {
            LOG.info("msg: if (genre == null) { model.addAttribute(\"error\", \"Sorry, books of the genre \" + genreName + \" a not found.\"); }", genreName);
            model.addAttribute("error", "Sorry, books of the genre " + genreName + " a not found.");
            model.addAttribute("bookName", "");
        }
        LOG.info("msg: return \"book/showallbooks\";");
        return "book/showallbooks";
    }
}
