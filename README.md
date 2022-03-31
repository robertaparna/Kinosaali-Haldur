# Kinosaali-Haldur
Kino/teatri haldaja

-Kinosse saab lisada saale (klass), erinevad konstruktorid (kas igas reas sama palju kohti või ei), määrata saab ridade arvu ja kohtade arvu igas reas;
-Saalidesse saab lisada seansse (klass), sellele määrata pealkiri, žanr, algus, pileti hind;
- NB! Kui kasutaja valib seansi, millel on vanusepiirang, siis peab ta sisestama oma vanuse (kusjuures, kui ostatakse rohkem kui 1 pilet, tuleb ka kaaslaste vanused sisestada);
-Seanssidele saab pileteid müüa, küsib mitu piletit, väljastab saali hetkeseisu, pakub suvalised jarjestikused kohad, saab valida, kas sobivad või tahad ise valida, siis väljastab hinna ja margib kohad valituks;
-Ühes saalis ei saa samal ajal olla kaks seanssi;

klassid: 

saal - list<list<Boolean>> kohad, (hashmap<date, time>)intervallid? broneeringud
					https://www.joda.org/joda-time/quickstart.html 

	konstruktor 1. votab int n, int m
			teeb saali n reaga kus igas m kohta
	konstruktor 2. votab int n
			teeb saali n reaga, kusib iga rea kohta eraldi mitu kohta
	
  märgib kõik false

	meetod mis valjastab koik info saali broneeringute kohta
	
	meetod mis valjastab broneeringud kindlal päeval

	meetod mis votab ajavahemiku ja kontrollib kas see on vaba
	
	broneeringutesse lisamine

seanss - date kuupaev, time algus, time lopp, string pealkiri
	
	konstruktor votab parameetriks antud saali plaanist koopia, kontrollib saali meetodi abil kas samal ajal juba selles saalis midagi toimub

mängufilm extends seanss - string žanr, string näitlejad
	seansi info tagastamise meetod

õudusfilm extends mängufilm - int vanusepiirang
	seansi info tagastamise meetod	
	meetod vanuse kontrolliks ! mitte siin vaid mujal peab olema

dokumentaal extends seanss - string tegijad, string teema
	seansi info tagastamise meetod


peaklassis:


kasutajaga suhtlemine peameetodis, https://www.utf8-chartable.de/unicode-utf8-table.pl
					nimekiri: geometric shapes
meetodid kasutaja valikute jaoks,
meetodid lae ja salvesta,
