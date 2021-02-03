java EE 8

ava EE とは、サーバーや大規模システム向けの機能をまとめたセット
java SE の拡張
開発には、tomcatではなく大規模なglassfishというサーバーが使用される。

tomcatとglassfishの違い

tomcatはHTTPサーバ・javaサーブレットコンテナ
glassfishはアプリケーションサーバで、EJBコンテナとそのスタックのほかのすべての機能を含む
tomcatのメモリが60～70MBに対してglassfishは数百MB

（tomcat）webサーバーはブラウザからのコンテンツのリクエストを受け取り、ブラウザにレスポンスを返す役割のが役割です。
（glassfish）アプリケーションサーバーは私たちが作ったRailsアプリケーションを動かしてくれるものです。
	     webサーバーから送られてきたリクエストをアプリケーションサーバーからアプリケーションに伝え、アプリが処理した結果をwebサーバーに返します。

glassfishはtomcatと同様の機能を持っており、さらにtomcatにはない機能もいくつかある
TomcatはWebコンテナを動作させるための必要最低限の機能になります。一方でGlassFishは大規模な商用システムの運用も考慮し、アプリやリソースの管理機能もついています。



API 

Java Platform, Enterprise Edition 8

	Javaで実装されたアプリケーションサーバの標準規格及びそのAPIを定めたもの。
	Java Platform, Standard Edition (Java SE) の拡張機能の形で提供される。

Enterprise JavaBeans 3.2（EJB）

	Enterprise JavaBeans (EJB) とは、JavaBeans仕様と同様のものを、
	ネットワーク分散型ビジネスアプリケーションのサーバサイドで実現した仕様のこと。

	※ここでの分散型というのは異なるJVMでも実行できることを指している

	EJBコンテナ:Javaによるサーバーサイド・アプリケーションのためのコンポーネントモデル

	webコンテナとの違い: ・サーバーサイドで使用されることが前提になっており、
				世の中のwebアプリケーション・サーバー製品はEJBを準拠している。

			　　 ・異なるJVM上で実行できる

			　　 ・トランザクション管理をEJBに任せられる。
				※トランザクション管理（複数のSQL文実行時に途中で
				エラーが発生したら全テーブルの変更を「破棄」すること）

Common Annotations for the Java Platform 1.3

	さまざまな個別のテクノロジーに適用されるJava SEおよび Java EEプラットフォームの
	共通のセマンティック概念に関するアノテーション(プログラム自体の一部ではないソフトウェア・プログラムに関する情報)
	 を開発することを目的とする Java仕様要求です。

	※セマンティック:コンピュータに文書や情報の持つ意味を正確に解釈させ、
	  文書の関連付けや情報収集などの処理を自動的に行わせる技術について用られる語である。


Java Servlet 4.0

	Java Servlet（ジャバ サーブレット）とは、サーバ上でウェブページなどを動的に生成したりデータ処理を行うために、
	Javaで作成されたプログラム及びその仕様である。単にサーブレットと呼ばれることが多い。
	Java EEの一機能という位置づけになっている。この機能を用いてショッピングサイトやオンラインバンキングなどを
	はじめとする多種多様な動的なWebサイトが構築されている。
	メリット : サーブレットはOSに依存しない特徴


Java API for WebSocket 1.1

	JSR 356、WebSocket 用 Java API は、Java 開発者が WebSocket をアプリケーションに統合する場合に使用できる API を指定します。
	JSR 356 に準拠していると主張する WebSocket プロトコルのすべての実装は、この API を実装する必要があります。
	その結果、開発者は、基になる WebSocket 実装から独立して、WebSocket ベースのアプリケーションを記述できます。
	ベンダーロックを防止し、ライブラリやアプリケーションサーバーの選択肢や自由度を増やすので、これは大きなメリットです。


JavaServer Faces 2.3

	JavaServer Faces (JSF) は、JavaベースのWebアプリケーションフレームワークである。
	Javaの拡張機能セットであるJava Platform, Enterprise Edition (Java EE) の仕様の一つに採用されている


