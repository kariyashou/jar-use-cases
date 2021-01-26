package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.InfoBeans;
import model.InfoLogic;
/**
 * @author kariya
 * @version 13.0
 */
public class SelectDAO {
	/** 
	 * DBへの接続を簡略化するための定数
	*/
	public static final String URL = "jdbc:postgresql://localhost:5432/information";
	public static final String USER = "postgres";
	public static final String PASS = "password";

	/** 
	 * 例外処理をこのクラスで処理するSQLExceptionやその他
	 * BeanクラスをつかいDB内のデータをオブジェクトとして抽出するためのメソッド
	 * @exception SQLException if (String型sqlの文法や値が正しくないとき)
	*/

	public List<InfoBeans> find() {
		Connection conn = null;
		List<InfoBeans> infoList = new ArrayList<InfoBeans>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			String sql = "SELECT * FROM status";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				System.out.println(id);
				String name = rs.getString("name");
				String kana = rs.getString("kana_name");
				String email = rs.getString("email");
				int sex = rs.getInt("sex_id");
				Date birthday = rs.getDate("birthday");
				int marriage = rs.getInt("marriage_id");
				int bloodtype = rs.getInt("bloodtype_id");
				int pref = rs.getInt("pref_id");
				String tell = rs.getString("tell");
				String phone = rs.getString("phone");
				int career = rs.getInt("career_id");
				String curry = rs.getString("curry");

				InfoBeans beans = new InfoBeans(id, name, kana, email, sex, birthday, marriage, bloodtype, pref, tell,
						phone, career, curry);
				infoList.add(beans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return infoList;
	}

	/** 
	 *  INSERT文にて引数（JSPからの入力）で指定した値をDBに追加するメソッド
	 * @param info InfoBeansで参照するlist
	 * @exception ClassNotFoundException　if (class.fornameの引数が正しくないとき)
	 * @exception SQLException if (String型sqlの文法や値が正しくないとき)
	*/
	public void addition(InfoBeans info) {
		SelectDAO select = new SelectDAO();
		List<InfoBeans> list = select.find();
		InfoLogic logic = new InfoLogic();
		Connection con = null;
		PreparedStatement st;
		int id = 0;
		try {
			id = logic.addition(list);
			con = DriverManager.getConnection(URL, USER, PASS);
			Class.forName("org.postgresql.Driver");
			String sql = ("INSERT INTO status(id,name,kana_name,email,sex_id,birthday,marriage_id,bloodtype_id,pref_id,tell,phone,career_id,curry) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.setString(2, info.getName());
			st.setString(3, info.getKanaName());
			st.setString(4, info.getEmail());
			st.setInt(5, info.getSexId());
			st.setDate(6, info.getBirthday());
			st.setInt(7, info.getMarriageId());
			st.setInt(8, info.getBloodtypeId());
			st.setInt(9, info.getPrefId());
			st.setString(10, info.getTell());
			st.setString(11, info.getPhone());
			st.setInt(12, info.getCareerId());
			st.setString(13, info.getCurry());
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * DELETE文にて引数（JSPからの入力）で指定した値（id）をDBから削除するメソッド
	 * @param id 削除したいデータのidを指定する、指定したint型をSQL文にして実行する
	 * @exception ClassNotFoundException　if (class.fornameの引数が正しくないとき)
	 * @exception SQLException if (String型sqlの文法や値が正しくないとき)
	 */
	public void delete(int id) {
		Connection con = null;
		PreparedStatement st;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
			String sql = "DELETE FROM status WHERE id = '" + id + "'";
			st = con.prepareStatement(sql);
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UPDATE文にて引数（JSPからの入力）で指定した値で該当するDBのデータを更新するメソッド戻り値はなし
	 * @param info InfoBeansで参照するlist
	 * @exception ClassNotFoundException　if (class.fornameの引数が正しくないとき)
	 * @exception SQLException if (String型sqlの文法や値が正しくないとき)
	 */
	public void change(InfoBeans info) {
		Connection con = null;
		PreparedStatement st;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
			String sql = ("UPDATE status SET name = ?,kana_name = ?,email = ?,sex_id = ?,birthday= ?,"
					+ "marriage_id = ?,bloodtype_id = ?,pref_id = ?,tell = ?,phone = ?,career_id = ?,curry = ?"
					+ "WHERE id = '" + info.getId() + "'");
			System.out.println(sql);
			st = con.prepareStatement(sql);
			st.setString(1, info.getName());
			st.setString(2, info.getKanaName());
			st.setString(3, info.getEmail());
			st.setInt(4, info.getSexId());
			st.setDate(5, info.getBirthday());
			st.setInt(6, info.getMarriageId());
			st.setInt(7, info.getBloodtypeId());
			st.setInt(8, info.getPrefId());
			st.setString(9, info.getTell());
			st.setString(10, info.getPhone());
			st.setInt(11, info.getCareerId());
			st.setString(12, info.getCurry());
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/** 
	 *  SELECT文にて引数（JSPからの入力）で指定した値をDBから抽出しリストにして変換するメソッド
	 * 入力条件に合わせてSQL文を組み立てていく（始） 下記のif分はjspからの入力データがnullまたは0かどうかを判定しそうでなかった場合に
	 * StringBuilderにappendする
	 * @param info InfoBeansで参照するlist
	 * @return list:infoに対してパラメータをsetし、別の新しいlistに対してaddし、
	 * それらを追加し終わったlistを戻り値として返す。
	 * @exception ClassNotFoundException　if (class.fornameの引数が正しくないとき)
	 * @exception SQLException if (String型sqlの文法や値が正しくないとき)
	*/
	public List<InfoBeans> search(InfoBeans info) {

		Connection con = null;
		StringBuilder sql = null;
		List<InfoBeans> list = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);

			sql = new StringBuilder("SELECT * FROM status WHERE 1=1");
			
			if (info.getId() != 0) {
				sql.append(" AND id = " + String.valueOf(info.getId()));
			}
			if (info.getName() != null) {
				sql.append(" AND name = " + "'" + String.valueOf(info.getName()) + "'");
			}
			if (info.getKanaName() != null) {
				sql.append(" AND kana_name = " + "'" + String.valueOf(info.getKanaName()) + "'");
			}
			if (info.getEmail() != null) {
				sql.append(" AND email = " + "'" + String.valueOf(info.getEmail()) + "'");
			}
			if (info.getSexId() != 0) {
				sql.append(" AND sex_id = " + String.valueOf(info.getSexId()));
			}
			if (info.getBirthday() != null) {
				sql.append(" AND birthday = " + "'" + info.getBirthday() + "'");
			}
			if (info.getMarriageId() != 0) {
				sql.append(" AND marriage_id = " + String.valueOf(info.getMarriageId()));
			}
			if (info.getBloodtypeId() != 0) {
				sql.append(" AND bloodtype_id = " + String.valueOf(info.getBloodtypeId()));
			}
			if (info.getPrefId() != 0) {
				sql.append(" AND pref_id = " + String.valueOf(info.getPrefId()));
			}
			if (info.getTell() != null) {
				sql.append(" AND tell = " + "'" + String.valueOf(info.getTell()) + "'");
			}
			if (info.getPhone() != null) {
				sql.append(" AND phone = " + "'" + String.valueOf(info.getPhone()) + "'");
			}
			if (info.getCareerId() != 0) {
				sql.append(" AND career_id = " + String.valueOf(info.getCareerId()));
			}
			if (info.getCurry() != null) {
				sql.append(" AND curry = " + "'" + String.valueOf(info.getCurry()) + "'");
			}
			sql.append(" ORDER BY id ASC");

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

				list.add(new InfoBeans(info.getId(), info.getName(), info.getKanaName(), info.getEmail(),
						info.getSexId(), info.getBirthday(), info.getMarriageId(), info.getBloodtypeId(),
						info.getPrefId(), info.getTell(), info.getPhone(), info.getCareerId(), info.getCurry()));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * idを引数にDB内にそのidが存在しているのか調べるメソッド
	 * @param id infobeansのidを指している。SQL側からパラメータをもらうのでString型
	 * @return list内に同じ文字列がない場合true,ある場合はfalseを返す。
	 * @exception NumberFormatException if (変数idIntが正常にInt型に変換できなかった場合)
	 */
	public boolean idCheck(String id) {
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

	/**
	 * 各機能ごとのメソッドの処理の中で最後にソートする処理をするメソッド
	 * @return list:infoに対してパラメータをsetし、別の新しいlistに対してaddし、
	 * それらを追加し終わったlistを戻り値として返す。
	 * @exception ClassNotFoundException　if (class.fornameの引数が正しくないとき)
	 * @exception SQLException if (String型sqlの文法や値が正しくないとき)
	 * 
	 */
	public List<InfoBeans> sort() {
		Connection con = null;
		List<InfoBeans> list = new ArrayList<>();
		InfoBeans info = new InfoBeans();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
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

				list.add(new InfoBeans(info.getId(), info.getName(), info.getKanaName(), info.getEmail(),
						info.getSexId(), info.getBirthday(), info.getMarriageId(), info.getBloodtypeId(),
						info.getPrefId(), info.getTell(), info.getPhone(), info.getCareerId(), info.getCurry()));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
