コマンド実行例
△:理解できてない ※:土曜日聞くところ
×:なし
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
   main.dd              -> java.io            java.base
   main.dd              -> java.lang          java.base
   main.dd              -> sub.bb             aa
   main.dd              -> sub.ee             aa
   sub.bb               -> java.io            java.base
   sub.bb               -> java.lang          java.base
   sub.bb               -> sub.cc             aa
   sub.bb               -> sub.ee             aa
   sub.cc               -> java.lang          java.base
   sub.cc               -> sub.ee             aa
   sub.ee               -> java.lang          java.base
----------------------------------------------------------
※17.jfr
	｜実行中のJavaアプリケーションの診断ができる
	｜※実際に実行しようとしたがOracleにサンプルがなく
	｜使用例を見つけたが、今の自分には少し難しすぎたので
	｜飛ばします
	｜https://qiita.com/KevinFQ/items/74478bcf77839ebc7142
----------------------------------------------------------
C:\Users\owner>jfr
Tool for working with Flight Recorder files (.jfr)

Before using this tool, you must have a recording file.
A file can be created by starting a recording from command line:

 java -XX:StartFlightRecording:filename=recording.jfr,duration=30s ...

A recording can also be started on already running Java Virtual Machine:

 jcmd (to list available pids)
 jcmd <pid> JFR.start

Recording data can be dumped to file using the JFR.dump command:

 jcmd <pid> JFR.dump filename=recording.jfr

The contents of the recording can then be printed, for example:

 jfr print recording.jfr

 jfr print --events CPULoad,GarbageCollection recording.jfr

 jfr print --json --events CPULoad recording.jfr

 jfr print --categories "GC,JVM,Java*" recording.jfr

 jfr print --events "jdk.*" --stack-depth 64 recording.jfr

 jfr summary recording.jfr

 jfr metadata recording.jfr

For more information about available commands, use 'jfr help'
----------------------------------------------------------
18.jhsdb
	｜コマンドそのものはデバッグに使うようで
	｜そのままじっこうすると下のようなオプションが
	｜表示される。
----------------------------------------------------------
C:\Users\owner>jhsdb
    clhsdb              command line debugger
    hsdb                ui debugger
    debugd --help       to get more information
    jstack --help       to get more information
    jmap   --help       to get more information
    jinfo  --help       to get more information
    jsnap  --help       to get more information

C:\Users\owner>
----------------------------------------------------------
？19.jimage
	｜jimage.exeとしてあるのに検索に一切出てこない
	｜image というクラスが検索にかかる
	｜実際にコマンドを入力してみると下記のような表示
----------------------------------------------------------
C:\Users\owner>jimage
Usage: jimage <extract | info | list | verify> <options> jimage...
use -h or --help for a list of possible options.

C:\Users\owner>
----------------------------------------------------------
※20.jinfo
	｜-flagというコマンドを使うと値が設定できるようです。
	｜jinfo -flagコマンドを使用すると、指定されたJavaプロセス
	｜の特定のJava VMフラグの値を動的に設定、
	｜設定解除または変更できます。
----------------------------------------------------------
C:\Users\owner>jinfo c:\java\Test.java
Could not find any processes matching : 'c:\java\Test.java'

C:\Users\owner>jinfo c:\java\Test
Could not find any processes matching : 'c:\java\Test'

C:\Users\owner>jinfo -h
Usage:
    jinfo <option> <pid>
       (to connect to a running process)

where <option> is one of:
    -flag <name>         to print the value of the named VM flag
    -flag [+|-]<name>    to enable or disable the named VM flag
    -flag <name>=<value> to set the named VM flag to the given value
    -flags               to print VM flags
    -sysprops            to print Java system properties
    <no option>          to print both VM flags and system properties
    -? | -h | --help | -help to print this help message

