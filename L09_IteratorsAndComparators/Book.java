package L09_IteratorsAndComparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = Arrays.asList(authors);
        }
    }

    @Override
    public int compareTo(Book o) {
        int byTitle = this.getTitle().compareTo(o.getTitle());
        if (byTitle == 0) {
            return Integer.compare(this.getYear(), o.getYear());
        }
        return byTitle;
    }
}
