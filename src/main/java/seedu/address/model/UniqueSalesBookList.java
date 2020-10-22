package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.sales.exception.DuplicateSalesRecordException;
import seedu.address.model.sales.exception.SalesRecordNotFoundException;

public class UniqueSalesBookList {
	private final ObservableList<SalesBookEntry> internalList = FXCollections.observableArrayList();
	private final ObservableList<SalesBookEntry> internalUnmodifiableList =
			FXCollections.unmodifiableObservableList(internalList);

	/**
	 * Returns true if the list contains an equivalent record entry of {@Code SalesBookEntry toCheck}.
	 *
	 * @param toCheck the sales book entry to check for
	 * @return true if the list contains an equivalent sales book entry
	 */
	public boolean contains(SalesBookEntry toCheck) {
		requireNonNull(toCheck);
		return internalList.stream().anyMatch(toCheck::isSameRecord);
	}

	/**
	 * Adds the given {@SalesBookEntry toAdd} to the list.
	 * If there exists a salesbook of the same date, that record will be replaced.
	 *
	 * @param toAdd the SalesBookEntry to be added
	 */
	public void add(SalesBookEntry toAdd) {
		requireNonNull(toAdd);
		if (contains(toAdd)) {
			// if it exists, then replace it with the new entry
			setSalesBookEntry(toAdd);
		}
		internalList.add(toAdd);
	}

	/**
	 * Sets and replaces the entry that is recording the same date as {@Code newEntry}.
	 *
	 * @param newEntry the sales record entry to be updated.
	 */
	public void setSalesBookEntry(SalesBookEntry newEntry) {
		requireNonNull(newEntry);
		// find the sales entry with the drink
		int index = indexOf(newEntry.getDrink());
		if (index == -1) {
			throw new SalesRecordNotFoundException();
		}

		assert index > -1;

		internalList.set(index, newEntry); // replace with the new entry
	}



}
