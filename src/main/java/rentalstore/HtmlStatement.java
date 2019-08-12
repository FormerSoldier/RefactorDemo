package rentalstore;


public class HtmlStatement extends Statement {
    @Override
    protected String getEachRow(Rental each) {
        return each.getMovie().getTitle() + ": "+String.valueOf(each.getThisAmount())+"<BR>\n";
    }

    @Override
    protected String getFooterString(double totalAmount, int frequentRenterPoints, String result) {
        return result + "<P>You owe<EM>"+String.valueOf(totalAmount)+"</EM><P>\n" +
                "On this rental you earned <EM>"+String.valueOf(frequentRenterPoints)+"</EM> frequent renter points<P>";
    }

    @Override
    protected String getHeaderString(Customer customer) {
        return "<H1>Rentals for <EM>"+ customer.getName()+"</EM></H1><P>\n";

    }
}
