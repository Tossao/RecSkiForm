# RecSkiForm
<h3>A simple application that helps in collecting personal data from participants of ski camps and pre-determines their skiing skills.</h3>


Notes:<br>
I tak wyobrazam sobie to w ten sposob ze na stronie ktora juz istnieje www.recski.pl chcialbym dodac taki formularz do ktorego rodzic( kazdy ma swoje konto) moze sie
zalogowac (super by bylo jakby mogl to zrobic za pomoca np gmaila) i po zalogowaniu widzi opcje 'dodaj dziecko' i swoja liste dzieci ktora moze edytowac i zmieniac tam dane
ktore podal w zeszlym roku - bo juz sporo rodzin z nami jezdzi od kilku lat i skill dzieciakow wiadomo rosnie:)

Encje:

Encja - Parent - jako user <br>
ID<br>
firstName<br>
lastName<br>
phone<br>
email<br>
login<br>
passowrd<br>
<br><br>
Encja - Child (ManyToOne -> Parent)<br>
ID<br>
firstName<br>
lastName<br>
age - birth date (żeby zostało na inne lata)<br>
group ( ski OR snowboard ) - radio button?<br>
skills - select multiple choice<br>
level - select one (poziom rekusiowy kolor jesli ma)<br>
description - ogolne uwagi rodziców, z jakich stoków swobodnie zjeżdża,<br>

<br><br>
Do tych 2 encji dostep do edycji ma tylko admin i admin je ustawia ale chcialbym zeby user mogl sobie przeczytac description no i user wybiera skille (multiple)
i levelColor (jeden) z listy podczas dodawania dziecka :)
<br><br>
Encja - Skills (ManyToOne -> Child)<br>
ID<br>
skillName (hamowanie, kontrola prędkości, pług, skręt równoległy, śmig, czy jezdzi orczykiem/ krzesełkiem + skille snowboardowe)<br>
description skilla<br>

Encja - Levels (ManyToOne -> Child)<br>
ID<br>
LevelColor - poziom bialy, zielony, czerwony, niebieski, złoty itd... lub brak<br>
description - opis poziomu<br>
<br>
Encje ski i snowboard osobno ?
<br><br>
Automatyczne tworzenie grup dzieciaków wg koloru poziomu Rekusiowego
Wyszukiwarka z filtrem dostepna dla Admina - mozliwosc wyszukania dzieci danego rodzica, dzieci w danym wieku, dzieci w danej grupie Rekusiowej, dzieci jezdzacych na nartach/snowboardzie