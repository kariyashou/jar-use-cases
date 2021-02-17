tomcatディレクトリ構造

	tomcat8.5 - bin : 実行ファイル

		  - conf : 設定ファイル

		  - lib : API

		  - logs : ログファイル

		  - temp : 一時ファイル

		  - webapps : プログラムファイル(ここにwebアプリケーションが入る）

		  - work : 作業ファイル


tomcat管理画面でできること

まず、管理画面の機能を使うためにtomcat/conf内にあるtomcat - users.xmlに管理者ユーザーを作成する

以下コード
 <role rolename="manager-gui"/>
 <user username="hoge" password="hoge" roles="manager-gui"/>

ここではサーバーの状態の確認と
webapps内のディレクトリの管理ができる
現在あるディレクトリを編集したり、新たに追加したりできる
おそらくアプリケーションマネージャーが主要な機能
アプリケーションマネージャーではtomcat内のwebapps内のディレクトリ（WEBアプリケーション）を
管理でき、配置もここで行うことができる。自身でtomcatのwebapps内に設置しても同じようだ

今回行ったこと
１：新規に簡単なサーブレットを作ってコンパイル

	言わずもがなservletクラスは外部ライブラリなので-cpでのパス指定が必要
　　　　今回から使用するweb.xmlというものが必要、web.xmlに対してサーブレットをタグで登録する
	これをしなければ作ったサーブレットは見えない
	下記がコンパイル時の該当コード

javac -cp "C:\Program Files\Apache Software Foundation\Tomcat 8.5\lib\servlet-api.jar;
C:\Program Files\Apache Software Foundation\Tomcat 8.5\webapps\testservlet\WEB-INF\classes\testservlet" TestServlet.java

※webアプリケーションを作る際は、必ず入り口となるindex.htmlを用意する

２：warファイルに変換

	ここが少しはまったポイント、ここではjarコマンドを使ってwarを作成する
	使用するオプションはc(アーカイブ作成) v(結果表示) f(出力ファイル名) C(入力するディレクトリ)
	ここで注意すべきなのがCオプション、これはなぜか最後に（スペース）/.が必要
	カレントは指定するディレクトリの親ディレクトリにすると簡単
	下記該当コード

c:\java>jar -Mcf testservlet.war -C testservlet /.

３：tomcatアプリケーションマネージャーで作成したwarを配置

	warを配置すると自動的にtomcatのwebapps内に対象warが展開される
	localhost:8080/対象アプリケーション名を入力するとindex.htmlが開かれる
	このhtmlを入り口にしてサーブレットなどとつなげる。
