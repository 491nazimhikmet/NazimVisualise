package main;

import java.sql.SQLException;
import java.util.List;

import processing.core.PApplet;
import model.Word;
import model.Work;
import model.WorkLine;
import model.Book;
import dao.WordDao;
import dao.WorkDao;
import dao.WorkLineDao;
import dao.BookDao;

public class Test extends PApplet {
	
	List<Work> works;
	public static void main (String[] args) {
		PApplet.main(new String[]{"--present", "main.Test"});
	}
	
	public void setup () {
		size (displayWidth, displayHeight);	
		stroke(255);     // Set line drawing color to white
		frameRate(30);  
		
	}
	/*public void draw () {
		background(0);
		
		WorkLineDao workLineDao = new WorkLineDao();
		WorkDao workDao = new WorkDao();
		//BookDao bookDao = new BookDao();
		
		try {
			List<WorkLine> workLines = workLineDao.getWorkLineOfAWork(6161);
			int x=10;
			int y=30;
			for(int i=0;i<workLines.size();i++){
				System.out.println(workLines.get(i));
				
				text(workLines.get(i).toString(),x,y);
				y+=10;	
			}
			
			List<Work> works = workDao.getWorksOfABook(299);	
			/*for(int i=0;i<works.size();i++){
				System.out.println(works.get(i));
				
				text(works.get(i).toString(),x,y);
				x+=50;
				y+=50;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	public void draw(){
		background(0);
		
		WorkLineDao workLineDao = new WorkLineDao();
		WorkDao workDao = new WorkDao();
		WordDao wordDao = new WordDao();
		
		try {
			List<WorkLine> workLines = workLineDao.getWorkLineOfAWork(6169);
			
			int x=10; //x coordinate of the ellipse
			int y=30; //y coordinate of the ellipse
			int r=15;	
			/*for(int i=0;i<workLines.size()-2;i++){
				//System.out.println(workLines.get(i));
				text(workLines.get(i).toString(),x,y);
				y+=10;	
			}*/
			for(int i=0;i<workLines.size()-2;i++){
				List<Word> words = wordDao.getWordsOfAWorkline(workLines.get(i).getLineID());
				for(int j=0;j<words.size();j++){
					System.out.print(words.get(j).toString()+" ");
					x=(int)words.get(j).getWordStart()*3/2;
					r=words.get(j).toString().length()*2;
					ellipse(x,y,r,r);
					
				}
				System.out.println();
				y=y+22;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
