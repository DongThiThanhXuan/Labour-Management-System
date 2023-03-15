package bao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.RequestleaveDao;
import entities.Requestleave;

public class RequestleaveBao {
	RequestleaveDao rqDao = new RequestleaveDao();

	//================================dac==============
		public boolean insertReLeave(Requestleave requestleave) {
			return rqDao.insertRequestleave(requestleave);
		}
		
		public List<Requestleave> getRLByIdemp(int idemp) {
			return rqDao.getRequestLeaveByIdemp(idemp);
		}
		public int reHalfShift(int idemp, Date date) {
			return rqDao.countReLeHalf(idemp, date);
		}

	// ================================xuan==============
	public List<Requestleave> showRequestLeavebyADOrHR(int idemp) {
		return rqDao.showRequestLeavebyADOrHR(idemp);
	}

	public List<Requestleave> showRequestLeavebyADOrHR1(int idemp) {
		return rqDao.showRequestLeavebyADOrHR1(idemp);
	}

	public int updateSTT(int idemp, int stt, int idrqleave) {
		return rqDao.updateSTT(idemp, stt, idrqleave);

	}

	public Requestleave selectidemp(int idrequest) {
		return rqDao.selectidemp(idrequest);

	}

	public List<Requestleave> search(String namekey, int idemp) {
		return rqDao.search(namekey, idemp);
	}

	public List<Requestleave> searchandsort(String namekey, int stt, int idemp) {
		return rqDao.searchandsort(namekey, stt, idemp);
	}

	public List<Requestleave> Sort(int stt, int idemp) {
		return rqDao.Sort(stt, idemp);
	}

	public int checksubmithalfshift(int idemp, Date date) {
		return rqDao.checksubmithalfshift(idemp, date);
	}

	public Requestleave submithalfshift(int idemp, Date date) {
		return rqDao.submithalfshift(idemp, date);
	}
	// ===================== show tat ca==========

	public List<Requestleave> showAllRequestLeave() {
		return rqDao.showAllRequestLeave();
	}

	public List<Requestleave> showAllRequestLeave1() {
		return rqDao.showAllRequestLeave1();
	}

	public List<Requestleave> search(String namekey) {
		return rqDao.search(namekey);
	};

	public List<Requestleave> searchandsort(String namekey, int stt) {
		return rqDao.searchandsort(namekey, stt);
	}

	public List<Requestleave> Sort(int stt) {
		return rqDao.Sort(stt);
	}

	public int differenceDate(Date date) {
		return rqDao.differenceDate(date);

	}

	// =============================lan=====================
	public List<Requestleave> searchRQbyName(String key, int idemp) {
		return rqDao.searchRQbyName(key, idemp);
	}

}
