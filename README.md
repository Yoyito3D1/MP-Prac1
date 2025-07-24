# 🔍 Projecte de Cerca de Nombres Primers Grans

Aquest projecte en Java permet calcular **el nombre primer més gran menor o igual a un valor donat**, llegint valors des d’un fitxer d’entrada i escrivint els resultats en un fitxer `.csv`.

---

## 📦 Contingut del projecte

🧮 **Classes principals:**

- `Primer.java`: Conté els mètodes per detectar si un número és primer i buscar el primer més gran a un valor donat, tant per `long` com per `BigInteger`.
- `UsaPrimer.java`: Programa principal que llegeix els valors d’un fitxer (`FitEntrada.txt`), aplica la cerca de primers i desa els resultats i el temps emprat en un fitxer de sortida.

---

## 🚀 Com funciona

1. 👤 L'usuari introdueix quantes línies vol llegir del fitxer `FitEntrada.txt` (màxim 15).
2. 📖 El programa llegeix aquests valors i detecta si han de ser tractats com `long` o com `BigInteger`.
3. 🔎 Es calcula el **primer més gran** per cada valor.
4. ⏱️ Es mesura el temps d’execució per a cada càlcul.
5. 💾 Es genera un fitxer `.csv` amb el resultat:
   - Valor original
   - Primer més gran trobat
   - Temps emprat (en mil·lisegons)

---

## 📂 Exemple de fitxer `.csv` generat

```csv
Valor; Primer; Temps
100000000000003; 99999999999989; 3.402 ms
987654321987654321; 987654321987654319; 12.784 ms
...

🛠️ Requisits
JDK 8 o superior

Fitxer FitEntrada.txt amb un màxim de 15 línies numèriques
