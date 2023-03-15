package bao;

import java.util.ArrayList;
import java.util.List;

import dao.RequestchangeShiftDao;
import entities.RequestchangeShift;

public class RequestchangeShiftBao {
	RequestchangeShiftDao resdao=new RequestchangeShiftDao();
	//================================dac===========================
	public boolean insertChangeshift(RequestchangeShift requestchangeShift) {
			
			return resdao.insertRequestShift(requestchangeShift);
		}
		public List<RequestchangeShift> getReShiftById(int idemp) {
			return resdao.getRequestShiftByFromIdemp(idemp);
		}
		public List<RequestchangeShift> getReShiftSubmit(int toIdemp) {
			return resdao.getRequestShiftSubmit(toIdemp);
		}
		public boolean updateSubmit(int status , int admin ,int idRe) {
			return resdao.submitShift(status,admin,idRe);
		}
		
	
	
	//=============================xuan==============
	//=======================================my box================================
		public RequestchangeShift ShowRequestchangeShift(int idrq) {
			return resdao.ShowRequestchangeShift(idrq);
		}
		
		public List<RequestchangeShift> ShowAllRequestchangeShift(int myid) {
			return resdao.ShowAllRequestchangeShift(myid);
		}
		public List<RequestchangeShift> showrqcshiftbystt(int myid,int stt) {
			return resdao.showrqcshiftbystt(myid, stt);
		}
		
		

		public List<RequestchangeShift> showrqcshiftbysttandnamekey(int myid,int stt,String namekey) {
			return resdao.showrqcshiftbysttandnamekey(myid, stt, namekey);
		}
		
		public List<RequestchangeShift> showrqcshiftsearch(int myid,String namekey) {
			return resdao.showrqcshiftsearch(myid, namekey);
		}
		
		
		
		//=======================================all box================================
		
		public List<RequestchangeShift> ShowAllRequestchangeShift() {
			return resdao.ShowAllRequestchangeShift();
		}
		
		
		public List<RequestchangeShift> showrqcshiftbystt(int stt) {
			return resdao.showrqcshiftbystt(stt);
		}
		
		

		public List<RequestchangeShift> showrqcshiftbysttandnamekey(int stt,String namekey) {
			return resdao.showrqcshiftbysttandnamekey(stt, namekey);
		}
		
		public List<RequestchangeShift> showrqcshiftsearch(String namekey) {
			return resdao.showrqcshiftsearch(namekey);
		}

		//============================================================================
		public int updateSTT(int stt,int idrs) {
			return resdao.updateSTT(stt, idrs);
			
		}
		
		
	
	
	
	
}
