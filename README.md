# BJ
## Sammanfattning:

Projektet innebar att skapa en Java-applikation för att hantera terrorister och spelare samt integrera med FBI:s API för att hämta information om terrorister. Arbetets gång var utmanande men lärorik. Här är en översikt över arbetets gång, de hinder som stöttes på och de lärdomar som projektet medförde:

Planering och design: Projektet inleddes med en planeringsfas där kraven och funktionaliteten definierades. En designstruktur för klasserna skapades för att organisera och hantera data.

Implementering av klasserna: Klasserna Terrorist, Player, SQLite och FBIAPI skapades enligt den definierade designstrukturen. Metoder för databashantering och API-anrop implementerades.

Integrering av FBI:s API: För att hämta terroristinformation integrerades applikationen med FBI:s API. HTTP-anrop och JSON-hantering implementerades för att extrahera relevant information om terrorister.

Databasanslutning och operationer: SQLite-klassen implementerades för att hantera anslutning till databasen och utföra CRUD-operationer för spelare och terrorister. Tabeller skapades och säkerhetsåtgärder implementerades.

Under processens gång stötte jag på följande hinder:

Svårigheter med API-anrop: Att ansluta till och hantera API-anrop var en utmaning. Hantering av JSON-respons och extrahering av önskad information krävde noggrannhet och förståelse för JSON-strukturen.

Felhantering och undantagshantering: Hantering av fel och undantag var viktigt för att säkerställa att applikationen fungerade korrekt och inte kraschade vid oväntade situationer. Detta krävde noggrann testning och korrigering av potentiella buggar.

Databasdesign och operationer: Att designa och implementera en databasstruktur för spelare och terrorister krävde omsorg och noggrannhet. Säkerhetsåtgärder och korrekt datahantering var viktigt för att undvika datakorruption eller felaktiga operationer.

Lärdomar från detta projekt inkluderar:

Bättre förståelse för API-integration: Genom att arbeta med FBI:s API fick jag en djupare förståelse för att hantera externa API-anrop, hantering av JSON-data och att utnyttja externa tjänster i mina applikationer.

Databashantering och SQL-operationer: Genom att implementera och använda SQLite för databashantering fick jag en ökad kunskap om SQL-operationer, att designa databasstrukturer och att säkerställa korrekt datahantering.

Felhantering och undantagshantering: Att hantera fel och undantag korrekt var en viktig lärdom. Genom att identifiera och hantera fel under körning kunde jag förbättra applikationens stabilitet och användarupplevelse.

Projektplanering och design: En noggrann planering och design i början av projektet hjälpte till att strukturera arbetet och undvika eventuella fallgropar längs vägen. Det gav även möjlighet att tänka igenom och identifiera eventuella problemområden i förväg.

Sammanfattningsvis var arbetet med att skapa en Java-applikation för hantering av terrorister och spelare lärorikt och utmanande. Genom att övervinna hinder och lösa problem längs vägen förbättrades mina färdigheter inom API-integration och databashantering. Projektet bidrog till en djupare förståelse för att arbeta med externa resurser och att implementera robusta och säkra applikationer.
