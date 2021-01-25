package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SelectDAO;

public class SelectLogic {
	// DBへの接続を簡略化するための定数
	public static final String URL = "jdbc:postgresql://localhost:5432/information";
	public static final String USER = "postgres";
	public static final String PASS = "password";

	// INSERT文にて引数（JSPからの入力）で指定した値をDBに追加するメソッド
	public void addition(String name, String kanaName, String email, int sexId, Date birthday, int marriageId,
			int bloodtypeId, int prefId, String tell, String phone, int careerId, String curry)
			throws ClassNotFoundException, SQLException {
		SelectDAO select = new SelectDAO();
		List<InfoBeans> list = select.find();
		InfoLogic logic = new InfoLogic();
		Connection con = null;
		PreparedStatement st;
		int id = logic.addition(list);
		con = DriverManager.getConnection(URL, USER, PASS);
		Class.forName("org.postgresql.Driver");
		String sql = ("INSERT INTO status(id,name,kana_name,email,sex_id,birthday,marriage_id,bloodtype_id,pref_id,tell,phone,career_id,curry) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		st = con.prepareStatement(sql);
		st.setInt(1, id);
		st.setString(2, name);
		st.setString(3, kanaName);
		st.setString(4, email);
		st.setInt(5, sexId);
		st.setDate(6, birthday);
		st.setInt(7, marriageId);
		st.setInt(8, bloodtypeId);
		st.setInt(9, prefId);
		st.setString(10, tell);
		st.setString(11, phone);
		st.setInt(12, careerId);
		st.setString(13, curry);
		st.executeUpdate();

	}

	// DELETE文にて引数（JSPからの入力）で指定した値（id）をDBから削除するメソッド
	public void delete(int id) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement st;
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(URL, USER, PASS);
		String sql = "DELETE FROM status WHERE id = '" + id + "'";
		st = con.prepareStatement(sql);
		st.executeUpdate();

	}

