1-1　mainメソッドを含むパッケージ化されたクラスをjarにして実行する

	実行コード:java -cp test\TestJar.jar TestJar


1-2 モジュール化されたパッケージのクラスをjarにして実行する

	実行コード:java -cp main\main.dd.TempC.jar -p sub;main -m module.main/main.dd.TempC


1-3 jarを拡張ディレクトリに置いてクラスパスオプション無しでクラスを実行する

	※過去バージョンで拡張ディレクトリが廃止されていたためなし


1-4 実行可能なjar(executable jar)を作ってクラス指定なしで実行する

	実行コード:jar -cvfm TestJar.jar manifest.mf *.class
	マニフェストファイルを指定してjarファイルを作成

	実行コード:java -jar TestJar.jar
	実行コマンド
	