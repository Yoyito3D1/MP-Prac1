🔢 Projecte: Cerca de nombres primers grans
Aquest projecte en Java té com a objectiu trobar el nombre primer més gran i proper a un valor donat. 📈 Està pensat per gestionar valors molt grans, i utilitza optimitzacions per fer-ho de manera eficient!

🧠 Funcionalitat principal
Donats diversos números des d’un fitxer d’entrada (FitEntrada.txt), el programa:

Determina si ha de tractar el número com a Long o BigInteger.

Cerca el nombre primer més gran i pròxim a aquell valor.

Mesura el temps d’execució de cada cerca.

Desa els resultats (valor original, primer trobat i temps) en un fitxer .csv 📝

🧪 Exemple d’ús
L’usuari indica quantes línies llegir del fitxer.

Es calcula el primer per a cada línia.

S’imprimeixen i desen els resultats.

🛠️ Estructura del projecte
Primer.java → Conté els mètodes per verificar si un nombre és primer i cercar el primer més gran, tant amb long com amb BigInteger.

UsaPrimer.java → Classe principal que llegeix dades, fa càlculs, i escriu els resultats.

FitEntrada.txt → Fitxer d’entrada amb valors numèrics.

resultats.csv → Fitxer de sortida amb els resultats.

📊 Exemple de sortida (.csv)
python-repl
Copiar
Editar
Valor     ; Primer     ; Temps
982451653 ; 982451653  ; 0.123 ms
100000000000000000001 ; 99999999999999999989 ; 52.345 ms
...
🚀 Altres detalls
🧮 Per a valors molt grans s'utilitza la classe BigInteger.

⏱️ El temps d'execució es calcula amb System.nanoTime().

📂 Els fitxers d’entrada i sortida es poden personalitzar fàcilment.
