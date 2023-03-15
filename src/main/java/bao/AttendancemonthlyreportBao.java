package bao;

import java.util.Date;
import java.util.List;

import dao.AttendancemonthlyreportDao;
import entities.Attendancemonthlyreport;

public class AttendancemonthlyreportBao {
	AttendancemonthlyreportDao attendMonth = new AttendancemonthlyreportDao();

	// get all list attend
	public List<Attendancemonthlyreport> getListAttend(int month) {
		return attendMonth.ShowAllAttendReport(month);
	}

	// ==============xuan
	public int inserttotableNoHL(int month) {
		return attendMonth.inserttotableNoHL(month);

	}

	// insert thang vua co nghi le, vua co nghi bu
	public int inserttotableHL(int month, Date fromdateHl, Date todatehl, Date fromdateoffHL, Date todateoffHL) {
		return attendMonth.inserttotableHL(month, fromdateHl, todatehl, fromdateoffHL, todateoffHL);

	}

	// insert thang co nghi le
	public int inserttotableOnlyHL(int month, Date fromdateHl, Date todatehl) {
		return attendMonth.inserttotableOnlyHL(month, fromdateHl, todatehl);
	}

	// insert thang co NGHI BU
	public int inserttotableOnlyNghiBu(int month, Date fromdateHl, Date todatehl) {
		return attendMonth.inserttotableOnlyNghiBu(month, fromdateHl, todatehl);
	}

	// check xem lam bao cao chua
	public int checkreport(int monnth) {
		return attendMonth.checkreport(monnth);
	}

	public int deletereport(int monnth) {
		return attendMonth.deletereport(monnth);
	}

	public int update(int month) {

		return attendMonth.update(month);

	}

	// ====check month exist xuất excel
	public boolean checkMonth(int month) {
		return attendMonth.checkExistMonth(month);
	}

}
