public class Book extends LibraryItem {
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        super(title);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public String toString() {
        return "\nBook: " +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages;
    }
}