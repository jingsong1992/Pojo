package cm.user.bean;

import java.util.ArrayList;
import java.util.List;

public class CEBook {
	private String title;
	private String author;
	private List<BookChapter> listBookChapter;
	
	public CEBook(){
		listBookChapter = new ArrayList<BookChapter>();
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

	public List<BookChapter> getListBookChapter() {
		return listBookChapter;
	}

	public void setListBookChapter(List<BookChapter> listBookChapter) {
		this.listBookChapter = listBookChapter;
	}
	
	public void addBookChapter(BookChapter bookChapter) {  
		listBookChapter.add(bookChapter);  
	}
}
