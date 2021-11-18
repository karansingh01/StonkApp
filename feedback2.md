# Tilbakemelding på innlevering 2

## Bygging

- spotbugs ga flere feil i ui-kontroller-klasser, check!
- checkstyle el.l. ikke koblet inn, check!

## Kodegjennomgang

### Stonk

- getStockInfo: "Could not find stock" er misvisende melding når ticker er null
- getStockInfo: det blir vanskelig å gi god tilbakemelding til brukeren, når unntak fanges opp

### DataHandler

- ikke bruk relative filnavn på denne måten, prosjektet er jo ikke der når brukeren installerer appen på ordentlig, check!

### User

- det er uheldig å gjøre en kjerneklasse avhengig av fillagring, det fungerer jo ikke når appen i stedet skal hente data fra en REST-tjeneste, check

### DataHandlerTest

- denne ligger i feil modul og gjør heller ikke noe, check

### StonkTest

- funksjonaliteten testes ikke, check

### StonkApp

- changeScene-metoden kan være nyttig, men ikke lett å få tak i når en må ha en instans av denne klassen. ellers kan den godt kodes slik at den gjenbrukes et tidligere innlastet panel, så en slipper å lese inn fxml-en på nytt hver gang
- globale/statiske variabler må unngås!, check!

### LoginController

- login- og registerUserNew-metodene viser at changeScene ligger i feil klasse, det gir ikke mening å lage en instans av app-klassen her, bare for å få brukt den metoden. lag heller en felles superklasse for alle kontroller-klassene med denne metoden, så kan den brukes av alle kontrollerne, check!

### MainController

- håndtering av json burde ikke være i en ui-klasse eller i ui-modulen for den saks skyld. json-koden burde vært ferdig dekodet i getPortfolio-metoden, check

### StockPageController

- overføring av data gjennom globale variabler er ikke bra!, check!
- updateStockPage: getPriceChange burde returner et tall, ikke en String, så kan en sjekke fortegnet og ikke tegn 0
- updateTotalPrice: en må ta høyde for at parseFloat utløser unntak, helst bør tekstfeltet validere input så en sikrer at tallformatet er korrekt
- metoder som updateTotalPrice bør @FXML-annoteres for å tydeliggjøre at disse kalles automatisk som respons på hendelser (events)
- for mange tekstfelt er det bedre å reagere på endringer i tekstinnholdet (onTextChanged) enn på tastetrykk

### StonkBuyTest

- se om Junit 5 sine "parameterized tests" kan gjøre dette mer elegant

### StonkLoginTest

- testLoginFalse: jeg tror ikke det fungerer å fange opp feil på denne måten, unntakene utløses i ui-tråden, ikke i test-tråden
