package escrapeNfts;
import java.io.IOException;
import java.sql.SQLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/* wwww.anfesoft.com
 * Created by: Andres F Sanchez
 * Scans html file dowloaded from opensea and inserts nfts into database
 *  1) download source code into test.html
 *  2) start pythonwebserver: python -m http.server 9000
 *  3) declare tokenaddress 
 *  4) declare database location
 *  5) create database if not available:
 *  CREATE TABLE "recentadded" (
	"id"	INTEGER,
	"contractAddress"	TEXT,
	"tokenId"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
)
 */


public class Main {
public static String tokenaddress = "0x495f947276749ce646f68ac8c248420045cb7b5e/";
	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	Document doc = Jsoup.connect("http://localhost:9000/test.html").get();
	Elements the_Elements = doc.getElementsByTag("a");
	Datamanager dm = new Datamanager();
	for(Element e : the_Elements)
	{
		
		if(e.text().contains("assets/"))
		{
			String x = e.text();
			String[] assetarray = x.split("assets/");
			dm.processinsert(assetarray[1].replace(tokenaddress,""),tokenaddress);
			
		}
	}
	System.out.println("FINISHED!");
		
	}

}
