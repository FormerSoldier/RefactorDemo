package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    double getThisAmount() {
        double thisAmount = movie.calculateAmount(this);
        return thisAmount;
    }

    int getFrequentRenterPoints(int frequentRenterPoints) {
        //add frequent renter points
        frequentRenterPoints++;
        //add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDayRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }


}
