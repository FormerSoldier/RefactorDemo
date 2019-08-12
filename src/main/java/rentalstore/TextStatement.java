package rentalstore;

public class TextStatement extends Statement{
//    protected String getEachRow(Rental each, double thisAmount) {
//        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
//    }
//
//    protected String getFooterString(double totalAmount, int frequentRenterPoints, String result) {
//        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
//        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
//        return result;
//    }
//
//    protected String getHeaderString(Customer customer) {
//        return "Rental Record for " + customer.getName() + "\n";
//    }

    @Override
    protected String getEachRow(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getThisAmount()) + "\n";
    }

    @Override
    protected String getFooterString(double totalAmount, int frequentRenterPoints, String result) {
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    @Override
    protected String getHeaderString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
