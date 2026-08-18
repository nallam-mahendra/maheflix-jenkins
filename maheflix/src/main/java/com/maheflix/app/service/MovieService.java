package com.maheflix.app.service;

import com.maheflix.app.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {
        seed();
    }

    private void poster(List<Movie> list, long id, String title, String genre, String category,
                         String desc, String bg, String fg, double rating, int year) {
        String encodedTitle = title.replace(" ", "+");
        String posterUrl = "https://placehold.co/300x450/" + bg + "/" + fg + "?text=" + encodedTitle + "&font=roboto";
        String bannerUrl = "https://placehold.co/1280x400/" + bg + "/" + fg + "?text=" + encodedTitle + "&font=roboto";
        list.add(new Movie(id, title, genre, category, desc, posterUrl, bannerUrl, rating, year));
    }

    private void seed() {
        long id = 1;
        poster(movies, id++, "Crimson Horizon", "Action / Thriller", "Trending Now",
                "A rogue agent races against time to stop a global conspiracy before dawn.",
                "141414", "e50914", 8.4, 2024);
        poster(movies, id++, "Silent Orbit", "Sci-Fi", "Trending Now",
                "A lone astronaut discovers a signal that shouldn't exist deep in space.",
                "0d1b2a", "00b4d8", 8.1, 2023);
        poster(movies, id++, "Velvet Shadows", "Drama", "Trending Now",
                "Two rival families collide in a story of ambition, love, and betrayal.",
                "1a1a2e", "e94560", 7.8, 2022);
        poster(movies, id++, "Neon Pulse", "Action", "Trending Now",
                "In a city run by machines, one hacker fights to bring back the human spirit.",
                "16213e", "00ff9c", 8.6, 2025);

        poster(movies, id++, "The Last Harvest", "Drama", "Because You Watched Action",
                "A family fights to save their farmland as the world changes around them.",
                "222831", "ffd369", 7.5, 2021);
        poster(movies, id++, "Iron Tide", "Action / War", "Because You Watched Action",
                "An elite squad is dropped behind enemy lines with one shot at victory.",
                "1b1b2f", "f72585", 8.0, 2020);
        poster(movies, id++, "Blackout City", "Thriller", "Because You Watched Action",
                "When the lights go out, a detective must solve the case before chaos wins.",
                "0b132b", "3a86ff", 7.9, 2023);
        poster(movies, id++, "Steel Requiem", "Action", "Because You Watched Action",
                "A retired soldier is pulled back for one final, impossible mission.",
                "10002b", "ff006e", 8.2, 2024);

        poster(movies, id++, "Comedy Nights Live", "Comedy", "Comedy Picks For You",
                "Four friends turn an ordinary road trip into an unforgettable disaster.",
                "3a0ca3", "ffbe0b", 7.2, 2022);
        poster(movies, id++, "Office Chaos", "Comedy", "Comedy Picks For You",
                "A new intern accidentally becomes the company's most valuable employee.",
                "780000", "ffba08", 6.9, 2021);
        poster(movies, id++, "Wedding Bells & Whistles", "Comedy / Romance", "Comedy Picks For You",
                "Nothing goes as planned when two families merge for the wedding of the year.",
                "606c38", "fefae0", 7.4, 2023);
        poster(movies, id++, "The Roommate Situation", "Comedy", "Comedy Picks For You",
                "Three strangers, one apartment, and endless hilarious misunderstandings.",
                "9d0208", "ffba08", 7.0, 2024);

        poster(movies, id++, "Kingdom of Ember", "Fantasy", "New Releases",
                "A young heir must reclaim a throne guarded by ancient fire spirits.",
                "370617", "faa307", 8.3, 2026);
        poster(movies, id++, "Whispering Pines", "Horror", "New Releases",
                "A small town uncovers a decades-old secret buried beneath the forest.",
                "03071e", "d00000", 7.6, 2026);
        poster(movies, id++, "Quantum Drift", "Sci-Fi", "New Releases",
                "Two scientists must repair a fractured timeline before it erases them.",
                "001219", "94d2bd", 8.5, 2026);
        poster(movies, id++, "Coastal Hearts", "Romance", "New Releases",
                "A chance encounter on a summer coastline changes two lives forever.",
                "023047", "fb8500", 7.3, 2026);

        poster(movies, id++, "Mountain of Legends", "Documentary", "Maheflix Originals",
                "An intimate journey following climbers who chase the world's tallest peaks.",
                "283618", "dda15e", 8.0, 2023);
        poster(movies, id++, "Deep Current", "Documentary", "Maheflix Originals",
                "Marine explorers reveal the hidden wonders of the ocean's deepest trenches.",
                "14213d", "fca311", 8.2, 2024);
        poster(movies, id++, "Startup Dreams", "Documentary / Drama", "Maheflix Originals",
                "Follow five founders as they build companies from garages to global brands.",
                "241623", "e01a4f", 7.7, 2022);
        poster(movies, id++, "Voices of the City", "Documentary", "Maheflix Originals",
                "Everyday stories from the people who keep a great city alive.",
                "22223b", "4cc9f0", 7.9, 2025);
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getFeatured() {
        return movies.get(3);
    }

    public Map<String, List<Movie>> getMoviesByCategory() {
        Map<String, List<Movie>> grouped = new LinkedHashMap<>();
        for (Movie m : movies) {
            grouped.computeIfAbsent(m.getCategory(), k -> new ArrayList<>()).add(m);
        }
        return grouped;
    }

    public List<Movie> search(String query) {
        if (query == null || query.isBlank()) {
            return movies;
        }
        String q = query.toLowerCase();
        return movies.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(q)
                        || m.getGenre().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Movie getById(Long id) {
        return movies.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }
}
