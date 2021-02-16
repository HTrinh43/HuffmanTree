import java.util.HashMap;

public class HuffmanFrequencyTable {

	public static void frequencyTable(final String input) {
		HashMap<Character,Integer> table = new HashMap<Character,Integer>();
		for (int i = 0; i < input.length(); i++) {
			//if the char is already in the table, incrementing the value
			if (table.containsKey(input.charAt(i))){
				table.put(input.charAt(i), table.get(input.charAt(i)) + 1);
			}
			//if it is not in the talbe, create 1 with 0 value
			else {
				table.put(input.charAt(i), 1);
			}
		}
		for (char c : table.keySet()) {
			System.out.print(c);
			System.out.print(" ");
			System.out.print(table.get(c));
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		frequencyTable("tHis is an exaMmple of a frequency table");
	}
}