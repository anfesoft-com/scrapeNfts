package escrapeNfts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Datamanager {
	public static String dataUri = "jdbc:sqlite:/run/media/andressanchez/LENOVO/TAFNACX/DATABASES/tafnacx.db";
	private Connection conn() throws SQLException
	{
	Connection conn = DriverManager.getConnection(dataUri);
		return conn;
	}
	
	private void insert(String query) throws SQLException
	{
		//System.out.println(query);
		Connection conn = this.conn();
		conn.createStatement().execute(query);
		conn.close();
	}
		
	
	public void processinsert(String contractid, String addressid) throws SQLException
	{
		StringBuilder sb = new StringBuilder("INSERT INTO recentadded");
		sb.append(" ('id','contractAddress','tokenId')");
		sb.append(" SELECT ?,'"+addressid+"','"+contractid+"'");
		sb.append(" WHERE NOT EXISTS(SELECT tokenId from recentadded WHERE tokenId='"+contractid+"');");
			this.insert(sb.toString());
	}
	
}

