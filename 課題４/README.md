Oracle Open JDK
・権利がフリーなJDKのこと

※JDK(java SEで開発をするためのツール）
ライブラリや実行ファイル、設定ファイルなどが入っている。

Oracle JDK
・権利がフリーではないJDKのこと
　java 11 からはこの2つの機能的な差はない

Java SE プラットフォーム
・javaに関する様々な仕様が入っている
機能の概要　機能の使用に関するガイド　APIドキュメント

Oracle Java SE サブスクリプ
・上記のjava SEがサブスクリプションな方式になっている。
（一定期間ごとに一定料金が発生する）
---------------------------------------------------------------------------------------
java EE ディレクトリ用語

glassfish : GlassFishは、サンを中心としたオープンソース・コミュニティと、
同コミュニティで開発されたJava EE準拠のアプリケーションサーバの名称である。

ディレクトリ構造
java_ee_sdk-8u1 - glassfish5 - bin : asadminというファイルとbatファイルがある。


			     - docs - api - javaee-full:java EE 内のapiに関するjavadoc

			            - firstcup - doc : html
					       - example : 初回のチュートリアルで使用されるソース

				    - javaee-tutorial - doc : html
						      - examples : チュートリアルで使用されるソース


			     - glassfish - bin : batファイル
					 
					 - common - templates - gf : jarファイル

					 - config : 設定ファイル
	
					 - docs : html

					 - domains :

					 - legal : ライセンス（テキスト）

					 - lib :

					 - modules : 

					 - osgi : 
			
			    - javadb - bin : windows bat ファイル

				     - lib : jar war ファイル
					
			    　htmlファイル


			    - mq - bin : 実行ファイル

				 - etc : XMLファイル

				 -legal : ライセンス情報（テキスト）

				 - lib : jar ファイル
					※文書構造を定義するファイル（DTD) 　


			    - samples - batch

				      - cbi

				      - concurrency

				      - connectors

				      - docs

				      - ejb

				      - el

				      - jsf

				      - jsonb

				      - jsonp

 				      - platform

				      - rest

				      - security

				      - servlet

				      - websocket


