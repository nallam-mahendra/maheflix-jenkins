package com.maheflix.app.controller;

import com.maheflix.app.model.Movie;
import com.maheflix.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("featured", movieService.getFeatured());
        model.addAttribute("moviesByCategory", movieService.getMoviesByCategory());
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "q", required = false) String q, Model model) {
        model.addAttribute("query", q);
        model.addAttribute("results", movieService.search(q));
        return "search";
    }

    @GetMapping("/movie/{id}")
    public String movieDetail(@PathVariable Long id, Model model) {
        Movie movie = movieService.getById(id);
        model.addAttribute("movie", movie);
        return "detail";
    }
}
