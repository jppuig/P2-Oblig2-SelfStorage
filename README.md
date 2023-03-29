# Self-storage - Obligatorio 2 (Programación 2)

Self-storage ("auto-almacenamiento") es una forma de guardar pertenencias en depósitos, a través del alquiler del espacio necesario.
Self-Storage SA es una empresa que se dedica al alquiler de variados tipos de depósitos para sus clientes para permitir el almacenamiento.

### El sistema debe permitir:

a) Registro de depósito. Cada depósito tiene un número único que lo identifica, tamaño en m2, la indicación de si es con estantes o no y la indicación de si es refrigerado o no.

b) Registro de empleado. Se indica nombre, cédula (no es necesario validar formato), dirección, año de ingreso y teléfono.

c) Registro de cliente. Se indica nombre, cédula (no es necesario validar formato), mail y teléfono. (Nota: no hay empleados que sean clientes ni viceversa).

d) Registro de contrato. Se elige el empleado de una lista, se elige el cliente de una lista, se indican las características deseadas (tamaño mínimo y máximo, con estantes/ sin estantes/ no relevante, refrigerado/no refrigerado/no relevante) y se muestra en una lista todos los depósitos no alquilados de esas características específicas, ordenado por número.
Destacar: en verde los depósitos con estantes y refrigerados, en naranja los que tiene estantes y no refrigerados, en amarillo los que son sin estantes y refrigerados y en turquesa los que son sin estantes y no refrigerados.
Se seleccionan los que se alquilan. Se indica un texto con detalles del alquiler. Al registrar, se genera automáticamente un contrato autonumerado por cada depósito en particular seleccionado.

e) Visita a depósito. Cada vez que el cliente va a uno de sus depósitos alquilados, se registra en el sistema. Se elige el cliente de una lista, y se muestran sus contratos, se elige, también se selecciona el empleado de una lista, se indica día y mes y se registra.

f) Consulta/baja de contrato. Se elige un contrato de una lista y se muestran a modo informativo los datos completos del contrato y en una tabla se visualizan todas las visitas que se realizaron, ordenadas por fecha.
Si se indica dar de baja ese contrato, previa confirmación, se graba un archivo cuyo nombre es el nombre del cliente y número de contrato (ej. "Ana García 153") y se graba una línea por cada visita realizada al depósito. Se eliminan del sistema las visitas y el contrato.

g) Estadística de ocupación. Se muestra en una gráfica de torta los depósitos alquilados (desglosando por refrigerado/con estantes, refrigerado/sin estantes, no refrigerado/con estantes, no refrigerado/sin estantes). (Nota: el equipo deberá investigar por cuenta propia formas de graficar en Java).

h) Consulta de depósitos. Se muestra en una grilla de varias filas y 5 columnas todos los depósitos ordenados por número (si hay muchas filas, incluir "scroll" vertical). En cada elemento, se muestra el número de depósito y debe ser de color verde si está libre o rojo si está alquilado. Al presionar sobre un depósito mostrar en una ventana emergente su información. En el caso que esté alquilado, incluir además el número de contrato, nombre del cliente y la cantidad de visitas.


#### A los efectos de la prueba del sistema se debe consultar al ingreso si:
a) se toman los datos guardados anteriormente,
b) se parte de un sistema vacío, o
c) se parte de un conjunto de depósitos: se elige un archivo de una lista y se cargan esos depósitos. Se asumen están todos no alquilados y no hay inconsistencias. El archivo contendrá una línea por depósito. El formato es: número#metros cuadrados#conEstantes#Refrigerado. El valor de conEstantes y Refrigerado es "S" o "N".

### Se pide:

Implementar en Java un sistema para brindar todas las funcionalidades presentadas. La interfaz debe ser estilo Windows, en ventanas independientes. El sistema debe ser persistente (en forma automática) y realizar todas las validaciones necesarias. Se valorará que toda la información esté permanentemente actualizada en pantalla. Entregar además un archivo .jar que contenga toda la aplicación para funcionar correctamente.


