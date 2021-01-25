package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import dao.SelectDAO;
/**
 * @author kariya
 * @version 13.0
 */
public class InfoLogic {
	/**
	 * DAOクラスをnewしてfindメソッドでlistを作成し作成した
	 * listからidをgetするメソッド
	 * @param id DBのデータの一つ、int型の整数
	 * @return listからgetしintの整数をreturnする
	 */
	public InfoBeans search(int id) {
		SelectDAO search = new SelectDAO();
		List<InfoBeans> searchList = null;
		searchList = search.find();
		return searchList.get(id);
	}
	/**
	 * DB内のデータ数の最大値に＋１してint型で返すメソット
	 * @param searchList InfoBeansのlistを入れる
	 * @return list内に存在するid(int)の最大値に+1したint型整数を返す
	 */
	public int addition(List<InfoBeans> searchList) {
		int id = 0;
		for (int i = 0; i < searchList.size(); i++) {
			if (id < searchList.get(i).getId()) {
				id = searchList.get(i).getId();
			}
		}
		id = id + 1;
		return id;
	}
	/**
	 * JavaDate型をSqlDate型に変換するメソット
	 * @param string DBから抽出した日付データが入る
	 * @return 日付データをjava.util.date型からjava.sql.date型に変換して
	 * returnする。
	 */
	public Date dateConversion(String string) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date = null;
		try {
			date = fmt.parse(string);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		java.sql.Date birthday = new java.sql.Date(date.getTime());
		return birthday;
	}
}
