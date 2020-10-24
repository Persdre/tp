package seedu.address.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class SalesBookEntry {

	private final LocalDate localDate;
	private final SalesBook salesBook;

	/**
	 * Creates a SalesBookEntry which records the salesbook of a date
	 * @param localDate the time
	 * @param salesBook the record of all drinks which have been sold
	 */
	public SalesBookEntry(LocalDate localDate, SalesBook salesBook) {
		this.localDate = localDate;
		this.salesBook = salesBook;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public SalesBook getSalesBook() {
		return salesBook;
	}

	/**
	 * A record entry is the same as another record entry if they record the same Drink item.
	 *
	 * @param otherEntry the other record entry to compare to
	 * @return true if they record the same Drink item, and false otherwise
	 */
	public boolean isSameSalesBook(SalesBookEntry otherEntry) {
		if (otherEntry == this) {
			return true;
		}

		return this.localDate.equals(otherEntry.localDate);
	}

	@Override
	public String toString() {
		return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + salesBook.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (!(other instanceof SalesBookEntry)) {
			return false;
		}

		SalesBookEntry otherEntry = (SalesBookEntry) other;
		return otherEntry.localDate.equals(localDate)
				&& otherEntry.salesBook == salesBook;
	}

	@Override
	public int hashCode() {
		return Objects.hash(localDate, salesBook);
	}
}
