import java.util.ArrayList;

public class MergeSort{
	
	public static void sort(ArrayList<User> table) {
		
		if(table.size() > 1){
			int halfSize = table.size() / 2;

			ArrayList<User> leftTable = new ArrayList<>();
			ArrayList<User> rightTable = new ArrayList<>();
			
			for(int i = 0; i<halfSize; i++) {
				leftTable.add(table.get(i));
			}
			
			for(int i = halfSize; i < table.size(); i++) {
				rightTable.add(table.get(i));
			}
			
			sort(leftTable);
			sort(rightTable);
			
			merge(leftTable , rightTable , table);
			
		}
	}
	
	private static void merge(ArrayList<User> leftTable , ArrayList<User> rightTable , ArrayList<User> table) {
		
		int i = 0; // left
		int j = 0; // right
		int k = 0; // table
		
		while(i < leftTable.size() && j < rightTable.size()) {
			
			if(leftTable.get(i).getID().compareTo(rightTable.get(j).getID()) < 0){
				table.set(k++, leftTable.get(i++));
			}
			else {
				table.set(k++, rightTable.get(j++));
			}
		}
		while(i < leftTable.size() ) {
			table.set(k++, leftTable.get(i++));
		}
		while(j < rightTable.size()) {		
			table.set(k++, rightTable.get(j++));
		}
		
	}
}