C:\Users\owner>
----------------------------------------------------------
×21.jjsはオラクルにはあるがjdk15のbin内を見たらなかった
ので誤りです。
----------------------------------------------------------
※22.jlink
----------------------------------------------------------
C:\Users\owner>jlink -h
使用方法: jlink <options> --module-path <modulepath> --add-modules <module>[,<module>...]
使用可能なオプションには次のものがあります:
      --add-modules <mod>[,<mod>...]    初期モジュールに加えて解決するルート・モジュール。
                                        <mod>はALL-MODULE-PATHにすることもできます。
      --bind-services                   サービス・プロバイダ・モジュールとその依存性
                                        内でリンクします
  -c, --compress=<0|1|2>                Enable compression of resources:
                                          Level 0: No compression
                                          Level 1: Constant string sharing
                                          Level 2: ZIP
      --disable-plugin <pluginname>     Disable the plugin mentioned
      --endian <little|big>             生成されたjimage
                                        (default:native)のバイト順
  -h、--help、-?                        このヘルプ・メッセージを出力します
      --ignore-signing-information      署名済モジュラJARがイメージにリンク
                                        されている場合、致命的エラーを抑止
                                        します。署名済モジュラJARの署名関連
                                        ファイルは、ランタイム・イメージにコピー
                                        されません。
      --launcher <name>=<module>[/<mainclass>]
                                        モジュールおよびメイン・クラス(指定した場合)に
                                        指定された名前の起動ツール・コマンドを
                                        追加します
      --limit-modules <mod>[,<mod>...]  参照可能なモジュールの領域を制限します
      --list-plugins                    List available plugins
  -p, --module-path <path>              モジュール・パス。
                                        指定されていない場合、JDKのjmodsディレクトリ
                                        が使用されます(存在する場合)。指定されて
                                        いるがjava.baseモジュールを含まない場合は、
                                        JDKのjmodsディレクトリが追加されます
                                        (存在する場合)。
      --no-header-files                 Exclude include header files
      --no-man-pages                    Exclude man pages
      --output <path>                   出力パスの場所
      --post-process-path <imagefile>   Post process an existing image
      --resources-last-sorter <name>    The last plugin allowed to sort
                                        resources
      --save-opts <filename>            指定のファイルにjlinkオプションを保存します
  -G, --strip-debug                     Strip debug information
      --suggest-providers [<name>,...]  モジュール・パスから指定のサービス・タイプを
                                        実装するプロバイダを推奨します
  -v、--verbose                         詳細なトレースを有効にします
      --version                         バージョン情報
      @<filename>                       ファイルからオプションを読み取ります
----------------------------------------------------------
※23.jmap
	｜指定されたプロセスの詳細を出力する場合に使用します。
