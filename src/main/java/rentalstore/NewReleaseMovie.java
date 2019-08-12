package rentalstore;

public class NewReleaseMovie extends Movie{
    public NewReleaseMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    protected double calculateAmount(Rental rental) {
        return rental.getDayRented() * 3;
    }
}
