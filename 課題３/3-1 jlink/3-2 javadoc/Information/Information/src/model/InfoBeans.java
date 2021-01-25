package model;

import java.io.Serializable;
import java.sql.Date;
/**
 * @author kariya
 * @version 13.0
 */
public class InfoBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id = 0;
	private String name;
	private String kanaName;
	private String email;
	private int sexId = 0;
	private Date birthday;
	private int marriageId = 0;
	private int bloodtypeId = 0;
	private int prefId = 0;
	private String tell;
	private String phone;
	private int careerId;
	private String curry;

	public InfoBeans() {
	}
	/**
	 * 
	 * @param id Int型の整数、DBのデータの一つ、プライマリキー
	 * @param name String型、DBのデータの一つ、名前が入る
	 * @param kanaName String型、DBのデータの一つ、フリガナが入る
	 * @param email String型、DBのデー、DBのデータの一つ、0または１が入るそれ以外は例外
	 * @param bloodtypeId int型の整数、、DBのデータの一つ、0または１または２または３が入るそれ以外は例外
	 * @param prefId int型の整数、、DBのデータの一つ、0から３６までが入る、それ以外は例外
	 * @param tell String型、DBのデータの一つ、電話番号が入るString型、DBのデータの一つ、電話番号が入る
	 * @param phone String型、DBのデータの一つ、携帯番号が入る
	 * @param careerId int型の整数、、DBのデータの一つ、０から３までが入る
	 * @param curry String型、DBのデータの一つ、文字列が入る
	 */
	public InfoBeans(int id, String name, String kanaName, String email, int sexId, Date birthday, int marriageId,
			int bloodtypeId, int prefId, String tell, String phone, int careerId, String curry) {
		this.id = id;
		this.name = name;
		this.kanaName = kanaName;
		this.email = email;
		this.sexId = sexId;
		this.birthday = birthday;
		this.marriageId = marriageId;
		this.bloodtypeId = bloodtypeId;
		this.prefId = prefId;
		this.tell = tell;
		this.phone = phone;
		this.careerId = careerId;
		this.curry = curry;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getKanaName() {
		return kanaName;
	}

	public String getEmail() {
		return email;
	}

	public int getSexId() {
		return sexId;
	}

	public Date getBirthday() {
		return birthday;
	}

	public int getMarriageId() {
		return marriageId;
	}

	public int getBloodtypeId() {
		return bloodtypeId;
	}

	public int getPrefId() {
		return prefId;
	}

	public String getTell() {
		return tell;
	}

	public String getPhone() {
		return phone;
	}

	public int getCareerId() {
		return careerId;
	}

	public String getCurry() {
		return curry;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSexId(int sexId) {
		this.sexId = sexId;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setMarriageId(int marriageId) {
		this.marriageId = marriageId;
	}

	public void setBloodtypeId(int bloodtypeId) {
		this.bloodtypeId = bloodtypeId;
	}

	public void setPrefId(int prefId) {
		this.prefId = prefId;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCareerId(int careerId) {
		this.careerId = careerId;
	}

	public void setCurry(String curry) {
		this.curry = curry;
	}

	@Override
	public String toString() {
		return "InfoBeans [id=" + id + ", name=" + name + ", kanaName=" + kanaName + ", email=" + email + ", sexId="
				+ sexId + ", birthday=" + birthday + ", marriageId=" + marriageId + ", bloodtypeId=" + bloodtypeId
				+ ", prefId=" + prefId + ", tell=" + tell + ", phone=" + phone + ", careerId=" + careerId + ", curry="
				+ curry + "]";
	}

}
