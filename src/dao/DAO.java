package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO{
	//全てのインスタンスで利用する為
	//staticフィールドとして定義（グローバル変数）
	static DataSource ds;

	//データメソッドへ接続する処理をgetConnectionという名前の
	//メソッドにまとめている
	public Connection getConnection() throws Exception{
		//データソースを確認して未接続の場合のみ接続を実行
		if(ds==null){
			//データソース確認する為のインスタンス
			InitialContext ic=new InitialContext();
			//context.xmlの/jdbc/bookで定義した接続情報でDBに接続
			ds=(DataSource)ic.lookup("java:/comp/env/jdbc/book");
	}
	return ds.getConnection();
}
}