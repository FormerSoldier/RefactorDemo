package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer = new Customer("Thomas");

    @Test
    public void should_return_correct_statement_when_call_statement_given_customer_has_no_rent() {
        Statement textStatement = new TextStatement();
        String statement = textStatement.statement(customer);
        assertEquals("Rental Record for Thomas\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", statement);
    }
    @Test
    public void should_return_correct_statement_when_call_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new Movie("spiderman", 0);
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        Statement textStatement = new TextStatement();
        String statement = textStatement.statement(customer);

        assertEquals("Rental Record for Thomas\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_when_call_statement_given_customer_has_rent_one_regular_movie_for_5_day() {
        Movie regularMovie = new Movie("spiderman", 0);
        Rental oneDayRental = new Rental(regularMovie, 5);
        customer.addRental(oneDayRental);

        Statement textStatement = new TextStatement();
        String statement = textStatement.statement(customer);

        assertEquals("Rental Record for Thomas\n" +
                "\t" + regularMovie.getTitle() + "\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_when_call_statement_given_customer_has_rent_one_new_release_movie_for_5_day() {
        Movie newReleaseMovie = new Movie("spiderman", 1);
        Rental oneDayRental = new Rental(newReleaseMovie, 5);
        customer.addRental(oneDayRental);

        Statement textStatement = new TextStatement();
        String statement = textStatement.statement(customer);

        assertEquals("Rental Record for Thomas\n" +
                "\t" + newReleaseMovie.getTitle() + "\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_when_call_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new Movie("spiderman", 1);
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        Statement textStatement = new TextStatement();
        String statement = textStatement.statement(customer);

        assertEquals("Rental Record for Thomas\n" +
                "\t" + newReleaseMovie.getTitle() + "\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_when_call_statement_given_customer_has_rent_children_movie_for_1_day() {
        Movie childrenMovie = new Movie("spiderman", 2);
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        Statement textStatement = new TextStatement();
        String statement = textStatement.statement(customer);

        assertEquals("Rental Record for Thomas\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_when_call_statement_given_customer_has_rent_children_movie_for_5_day() {
        Movie childrenMovie = new Movie("spiderman", 2);
        Rental oneDayRental = new Rental(childrenMovie, 5);
        customer.addRental(oneDayRental);

        Statement textStatement = new TextStatement();
        String statement = textStatement.statement(customer);

        assertEquals("Rental Record for Thomas\n" +
                "\t" + childrenMovie.getTitle() + "\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points", statement);
    }


    @Test
    public void should_return_correct_html_when_call_statement_given_customer_has_rent_children_movie_for_5_day() {
        Movie childrenMovie = new Movie("spiderman", 2);
        Rental FiveDayRental = new Rental(childrenMovie, 5);
        customer.addRental(FiveDayRental);

        Statement htmlStatement = new HtmlStatement();
        String statement = htmlStatement.statement(customer);

        assertEquals("<H1>Rentals for <EM>Thomas</EM></H1><P>\n" +
                "spiderman: 4.5<BR>\n" +
                "<P>You owe<EM>4.5</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new Movie("spiderman", 2);
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        Statement htmlStatement = new HtmlStatement();
        String statement = htmlStatement.statement(customer);

        System.out.println(statement);

        assertEquals("<H1>Rentals for <EM>Thomas</EM></H1><P>\n" +
                "spiderman: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }
}