----------------------------------------------------------
C:\Users\owner>jmap
Usage:
    jmap -clstats <pid>
        to connect to running process and print class loader statistics
    jmap -finalizerinfo <pid>
        to connect to running process and print information on objects awaiting finalization
    jmap -histo[:[<histo-options>]] <pid>
        to connect to running process and print histogram of java object heap
    jmap -dump:<dump-options> <pid>
        to connect to running process and dump java heap
    jmap -? -h --help
        to print this help message

    dump-options:
      live         dump only live objects
      all          dump all objects in the heap (default if one of "live" or "all" is not specified
      format=b     binary format
      file=<file>  dump heap to <file>

    Example: jmap -dump:live,format=b,file=heap.bin <pid>

    histo-options:
      live         count only live objects
      all          count all objects in the heap (default if one of "live" or "all" is not specified)
      file=<file>  dump data to <file>

    Example: jmap -histo:live,file=/tmp/histo.data <pid>

C:\Users\owner>
----------------------------------------------------------
※24.jmod
	｜jmodファイルを作成したりそれらに対して操作を行う。
----------------------------------------------------------
C:\Users\owner>jmod --class-path c:\java\Test.jar
エラー: create、extract、list、describeまたはhashのいずれかを指定する必要があります
使用方法: jmod (create|extract|list|describe|hash) <OPTIONS> <jmod-file>
使用可能なオプションのリストについては、--helpを使用します

C:\Users\owner>jmod create --class-path c:\java\Test.jar
エラー: jmod-fileを指定する必要があります
使用方法: jmod (create|extract|list|describe|hash) <OPTIONS> <jmod-file>
使用可能なオプションのリストについては、--helpを使用します

C:\Users\owner>jmod -help
使用方法: jmod (create|extract|list|describe|hash) <OPTIONS> <jmod-file>

メイン操作モード:
  create    - 新規のjmodアーカイブを作成します
  extract   - アーカイブからすべてのファイルを抽出します
  list      - すべてのエントリの名前を出力します
  describe  - モジュールの詳細を出力します
  hash      - モジュールのハッシュを記録します。

 Option                              Description
 ------                              -----------
  -?, -h, --help                      このヘルプ・メッセージを出力します
  --class-path <path>                 クラスを含むアプリケーションjarファイル|ディレクトリ
  --cmds <path>                       ネイティブ・コマンドの場所
  --config <path>                     ユーザーが編集可能な構成ファイルの場所
  --dir <path>                        抽出のターゲット・ディレクトリ
  --dry-run                           ハッシュ・モードの試験的な実行
  --exclude <pattern-list>            各要素が次の形式のいずれかを使用する、指定されたカンマ区切りパターン・リストに
                                        一致するファイルを除外します: <glob-pattern>、glob:
                                        <glob-pattern>またはregex:<regex-
                                        pattern>
  --hash-modules <regex-pattern>      指定の<regex-pattern>に一致し、直接または間接的に依存しているモ
                                        ジュールでパッケージ・モジュールを結合するハッシュを計算および記録します。
                                        ハッシュは、作成されているJMODファイル、jmod hashコマンドで指
                                        定したモジュール・パスのJMODファイルまたはモジュラJARに記録されま
                                        す。
  --header-files <path>               ヘッダー・ファイルの場所
  --help-extra                        追加オプションのヘルプを出力します
  --legal-notices <path>              法律上の注意点の場所
  --libs <path>                       ネイティブ・ライブラリの場所
  --main-class <String: class-name>   メイン・クラス
  --man-pages <path>                  manページの場所
  --module-version <module-version>   モジュール・バージョン
  -p, --module-path <path>            モジュール・パス
  --target-platform <String: target-  ターゲット・プラットフォーム
    platform>
  --version                           バージョン情報
  @<filename>                         指定したファイルからオプションを読み取ります

C:\Users\owner>
----------------------------------------------------------
25.jps
	｜システム上で計測されたJVMをリストする
----------------------------------------------------------
C:\Users\owner>jps
8596 Jps

C:\Users\owner>jps -help
usage: jps [--help]
       jps [-q] [-mlvV] [<hostid>]

Definitions:
    <hostid>:      <hostname>[:<port>]
    -? -h --help -help: Print this help message and exit.

C:\Users\owner>
----------------------------------------------------------
※26.jrunscript
	｜スクリプトファイルというものを指定しなければ
	｜ならないようですがスクリプトファイルが調べても
	｜理解できない
----------------------------------------------------------
27.jshell
	｜このツールでは分や式を実行できるようです。
----------------------------------------------------------
C:\Users\owner>jshell
|  JShellへようこそ -- バージョン15
|  概要については、次を入力してください: /help intro

jshell>

jshell>

jshell> System.out.println("hello world")
hello world

jshell>
----------------------------------------------------------
※28.jstack

https://www.techscore.com/blog/2018/12/13/java-process-thread-study/#Process
----------------------------------------------------------
C:\java>java ProcessTest
java.io.IOException: Cannot run program "ps": CreateProcess error=2, 指定されたファイルが見つかりません。
        at java.base/java.lang.ProcessBuilder.start(ProcessBuilder.java:1142)
        at java.base/java.lang.ProcessBuilder.start(ProcessBuilder.java:1073)
        at ProcessTest.main(ProcessTest.java:8)
Caused by: java.io.IOException: CreateProcess error=2, 指定されたファイルが見つかりません。
        at java.base/java.lang.ProcessImpl.create(Native Method)
        at java.base/java.lang.ProcessImpl.<init>(ProcessImpl.java:483)
        at java.base/java.lang.ProcessImpl.start(ProcessImpl.java:158)
        at java.base/java.lang.ProcessBuilder.start(ProcessBuilder.java:1109)
        ... 2 more

C:\java>jstack ProcessTest
Could not find any processes matching : 'ProcessTest'

C:\java>jstack ProcessTest.java
Could not find any processes matching : 'ProcessTest.java'

C:\java>jstack ProcessTest.class
Could not find any processes matching : 'ProcessTest.class'

C:\java>
----------------------------------------------------------
※29.jstat
----------------------------------------------------------
C:\java>jstat -gcutil
invalid argument count
Usage: jstat --help|-options
       jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]

