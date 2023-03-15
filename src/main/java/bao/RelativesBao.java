package bao;

import dao.RelativesDao;
import entities.Relatives;

public class RelativesBao {
	private RelativesDao relativesdao = new RelativesDao();
	//==================dac==============================
	public Relatives getRelatives(int idemp) {
		return relativesdao.getRe(idemp);
	}
	//==================LAN==============================
	public boolean insertRealatives(Relatives relatives) {	
		return relativesdao.insertRelatives(relatives);
	}

	public boolean checkPhoneRelative(String phone) {	
		return relativesdao.checkExistPhoneRelatives(phone);
	}
	
	public Relatives findRel(int idemp) {
		return relativesdao.getRel(idemp);
	}
	
	public boolean updatePhone(String phone, int idemp) {	
		return relativesdao.updatePhone(phone, idemp);
	}
	
	public boolean updateInfo(Relatives rel, int idemp) {	
		return relativesdao.updateRel(rel, idemp);
	}
}
