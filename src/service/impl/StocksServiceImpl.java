package service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.impl.StocksInfoDaoImpl;
import model.StocksInfo;
import service.StocksService;

public class StocksServiceImpl implements StocksService{

	public static void main(String[] args) {
		

	}
	
	StocksInfoDaoImpl sid = new StocksInfoDaoImpl();
	
	@Override
	public void addSK(StocksInfo data) {
		sid.addStocks(data);
		
	}

	@Override
	public StocksInfo addSk(String username, int stock1_amount, int stock2_amount, int stock3_amount,
		double stock1_price, double stock2_price, double stock3_price) {
		int sum = (int)(stock1_price * 1000) * stock1_amount +
				  (int)(stock2_price * 1000) * stock2_amount +
				  (int)(stock3_price * 1000) * stock3_amount;
		
		StocksInfo si = new StocksInfo();
		si.setUsername(username);
		si.setStock1(stock1_amount);
		si.setStock2(stock2_amount);
		si.setStock3(stock3_amount);
		si.setStock1_price(stock1_price);
		si.setStock2_price(stock2_price);
		si.setStock3_price(stock3_price);
		si.setTotal(sum);
		
		return si;
	}
	
	@Override
	public List<StocksInfo> queryByUN(String username) {
		
		return sid.queryByUsername(username);
	}

	@Override
	public String queryStockInfo(String username) {
		List<StocksInfo> da = queryByUN(username);
		String show = "";
		
		if(da.size() > 0) {
			DecimalFormat df = new DecimalFormat("#,###");
			for(StocksInfo i : da) {
				if(i.getStock1() > 0) {show += "台雞店\t" + i.getStock1_price() + "\t" + i.getStock1() + "\n";}
				if(i.getStock2() > 0) {show += "大粒胱\t" + i.getStock2_price() + "\t" + i.getStock2() + "\n";}
				if(i.getStock3() > 0) {show += "蓮發顆\t" + i.getStock3_price() + "\t" + i.getStock3() + "\n";}
				
				show += "\t\t\t" + df.format(i.getTotal()) + "\t" + i.getDate() + "\n" +
						"---------------------------------------------------------------------------------------------\n";
			}
		}
		
		return show;
	}

	@Override
	public List<StocksInfo> queryAll() {
		
		return sid.queryByAll();
	}

	@Override
	public List<StocksInfo> queryByDT(Date start, Date end) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String start_date = dateFormat.format(start);
		String end_date = dateFormat.format(end) + " 23:59:59";
		
		List<StocksInfo> da = sid.queryByDate(start_date, end_date);
		
		return da;
	}

	@Override
	public List<StocksInfo> queryByDTAndUN(Date start, Date end, String username) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String start_date = dateFormat.format(start);
		String end_date = dateFormat.format(end) + " 23:59:59";
		
		List<StocksInfo> da = sid.queryByDateAndUsername(start_date, end_date, username);
		
		return da;
	}

}
