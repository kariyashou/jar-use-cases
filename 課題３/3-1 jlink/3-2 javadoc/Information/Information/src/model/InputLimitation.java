package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//それぞれの入力項目に対しての条件指定クラス
public class InputLimitation {
	//入力された文字がカタカナか判定するメソット
	public boolean isKana(String string) {
		Pattern pattern = Pattern.compile("^[ァ-ヶー]*$");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	//入力されたメールアドレスが正しいものか判別するメソット
	public boolean isMail(String string) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	//入力された電話番号の桁数をチェックするメソット
	public boolean isTell(String string) {
		Pattern pattern = Pattern.compile("[0-9]{10}");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	//入力された携帯番号の桁数をチェックするメソット
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
