コマンド実行例

1.jabswitch
	｜実行するとオンオフとバージョンのオプションが表示される。
----------------------------------------------------------
C:\Users\owner>jabswitch

jabswitch [/enable | /disable | /version | /?]

Description:
  jabswitch enables or disables the Java Access Bridge.

Parameters:
  /enable   Enable the Java Accessibility Bridge.
  /disable  Disable the Java Accessibility Bridge.
  /version  Display the version.
  /?        Display this usage information.

Note:
  The Java Access Bridge can also be enabled with the
  Windows Ease of Access control panel (which can be
  activated by pressing Windows + U).  The Ease of Access
  control panel has a Java Access Bridge checkbox.  Please
  be aware that unchecking the checkbox has no effect and
  in order to disable the Java Access Bridge you must run
  jabswitch.exe from the command line.
----------------------------------------------------------
2.jaccessinspector
	｜実行すると５つのメニューがあるタブが表示される
	｜フォーカスの変更、マウスの移動、プロパティ変更
	｜メニュー選択、ポップアップ・メニューの表示
	｜といったイベントが発生した場合、
	｜マウスがオブジェクト上にあるときに[F1]キーを
	｜押した場合またはマウスがウィンドウ上にあるときに
	｜[F2]キーを押した場合アクセシビリティ情報を
	｜調べられる。
	｜アクセシビリティ（Accessibility）は
	｜「利用のしやすさ」のこと。
----------------------------------------------------------
C:\Users\owner>jaccessinspector
----------------------------------------------------------
3.jaccesswalker
	｜実行すると２つのメニューがあるタブが表示される。
	｜jaccesswalkerツールは、オブジェクトに関する
	｜アクセシビリティ情報をウィンドウに表示します。
----------------------------------------------------------
C:\Users\owner>jaccesswalker
----------------------------------------------------------
4.jaotc 
	｜windowsでは実行できないようです。
	｜
----------------------------------------------------------
C:\Users\owner>jaotc
Usage: jaotc <options> list

  list       A : separated list of class names, modules, jar files
             or directories which contain class files.

where options include:
  --output <file>            Output file name
  --class-name <class names> List of classes to compile
  --jar <jarfiles>           List of jar files to compile
  --module <modules>         List of modules to compile
  --directory <dirs>         List of directories where to search for files to compile
  --search-path <dirs>       List of directories where to search for specified files
  --compile-commands <file>  Name of file with compile commands
  --compile-for-tiered       Generate profiling code for tiered compilation
  --compile-with-assertions  Compile with java assertions
  --compile-threads <number> Number of compilation threads to be used
  --ignore-errors            Ignores all exceptions thrown during class loading
  --exit-on-error            Exit on compilation errors
  --info                     Print information during compilation
  --verbose                  Print verbose information
  --debug                    Print debug information
  -? -h --help               Print this help message
  --version                  Version information
  --linker-path              Full path to linker executable
  -J<flag>                   Pass <flag> directly to the runtime system	

----------------------------------------------------------
5.jar
	｜複数のクラスファイルをまとめることができる
----------------------------------------------------------
C:\java>javac Test.java

C:\java>jar -cvf Test.jar *.class
マニフェストが追加されました
Test.classを追加中です(入=182)(出=153)(15%収縮されました)
----------------------------------------------------------
6.jarsigner
	｜JARファイルの署名および検証をする
----------------------------------------------------------
C:\java>jarsigner -verify Test.jar

jarは署名されていません。
----------------------------------------------------------
7.java
	｜Javaアプリケーションの起動時に実行する
----------------------------------------------------------
C:\java>java Test
ok
----------------------------------------------------------
8.javac
	｜クラスファイルにコンパイルする。
----------------------------------------------------------
C:\java>javac Test.java

C:\java>
----------------------------------------------------------
9.javadoc
	｜APIドキュメントのHTMLページを生成する。
