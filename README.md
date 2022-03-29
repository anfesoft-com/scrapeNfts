# scrapeNfts
Scrapes html contents of opensea and dumps unique nfts into database
 
 wwww.anfesoft.com
 
 Created by: Andres F Sanchez
  Scans html file dowloaded from opensea and inserts nfts into database
   1) download source code into test.html
   2) start pythonwebserver: python -m http.server 9000
   3) declare tokenaddress 
   4) declare database location
   5) create database if not available:
 
 
 CREATE TABLE "recentadded" (
	"id"	INTEGER,
	"contractAddress"	TEXT,
	"tokenId"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
)