Definitions:
  <option>      An option reported by the -options option
  <vmid>        Virtual Machine Identifier. A vmid takes the following form:
                     <lvmid>[@<hostname>[:<port>]]
                Where <lvmid> is the local vm identifier for the target
                Java virtual machine, typically a process id; <hostname> is
                the name of the host running the target Java virtual machine;
                and <port> is the port number for the rmiregistry on the
                target host. See the jvmstat documentation for a more complete
                description of the Virtual Machine Identifier.
  <lines>       Number of samples between header lines.
  <interval>    Sampling interval. The following forms are allowed:
                    <n>["ms"|"s"]
                Where <n> is an integer and the suffix specifies the units as
                milliseconds("ms") or seconds("s"). The default units are "ms".
  <count>       Number of samples to take before terminating.
  -J<flag>      Pass <flag> directly to the runtime system.
  -? -h --help  Prints this help message.
  -help         Prints this help message.

C:\java>
----------------------------------------------------------
※30.jstatd
----------------------------------------------------------
C:\java>jstatd -J-Djava.security.policy=all.policy
Could not create remote object
java.security.AccessControlException: access denied ("java.util.PropertyPermission" "java.rmi.server.ignoreSubClasses" "write")
        at java.base/java.security.AccessControlContext.checkPermission(AccessControlContext.java:472)
        at java.base/java.security.AccessController.checkPermission(AccessController.java:1036)
        at java.base/java.lang.SecurityManager.checkPermission(SecurityManager.java:408)
        at java.base/java.lang.System.setProperty(System.java:911)
        at jdk.jstatd/sun.tools.jstatd.Jstatd.main(Jstatd.java:153)

C:\java>
----------------------------------------------------------
31.keytool
https://www.qoosky.io/techs/9db75cec15
----------------------------------------------------------
C:\java>keytool -genkeypair -keystore mykeystore.jks -alias mykeypair -v -keyalg RSA -keysize 2048 -validity 36500
キーストアのパスワードを入力してください:
新規パスワードを再入力してください:
一致しません。もう一度実行してください
キーストアのパスワードを入力してください:
キーストアのパスワードが短すぎます - 6文字以上にしてください
キーストアのパスワードを入力してください:
キーストアのパスワードが短すぎます - 6文字以上にしてください
障害が多すぎます - 後で実行してください

C:\java>
----------------------------------------------------------
△32.kinit
	｜kinitツールとそのオプションは、Kerberosチケット認可チケットを取得およびキャッシュする場合に使用します。
https://docs.oracle.com/javase/jp/11/tools/kinit.html#GUID-8AA6A058-419A-41D4-A61E-E5E1911E51E6
----------------------------------------------------------
C:\java>kinit [-A] [-f] [-p] [-c cache_name] [-l lifetime] [-r renewable_time] [[-k [-t keytab_file_name]] [principal] [password]
Exception: invalid Principal name: [-A]KrbException: Cannot locate default realm
java.lang.IllegalArgumentException: invalid Principal name: [-A]KrbException: Cannot locate default realm
        at java.security.jgss/sun.security.krb5.internal.tools.KinitOptions.<init>(KinitOptions.java:154)
        at java.security.jgss/sun.security.krb5.internal.tools.Kinit.<init>(Kinit.java:130)
        at java.security.jgss/sun.security.krb5.internal.tools.Kinit.main(Kinit.java:96)

C:\java>
----------------------------------------------------------
△33.klist
	｜klistツールは、ローカルの資格キャッシュおよびキー表のエントリを表示します。
https://docs.oracle.com/javase/jp/11/tools/klist.html#GUID-205BCE0D-F5D4-4A9C-ACBC-46423BAF616F
----------------------------------------------------------
C:\java>klist [ [-c] [-f] [-e] [-a [-n]] ] [-k [-t] [-K] ] [name] [-help]]

使用法: klist.exe [コマンド]

