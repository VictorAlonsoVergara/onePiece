## Backend del ejercicio del anime One Piece
En este repositorio se almacena la codificación del módulo de backend con el lenguaje Java y el framework Spring Boot.

Se realizaron 3 api rest para ser consumidas las cuales obtienen la información más relevante de cada servicio REST brindado por el usuario. 

A continuación, se describe la información obtenida en cada una:

- La información que se muestra con la primera api rest es el id de la película, el url, el url de la imagen default y el título. Para obtener la información de las películas es a través del siguiente endpoint:  
```
/movies
```
- La información que se muestra con la segunda api rest es el id del personaje, el url, el url de la imagen default, el nombre y el rol. Para obtener la información de los personajes es a través del siguiente endpoint:  
```
/characters/{id}
```
- La información que se muestra con la tercera api rest es el id de la película, el url, el url de la imagen default, el nombre, la lista de apodos, la descripción, seguida de dos listas de información del anime y manga al que pertenece el personaje con su rol respectivo en cada uno. Para obtener la información completa del personaje es a través del siguiente endpoint:  
```
/fullcharacters/{id}
```
