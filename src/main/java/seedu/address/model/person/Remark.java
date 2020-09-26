package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

//@@author ngzhenteng-reused
//Reused from https://nus-cs2103-ay2021s1.github.io/tp/tutorials/AddRemark.html
/**
 * Represents a Person's remarks in the address book.
 * Guarantees: immutable; always valid
 */
public class Remark {

    public final String value;

    /**
     * Constructs a {@code Remark}
     * @param remark remark contents
     */
    public Remark(String remark) {
        requireNonNull(remark);
        this.value = remark;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        return this == other || other instanceof Remark && this.value.equals(((Remark) other).getValue());
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

}
//@@author
