package service;

import java.util.Date;
import java.util.List;

import model.StocksInfo;

public interface StocksService {
	// create
	void addSK(StocksInfo data);
	
	StocksInfo addSk(String username, int stock1_amount, int stock2_amount, int stock3_amount,
		double stock1_price, double stock2_price, double stock3_price);
	
	
	// read
	List<StocksInfo> queryByUN(String username);
	List<StocksInfo> queryAll();
	String queryStockInfo(String username);
	List<StocksInfo> queryByDT(Date start, Date end);
	List<StocksInfo> queryByDTAndUN(Date start, Date end, String username);
	
}
