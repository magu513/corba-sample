# README

パッケージなど雑です。  
一旦、REST to CORBAをするようにしています。  

## 実行

### 事前
アプリケーションを実行する前にorbdを起動すること
```sh
orbd -ORBInitialPort 1050 -ORBInitialHost localhost
```

### 起動
Embedded Tomcatを使用しているため、mainクラスを実行すればサンプルを確認できます。

## TODO

- RESTをServletでの実装からjax-rsへ変更
  - 余裕があれば
- ~~CORBAサーバを直接起動からEJBで呼び出すよう変更~~
  - Tomcatでは非対応のためやらない
- リフレクションとアノテーションを使用し、クラスの変換処理を実装
- IDLファイルをresources配下へ
  - 合わせたほうが分かりやすいため。余裕があれば。

## 資料

### IDL関係
<https://software.fujitsu.com/jp/manual/manualfiles/M050000/B1WN4971/01/index.htm>

### jax-rs関係

実際に使用するかは分かりませんが、参考にした資料についてとなります。

<https://cxf.apache.org/docs/jaxrs-services-configuration.html#JAXRSServicesConfiguration-WithCXFNonSpringJaxrsServlet>