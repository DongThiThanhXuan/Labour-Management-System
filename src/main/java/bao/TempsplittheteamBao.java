package bao;

import dao.TempsplittheteamDao;

public class TempsplittheteamBao {
	TempsplittheteamDao tstdao=new TempsplittheteamDao();
	public int inserttodab(int numtem1,int numtem2,int numtem3,int numtem4,int numtem5) {	
	return tstdao.inserttodab(numtem1,numtem2, numtem3, numtem4, numtem5);
	
}
}
