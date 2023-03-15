package dao;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Attendancerecord;
import entities.Requestleave;

public class RequestleaveDao {
	//====================dac=====================
	public boolean insertRequestleave(Requestleave requestleave) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call dac_insert_requestleave(?,?,?,?,?,?,?,?,?)}");) {
			ps.setInt(1, requestleave.getIdemp());
			ps.setDate(2, new java.sql.Date(requestleave.getFromdate().getTime()));
			ps.setDate(3, new java.sql.Date(requestleave.getTodate().getTime()));
			ps.setDouble(4, requestleave.getAnnualleave());
			ps.setDouble(5, requestleave.getUnpaidleave());
			ps.setDouble(6, requestleave.getSickleave());
			ps.setInt(7, requestleave.getSendrequesttoadmin());
			ps.setInt(8, requestleave.getSttrequestleave());
			ps.setInt(9, requestleave.getNote());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	public List<Requestleave> getRequestLeaveByIdemp(int idemp) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		Requestleave requestleave = null;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call dac_getrl_by_id(?)}");) {
			ps.setInt(1, idemp);
			var rs = ps.executeQuery();
			while (rs.next()) {
				requestleave = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"), rs.getDate("deadline"));
				list.add(requestleave);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public int countReLeHalf(int idemp, Date date ) {
		int i=0 ;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("{call requestHalfShift(?,?)}");) {
			cs.setDate(1, new java.sql.Date(date.getTime()));
			cs.setInt(2, idemp);
			var rs = cs.executeQuery();
		    while (rs.next()) {
				i = rs.getInt(1);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//==================Xuan=================
	public List<Requestleave> showRequestLeavebyADOrHR(int idemp) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select * from requestleave where sendrequesttoadmin=? \r\n"
						+ "and ( sttrequestleave!=0 and sttrequestleave!=4) order by deadline ASC");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Requestleave> showRequestLeavebyADOrHR1(int idemp) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select * from requestleave where sendrequesttoadmin=? order by deadline ASC");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateSTT(int idemp,int stt,int idrqleave ) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update requestleave set sendrequesttoadmin=?, sttrequestleave=? where idrqleave=? ");) {
			ps.setInt(1, idemp);
			ps.setInt(2, stt);
			ps.setInt(3, idrqleave);

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}
	public Requestleave selectidemp(int idrequest ) {
		Requestleave rql=null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from requestleave where idrqleave=?");) {
			ps.setInt(1, idrequest);
			var rs = ps.executeQuery();
			while(rs.next()) {
				rql=new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rql;

	}
	public Requestleave submithalfshift(int idemp,Date date ) {
		Requestleave rql=null;
		System.out.println("vo submithalfshift");
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from requestleave where idemp=? and fromdate=? and todate=? and sttrequestleave=4");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date)date );
			ps.setDate(3, (java.sql.Date)date );
			var rs = ps.executeQuery();
			while(rs.next()) {
				rql=new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rql;

	}
	public int checksubmithalfshift(int idemp,Date date ) {
		var i=0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select count(idrqleave) from requestleave where idemp=? and fromdate=? and todate=? and sttrequestleave=4");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date)date );
			ps.setDate(3, (java.sql.Date)date );
			var rs = ps.executeQuery();
			while(rs.next()) {
				i=rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}
	
	
	public List<Requestleave> search(String namekey,int idemp) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select  idrqleave,r.idemp,fullname,fromdate,todate,r.annualleave,\r\n"
						+ "r.unpaidleave,r.sickleave,sendrequesttoadmin,sttrequestleave,note,deadline\r\n"
						+ "from requestleave r,employee e \r\n"
						+ "where r.idemp=e.idemp and fullname like '%' + ? + '%' and sendrequesttoadmin=?\r\n"
						+ "order by deadline ASC");) {
			cs.setString(1, namekey);				
			cs.setInt(2, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Requestleave> searchandsort(String namekey,int stt,int idemp) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select idrqleave,r.idemp,e.fullname,\r\n"
						+ "fromdate,todate,r.annualleave,r.unpaidleave,r.sickleave,sendrequesttoadmin,sttrequestleave,note,deadline\r\n"
						+ "from requestleave r inner join employee e on r.idemp=e.idemp\r\n"
						+ "where e.fullname like '%'+?+'%' and r.sttrequestleave=?  and sendrequesttoadmin=?\r\n"
						+ "order by deadline ASC");) {
			cs.setString(1, namekey);		
			cs.setInt(2, stt);
			cs.setInt(3, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Requestleave> Sort(int stt,int idemp) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select idrqleave,r.idemp,fromdate,todate,r.annualleave,r.unpaidleave,r.sickleave,sendrequesttoadmin,sttrequestleave,note,deadline\r\n"
						+ "from requestleave r inner join employee e on r.idemp=e.idemp\r\n"
						+ "where  r.sttrequestleave=? and sendrequesttoadmin=?\r\n"
						+ "order by deadline ASC");) {	
			cs.setInt(1, stt);
			cs.setInt(2, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//========================= show tat ca===============================
	
	
	public List<Requestleave> showAllRequestLeave() {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select * from requestleave "
						+ "where  sttrequestleave!=0 and sttrequestleave!=4");) {
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Requestleave> showAllRequestLeave1() {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select * from requestleave ");) {
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	public List<Requestleave> search(String namekey) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select  idrqleave,r.idemp,fullname,fromdate,todate,r.annualleave,\r\n"
						+ "r.unpaidleave,r.sickleave,sendrequesttoadmin,sttrequestleave,note,deadline\r\n"
						+ "from requestleave r,employee e \r\n"
						+ "where r.idemp=e.idemp and fullname like '%' + ? + '%' "
						+ " order by deadline ASC");) {
			cs.setString(1, namekey);				
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Requestleave> searchandsort(String namekey,int stt) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select idrqleave,r.idemp,e.fullname,\r\n"
						+ "fromdate,todate,r.annualleave,r.unpaidleave,r.sickleave,sendrequesttoadmin,sttrequestleave,note,deadline\r\n"
						+ "from requestleave r inner join employee e on r.idemp=e.idemp\r\n"
						+ "where e.fullname like '%'+?+'%' and r.sttrequestleave=? "
						+ " order by deadline ASC");) {
			cs.setString(1, namekey);		
			cs.setInt(2, stt);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Requestleave> Sort(int stt) {
		List<Requestleave> list = new ArrayList<Requestleave>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select idrqleave,r.idemp,fromdate,todate,r.annualleave,r.unpaidleave,r.sickleave,sendrequesttoadmin,sttrequestleave,note,deadline\r\n"
						+ "from requestleave r inner join employee e on r.idemp=e.idemp\r\n"
						+ "where  r.sttrequestleave=? "
						+ "order by deadline ASC");) {	
			cs.setInt(1, stt);

			var rs = cs.executeQuery();
			while (rs.next()) {
				var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
				list.add(rql);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int differenceDate(Date date) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call chenhlechngay1(?)}");) {
			ps.setDate(1, (java.sql.Date) date);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}
	
	
	
	
	//=============================LAN=======================
			public List<Requestleave> searchRQbyName(String key, int idemp) {
				List<Requestleave> list = new ArrayList<Requestleave>();
				try (var conn = commom.ConnecDB.getConnect();
						var cs = conn.prepareCall("{call Lan_rqleave_searchname(?,?)}");) {
					cs.setString(1, key);
					cs.setInt(2, idemp);
					var rs = cs.executeQuery();
					while (rs.next()) {
						var rql = new Requestleave(rs.getInt("idrqleave"),rs.getInt("idemp"),rs.getDate("fromdate"),rs.getDate("todate"),rs.getDouble("annualleave"),
								rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sendrequesttoadmin"),rs.getInt("sttrequestleave"),rs.getInt("note"),rs.getDate("deadline"));
						list.add(rql);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
		
	
	
	
}
