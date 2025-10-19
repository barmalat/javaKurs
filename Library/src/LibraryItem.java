import java.util.Objects;

public class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem that = (LibraryItem) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}