----------------------------------------------------------
C:\java>javadoc Test.java
ソース・ファイルTest.javaを読み込んでいます...
Javadoc情報を構築しています...
標準Docletバージョン15+36-1562
全パッケージとクラスの階層ツリーを作成しています...
Test.java:1: 警告:コメントなし
public class Test{
       ^
.\Test.htmlの生成中...
Test.java:2: 警告:コメントなし
    public static void main(String[]args){
                       ^
.\package-summary.htmlの生成中...
.\package-tree.htmlの生成中...
.\constant-values.htmlの生成中...
.\overview-tree.htmlの生成中...
.\deprecated-list.htmlの生成中...
全パッケージとクラスのインデックスを作成しています...
.\index-all.htmlの生成中...
全クラスのインデックスを作成しています...
.\allclasses-index.htmlの生成中...
.\allpackages-index.htmlの生成中...
.\index.htmlの生成中...
.\help-doc.htmlの生成中...
警告2個
----------------------------------------------------------
10.javap
	｜1つ以上のクラス・ファイルを
	｜逆アセンブルする場合に使用します。
----------------------------------------------------------
C:\java>javap Test.class
Compiled from "Test.java"
public class Test {
  public Test();
  public static void main(java.lang.String[]);
}
----------------------------------------------------------
11.javaw
	｜コンソール・ウィンドウがないjavaコマンド。
----------------------------------------------------------
C:\java>javaw Test

C:\java>
----------------------------------------------------------
12.jcmd
	｜実行中のJava仮想マシン(JVM)に診断コマンド要求を
	｜送信する。
----------------------------------------------------------
C:\java>jcmd
11012 jdk.jcmd/sun.tools.jcmd.JCmd
----------------------------------------------------------
13.jconsole
	｜グラフィカル・コンソールを開始します。
----------------------------------------------------------
C:\java>jconsole

C:\java>
----------------------------------------------------------
14.jdb
	｜バグを見つけて修正するために使用するツールです。
----------------------------------------------------------
jdb -help
使用方法: jdb <options> <class> <arguments>

オプションは次のとおりです:
    -? -h --help -help このヘルプ・メッセージを出力して終了する
    -sourcepath <directories separated by ";">
                      ソース・ファイルを検索するディレクトリ
    -attach <address>
                      標準コネクタを使用して、指定されたアドレスで実行中のVMに接続する
    -listen <address>
                      標準コネクタを使用して、指定されたアドレスで実行中のVMの接続を待機する
    -listenany
                      標準コネクタを使用して、使用可能な任意のアドレスで実行中のVMの接続を待機する
    -launch
                      'run'コマンドを待機せずにVMを即時に起動する
    -listconnectors   このVMで使用可能なコネクタをリストする
    -connect <connector-name>:<name1>=<value1>,...
                      指定されたコネクタを使用して、リストされた引数値でターゲットVMに接続する
    -dbgtrace [flags] jdbのデバッグの情報を出力する
    -tclient          アプリケーションをHotSpot(TM) Client Compilerで実行する
    -tserver          アプリケーションをHotSpot(TM) Server Compilerで実行する

オプションはデバッグするプロセスに転送されます:
    -v -verbose[:class|gc|jni]
                      詳細モードをオンにする
    -D<name>=<value>  システム・プロパティを設定する
    -classpath <directories separated by ";">
                      クラスを検索するディレクトリをリストする
    -X<option>        非標準のターゲットVMオプション

<class>はデバッグを開始するクラスの名前です
<arguments>は<class>のmain()メソッドに渡される引数です

コマンドのヘルプについてはjdbプロンプトで'help'を入力してください

----------------------------------------------------------
15.jdeprscan
	｜jarファイル(またはクラス・ファイルの他の集合)を
	｜スキャンする静的分析ツール。
----------------------------------------------------------
C:\Users\owner>jdeprscan c:\java\Test.jar
JARファイル c:\java\Test.jar:
----------------------------------------------------------
16.jdeps
	｜依存関係アナライザを起動する場合に使用します。
----------------------------------------------------------
C:\java>jdeps aa
aa -> java.base
   main.dd              -> java.io                      java.base
   main.dd              -> java.lang                    java.base
   main.dd              -> sub.bb                       aa
   main.dd              -> sub.ee                       aa
   sub.bb               -> java.io                      java.base
   sub.bb               -> java.lang                    java.base
   sub.bb               -> sub.cc                       aa
   sub.bb               -> sub.ee                       aa
   sub.cc               -> java.lang                    java.base
   sub.cc               -> sub.ee                       aa
   sub.ee               -> java.lang                    java.base