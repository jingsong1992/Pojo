package cm.user.test;

import cm.user.bean.BookChapter;
import cm.user.bean.CEBook;
import cm.user.bean.EEBook;
import cm.user.bean.Library;
import cm.user.cache.CacheManager;
import cm.user.pojo.CacheGetPojo;

public class Test {
	public static void main(String[] args) {
		CacheManager.init("E:/Cache_Config.xml");
		Library library = (Library)CacheGetPojo.getLibrary("book.xml", "book_rule.xml");
		System.out.println(" 图书馆: " + library.getName());
		System.out.println("共藏书: " +(library.getListEEBook().size()+library.getListCEBook().size()));		
		for(EEBook book : library.getListEEBook()){
			System.out.println("EE共有"+library.getListEEBook().size()+"本书");
			System.out.println("书名: "+book.getTitle()+"  作者: "+book.getAuthor());
			System.out.println(".........................");
			System.out.println("共 "+book.getListBookChapter().size()+"章");
			for(BookChapter bookChapter:book.getListBookChapter()){
				System.out.println(bookChapter.getNo()+":"+bookChapter.getCaption());
			}
			System.out.println("..................");
		}	
		for(CEBook book : library.getListCEBook()){
			System.out.println("CE共有"+library.getListCEBook().size()+"本书");
			System.out.println("书名: "+book.getTitle()+"  作者: "+book.getAuthor());
			System.out.println(".........................");
			System.out.println("共 "+book.getListBookChapter().size()+"章");
			for(BookChapter bookChapter:book.getListBookChapter()){
				System.out.println(bookChapter.getNo()+":"+bookChapter.getCaption());
			}
			System.out.println("..................");
		}
	}
		
}
