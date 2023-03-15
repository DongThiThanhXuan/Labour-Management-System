package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Attendancemonthlyreport;
import entities.RequestchangeShift;

public class RequestchangeShiftDao {
	//=========Dac==========
		public boolean insertRequestShift(RequestchangeShift requestchangeShift) {
			boolean result = true;
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareCall("{call dac_insert_change_shift(?,?,?,?,?,?,?)}");) {
				ps.setInt(1, requestchangeShift.getFromidemp());
				ps.setInt(2, requestchangeShift.getFromidShift());
				ps.setDate(3, new java.sql.Date(requestchangeShift.getDatechange().getTime()));
				ps.setInt(4, requestchangeShift.getToidemp());
				ps.setInt(5, requestchangeShift.getToidShift());
				ps.setDouble(6, requestchangeShift.getSendrequesttoadmin());
				ps.setDouble(7, requestchangeShift.getSttrequestchangeShift());
				result = ps.executeUpdate() > 0;
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
			return result;
		}

		public List<RequestchangeShift> getRequestShiftByFromIdemp(int idemp) {
			List<RequestchangeShift> list = new ArrayList<RequestchangeShift>();
			RequestchangeShift shift = null;
			try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call select_ReShift(?)}");) {
				ps.setInt(1, idemp);
				var rs = ps.executeQuery();
				while (rs.next()) {
					shift = new RequestchangeShift(rs.getInt("idrqcShift"), rs.getInt("fromidemp"),
							rs.getInt("fromidShift"), rs.getDate("datechange"), rs.getInt("toidemp"),
							rs.getInt("toidShift"), rs.getInt("sendrequesttoadmin"), rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
					list.add(shift);
				}
				rs.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
			return list;
		}

		public List<RequestchangeShift> getRequestShiftSubmit(int toIdemp) {
			List<RequestchangeShift> list = new ArrayList<RequestchangeShift>();
			RequestchangeShift shift = null;
			try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call select_SubmitShift(?)}");) {
				ps.setInt(1, toIdemp);
				var rs = ps.executeQuery();
				while (rs.next()) {
					shift = new RequestchangeShift(rs.getInt("idrqcShift"), rs.getInt("fromidemp"),
							rs.getInt("fromidShift"), rs.getDate("datechange"), rs.getInt("toidemp"),
							rs.getInt("toidShift"), rs.getInt("sendrequesttoadmin"), rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
					list.add(shift);
				}
				rs.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
			return list;
		}
		
