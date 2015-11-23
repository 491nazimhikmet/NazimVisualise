package main;

import java.sql.SQLException;
import java.util.List;

import processing.core.PApplet;
import model.Work;
import model.WorkLine;
import model.Book;
import dao.WorkDao;
import dao.WorkLineDao;
import dao.BookDao;

public class Test extends PApplet {
	
	List<Work> works;
	public static void main (String[] args) {
		
		PApplet.main(new String[]{"--present", "main.Test"});
		
		/*WorkLineDao workLineDao = new WorkLineDao();
		WorkDao workDao = new WorkDao();
		//BookDao bookDao = new BookDao();
		
		try {
			//List<WorkLine> workLines = workLineDao.getWorkLineOfAWork(6161);
		
			/*for(int i=0;i<workLines.size();i++){
				System.out.println(workLines.get(i));			
			}*//*
			
			List<Work> works = workDao.getWorksOfABook(299);
			
			for(int i=0;i<works.size();i++){
				System.out.println(works.get(i));			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}
	
	public void setup () {
		size (displayWidth, displayHeight);	
		stroke(255);     // Set line drawing color to white
		frameRate(30);  
		
	}
	public void draw () {
		background(0);
		
		WorkLineDao workLineDao = new WorkLineDao();
		WorkDao workDao = new WorkDao();
		//BookDao bookDao = new BookDao();
		
		try {
			//List<WorkLine> workLines = workLineDao.getWorkLineOfAWork(6161);
		
			/*for(int i=0;i<workLines.size();i++){
				System.out.println(workLines.get(i));			
			}*/
			
			List<Work> works = workDao.getWorksOfABook(299);
			int x=works.get(0).getPageNum();
			int y=works.get(0).getName().length();
			for(int i=0;i<works.size();i++){
				System.out.println(works.get(i));
				
				text(works.get(i).toString(),x,y);
				x+=50;
				y+=50;
			}
			
			//text(works.get(0).toString(),50,100);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
