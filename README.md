# Product Finder
## Descrierea problemei
Aplicația Product Finder oferă utilizatorilor posibilitatea de a găsi cu ușurință un anumit produs prin simpla căutare după nume a acestuia.
Aceasta oferă informații specifice despre produs cum ar fi :
- prețul
- magazinele la care se găsește
- stocul de la un anumit magazin pentru produsul respectiv

De asemenea utilizatorul are posibilitatea de realiza anumite comparații și cereri precum :
- compararea unor produse în funcție de prețul acestora
- compararea unor produse în funcție de stocul existent
- posibilitatea de a adăuga un produs la secțiunea *favorite*

## Soluția propusă
În ceea ce privește implementarea, proiectul va fi împărțit în două părți :
### Partea de back end
Această parte se va ocupa în special cu prelucrarea datelor și cu operațiile care se pot aplica pe acestea.
Datele referitoare la produse, magazine și utilizatori vor fi stocate intr-o bază de date cu mai multe tabele iar obținerea
și prelucrarea datelor se va realizeaza folosind limbajul Java astfel fiecare tip de date va avea asociat câte două clase, una pentru
definirea proprietățiilor tipului de date și una pentru extragerea și prelucrarea datelor din baza de date.De asemnea vor exista clase adiționale care se vor ocupa cu realizarea comunicării dintre clasele de logică și partea de *interfață utilizator*.

## Descrierea soluției
Responsabilitatea claselor din aplicație este împărțită pe pachete după cum urmează:
![alt text](https://github.com/cosmacatalin98/ProductFinder/blob/master/UMLPackageDiagarm.jpeg)
Pachetul domain conține clasele corespunzătoare tipurilor de bază (Product, Store, User).\
Pachetul connection conține clasele care se ocupă de realizarea conexiunii la baza de date.\
Pachetul infoaccess conține clasele responsabile de preluarea și prelucrarea datelor din baza de date.\
Pachetul application conține clasele care se ocupă de rularea aplicației propriu-zise.

Pentru partea de back end se utilizează structura de clase din următoarea diagramă :
![alt text](https://github.com/cosmacatalin98/ProductFinder/blob/master/UMLNewClassDiagram.jpeg)

Fiecare tabelă din baza de date are asociată o clasă care are ca și atribute câmpurile tabelei, astfel clasele Product, Store și User corespund obiectelor din tabelele products, stores și users, aceste clase se ocupă doar de definirea tipului și operații simple (get,set) pe acesta.

Clasele ProductBLL,StoreBLL și UserBLL implementează o interfață comună numită DBAccessOperations care definește operațiile de obținere, inserare, actualizare și ștergere de obiecte din baza de date, operații care sunt implementate diferit de fiecare dintre cele trei clase în conformitate cu tipul de obiect asociat.
În special, clasa ProductBLL definește metode adiționale pentru căutarea și sortarea obiectelor de tip Product .

Clasa DBAOContext a fost implementată după șablonul de proiectare Strategy și are rolul de a mării încapsularea.

Clasa DBAccessFacade a fost implementată după șablonul de proiectare Facade cu rolul de a simplifica utilizarea operațiilor de manipulare a datelor din clasele ProductBLL, StoreBLL și UserBLL.

Clasa ConnectionFactory se ocupă în special de implementarea operațiilor legate de conexiunea dintre aplicație și baza de date.

Clasa PFApplication conține o singură metodă (main) și este utilizată pentru rularea aplicației.

Funcționarea internă a aplicației se poate observa în următoarea diagramă de secvențe unde este prezentat un exemplu de căutare după nume a unui produs , acțiune realizată de un utilizator oarecare prin intermediul Interfeței Utilizator sau UI(User Interface) prezentată sub forma unei pagini Web.

![alt text](https://github.com/cosmacatalin98/ProductFinder/blob/master/UMLSequenceDiagram.jpeg)

### Partea de front end (UI)
Această parte va avea rolul de a prezenta utilizatorului o interfață grafică sub forma unei pagini web prin intermediul căreia să se
faciliteze utilizarea aplicației de către acesta.Pagina de web va fi fi implementată cu ajutorul framework-ului Angular și o combinație de limbaje precum : HTML, CSS, TypeScript.

## Descrierea soluției
La accesarea aplicației web se afișează o pagină de autentificare care are rolul de a permite accesul la aplicație în funcție de tipul de cont al persoanei care se autentifică. Există două tipuri de conturi care au asociate diferite privilegii :
- cont de tip utilizator
- cont de tip administrator
Ambele tipuri necesită o autentificare pe baza unui nume de utilizator și o parolă.

![alt text](https://github.com/cosmacatalin98/ProductFinder/blob/master/log-in.jpeg)

