package dao;

import java.util.Date;

public class TempsplittheteamDao {
	public int inserttodab(int numtem1,int numtem2,int numtem3,int numtem4,int numtem5) {	
			int i = 0;
			try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call chiateam(?,?,?,?,?)}");) {
				ps.setInt(1, numtem1);
				ps.setInt(2, numtem2);
				ps.setInt(3, numtem3);
				ps.setInt(4, numtem4);
				ps.setInt(5, numtem5);
				i = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return i;

		
	}
	
	
}
