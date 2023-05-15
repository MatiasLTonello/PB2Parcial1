# PB2 Primer parcial

## Torneo S.A App

### Requerimentos: 

Se requiere poder crear un torneo. El mismo debe contar con 10 equipos para poder generar un fixture en el que jueguen todos los equipos contra todos (generando un total de 45 partidos). El torneo no debe permitir agregar más de 10 equipos, ni tampoco equipos con el mismo nombre para evitar confusión para dar difusión de los partidos. En el torneo, se requiere poder generar una tabla de rankings con el jugador que hizo más goles en todas las fechas, el jugador más amonestado, y el más expulsado. También tendremos una tabla de posiciones, utilizando el formato de victoria = 3 puntos, empate = 1 punto, y derrota = 0 puntos.

De los equipos, se interesa poder registrar el nombre, su apodo y dirección. Además, cada equipo debe tener un máximo de 6 jugadores. Estos jugadores deben ser mayor de edad (ya que hay premios de alcohol). A su vez, sólo se aceptará un máximo de 2 personas partes del cuerpo técnico, que serán parte de la dirección técnica (DT) o asistentes. En el tema indumentaria, necesitamos que con el jugador se registre su número de dorsal, y por ende, no podemos permitir que dos jugadores tengan el mismo. Otro dato importante para los equipos, debemos almacenar su cantidad de victorias, empates y derrotas, que luego serán usados para generar la tabla de posiciones.

Por otra parte, también necesitamos poder tener un registro de los partidos. De los mismos, vamos a estar almacenando los datos del equipo local y del equipo visitante. Otro requerimiento, es poder registrar los eventos del partido. Estos eventos podrían ser anotar un gol, una amonestación o expulsión a un jugador. Para los mismos, hay que almacenar el jugador que participó de dicho evento, y el minuto en que ocurrió. Esto nos ayudará luego para obtener el ranking. A su vez, poder tener un registro con la lista de amonestados del partido, y generar la implementación de una regla muy importante, que es que si un jugador recibe dos tarjetas amarillas en el mismo partido, debe ser automáticamente expulsado.


## Authors

- [@MatiasLTonello](https://www.github.com/MatiasLTonello)
- [@Rayvony](https://www.github.com/Rayvony)
- [@mariela1982](https://www.github.com/mariela1982)


