public class Video {
    private int Id;
	private String Title;
	private boolean InStore;
	private int CheckedOutToCustomerId;

	public Video(String title) {
		Id = 0;
		Title = title;
		InStore = true;
		CheckedOutToCustomerId = 0;
	}

	public String getTitle() {
		return Title;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public boolean getInStore() {
		return InStore;
	}

	public void setInStore(boolean inStore) {
		InStore = inStore;
	}

	public int getCheckedOutCustomerId() {
		return CheckedOutToCustomerId;
	}

	public void setCheckedOutCustomerId(int customerId) {
		CheckedOutToCustomerId = customerId;
	}

	public String toString() {
		return "[" + Id + "]: " + Title + " [STATUS: " + (InStore ? "In Store" : "Not In Store") + "]";
	}

	public String toBasicString() {
		return "[" + Id + "]: " + Title;
	}
}
