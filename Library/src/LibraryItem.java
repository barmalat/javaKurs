public abstract class LibraryItem {
    protected String title;
    private boolean availability = true;

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}