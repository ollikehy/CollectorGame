## Ohjelman kulku

Main-luokka aloittaa luomalla Menu-luokan ja tämän jälkeen kutsuu Menu-luokan metodia start(). Menu-luokan start()-metodi puolestaan valmistelee ensiksi graafisen käyttöliittymän ja lisää siihen painikkeet. Tämän lopuksi asetetaan ikkuna näkyviin, josta voi jatkaa ohjelman käyttöä.

Menuikkunassa on neljä painiketta: pelaa, tulokset, kartta ja lopeta. 

Pelaa painikkeesta Menu-luokka käynnistää gameOn()-metodin, missä luodaan Board-luokan olio ja asetetaan se näkyviin. Board luokassa luodaan pelikenttä, pelaaja ja esim. näppäimistönkuuntelija. Lopuksi kun pelikenttä on asetettu näkyville voi peliä pelata. 

Tulokset painike avaa uuden ikkunan, missä on näkyvillä top-5 tulokset jotka ohjelma lukee tekstitiedostosta. 

Kartta painike luo Map-luokan jossa ladataan kuva pelikentästä ja asetetaan se ikkunaan näkyviin. Ikkunaan lisätään myös painike, mistä voi palata päävalikkoon.

Lopeta painike sulkee pelin.


## Luokat joita ylhäällä ei käsitelty

Player-luokkassa luodaan pelaaja-olio ja liikutellaan kyseistä pelaajaa. Luokan tehtävänä on myös pelaajan pisteiden laskeminen, sekä pelaajan sijainnin seuraaminen.

Tile-luokka taas luo pelikentän yksittäiset Tile-oliot ja niitä luodessa tarkistaa ovatko ne seiniä vai ei. Jos ruutu ei ole seinä arvotaan siihen esine.

