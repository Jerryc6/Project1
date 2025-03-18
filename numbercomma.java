public class Main {
	public static void main(String[] args) {
		
		
		
		String number = "1000500000.574";
    Double numParsed = Double.parseDouble(number);

    System.out.println(String.format("The input number is: %,.2f", numParsed));
    // Or
    String numString = String.format("%,.2f", numParsed);
	}
}