java EE に含まれる機能

	・javax.servlet.*：

		Servletパッケージでは、主にHTTPリクエストのためのAPIが定義されている。
		またJavaServer Pages (JSP) に関するAPIも含まれる。

	・javax.websocket.*：
		
		WebSocketパッケージでは、WebSocketの通信に関するAPIが定義されている。
		
		※WebSocket （ウェブソケット）は、 コンピュータネットワーク 用の通信規格の1つである。
		 ウェブアプリケーション において、 双方向通信 を実現するための技術規格である。

	・javax.faces.*：

		Facesパッケージでは、 Java Server Faces (JSF) に関するAPIが定義されている。
		JSFはコンポーネントによるUI構築技術である。

		※(JSF) は、Java™ ベースの Web アプリケーションの開発を容易にするAPIです。

	・javax.el.*：

		ELパッケージでは、Java EEのEL式に関するクラスとインターフェースが定義されている。
		EL式はJSPやJSFを作成するWebアプリケーション開発者のためにデザインされた簡単な構文である。
		主にJSFにおいてコンポーネントに管理beanを結びつけるために用いられるが、仕様自体は独立しており、
		それ以外の部分でも使用可能である。

		※EL式 とは、文書中に一つの式として表された短い プログラムコード を記述し、処理を実行したり評価結果を埋め込んで表示する技術。

	・javax.enterprise.inject.*：

		Injectパッケージでは、Contexts and Dependency Injection (CDI) APIのためのインジェクションアノテーションが定義されている。
		CDIは依存性の注入 (DI) に関する仕様である。

	・javax.enterprise.context.*:

		Contextパッケージでは、Contexts and Dependency Injection (CDI) APIのためのコンテキストアノテーションとインタフェースが定義されている。

	・javax.ejb.*:

		Enterprise JavaBeans (EJB) パッケージでは、EJBコンテナがサポートするトランザクション処理 (JTA)、RPC（RMIまたはRMI-IIOP）、
		並行性制御、依存性の注入 (DI)、ビジネスオブジェクトのためのアクセス制御といった軽量APIが定義されている。
		またこのパッケージは、エンタープライズBeanとそのクライアント間、エンタープライズBeanとEJBコンテナ間の取り決めを定義したクラスとインタフェースも含む。

		※Enterprise JavaBeans (EJB) とは、JavaBeans仕様と同様のものを、ネットワーク分散型ビジネスアプリケーションのサーバサイドで実現した仕様のこと。
		※Java トランザクション API （ 英: Java transaction API 、JTA）とは、 Java EE の API の1つであり、 XA リソース（インターフェース）間の分散 トランザクション処理 を扱う。
		※XAインタフェースは、分散トランザクション処理(DTP)環境でのリソース・マネージャとトランザクション・マネージャの間の規約を定義します。
		※Java RMIとは、Java言語に標準で用意された機能の一つで、あるJavaオブジェクトから、異なるコンピュータ上で動作する別のJavaオブジェクトのメソッドを
		　呼び出して実行することができるようにする仕組み。

	・javax.validation.*:

		Validationパッケージでは、Bean Validation APIのためのアノテーションとインタフェースが定義されている。
		Bean Validationはbean（例えばJPAのモデルクラス）に対する統一されたバリデーション（値の検証）手法を提供する。
		Java EEの各要素では、JPAが永続化層におけるバリデーションに、JSFがビュー層におけるバリデーションにまた関与する。

	・javax.persistence.*:

		Persistenceパッケージには、永続化プロバイダと管理クラス、それにJava Persistence API (JPA) クライアントの間の取り決めを定義したクラスとインタフェースが含まれている。
		
		※Java Persistence API（JPA）とは、関係データベースのデータを扱う Java SE および Java EE のアプリケーションを開発するためのJava用フレームワークである。

	・javax.transaction.*:

		Transactionパッケージでは、Java EEのトランザクション処理を担うJava Transaction API (JTA) のインタフェースとアノテーションを含むAPIが定義されている。
		これらのAPIは低レベルAPIが抽象化されたものであり、通常のアプリケーション開発者がJava EEを用いて開発する場合は、EJBのより高レベルのトランザクション管理を用いたり、
		このAPIのアノテーションとCDIの管理Beanとを組み合わせて使用することが想定されている。

	・javax.security.auth.message.*:

		Messageパッケージでは、Java Authentication SPI (JASPIC) のインタフェースやクラスを含むAPIが定義されている。
		JASPICはセキュアなJava EEアプリケーションを構築するための仕様である。

		※JASPIC仕様 speciﬁcationの目的は、Java EEコンテナ内の認証プロセス の実行方法と、そのプロセス内でセキュリティ・メッセージ、ユーザー、
		　グループを検証するカスタム認証モジュールを統合できる場所を標準的な方法で 定義することです。

	・javax.enterprise.concurrent.*:

		Concurrentパッケージでは、Java EEプラットフォーム標準の管理されたスレッドプールと連携する、並行処理に関するインタフェースが定義されている。

		※スレッドプールとはあらかじめいくつかのスレッドを作成して待機させ、タスクが来たらすぐにスレッドを割り当てることで、スレッドの生成のコストを減らすもの

	・javax.jms.*:

		JMSパッケージでは、Java Message Service (JMS) APIが定義されている。
		JMSはJavaプログラムにエンタープライズメッセージの生成、送信、受信、読込のための手法を提供する。

	・javax.batch.api.*:
		
		BatchのAPIパッケージでは、Java EEのバッチ処理のためのAPIが定義されている。
		バッチ処理APIは、大容量のデータを扱う長時間に亘るバックグラウンドタスクや、定期的に実行されるタスクのための手法を提供する。

	・javax.resource.*:

		Resourceパッケージでは、Java EE Connector Architecture（英語版） (JCA) APIが定義されている。
		JCAはEnterprise application integration (EAI) の一部であるアプリケーションサーバーや企業情報システム (EIS) の相互接続を実現するための技術である。
		このAPIはベンダーのための低レベルAPIであり、通常のアプリケーション開発者をターゲットとしてはいない。