package bao;

import java.util.List;

import dao.TypeaccountDao;
import entities.Typeaccount;

public class TypeaccountBao {
private TypeaccountDao typed = new TypeaccountDao();
	


public List<Typeaccount> getListType() {
	return typed.findAllType();
}

//================LAN=======================
public Typeaccount gettype(String typeid) {	
	return typed.gettype(typeid);
}
}
