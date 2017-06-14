package MSD_radix_sort_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MSD_rxs_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bfs = Arrays.asList("158", "124", "238", "707", "608", "250", "888");
		
		System.out.println("============ MSD ============");
		System.out.println("");
		System.out.println("");
		System.out.println("============ Before ============");
		System.out.println("");
		System.out.println(bfs);
		bfs = sort_Msd(bfs, 0, 3);
		System.out.println("");
		System.out.println("============ After sort ======");
		System.out.println("");
		System.out.println(bfs);
	}

	public static List<String> sort_Msd(List<String> stringsort, int ps, int size) {

		Map<Character, List<String>> tm = new TreeMap<Character, List<String>>();

		for (String item : stringsort) {

			char i = item.charAt(ps);

			add(tm, i, item);
		}

		List<String> aftersort = new ArrayList<>();

		for (Character afsitem : tm.keySet()) {
			List<String> items = tm.get(afsitem);

			if (ps + 1 < size && tm.size() > 1) {
				items = sort_Msd(items, ps + 1, size);
			}
			aftersort.addAll(items);
		}
		return aftersort;

	}

	private static void add(Map<Character, List<String>> inputstring, char i, String item) {
		List<String> storestring = inputstring.get(i);
		if (storestring == null) {
			inputstring.put(i, storestring = new ArrayList<String>());
		}
		storestring.add(item);
	}

}
