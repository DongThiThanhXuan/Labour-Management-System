package bao;

import java.util.List;

import dao.SalaryDao;
import entities.Salary;

public class SalaryBao {
	private SalaryDao sald = new SalaryDao();
	
	public List<Salary> getListSalary (){
		return sald.showListSalary();
	}
	
	public List<Salary> getSalById (String key){
		return sald.SearchSalaryById(key);
	}
	
	public List<Salary> getSalByName (String key){
		return sald.SearchSalaryByName(key);
	}
	
	public List<Salary> getSalByMonth (String key){
		return sald.SearchSalaryByMonth(key);
	}
	
	public List<Salary> getSalByMonthDesc(String key){
		return sald.SearchSalaryByMonthDesc(key);
	}
	
	public List<Salary> getSalByMonthAsc(String key){
		return sald.SearchSalaryByMonthAsc(key);
	}
	
	public List<Salary> getSalByIdMonth(int idemp, int month){
		return sald.SearchSalaryByIdMonth(idemp, month);
	}
	
	public List<Salary> sortSalByDeptMonth(int month, String iddep){
		return sald.SortSalaryByDeptMonth(month, iddep);
	}
	
	public List<Salary> sortSalByDeptMonthDesc(int month, String iddep){
		return sald.SortSalaryByDeptMonthDesc(month, iddep);
	}
	
	public List<Salary> sortSalByDeptMonthAsc(int month, String iddep){
		return sald.SortSalaryByDeptMonthAsc(month, iddep);
	}
	
	public Salary showSalaryById(int idemp, int month) {
		return sald.findSalaryById(idemp, month);
	}
	
	public void showSalary(int month){
		sald.insertPayroll(month);
	}
	
	public boolean checkMonth(int month) {
		return sald.checkExistMonth(month);
	}
	
	public int checkLastestMonth() {
		return sald.checkLatestMonth();
	}
	
	public int checkLastestMonthSal() {
		return sald.checkLatestMonthSal();
	}
	
	public boolean updatePayday(Salary salary, int month) {
		return sald.updatePayday(salary, month);
	}
	
	public void updateSalary(int month){
		sald.EditPayroll(month);
	}
	
	public int totalEmp(int month) {
		return sald.CountAllEmp(month);
	}
	
	public int countMonth(int idemp) {
		return sald.CountMonth(idemp);
	}
	
	public long totalMealEmp(int idemp) {
		return sald.totalMealEmp(idemp);
	}
	
	public long totalNightEmp(int idemp) {
		return sald.totalNightEmp(idemp);
	}
	
	public long totalOTSalEmp(int idemp) {
		return sald.totalOTSalEmp(idemp);
	}
	
	public long totaSalEmp(int idemp) {
		return sald.totalSalEmp(idemp);
	}
	
	public long totaSalDeducEmp(int idemp) {
		return sald.totalSalDeducEmp(idemp);
	}
	
	public long totaInsurEmp(int idemp) {
		return sald.totalInsurEmp(idemp);
	}
	
	public long totaNetpayEmp(int idemp) {
		return sald.totalNetpayEmp(idemp);
	}
	
	public long AvgNetpayEmp(int idemp) {
		return sald.AvgNetpayEmp(idemp);
	}
	
	public long MaxNetpayEmp(int idemp) {
		return sald.MaxNetpayEmp(idemp);
	}
	
	public long MinNetpayEmp(int idemp) {
		return sald.MinNetpayEmp(idemp);
	}
	
	public int totalEmbyDept(String iddep, int month) {
		return sald.CountEmpByDept(iddep, month);
	}
	
	public long totalMeal(int month) {
		return sald.totalMeal(month);
	}
	
	public long totalMealDept(String iddep, int month) {
		return sald.totalMealDept(iddep, month);
	}
	
	public long totalNight(int month) {
		return sald.totalNight(month);
	}
	
	public long totalNightDept(String iddep, int month) {
		return sald.totalNightDept(iddep, month);
	}
	
	public long totalOTSal(int month) {
		return sald.totalOTSal(month);
	}
	
	public long totalOTSalDept(String iddep, int month) {
		return sald.totalOTSalDept(iddep, month);
	}
	
	public long totaSal(int month) {
		return sald.totalSal(month);
	}
	
	public long totaSalDept(String iddep, int month) {
		return sald.totalSalDept(iddep, month);
	}
	
	public long totaSalDeduc(int month) {
		return sald.totalSalDeduc(month);
	}
	
	public long totaSalDeducDept(String iddep, int month) {
		return sald.totalSalDeducDept(iddep, month);
	}
	
	public long totaInsur(int month) {
		return sald.totalInsur(month);
	}
	
	public long totaInsurDept(String iddep, int month) {
		return sald.totalInsurDept(iddep, month);
	}
	
	public long totaNetpay(int month) {
		return sald.totalNetpay(month);
	}
	
	public long totaNetpayDept(String iddep, int month) {
		return sald.totalNetpayDept(iddep, month);
	}
	
	public long AvgNetpay(int month) {
		return sald.AvgNetpay(month);
	}
	
	public long AvgNetpayDept(String iddep, int month) {
		return sald.AvgNetpayDept(iddep, month);
	}
	
	public long MaxNetpay(int month) {
		return sald.MaxNetpay(month);
	}
	
	public long MaxNetpayDept(String iddep, int month) {
		return sald.MaxNetpayDept(iddep, month);
	}
	
	public long MinNetpay(int month) {
		return sald.MinNetpay(month);
	}
	
	public long MinNetpayDept(String iddep, int month) {
		return sald.MinNetpayDept(iddep, month);
	}
	
	public double numberAL(int idemp, int month) {
		return sald.numberAL(idemp, month);
	}
	public double numberUL(int idemp, int month) {
		return sald.numberUL(idemp, month);
	}
	public double numberSL(int idemp, int month) {
		return sald.numberSL(idemp, month);
	}
}
