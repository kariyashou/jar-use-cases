<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索処理</title>
</head>
<body>
	<jsp:include page="./Header.jsp" />
	<p>検索する項目にデータを入力してください</p>
	<form action="SearchServlet" method="post">
		<table>
			<tr>
				<th>ID</th>
				<th>氏名</th>
				<th>カナ</th>
				<th>メール</th>
				<th>性別</th>
				<th>誕生日</th>
				<th>婚約</th>
				<th>性別</th>
			</tr>
			<tr>
				<td><div class="id">
						<input type="text" name="id" placeholder="半角数字">
					</div></td>
				<td><div class="name">
						<input type="text" name="name" placeholder="山田 太郎(例)">
					</div></td>
				<td><div class="kana">
						<input type="text" name="kana" placeholder="全角カナ">
					</div></td>
				<td><div class="email">
						<input type="text" name="email" placeholder="yamada@aa.bb.cc(例)">
					</div></td>
				<td><div class="sex">
						<select id="sex" name="sex">
							<option value=0></option>
							<option value=1>男</option>
							<option value=2>女</option>
						</select>
					</div></td>
				<td><div class="birthday">
						<input type="text" name="birthday" placeholder="2020/01/01(例)">
					</div></td>
				<td><div class="marriage">
						<select id="marriage" name="marriage">
							<option value=0></option>
							<option value=1>既婚</option>
							<option value=2>未婚</option>
						</select>
					</div></td>
				<td><div class="blood">
						<select id="blood" name="blood">
							<option value=0></option>
							<option value=1>A</option>
							<option value=2>B</option>
							<option value=3>O</option>
							<option value=4>AB</option>
						</select>
					</div></td>
			</tr>
		</table>
		<table>
			<tr>
				<th>都道府県</th>
				<th>電話</th>
				<th>携帯</th>
				<th>キャリア</th>
				<th>カレーの食べ方</th>
			</tr>
			<tr>
				<td><div class="pref">
						<select id="pref" name="pref">
							<option value=0></option>
							<option value=1>北海道</option>
							<option value=2>青森県</option>
							<option value=3>岩手県</option>
							<option value=4>宮城県</option>
							<option value=5>秋田県</option>
							<option value=6>山形県</option>
							<option value=7>福島県</option>
							<option value=8>茨城県</option>
							<option value=9>栃木県</option>
							<option value=10>群馬県</option>
							<option value=11>埼玉県</option>
							<option value=12>千葉県</option>
							<option value=13>東京都</option>
							<option value=14>神奈川県</option>
							<option value=15>新潟県</option>
							<option value=16>富山県</option>
							<option value=17>石川県</option>
							<option value=18>福井県</option>
							<option value=19>山梨県</option>
							<option value=20>長野県</option>
							<option value=21>岐阜県</option>
							<option value=22>静岡県</option>
							<option value=23>愛知県</option>
							<option value=24>三重県</option>
							<option value=25>滋賀県</option>
							<option value=26>京都府</option>
							<option value=27>大阪府</option>
							<option value=28>兵庫県</option>
							<option value=29>奈良県</option>
							<option value=30>和歌山県</option>
							<option value=31>鳥取県</option>
							<option value=32>島根県</option>
							<option value=33>岡山県</option>
							<option value=34>広島県</option>
							<option value=35>山口県</option>
							<option value=36>徳島県</option>
							<option value=37>香川県</option>
							<option value=38>愛媛県</option>
							<option value=39>高知県</option>
							<option value=40>福岡県</option>
							<option value=41>佐賀県</option>
							<option value=42>長崎県</option>
							<option value=43>熊本県</option>
							<option value=44>大分県</option>
							<option value=45>宮崎県</option>
							<option value=46>鹿児島県</option>
							<option value=47>沖縄県</option>
						</select>
					</div></td>
				<td><div class="tell">
						<input type="text" name="tell" maxlength="10"
							placeholder="0123456789(例１０桁)">
					</div></td>
				<td><div class="phone">
						<input type="text" name="phone" maxlength="11"
							placeholder="01234567890(例１1桁)">
					</div></td>
				<td><div class="career">
						<select id="career" name="career">
							<option value=0></option>
							<option value=1>ドコモ</option>
							<option value=2>ソフトバンク</option>
							<option value=3>エーユー</option>
							<option value=4>ツーカー</option>
						</select>
					</div></td>
				<td><div class="curry">
						<input type="text" name="curry">
					</div></td>
			</tr>
		</table>
		<input type="submit" value="検索">
	</form>
</body>
</html>