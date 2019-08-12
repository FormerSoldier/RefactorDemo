package rentalstore;

public abstract class Statement {


    protected  abstract String getEachRow(Rental each);

    protected abstract String getFooterString(double totalAmount, int frequentRenterPoints, String result);

    protected abstract String getHeaderString(Customer customer);

    public String statement(Customer customer) {
        String result = getHeaderString(customer);

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental each : customer.getRentals()) {
            double thisAmount = each.getThisAmount();
            //add frequent renter points
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            result += getEachRow(each);
            totalAmount += thisAmount;
        }

        //add footer lines
        return getFooterString(totalAmount, frequentRenterPoints, result);
    }
}