		public boolean submitShift(int status, int toAdmin, int idRe) {
			boolean result = false;
			try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call update_SubmitShift(?,?,?)}");) {
				ps.setInt(1, status);
				ps.setInt(2, toAdmin);
				ps.setInt(3, idRe);
			   result= ps.executeUpdate()>0;
			} catch (Exception e) {
				e.printStackTrace();

			}
			return result;
		}
		
		
	
	
	
	//=====================xuan=============================
	//=======================================my box================================
	public RequestchangeShift ShowRequestchangeShift(int idrq) {
		RequestchangeShift requestchangeshift = null;
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("select * from requestchangeShift where idrqcShift =? order by deadline ASC");) {
			ps.setInt(1, idrq);
			var rs = ps.executeQuery();
			while (rs.next()) {
				requestchangeshift = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestchangeshift;
	}
	
	public List<RequestchangeShift> ShowAllRequestchangeShift(int myid) {
		List<RequestchangeShift> listrqcs = new ArrayList<RequestchangeShift>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from RequestchangeShift where sendrequesttoadmin=? and idrqcShift!=1  order by deadline ASC");) {
			ps.setInt(1, myid);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var rqcs = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				listrqcs.add(rqcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrqcs;
	}
	public List<RequestchangeShift> showrqcshiftbystt(int myid,int stt) {
		List<RequestchangeShift> listrqcs = new ArrayList<RequestchangeShift>();
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("select * from RequestchangeShift where sendrequesttoadmin=? and sttrequestchangeShift=? order by deadline ASC");) {
			ps.setInt(1, myid);
			ps.setInt(2, stt);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var rqcs = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				listrqcs.add(rqcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrqcs;
	}
	
	

	public List<RequestchangeShift> showrqcshiftbysttandnamekey(int myid,int stt,String namekey) {
		List<RequestchangeShift> listrqcs = new ArrayList<RequestchangeShift>();
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("select idrqcShift,fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift\r\n"
					+ "from requestchangeShift r\r\n"
					+ "left join employee e on e.idemp=r.fromidemp\r\n"
					+ "right join employee f on f.idemp=r.toidemp\r\n"
					+ "where (e.fullname like '%' + ? + '%' or f.fullname like '%' + ? + '%') and sendrequesttoadmin=? and sttrequestchangeShift=? order by deadline ASC");) {
			ps.setString(1, namekey);
			ps.setString(2, namekey); 
			ps.setInt(3, myid);
			ps.setInt(4, stt);
			
			var rs = ps.executeQuery();
			while (rs.next()) {
				var rqcs = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				listrqcs.add(rqcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrqcs;
	}
	
	public List<RequestchangeShift> showrqcshiftsearch(int myid,String namekey) {
		List<RequestchangeShift> listrqcs = new ArrayList<RequestchangeShift>();
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("select idrqcShift,fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift\r\n"
					+ "from requestchangeShift r\r\n"
					+ "left join employee e on e.idemp=r.fromidemp\r\n"
					+ "right join employee f on f.idemp=r.toidemp\r\n"
					+ "where (e.fullname like '%' + ? + '%' or f.fullname like '%' + ? + '%') and sendrequesttoadmin=? and idrqcShift!=1 order by deadline ASC");) {
			ps.setString(1, namekey);
			ps.setString(2, namekey);
			ps.setInt(3, myid);
			
			var rs = ps.executeQuery();
			while (rs.next()) {
				var rqcs = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				listrqcs.add(rqcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrqcs;
	}
	
	
	
	//=======================================all box================================
	
	public List<RequestchangeShift> ShowAllRequestchangeShift() {
		List<RequestchangeShift> listrqcs = new ArrayList<RequestchangeShift>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from RequestchangeShift where idrqcShift!=1 and sendrequesttoadmin!=0 and sendrequesttoadmin is not null order by deadline ASC");) {

			var rs = ps.executeQuery();
			while (rs.next()) {
				var rqcs = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				listrqcs.add(rqcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrqcs;
	}
	
	
	public List<RequestchangeShift> showrqcshiftbystt(int stt) {
		List<RequestchangeShift> listrqcs = new ArrayList<RequestchangeShift>();
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("select * from RequestchangeShift where  sttrequestchangeShift=? and sendrequesttoadmin!=0 and sendrequesttoadmin is not null order by deadline ASC");) {

			ps.setInt(1, stt);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var rqcs = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				listrqcs.add(rqcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrqcs;
	}
	
	

	public List<RequestchangeShift> showrqcshiftbysttandnamekey(int stt,String namekey) {
		List<RequestchangeShift> listrqcs = new ArrayList<RequestchangeShift>();
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("select idrqcShift,fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift\r\n"
					+ "from requestchangeShift r\r\n"
					+ "left join employee e on e.idemp=r.fromidemp\r\n"
					+ "right join employee f on f.idemp=r.toidemp\r\n"
					+ "where (e.fullname like '%' + ? + '%' or f.fullname like '%' + ? + '%')  and sttrequestchangeShift=? and sendrequesttoadmin!=0 and sendrequesttoadmin is not null order by deadline ASC");) {
			ps.setString(1, namekey);
			ps.setString(2, namekey);
			ps.setInt(3, stt);
			
			var rs = ps.executeQuery();
			while (rs.next()) {
				var rqcs = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				listrqcs.add(rqcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrqcs;
	}
	
	public List<RequestchangeShift> showrqcshiftsearch(String namekey) {
		List<RequestchangeShift> listrqcs = new ArrayList<RequestchangeShift>();
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("select idrqcShift,fromidemp,fromidShift,datechange,toidemp,toidShift,sendrequesttoadmin,sttrequestchangeShift\r\n"
					+ "from requestchangeShift r\r\n"
					+ "left join employee e on e.idemp=r.fromidemp\r\n"
					+ "right join employee f on f.idemp=r.toidemp\r\n"
					+ "where (e.fullname like '%' + ? + '%' or f.fullname like '%' + ? + '%') and  idrqcShift!=1 and sendrequesttoadmin!=0 and sendrequesttoadmin is not null  order by deadline ASC");) {
			ps.setString(1, namekey);
			ps.setString(2, namekey);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var rqcs = new RequestchangeShift(rs.getInt("idrqcShift"),rs.getInt("fromidemp"),
						rs.getInt("fromidShift"),rs.getDate("datechange"),rs.getInt("toidemp")
						,rs.getInt("toidShift"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestchangeShift"),rs.getDate("deadline"));
				listrqcs.add(rqcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrqcs;
	}
	
	
	
	
	
	
	
	
	
	//============================================================================
	public int updateSTT(int stt,int idrs) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); 
				var ps = conn.prepareStatement("update requestchangeShift set sttrequestchangeShift=? where idrqcShift=? ");) {
			ps.setInt(1, stt);
			ps.setInt(2, idrs);

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