	// UPDATE文にて引数（JSPからの入力）で指定した値で該当するDBのデータを更新するメソッド戻り値はなし
	public void change(int id, String name, String kanaName, String email, int sexId, Date birthday, int marriageId,
			int bloodtypeId, int prefId, String tell, String phone, int careerId, String curry)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement st;
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(URL, USER, PASS);
		String sql = ("UPDATE status SET name = ?,kana_name = ?,email = ?,sex_id = ?,birthday= ?,"
				+ "marriage_id = ?,bloodtype_id = ?,pref_id = ?,tell = ?,phone = ?,career_id = ?,curry = ?"
				+ "WHERE id = '" + id + "'");
		System.out.println(sql);
		st = con.prepareStatement(sql);
		st.setString(1, name);
		st.setString(2, kanaName);
		st.setString(3, email);
		st.setInt(4, sexId);
		st.setDate(5, birthday);
		st.setInt(6, marriageId);
		st.setInt(7, bloodtypeId);
		st.setInt(8, prefId);
		st.setString(9, tell);
		st.setString(10, phone);
		st.setInt(11, careerId);
		st.setString(12, curry);
		st.executeUpdate();

	}

	// SELECT文にて引数（JSPからの入力）で指定した値をDBから抽出しリストにして変換するメソッド
	public List<InfoBeans> search(int id, String name, String kanaName, String email, int sexId, Date birthday,
			int marriageId, int bloodtypeId, int prefId, String tell, String phone, int careerId, String curry)
			throws ClassNotFoundException, SQLException {

		Connection con = null;
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(URL, USER, PASS);
		StringBuilder sql = null;
		List<InfoBeans> list = new ArrayList<>();
		InfoBeans info = new InfoBeans();

		/*
		 * 入力条件に合わせてSQL文を組み立てていく（始） 下記のif分はjspからの入力データがnullまたは0かどうかを判定しそうでなかった場合に
		 * StringBuilderにappendする
		 */
		sql = new StringBuilder("SELECT * FROM status WHERE 1=1");

		if (id != 0) {
			sql.append(" AND id = " + String.valueOf(id));
		}
		if (name != null) {
			sql.append(" AND name = " + "'" + String.valueOf(name) + "'");
		}
		if (kanaName != null) {
			sql.append(" AND kana_name = " + "'" + String.valueOf(kanaName) + "'");
		}
		if (email != null) {
			sql.append(" AND email = " + "'" + String.valueOf(email) + "'");
		}
		if (sexId != 0) {
			sql.append(" AND sex_id = " + String.valueOf(sexId));
		}
		if (birthday != null) {
			sql.append(" AND birthday = " + "'" + birthday + "'");
		}
		if (marriageId != 0) {
			sql.append(" AND marriage_id = " + String.valueOf(marriageId));
		}
		if (bloodtypeId != 0) {
			sql.append(" AND bloodtype_id = " + String.valueOf(bloodtypeId));
		}
		if (prefId != 0) {
			sql.append(" AND pref_id = " + String.valueOf(prefId));
		}
		if (tell != null) {
			sql.append(" AND tell = " + "'" + String.valueOf(tell) + "'");
		}
		if (phone != null) {
			sql.append(" AND phone = " + "'" + String.valueOf(phone) + "'");
		}
		if (careerId != 0) {
			sql.append(" AND career_id = " + String.valueOf(careerId));
		}
		if (curry != null) {
			sql.append(" AND curry = " + "'" + String.valueOf(curry) + "'");
		}
		sql.append(" ORDER BY id ASC");
		// SQL文組み立て（終）

		System.out.println(sql);
		PreparedStatement st = con.prepareStatement(sql.toString());
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			info.setId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setKanaName(rs.getString("kana_name"));
			info.setEmail(rs.getString("email"));
			info.setSexId(rs.getInt("sex_id"));
			info.setBirthday(rs.getDate("birthday"));
			info.setMarriageId(rs.getInt("marriage_id"));
			info.setBloodtypeId(rs.getInt("bloodtype_id"));
			info.setPrefId(rs.getInt("pref_id"));
			info.setTell(rs.getString("tell"));
			info.setPhone(rs.getString("phone"));
			info.setCareerId(rs.getInt("career_id"));
			info.setCurry(rs.getString("curry"));

			list.add(new InfoBeans(info.getId(), info.getName(), info.getKanaName(), info.getEmail(), info.getSexId(),
					info.getBirthday(), info.getMarriageId(), info.getBloodtypeId(), info.getPrefId(), info.getTell(),
					info.getPhone(), info.getCareerId(), info.getCurry()));
		}
		return list;
	}

	// idを引数にDB内にそのidが存在しているのか調べるメソッド
	public boolean idCheck(String id) throws ClassNotFoundException {
		SelectDAO select = new SelectDAO();
		boolean check = false;
		int idInt = 0;
		try {
			idInt = Integer.parseInt(id);
			List<InfoBeans> list = select.find();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == idInt) {
					check = true;
					break;
				} else {
					check = false;
				}
			}
		} catch (NumberFormatException e) {
			check = false;
		}
		return check;
	}

	// 各機能ごとのメソッドの処理の中で最後にソートする処理をするメソッド
	public List<InfoBeans> sort() throws ClassNotFoundException, SQLException {

		Connection con = null;
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(URL, USER, PASS);
		List<InfoBeans> list = new ArrayList<>();
		InfoBeans info = new InfoBeans();

		String sql = ("SELECT * FROM status ORDER BY id ASC");

		PreparedStatement st = con.prepareStatement(sql.toString());
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			info.setId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setKanaName(rs.getString("kana_name"));
			info.setEmail(rs.getString("email"));
			info.setSexId(rs.getInt("sex_id"));
			info.setBirthday(rs.getDate("birthday"));
			info.setMarriageId(rs.getInt("marriage_id"));
			info.setBloodtypeId(rs.getInt("bloodtype_id"));
			info.setPrefId(rs.getInt("pref_id"));
			info.setTell(rs.getString("tell"));
			info.setPhone(rs.getString("phone"));
			info.setCareerId(rs.getInt("career_id"));
			info.setCurry(rs.getString("curry"));

			list.add(new InfoBeans(info.getId(), info.getName(), info.getKanaName(), info.getEmail(), info.getSexId(),
					info.getBirthday(), info.getMarriageId(), info.getBloodtypeId(), info.getPrefId(), info.getTell(),
					info.getPhone(), info.getCareerId(), info.getCurry()));
		}
		return list;

	}
}
