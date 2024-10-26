# Współbieżność w Javie - Symulacja Warunków Wyścigu

## Przegląd

Projekt demonstruje problem warunków wyścigu w&nbsp;aplikacjach wielowątkowych. Symulacja ilustruje, jak brak synchronizacji prowadzi do błędów, gdy dwa wątki współzawodniczą o&nbsp;dostęp do&nbsp;wspólnego zasobu (licznika). Celem jest zrozumienie problemów związanych z&nbsp;równoległym przetwarzaniem i&nbsp;doskonalenie zarządzania współbieżnością.

## Szybki Start

### Wymagania wstępne

- **Java Development Kit (JDK) 1.8**

### Instalacja

1. Sklonuj repozytorium:
   ```bash
   git clone https://github.com/akotu235/Race.git
   ```

2. Przejdź do katalogu projektu:
    ```bash
    cd Race
    ```

3. Zbuduj projekt:
    ```bash
    .\mvnw clean install
    ```

### Uruchamianie symulacji

Uruchom symulację z wybraną wersją licznika jako argumentem:

```bash
java -jar .\target\Race-jar-with-dependencies.jar 3
```

W powyższym przykładzie `CounterV3` reprezentuje wersję licznika używaną w&nbsp;symulacji.

## Implementacje Licznika

Różne wersje liczników ilustrują kolejne podejścia do&nbsp;synchronizacji:

1. `CounterV1`: Brak synchronizacji, co&nbsp;powoduje warunki wyścigu.

2. `CounterV2`: Synchronizacja metod `inc()` i `dec()` za&nbsp;pomocą `synchronized`.

3. `CounterV3`: Synchronizacja z wykorzystaniem zegara `Clock` i&nbsp;"slotów czasowych".

4. `CounterV4`: Rozdzielenie operacji `inc()` i&nbsp;`dec()` na&nbsp;etapy.

5. `CounterV5`: Synchronizacja przy użyciu semafora (`Semafor`).

## Raporty

Szczegóły implementacji i analizy:

- [Raport 1](report1.md) – Problem wyścigu i&nbsp;podejścia do&nbsp;synchronizacji
- [Raport 2](report2.md) – Rozwiązanie z semaforem.