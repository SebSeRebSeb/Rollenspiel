# Willkommen zum DKB-RPG-SIMULATOR II
## ---------------------------------------------------------------------------

##Anleitung:

### 1. Start der Anwendung 
####Das Spiel startet im Startmenü mit dem Willkommensbildschirm
### 2. Das Startmenü
#### Im Startmenü muss die Entscheidung getroffen werden, ob 
####-eine neue Party ertellt werden soll,           
####-eine bestehende Party importiert werden soll, oder
####-ein Zufallskampf ausgetragen werden soll.      
        ("1) Create new parties (C)")
        ("2) Import parties (L)")
        ("3) Random fight (R)")
##### Drückt man keine der vorgegebenen Tasten, erscheint eine Fehlermeldung und man kann erneut einen Buchstaben eingeben.
        Input not accepted. Please choose between 1) (=C), 2) (=L) and 3) (=R).
#### 2.1    Erstellung einer neuen Party 

##### 2.1.1 ("1) Create new parties (C)") 
##### Bei Auswahl (1) mit der Taste "C" wird die Frage nach der Größe der zu erstellenden Party für Party 1 und Party 2 gestellt. Möglich ist die freie Wahl zwischen 1 - 10 Spielern.
        Choose the size of the parties (1-10)
##### Gibt man einen Wert von weniger als 1, bzw. mehr als 10 ein, erscheint eine Fehlermeldung und man kann erneut eine Zahl eingeben.

##### 2.1.2. Create a Character
##### In diesem Schritt wählt man die zu erstellende Klasse des Characters. Es besteht die Wahl zwischen einem "Wizard" und einem "Warrior".
        Type of character (1=Wizard;2=Warrior)
##### Dieser Vorgang wird solange wiederholt, bis die vorher festgelegte Party-Größe erreicht ist.
##### Die Klassen "Wizard" und "Warrior" haben unterschiedliche Eigenschaften. Die Namen der Charaktere werden zufällig erzeugt.
##### Der Wizard hat folgende Eigenschaften:
        -Hp:                    50-100
        -Mana:                  10-50
        -Intelligence (Damage): 1-50
##### Der Warrior hat folgende Eigenschaften:
        -Hp:                    100-200
        -Stamina:               10-50
        -Strength (Damage):     1-10
                

##### 2.1.3 Party exportieren
##### Sobald eine Party vollständig erstellt wurde, kann man die Party exportieren (J = Ja , N = Nein), um sie in einem neuen Spiel wieder zu importieren. Siehe <u>2.2.1</u>
        Do you wish to export the created parties (J/N)?
##### Wählt man "Ja", wird je nach Party eine *.csv-Datei erstellt (Bsp.: Für Party 1 = "partyOne.csv").
##### Der Kampf wird anschließend gestartet! (Siehe <u> 3.1 </u>)
       The Game will be started!

####  2.2 Parties importieren

##### 2.2.1 ("2) Import parties (L)")
##### Bei Auswahl (2) mit der Taste "L" sucht das System automatisch die Dateien "partyOne.csv" und "partyTwo.csv" und lädt die gespeicherten Parties sofort ins System. Der Kampf wird anschließend gestartet! (Siehe <u> 3.1 </u>
##### Sind keine Dateien vorhanden, erhält der Benutzer eine Fehlermeldung (FileNotFoundException).

#### 2.3 Einen Zufallskampf austragen

##### 2.3.1 ("3) Random fight (R)")
##### Bei Auswahl (3) mit der Taste "R" werden gleichgroße, zufällig generierte Parties erstellt. Der Kampf wird anschließend gestartet! (Siehe <u> 3.1 </u>)

###  3. Das Kampfsystem

#### 3.1 Character für den Kampf auswählen 
#### Ein Kampf findet rundenbasiert statt. In jeder Runde muss pro Party einen Character für den nächsten Kampf gewählt werden. Hierfür muss die Zahl des Characters eingegeben werden.
        Beispiel:
        Choose your fighter:
        1. Character Heinz (Type: Wizard)
        HP:86|Mana:42|Intelligence:4
        2. Character Oliver (Type: Wizard)
        HP:73|Mana:23|Intelligence:47
        3. Character Janine (Type: Wizard)
        HP:93|Mana:48|Intelligence:38
        Choose a fighter (Input: 1-3):

#### 3.2 Der Kampf und der Friedhof
#### Die gewählten Charaktere kämpfen solange, bis einer stirbt und zum Friedhof geschickt wird. Nach jeder Runde wird angezeigt, welche Charaktere bereits auf dem Friedhof gelandet sind.
        Beispiel:
        Sandra has been slaughtered!
        Sandra will be sent to the Graveyard.
        In the big clash of forces died the following Characters:
        Sandra

#### 3.3 Der Sieger
#### Gewonnen hat die Party, die nach den Kämpfen noch lebende Spieler besitzt. Tritt der Fall ein, dass beide Parties gleichzeitig keine lebenden Charaktere mehr besitzen, wird das Spiel unentschieden beendet.
        #############################################################"
        ###################It's a TIE !##############################"
        #############################################################"

        #############################################################"
        ###################Party 1 won!##############################"
        #############################################################"

        #############################################################"
        ###################Party 2 won!##############################"
        #############################################################"