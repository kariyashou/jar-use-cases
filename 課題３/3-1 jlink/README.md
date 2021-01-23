【jlinkコマンドの調査報告】
■機能概要
  モジュールに対して、実行時のイメージ（JVM）を軽量化するためのコマンド。
　
■コマンド使用方法
　--module-path,--add-moduleは必須のオプションで--add-moduleでモジュールをセットすることで
　そのモジュールに対して操作をするオプションが指定できる。
　そのほかは主要なものとしては、-Jというオプションでデバッガーを実行時に起動することができたりもします。
　outputというオプションでカレントディレクトリにoutputで指定した名称のディレクトリが作成される。

■jlinkを使用するメリット
　jdepsコマンドを使って依存関係を調べることで、jlinkを使い依存しているパッケージのみを使用する
　JVMを作成することでプログラムの軽量化される。
  
  C:\java>jdeps --list-deps test.aaa\test.aaa.jar
   java.base

  このコマンドで依存しているパッケージを調べ

　C:\java>jlink --module-path "C:\Program Files\Java\jdk-11.0.9\jmods" --add-modules java.base --output testjlink

  このコマンドで、モジュールに依存しているものだけを含んだJVMを作成する。
-----------------------------------------------------------------------------
　試験対象プログラム：test.aaa
　依存パッケージ：java.base
　【jlink実行前】

　     ●総ファイル数：6228

　【jlink実行後】

　     ●総ファイル数：92

  下記URL参照
　https://blogs.osdn.jp/2018/03/26/jre-minimize.html
-----------------------------------------------------------------------------
　
■調査にあたっての所感
このコマンドを実行については、エラーがなかなか消えず、WEBサイトで使用事例を探し回り試行錯誤を繰り返し
結果的に１．５日もの日数を費やしました。
それは、「--module-plath」オプションのフルパス指定時に、ダブルコーテーションが必要だったこと。
これまで学習したコマンドオプションでこのような例はなく、たまたま調べた参考サイトでも、ダブルコーテーションはついてませんでした。MACやLINUXではその必要がなく、Windowsだけの限定機能のようです。
また、-outputオプションについても、実在しているとエラーになる事もハマり、いい経験になりました。
これらエラーの原因追求には、○○オプションを明記することで、詳細なエラーが表示されることがわかりました。
デバッグの大切さを痛感しました。

jlink : javaが入っていない環境でも使える。JREを軽量化するためのもの


■jlinkを使った実行
jlinkの実行は少し癖があり、何度かエラーに直面したので記載しておきます。

①コマンドの際のパス指定

C:\java>jlink --compress=2 --module-path "C:\Program Files\Java\jdk-11.0.9\jmods:C:\java\test.aaa" --add-modules module.aaa --output testjlink5 --launcher myapp=module.aaa/test.aaa.aaa
エラー: Illegal char <:> at index 38: C:\Program Files\Java\jdk-11.0.9\jmods:C:\java\test.aaa

上記のモジュールの複数パス指定したかったが、複数パス指定のために使用した:(コロン)がエラーの
原因のようです。

②環境変数に新規でJAVA_HOME(jdk)へのルート

C:\java>jlink --compress=2 --module-path "%JAVA_HOME%\jmod:test.aaa" --add-modules module.aaa --output testjlink5 --launcher myapp=module.aaa/test.aaa.aaa
エラー: Illegal char <:> at index 37: C:\Program Files\Java\jdk-11.0.9\jmod::\java\test.aaa

上記では環境変数にJAVA＿HOMEを追加することでセパレーターのコロン以外を回避しようとしたが
実行時に展開され結局同じことになっていた。

解決策
C:\java>jlink --compress=2 --module-path "test.aaa" --add-modules module.aaa --output testjlink5 --launcher myapp=module.aaa/test.aaa.aaa

上記は解決したコードで、modsディレクトリは暗黙的に追加されているという情報からパスを省略しコロンを
なくすことで、実行へと至った。
これらの複雑な原因は、参考元のサイトの実行環境がwindowsではなくlinuxのものが多いためです。


参考URL
https://qiita.com/koduki/items/5a1b5e5da95a21935d18