JavaServer Pages 2.3

	JavaServer Pages (JSP) は、HTML内にJavaのコードを埋め込んでおき、
	Webサーバで動的にWebページを生成してクライアントに返す技術のこと。
	JSPを利用するメリットは、実行モジュールが早いこととJavaのライブラリが有効
	テキストコンテンツ (HTML や XML など) とカスタム タグ、式言語、および埋め込まれた Java コードの混合をサポートする
	Web アプリケーション用のテンプレートエンジンを定義し、ジャカルタサーブレットにコンパイルされます。
	
Standard Tag Library for JavaServer Pages 1.2

	JavaServer ページ標準タグ ライブラリ (JSTL) は、多くの Web アプリケーションに共通するコア機能を単純なタグとしてカプセル化します。
	JSTL は、反復や条件などの一般的な構造タスク、XML ドキュメントを操作するためのタグ、国際化タグ、および SQL タグをサポートしています。
	また、既存のカスタム タグと JSTL タグを統合するためのフレームワークも提供します。


Expression Language 3.0
	
	Webページに式を埋め込んで評価するために、主にjava EE Webアプリケーションで使用される特別な目的プログラミング言語です。


Debugging Support for Other Languages 1.0

	Java 仮想マシンで実行されるが、Java プログラミング言語以外の言語で記述されたプログラムを、
	元のソース (ソースファイルや行番号参照など) への参照でデバッグできるメカニズムを提供します。


Java Message Service 2.0
	
	Java アプリケーションが疎結合で信頼性の高い非同期通信サービスを介してメッセージを作成、送信、および受信する手段を記述します。


Java Transaction API 1.2
	
	Java トランザクション API（英: Java transaction API、JTA）とは、Java EE のAPIの1つであり、XAリソース間の分散トランザクション処理を扱う。
	JTA は Java コミュニティ・プロセスで JSR 907 として開発された仕様である。


JavaMail API 1.6

	JavaMail API は、Java に基づいたメール・クライアント・アプリケーションをビルドするための、プラットフォームおよびプロトコルに依存しないフレームワークです。
	JavaMail API は、メールの送信と読み取り用の汎用 API です。


Java EE Connector Architecture 1.7

	Java EE Connector Architectureは、アプリケーションがEIS(Enterprise Information System)と対話することを可能にするアーキテクチャの仕様です。


Web Services for Java EE 1.4

	Web サービスを統合するために進化しました。Web サービスは現在、J2EE プラットフォームの多くのサービス提供チャネルの 1 つです。
	既存の J2EE コンポーネントは、Web サービスとして容易に公開できます。J2EE プラットフォームの多くの利点は、
	移植性、スケーラビリティ、信頼性、シングルベンダーロックインなど、Web サービスで利用できます。


Java API for XML-based RPC 1.1

	JAX-RPC (Java API for XML-based RPC) は、XMLを使用した遠隔手続き呼出し (RPC) を
	実装するためのJavaの標準仕様である


Java API for XML Registries 1.0
	
	java EEアプリケーションがさまざまな種類のメタデータ・レジストリーにアクセスし、
	プログラムで対話するための標準 APIを定義しています。JAXR は、Java XMLプログラミング API の 1 つです

Java API for RESTful Web Services 2.1

	JAX-RS (Java API for RESTful Web Services) は、RESTアーキテクチャに基づくWebサービスのための機能を提供するJava言語のAPIである。
	JAX-RSはJava SE 5で導入されたアノテーションの仕組みを用いて、シンプルな開発を実現する。


Java API for JSON Processing 1.1

	JSON（JavaScript Object Notation）は、人間にも機械にも容易に読み書きできる、プログラミング言語に依存しないテキストベースの軽量なデータ交換フォーマットです。
	JSONでは2つの構造化型（オブジェクトおよび配列）を表現できます。オブジェクトは、順序付けされていない0個以上の名前/値ペアの集合です。
	配列は、順序付けされた0個以上の値の列です。値として取れるのは、文字列、数字、ブール、null、およびこれら2つの構造化型です。


Java API for JSON Binding 1.0

