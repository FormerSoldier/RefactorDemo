package rentalstore;

public class RegularMovie extends Movie{
    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    protected double calculateAmount(Rental rental) {
        double thisAmount = 2;
        if (rental.getDayRented() > 2) {
            thisAmount += (rental.getDayRented() - 2) * 1.5;
        }
        return thisAmount;
    }
}
