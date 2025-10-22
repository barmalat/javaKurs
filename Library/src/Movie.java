public class Movie extends LibraryItem {
    private String director;
    private int duration;

    public Movie(String title, String director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "\nMovie: " +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration;
    }
}