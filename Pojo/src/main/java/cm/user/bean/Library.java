package cm.user.bean;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	private List<EEBook> listEEBook;
	private List<CEBook> listCEBook;
	public Library(){
		listEEBook = new ArrayList<EEBook>();
		listCEBook = new ArrayList<CEBook>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EEBook> getListEEBook() {
		return listEEBook;
	}

	public void setListEEBook(List<EEBook> listBook) {
		this.listEEBook = listBook;
	}
	
	public List<CEBook> getListCEBook() {
		return listCEBook;
	}

	public void setListCEBook(List<CEBook> listCEBook) {
		this.listCEBook = listCEBook;
	}

	public void addEEBook(EEBook book){
		listEEBook.add(book);
	}
	public void addCEBook(CEBook book){
		listCEBook.add(book);
	}
}
