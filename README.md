# Product Finder
## Descrierea problemei
Aplicația Product Finder oferă utilizatorilor posibilitatea de a găsi cu ușurință un anumit produs prin simpla căutare după nume a acestuia.
Aceasta oferă informații specifice despre produs cum ar fi :
- prețul
- magazinele la care se găsește
- stocul de la un anumit magazin pentru produsul respectiv

De asemenea utilizatorul are posibilitatea de realiza anumite comparații și cereri precum :
- compararea unor produse în funcțtie de prețul acestora
- compararea unor produse în funcțtie de stocul existent
- posibilitatea setării unei alerte de stoc pentru un produs
- posibilitatea de a adăuga un produs la secțiunea *favorite*
- posibilitatea de a lăsa un *review* pentru un anumit produs

## Soluția propusă
În ceea ce privește implementarea, proiectul va fi împărțit în două părți :
### Partea de back end
Această parte se va ocupa în special cu prelucrarea datelor și cu operațiile care se pot aplica pe acestea.
Datele referitoare la produse, magazine și utilizatori vor fi stocate intr-o bază de date cu mai multe tabele iar obținerea 
și prelucrarea datelor se va realizeaza folosind limbajul Java astfel fiecare tip de date va avea asociat câte două clase, una pentru
definirea proprietățiilor tipului de date și una pentru extragerea acestuia din baza de date.De asemnea vor exista clase adiționale
care implementează operații de prelucrare a datelor.
### Partea de front end (UI)
Această parte va avea rolul de a prezenta utilizatorului o interfață grafică sub forma unei pagini de web prin intermediul căreia să se
faciliteze utilizarea aplicației de către acesta.Pagina de web va fi fi implementată cu ajutorul limbajului HTML.

## Descrierea soluției
Pentru partea de back end se va utiliza structura de clase din următoarea diagramă :
![alt text](https://github.com/cosmacatalin98/ProductFinder/blob/master/UMLClassDiagram.jpeg)

Fiecare tabelă din baza de date are asociată o clasă care are ca și atribute câmpurile tabelei, astfel clasele Product, Store și User corespund tabelelor Products, Stores și Users, aceste clase se ocupă doar de definirea tipului și operații simple (get,set) pe acesta.

Clasele ProductBLL,StoreBLL și UserBLL implementează o interfață comună numită DBAccessOperations care definește operațiile de obținere, inserare și ștergere de obiecte din baza de date, operații care sunt implementate diferit de fiecare dintre cele trei clase în conformitate cu tipul de obiect asociat.

Clasa DBAccessFacade a fost implementată după șablonul de proiectare Facade cu rolul de a simplifica utilizarea operațiilor de manipulare a datelor din clasele ProductBLL, StoreBLL și UserBLL.

Clasa ConnectionFactory se ocupă în special de implementarea operațiilor legate de conexiunea dintre aplicație și baza de date.

Clasa PFApplication conține o singură metodă (main) și este utilizată pentru rularea aplicației.


