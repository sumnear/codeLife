package chapter01.ver08;



public class CustomerTest
{
	public static void main(String[] args)
	{
		statement();
	}
	public static void statement() {
		Customer customer = new Customer("John");
		String title = "Titanic";
		int priceCode = 2;
		int _daysRented = 7;
		Movie movie = new Movie(title, priceCode);
		Rental rental = new Rental(movie, _daysRented);
		customer.addRental(rental);
		String result = customer.statement();
		System.out.println(result);
	}
}
