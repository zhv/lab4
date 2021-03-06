package lab4.library.book;

import lab4.library.Description;
import lab4.library.annotation.ToString;
import lab4.library.author.Author;
import lab4.library.genre.Genre;
import lab4.library.publisher.Publisher;
import lab4.library.review.Review;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Book extends Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;

    @ToString
    private String bookName;

    @Column(length = 17)
    @ToString
    private String isbn;

    @ToString
    private Integer year;


    //@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookGenre", joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "genreId"))
    private Set<Genre> genres = new HashSet<>();

    //@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookAuthor", joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "authorId"))
    private Set<Author> authors = new HashSet<>();

    //@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookPublisher", joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "publisherId"))
    private Set<Publisher> publishers = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Review> reviews = new HashSet<>();

    private Double bookRating;

    private String periodicity;

    public Book() {}

    public Book(String bookName, String isbn, int year, Set<Genre> genres, Set<Author> authors, Set<Publisher> publishers) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.year = year;
        this.genres = genres;
        this.authors = authors;
        this.publishers = publishers;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public String getPeriodicity() {
        /*StringBuilder stringBuilder = new StringBuilder();
        for (String layout: periodicity.split("/")){
            switch (layout) {
                case "1":
                    stringBuilder.append("One once a ");
                case "2":
                    stringBuilder.append("Two once a ");
                case "3":
                    stringBuilder.append("Three once a ");
                case "4":
                    stringBuilder.append("Four once a ");
                case "5":
                    stringBuilder.append("Five once a ");
                case "6":
                    stringBuilder.append("Six once a ");
                case "7":
                    stringBuilder.append("Seven once a ");
                case "w":
                    stringBuilder.append("week");
                case "m":
                    stringBuilder.append("month");
                case "y":
                    stringBuilder.append("year");
            }
        }
        return stringBuilder.toString();*/
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Double getBookRating() {

        Double ratingValue = 0d;

        List<Integer> reviewRating = new ArrayList<>();

        for (Review review: reviews) {
            for (Map.Entry<String, String> pair : review.getBookReview().entrySet()) {
                reviewRating.add(Integer.parseInt(pair.getValue()));
            }
        }

        for (Integer rating: reviewRating) {
            ratingValue = ratingValue + rating;
        }

        if (reviewRating.size() != 0) {
            ratingValue = ratingValue / reviewRating.size();
        }
        setBookRating(ratingValue);

        return bookRating;
    }

    public void setBookRating(Double bookRating) {
        this.bookRating = bookRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(bookId, book.bookId) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(genres, book.genres) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(publishers, book.publishers) &&
                Objects.equals(reviews, book.reviews) &&
                Objects.equals(bookRating, book.bookRating) &&
                Objects.equals(periodicity, book.periodicity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookId, bookName, isbn, year);
    }
}
