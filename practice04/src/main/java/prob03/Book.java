package prob03;

public class Book {

	private int no;
	private String title;
	private String author;
	private int stateCode;
	
	public Book(int no, String title, String author) {
		this.no = no;
		this.setTitle(title);
		this.author = author;
		this.stateCode = 1;
	}
	
	public int getNo() {
		return no;
	}

	public void rent() {
		stateCode = 0;
		System.out.println(getTitle() + "이(가) 대여 됐습니다.");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public void setNo(int no) {
		this.no = no;
	}


}
