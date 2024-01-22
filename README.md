# Projektni zadatak iz kolegija Metode i tehnike testiranja programske podrške

## O projektu

Projekt je razvijen koristeći IntelliJ kao razvojno okruženje, Selenium WebDriver za automatizaciju web preglednika, TestNG kao okvir za testiranje, i Maven za upravljanje projektom. Za pokretanje testova, preporučuje se instalacija IntelliJ IDE na računalo, kao i postavljanje odgovarajuće verzije Chrome WebDrivera i njegovo ubacivanje unutar mape testova.
Testovi su napisani u programskom jeziku JavaScript i ciljaju testiranje različitih funkcionalnosti web stranice. Svaki test fokusira se na određeni dio stranice, koristeći Selenium WebDriver za interakciju s elementima na web sučelju. 
Svaki test je napisan unutar zasebne klase i pokreće se zasebno te je neovisan o drugim testovima.
## Izvršeni testovi

**RegistrationTest:**
- Koristi Selenium WebDriver i TestNG za testiranje registracije na stranicu.
- Korišten je „xpath“ za pronalaženje elemenata poput polja za unos podataka i gumba.
- Testiraju se funkcionalnosti poput unosa podataka i klika na gumbe tijekom procesa registracije.
  
**LoginTest:**
- Koristi podatke koji su prethodno korišteni u RegistrationTest.
-	Pomoću „xpath“ pronalazi odgovarajuća polja za unos podataka i gumb za prijavu.
-	Testira se funkcionalnost uspješnog prijavljivanja na stranicu.
  
**AddingBookToCollectionTest:**
-	Izvršava postupak logina kao u LoginTestu, zatim testira pretraživanje postoji li željena knjiga u sustavu tako da pošalje samo dio naziva knjige u prostor za pretraživanje. Nakon izlistanih rezultata traži knjigu koja ima isti naziv kao predani string koji predstavlja cijelo ime knjige te zatim otvara web stranicu knjige i dodaje ju u korisnikovu kolekciju knjiga.
-	Pronalaženje elemenata se radi pomoću „xpath“ i „id“ elemenata.
-	Koristi dodatne naredbe poput Thread.sleep() i executeScript za rukovanje s vremenskim odgodama, koje su potrebne zbog učitavanja stranice, i izvršavanje JavaScript koda.
-	Nakon dodavanja knjige, vraća se na popis svih dostupnih knjiga i pretražuje predanu riječ kako bi se prikazale sve knjige koje unutar imena sadrže predanu riječ. Ako je potrebno, nakon ovoga moguće je ponovno primijeniti postupak dodavanja knjige.
  
**DragAndDropTest:**
-	Pronalazi dva elementa pomoću njihovih „id“.
-	Testira funkcionalnost povlačenja jednog elementa unutar drugog koristeći funkcije movetoElement i clickAndHold, a zatim se radi provjera sadrži li uistinu veći element droppable element unutar sebe.

**ProgressBarTest:**
-	Testira element progress bar i povezani gumb koji mijenja stanje između „start“ i „stop“.
-	Pronalazi elemente pomoću „id“.
-	Prvo pokreće popunjavanje progress bar pritiskom na tipku „start“, a zatim  se koristi WebDriverWait.until() funckija pomoću koje se čeka da progess bar dosegne broj na kojem se treba zaustaviti. Kada progess bar dosegne taj broj, pritisne gumb "stop" i daljnje napredovanje progess bar se zaustavlja.
-	Zbog stalnog dohvaćanja stanja progress bar, automatsko zaustavljanje na određenoj razini nije uspješno bez dodatnih vremenskih proračuna i proračuna brzine popunjavanja bara. Zato je zaustavljeno stanje progress bara gotovo uvijek različito tj. veće od predane vrijednosti.


