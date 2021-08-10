package dao;

/**
 * word_wolfスキーマにアクセスする、DAOの抽象クラス。
 * テーブルにアクセスするときはこのクラスを継承。
 */
abstract class parentDAO {

	/**
	 * JDBCドライバのFQDN
	 */
	private static final String DRIVER_PATH = "org.postgresql.Driver";
	
	/**
	 * ローカルのデータベースのURL
	 */
    static final String LOCAL_DATABASE_URL = "jdbc:postgresql://localhost:5433/postgres";
    

	
	
	
	/**
	 * JDBCドライバをロード。データベースのURLを決定。
	 */
	static {
		try {
			Class.forName(DRIVER_PATH);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}