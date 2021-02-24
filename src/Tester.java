public class Tester<T> {
	public static void main(String[] args) {
		String myString = "Eerie eyes seen near lake.Eerie eyes seen near lake.Eerie eyes seen near lake.Eerertyertyie eyes sasdfasdfeen near lake.Eerie sdfgsdfgfeyes seen near lake.Eerasdgfasdfgasgie eyes seen near lake.Eerie eyes seen near lake.Eerie eyes seen near lake.";
//		myString = "";
		final Output output = new Output();
		try {
			output.printoutput(myString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