コマンドの一覧:
  [tickets] [-lh <LogonId.HighPart>] [-li <LogonId.LowPart>]
  tgt [-lh <LogonId.HighPart>] [-li <LogonId.LowPart>]
  purge [-lh <LogonId.HighPart>] [-li <LogonId.LowPart>]
  sessions [-lh <LogonId.HighPart>] [-li <LogonId.LowPart>]
  kcd_cache [-lh <LogonId.HighPart>] [-li <LogonId.LowPart>]
  get <SPN> [-lh <LogonId.HighPart>] [-li <LogonId.LowPart>]
            [-kdcoptions <options>] [-cacheoptions <options>]
  add_bind <DOMAIN> <DC>
  query_bind
  purge_bind

C:\java>
----------------------------------------------------------
34.ktab
https://docs.oracle.com/javase/jp/11/tools/ktab.html#GUID-9E4FA1E5-03F4-457C-BE16-4A202AAFD316
----------------------------------------------------------
C:\Users\owner>ktab -l
No default key table exists.

C:\Users\owner>ktab -a duke@example.com
Password for duke@example.com:
Done!
Service key for duke@example.com is saved in C:\Users\owner\krb5.keytab

C:\Users\owner>
C:\Users\owner>ktab -d duke@example.com
Are you sure you want to delete service key(s) for duke@example.com (all etypes, all kvno) in C:\Users\owner\krb5.keytab? (Y/[N]):

C:\Users\owner>
----------------------------------------------------------
※35.pack200
https://docs.oracle.com/javase/jp/11/tools/pack200.html#GUID-8473A0F8-22C3-4122-9488-9F678E883A0B
----------------------------------------------------------
C:\Users\owner>pack200 [-opt... | --option=value] x.pack[.gz] JAR-file
'pack200' は、内部コマンドまたは外部コマンド、
操作可能なプログラムまたはバッチ ファイルとして認識されていません。

C:\Users\owner>pack200 myarchive.pack.gz myarchive.jar
'pack200' は、内部コマンドまたは外部コマンド、
操作可能なプログラムまたはバッチ ファイルとして認識されていません。

C:\Users\owner>
----------------------------------------------------------
※36.rmic
https://docs.oracle.com/javase/jp/11/tools/rmic.html#GUID-A6AF75AE-DC98-483D-9FF2-030D6EF2F5C7
----------------------------------------------------------
C:\Users\owner>rmic hello.HelloImpl
'rmic' は、内部コマンドまたは外部コマンド、
操作可能なプログラムまたはバッチ ファイルとして認識されていません。

C:\Users\owner>
----------------------------------------------------------
37.rmid
https://docs.oracle.com/javase/jp/14/docs/specs/man/rmid.html
----------------------------------------------------------
C:\Users\owner>rmid -J-Djava.security.policy=rmid.policy
Activation.main: 警告:sun.rmi.activation.execPolicyシステム
プロパティが指定されていない、またはExecPermissions/ExecOptionPermissionsが
許可されません。ExecPermissions/ExecOptionPermissionsアクセス権検査で許可され
ないため、後に続く起動は失敗する可能性があります。
セキュリティを確認するには、rmidのドキュメントを参照してください。

rmid: (警告) RMI起動メカニズムおよびrmidツールは削除予定のため
非推奨になりました。これらは、Javaプラットフォームの将来のバージョン
から削除される可能性があります。
----------------------------------------------------------
38.rmiregistry
	｜なにか出力されるわけではなく、バックグラウンドで実行
	｜されるコマンド。
	｜現在のホストの指定したポート上で
	｜リモート・オブジェクト・レジストリを開始します。
https://docs.oracle.com/javase/jp/8/docs/technotes/tools/windows/rmiregistry.html
----------------------------------------------------------
C:\Users\owner>rmiregistry &
----------------------------------------------------------
※39.serialver
https://docs.oracle.com/javase/jp/12/tools/serialver.html#GUID-88BA8143-30DD-4E6F-AFAF-4A9B75BBED5F
----------------------------------------------------------
----------------------------------------------------------
※40.unpack200
https://docs.oracle.com/javase/jp/11/tools/unpack200.html#GUID-C7C10990-A311-44EA-AE31-0FBB3AA6F7F3
----------------------------------------------------------
----------------------------------------------------------
