package dao;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import model.Work;


public class BookDao extends DBConnection{
	public Book getBookByID(int bookID) throws SQLException{
		String query = "SELECT * FROM BOOK WHERE bookId = "+Integer.toString(bookID);
		
		Book book = Extractors.extractBook(this.getStmt().executeQuery(query)).get(0);
		
		return book;
	}
}
