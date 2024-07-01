package dao;

import java.util.List;

import model.StocksInfo;

public interface StocksInfoDao {
	// create
	void addStocks(StocksInfo data);
	
	// read
	List<StocksInfo> queryByUsername(String username);
	List<StocksInfo> queryByAll();
	List<StocksInfo> queryByDate(String start_date, String end_date);
	List<StocksInfo> queryByDateAndUsername(String start_date, String end_date, String username);
}
