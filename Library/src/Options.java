public enum Options {
    SHOW_LIST(1),
    BORROW(2),
    RETURN(3),
    SHOW_NUMBERS_OF_ITEMS(4),
    EXIT(0);

    private final int option;

    Options(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}