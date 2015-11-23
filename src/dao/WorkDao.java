package dao;

import java.sql.SQLException;
import java.util.List;

import model.Work;
import model.WorkLine;

public class WorkDao extends DBConnection{
	
	public Work getWorkByID(int workID) throws SQLException{
		
		String query = "SELECT * FROM WORK WHERE workId = "+Integer.toString(workID);
		
		Work work = Extractors.extractWork(this.getStmt().executeQuery(query)).get(0);
		
		WorkLineDao workLineDao = new WorkLineDao();
		List<WorkLine> workLines = workLineDao.getWorkLineOfAWork(workID);
		work.setWorkLines(workLines);
		
		return work;
	}
	
	public List<Work> getWorksOfABook(int bookID) throws SQLException{
		String query = "SELECT * FROM Work WHERE bookId = "+Integer.toString(bookID);
		return Extractors.extractWork(this.getStmt().executeQuery(query));
	}
}

