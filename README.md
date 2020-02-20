# Ferma

----> Prieš paleidžiant - gali reikėti "set package name to MyMap"

## **1. Klasės, konstruktoriai, metodai**
**Tikslai.**
Sugebėti apibrėžti klasę kaip mažiausią programos statybinį elementą, suprasti kokias paslaugas klasė teikia, kuri jos dalis yra vieša, o kuri ne;
Sugebėti apibrėžti tinkamus konstruktorius;
Sugebėti sukurti klasės objektus su reikiamą būsena bei metodų kvietimais pertvarkyti būseną į norimą;
**Užduotis.**
Pasirinktąja semestro projektine tema parašyti bent vieną (nedidelę, bet prasmingą) klasę, kuri geba užtikrinti reikiamą modeliuojamo objekto funkcionalumą (jei klasių daugiau nei viena, jos tarpusavyje turi turėti prasmingus sąryšius). Klasėje turi būti apibrėžti:
Konstruktoriai, iš kurių vienas beargumentis, panaudoti this konstrukciją. Vienas tos pačios klasės konstruktorius privalo kviesti kitą tos pačios klasės konstruktorių;
Laukai, kuriems priega užtikrinama get/set metodais. Bent vienas laukas turi būti inicijuotas pradine reikšme;
Statiniai bei nestatiniai metodai (bent po vieną). Bent vienas metodas turi būti perkrautas (overloaded);
Apibrėžti metodą, kuris išveda objekto turinį į išvedimo srautą. Už išvedimą atsakinga testinė klasė (žr. žemiau), išvedimo turinį pateikia pats objektas;
Įtraukti į klasės apibrėžimą ir prasmingai panaudoti static bei final elementus (bent vienas static kintamasis, bent vienas final metodas);
Apibrėžti kitą (testinę) klasę, kuri sukurtų pirmosios klasės objektus, jais pasinaudotų, kviesdama metodus ir išvedinėtų laukų būsenas.
## **2. Išvestinės klasės, polimorfizmas**
**Tikslai.**
Sugebėti sudaryti klasių hierarchiją;
Suprasti, kaip išvestinės klasės pasinaudoja bazinės klasės sąsaja (interfeisu);
Mokėti išplėsti išvestinės klasės funkcionalumą, lyginant su bazine klase;
Sugebėti, panaudojant metodų užklotį (override), "modifikuoti" bazinės klasės veikimą išvestinėje klasėje.
**Užduotis.**
Pasirinkto projekto kontekste sudaryti klasių hierarchiją bent iš trijų paveldėjimo ryšiais susijusių klasių. Išvestinės klasės privalo:
Pasinaudoti bazinės klasės konstruktoriumi super() bei super metodu;
Turėti papildomų metodų ir laukų;
Užkloti bent vieną metodą;
Kitos klasės privalo pasinaudoti sukurtų klasių polimorfiniu elgesiu (kviesti užklotus (overriden) metodus bazinio tipo nuorodai);
Bazinė klasė privalo turėti metodų, kuriuos draudžiama užkloti;
Visos projekto klasės privalo priklausyti bent 2 skirtingiems paketams (package).
## **3. Abstrakčiosios klasės, interfeisai**
**Tikslai.**
Suvokti, kokią naudą teikią interfeisai, kokiais atvejais jie yra reikalingi, kaip jie yra plečiami;
Suprasti abstrakčiųjų klasių teikiamus privalumus, jų realizavimo ypatumus;
Skirtumų tarp interfeisų ir abstrakčiųjų klasių suvokimas;
Kodo "perpanaudojimas": kuomet naudojamas paveldėjimas, o kuomet - delegacija.
**Užduotis.**
Sukurti (netuščią) interfeisą (-sus) ar panaudoti jau egzistuojantį - standartinį (-ius), kad aprašyti kurios nors klasės suteikiamą "servisą";
Interfeisą išplėsti (extends) kitu. Šį realizuoti abstrakčiąja klase, o pastarąją - konkrečiąja;
Atkreipti dėmesį, kad konkrečiosios klasės funkcionalumo panaudojimas turi remtis kiek įmanoma abstraktesne klase (interfeisu). Galite panaudoti jau egzistuojančią klasių hierarchiją;
Bent vienoje klasėje panaudoti delegavimo principą. Bent viename interfeise įtraukti default metodą (ir jį panaudoti);
## **4. Išimtys**
**Tikslai.**
Mokėti naudoti išimtis (exceptions):
Aprašyti "nuosavą"/deklaruoti;
Iššaukti/išmesti (throw);
Gaudyti (catch);
Naudotis standartine Java biblioteka java.util.logging  "žurnalo įrašams" (logs) kurti;
**Užduotis.**
Apibrėžti bazinę išimties klasę savo projektui, išvestą iš java.lang.Exception;
Apibrėžti išvestinę išimties klasę su patikslinančiąja informacija;
Kitos klasės metodams deklaruoti (throws) metamas išimtis ir esant neteisingam kreipiniui jas iššaukti (throw);
Kitoje programos klasėje (ne ten, kur išimtis kyla) gaudyti metamas išimtis, parūpinant vartotojui diagnostinę informaciją (naudojant java.util.logging).
## **5. Klonavimas**
**Tikslai.**
Mokėti paruošti savo apibrėžtos klasės objektą klonavimui;
Suprasti objektų kūrimui skirtus projektavimo šablonus (prototipo, metodo-gamyklos, abstrakčiosios gamyklos);
**Užduotis.**
Išrinkti bent vieną klasę, kurios objektą būtų prasminga klonuoti ir paruošti giliam klonavimui. Kitoje klasėje klonavimą prasmingai panaudoti;
Identifikuoti tinkamą situaciją ir prasmingai panaudoti vieną iš aukščiau minėtųjų objektų kūrimo šablonų;
## **6. Gijos, IO srautai, kolekcijos, kodo versijavimas**
**Tikslai.**
Įsivaizduoti galimus gijų panaudojamumo atvejus;
Gebėti prasmingai sukurti, paleisti giją;
Mokėti panaudoti IO srautus;
Gebėti naudotis kodo versijavimo įrankiais;
**Užduotis 1 dalis.**
Suteikti programai galimybę išsaugoti duomenis/būseną/nuostatas faile binariniu pavidalu ir nuskaityti iš failo. Vykdyti šiuos veiksmus atskiroje gijoje (arba gijas panaudoti kitiems poreikiams);
Duomenų skaitymui rašymui naudoti DataInput/Output/Stream (jeigu manipuliuojama primityviaisiais duomenimis ir simbolių eilutėmis) arba ObjectInput/Output/Stream (jeigu norima įrašyti objektus su visais laukais). Objekto klasė pastaruoju atveju turi įgyvendinti interfeisą java.io.Serializable. Tas pats (rekursyviai) galioja ir klasės laukams;
**Užduotis 2 dalis.**
Parašyti implementaciją nurodytam interfeisui bei ją patalpinti naudojantis GIT versijavimo įrankiu (visa informacija apie jį, Objektinis_programavimas_6.pptx). Interfeisai: java.util.List, jei studento pažymėjimo numeris baigiasi 0, 1, 2, java.util.Map, jei studento pažymėjimo numeris baigiasi 3, 4, 5, 6, java.util.Set, jei studento pažymėjimo numeris baigiasi 7, 8, 9.
Nuorodą į savo GIT projektą pridėkite į pateikties komentarą/internetinio teksto lauką (pateikiant 1 užduoties dalį);
## **7. Objektų talpyklos - "Collections"**
**Tikslai.**
Sugebėti panaudoti Java collection karkaso galimybes;
Gebėti panaudoti GIT siekiant perpanaudoti jau parašytą kodą;
**Užduotis.**
Panaudoti standartines parametrizuotas kolekcijos realizacijas: sukurti, atnaujinti, peržiūrėti. Pagrįstai pasirinkti po vieną kolekciją iš 3 grupių ((ArrayList arba LinkedList) ir (SortedSet arba HashSet arba TreeSet) ir (HashMap arba TreeMap arba LinkedHashMap));
Viena iš pasirinktų implementacijų turi būti parašyta Jūsų kolegos. T.y. pasirinkite 7 užduotyje sukurtą kolegos implementaciją ir ją panaudokite vietoje standartinės Java. Turėsite parodyti, jog mokate pasinaudoti GIT, kad "pasiimtumėte" kolegos paviešintą išeities kodą.
## **8. Lambda. Swing. Unit testai. Projekto dokumentacija**
**Tikslai.**
Sugebėti panaudoti Java funkcinį stilių (lambda išraiškas). Suprasti, kaip veikia Java grafinė sąsaja ją kuriant su įrankių rinkiniu - SWING;
Suvokti semestro metu atliktą užduotį kaip problemos sprendimą, sugebėti jį aprašyti;
Gebėti dengti automatiniais testais savo kuriamą programą;
**Užduotis.**
Prasmingai panaudokite Java funkcinį stilių (lambda išraiškas). Reikia panaudoti šiuos metodus: filter, reduce, map, allMatch / anyMatch. TDD (Test Driven Development) panaudojimas šiame žingsnyje (reikia parašyti testus metodams, kuriuose yra naudojamas Java funkcinis stilius) premijuojamas 0.25b. Reikalinga informacija - Objektinis_programavimas_8.pptx;
Sukurti minimalią, prasmingą grafinę aplinką naudojant SWING. Ją galima panaudoti veiksmams inicijuoti (mygtukai), įdomiai informacijai parodyti (programos būsenoms stebėti), failų parinkimui ir t.t. Panaudojimas premijuojamas 0.25b;
Projektinę programą trumpai aprašykite atskirame dokumente: paskirtis, paleidimas, funkcionalumas, UML klasių diagrama. Identifikuokite klases, kuriose panaudojote žinomus projektavimo šablonus (design patterns). Sugeneruokite programos klasių dokumentaciją "javadoc" instrumentu;
Patalpinkite į sistemą .zip failą su projektine programa ir atskirą failą (.doc ar kitą, atvirą) su programos aprašu;
