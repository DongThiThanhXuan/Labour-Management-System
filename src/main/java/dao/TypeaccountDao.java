package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Typeaccount;

public class TypeaccountDao {
	//===================xuân==================================
	public List<Typeaccount> findAllType() {
		List<Typeaccount> listType = new ArrayList<Typeaccount>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * FROM typeaccount");
				var rs = ps.executeQuery();) {
			while (rs.next()) {
				Typeaccount type = new Typeaccount();
				type.setTypeid(rs.getString("typeid"));
				type.setTypename(rs.getString("typename"));
				listType.add(type);
			}
		} catch (Exception e) {
			listType = null;
		}
		return listType;
	}

	//===============LAN=============================
	public Typeaccount gettype(String typeid) {
		Typeaccount type = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * FROM typeaccount where typeid=?");) {
			ps.setString(1, typeid);
			var rs = ps.executeQuery();
			while (rs.next()) {
				type = new Typeaccount(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}
}
