public class Movie extends LibraryItem {
    private String director;
    private int duration;

    public Movie(String title, String director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
    }

    public Movie(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "\nMovie: " +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration;
    }
}