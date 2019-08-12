package rentalstore;

public class ChildrensMovie extends Movie{
    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    protected double calculateAmount(Rental rental) {
        double thisAmount = 1.5;
        if (rental.getDayRented() > 3) {
            thisAmount += (rental.getDayRented() - 3) * 1.5;
        }
        return thisAmount;
    }
}
