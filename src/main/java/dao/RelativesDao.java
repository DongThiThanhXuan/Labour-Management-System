package dao;


import entities.Relatives;

public class RelativesDao {
	//===========================dac==================
	public Relatives getRe(int idemp) {
		Relatives relatives=null;
		try (var conn = commom.ConnecDB.getConnect(); 
			var cs = conn.prepareCall("select * FROM relatives where idemp=?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			if (rs.next()) {
			     relatives= new Relatives();
			     relatives.setIdemp(rs.getInt(1));
			     relatives.setFullname(rs.getString(2));
			     relatives.setRelationship(rs.getString(3));
			     relatives.setPhone(rs.getString(4));
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return relatives;
}
	//==============LAN==========================
	public Relatives getRel(int idemp) {
		Relatives rel = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * FROM relatives where idemp=?");) {
			ps.setInt(1, idemp);
			var rs = ps.executeQuery();
			while (rs.next()) {
				rel = new Relatives(rs.getInt("idemp"),rs.getString("fullname"),rs.getString("relationship"), rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rel;
	}
	
	public boolean insertRelatives(Relatives relatives) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect(); 
			var cs = conn.prepareCall("insert into relatives(idemp, fullname, relationship, phone) values (?,?,?,?)");) {
			cs.setInt(1, relatives.getIdemp());
			cs.setString(2, relatives.getFullname());
			cs.setString(3, relatives.getRelationship());
			cs.setString(4, relatives.getPhone());
			result = cs.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	public boolean checkExistPhoneRelatives(String phone) {
		boolean check = false;
		try (var conn = commom.ConnecDB.getConnect(); 
			var ps = conn.prepareStatement("select phone FROM relatives where phone=?");) {
			ps.setString(1, phone);
			var rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	public boolean updateRel(Relatives relatives, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect(); 
			var cs = conn.prepareCall("{call Lan_update_relatives(?,?,?)}");) {
			cs.setString(1, relatives.getFullname());
			cs.setString(2, relatives.getRelationship());
			cs.setInt(3, idemp);
			result = cs.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	public boolean updatePhone(String phone, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect(); 
			var ps = conn.prepareStatement("update relatives set phone = ? where idemp = ?");) {
			ps.setString(1, phone);
			ps.setInt(2, idemp);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
