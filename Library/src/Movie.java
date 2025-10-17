public class Movie extends LibraryItem{
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
        return "Movie: " +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
