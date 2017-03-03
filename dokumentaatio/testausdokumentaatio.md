###Mitä en testannut
En testannut ui-luokkia, ja jätin pit-raportissa huomiotta sekä Main-luokan, että CollectorGame-luokan.
Tämä sen takia, että Main-luokassa ei käytännössä toiminnallisuutta ja CollectorGame-luokan toiminnallisuus lähinnä UI-toiminnallisuutta.
En testannut myöskään Player-luokassa metodeja KeyPressed ja KeyReleased, sillä en osannut simuloida tarvittavia näppäimistönpainalluksia.

###Mitä olen testannut manuaalisesti
Manuaalisesti olen testannut lähinnä UI-luokkaa, sillä sen testaaminen on yksikkötesteillä vaikeata, eikä ollut pakollista.
Olen myös testannut tuloksia, sekä pelihahmon liikkumista pelikentällä.

###Bugeja:
-Hahmo katoaa satunnaisesti piirtovaiheessa, johtunee siitä että uudelleenpiirtäessä hahmoa ei uudelleenpiirretä jostain syystä.
-Hahmon liikkuminen ei ole tarkoituksen mukaista, välillä ei liiku ollenkaan ja välillä toivottua enemmän.
