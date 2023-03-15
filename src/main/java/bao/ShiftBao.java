package bao;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.ShiftDao;
import entities.Shift;

public class ShiftBao {
	ShiftDao sdao = new ShiftDao();

	public LocalTime gettimecheckin(int idshift) {
		return sdao.gettimecheckin(idshift);
	}

	public LocalTime gettimecheckout(int idshift) {
		return sdao.gettimecheckout(idshift);

	}

	public int checkchenhlech(int idShift, LocalTime nowtime) {

		return sdao.checkchenhlech(idShift, nowtime);
	}

	public List<Shift> getListShift() {
		return sdao.getListShift();
	}

	// ==========Dac========
	public List<Shift> getListHalfShift(int idShift) {
		return sdao.getHalfShift(idShift);
	}

	public List<Shift> getListFullShift() {
		return sdao.getFullShift();
	}
}
