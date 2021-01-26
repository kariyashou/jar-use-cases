package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * それぞれの入力項目に対しての条件指定クラス
 * @author kariya
 * @version 13.0
 */
public class InputLimitation {
	/**
	 * 入力された文字がカタカナか判定するメソット
	 * @param string DBから抽出したデータ（フリガナ）
	 * @return 文字列がカタカナのみの場合trueをreturnする
	 * 違う場合はfalseが返される。
	 */
	public boolean isKana(String string) {
		Pattern pattern = Pattern.compile("^[ァ-ヶー]*$");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 入力されたメールアドレスが正しいものか判別するメソット
	 * @param string DBから抽出したデータ（メール）
	 * @return 文字列に英小文字大文字数字以外が含まれていたらfalseそれ以外はtrue
	 */
	public boolean isMail(String string) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 入力された電話番号の桁数をチェックするメソット
	 * @param string DBから抽出したデータ（電話番号）
	 * @return 数字のみ10文字以内で構成されている場合はtrue,
	 * それ以外はfalse
	 */
	public boolean isTell(String string) {
		Pattern pattern = Pattern.compile("[0-9]{10}");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 入力された携帯番号の桁数をチェックするメソット
	 * @param string DBから抽出したデータ（携帯番号）
	 * @return 数字のみ11文字以内で構成されている場合はtrue,
	 * それ以外はfalse
	 */
	public boolean isPhone(String string) {
		Pattern pattern = Pattern.compile("[0-9]{11}");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
}
