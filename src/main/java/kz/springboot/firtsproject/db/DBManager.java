package kz.springboot.firtsproject.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Film>films = new ArrayList<>();

    private static int id = 4;

    static {
        films.add(new Film(1, "Matrix", "About Neo", 2002, 8.8));
        films.add(new Film(2, "Harry Potter", "About Harry Potter", 2001, 8.5));
        films.add(new Film(3, "DUNA", "About Muadib", 2023, 8.7));
    }

    public static ArrayList<Film> getAllFilms(){
        return films;
    }

    public static void addFilm(Film film){
        film.setId(id);
        id++;
        films.add(film);
    }

    public static Film getFilmById(int id){
        return films.stream().filter(s -> s.getId()==id).findFirst().orElse(null);
    }

    public static void updateFilm(Film film) {
        for(Film f: films){
            if(f.getId()==film.getId()){
                f.setYear(film.getYear());
                f.setName(film.getName());
                f.setRating(film.getRating());
                f.setDescription(film.getDescription());
            }
        }
    }

    public static void deleteFilm(int id) {
        films.removeIf(s->s.getId()==id);
    }
}
