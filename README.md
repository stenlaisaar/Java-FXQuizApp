# Quiz App

Lihtne JavaFX-is loodud viktoriinirakendus (Quiz App). Projekt on ehitatud Maveniga ja kasutab Model-View-Controller (MVC) arhitektuuri.

## Mida rakendus teeb?
* Kuvab kasutajale ükshaaval küsimusi koos nelja vastusevariandiga.
* Salvestab valitud vastused ning jälgib mälus kasutaja edenemist.
* Kontrollib nupu "Järgmine" vajutamisel, et vastus oleks valitud (vajadusel kuvab hoiatuse).
* Näitab lõpus punktisummat ja õigete vastuste protsenti ning võimaldab viktoriini uuesti alustada.

## Kuidas käivitada?
Rakendust saab käivitada terminalist Maveni abil:

```bash
mvn clean javafx:run