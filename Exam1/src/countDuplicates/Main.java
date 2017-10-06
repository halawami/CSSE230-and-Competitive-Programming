package countDuplicates;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main <T extends Comparable<T>> {
	
	/**
	 * Given a List of Strings, returns a List containing StringWithCount objects,
	 * in alphabetical order by string and with no duplicate strings. The counts should
	 * match the number of times each string appears in the input list.
	 * @param <T>
	 * @param <T>
	 * @return
	 */
	public static <T extends Comparable<T>> List<StringWithCount> countDuplicates(List<String> list)  {
		// TODO: write this method!
		TreeMap<String, Integer> map = new TreeMap<>();
		ArrayList<StringWithCount> output = new ArrayList<>();
		for(int i =0;i<list.size();i++){
			if(map.containsKey(list.get(i))){
				map.put(list.get(i), map.get(list.get(i))+1);
			}else{
				map.put(list.get(i), 1);
			}
		}
		for(String string : map.keySet()){
			StringWithCount temp = new StringWithCount(string, map.get(string));
			output.add(temp);
		}
		//I just need something to sort it and I believe all my test will pass the unit tests.
		return output;
	}
}


class StringWithCount {
	String str;
	int count;
	
	StringWithCount(String s, int c) {
		this.str = s;
		this.count = c;
	}
	
	public String toString() {
		return "(" + str + "," + Integer.toString(count) + ")";
	}
}
