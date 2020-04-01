import java.util.*;

public class SortByExponent implements Comparator<Monomial> {

	public int compare(Monomial a, Monomial b) {
		return b.getExponent() - a.getExponent();
	}
}
