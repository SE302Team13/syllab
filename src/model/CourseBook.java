package model;

public class CourseBook {

	// Field(s)
	/**
	 * Full name of the book without specified edition
	 */
	private String name;

	/**
	 * Edition number of the book.
	 */
	private int edition;

	/**
	 * Author of the book.
	 */
	private String author;

	// Constructor(s)

	/**
	 * General constructor for {@link CourseBook} class
	 * 
	 * @param name
	 * @param edition
	 * @param author
	 */
	public CourseBook(String name, int edition, String author) {
		this.name = name;
		this.edition = edition;
		this.author = author;
	}

	// Getter(s) and Setter(s)
	public String getName() {
		return name;
	}

	public int getEdition() {
		return edition;
	}

	public String getAuthor() {
		return author;
	}

	public boolean setName(String name) {
		if ((name != null) && !(name.isBlank())) {
			this.name = name;
			return true;
		}
		return false;
	}

	public boolean setEdition(int edition) {
		if (edition >= 0) {
			this.edition = edition;
			return true;
		}
		return false;
	}

	public void setAuthor(String author) {
		if ((author == null) || (author.isBlank())) {
			author = "Anonymous";
		}
		this.author = author;
	}

	/**
	 * Overridden method equals() to identify object with exactly same properties
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CourseBook) {
			CourseBook book = (CourseBook) obj;
			if (this.name.equalsIgnoreCase(book.name) && this.author.equalsIgnoreCase(book.author)) {
				return true;
			}
		}
		return false;
	}

}
