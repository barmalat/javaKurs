public class Book extends LibraryItem {
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        super(title);
        this.author = author;
        this.pages = pages;
    }

    public Book(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "\nBook: " +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages;
    }
}