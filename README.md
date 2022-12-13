# Práctica piedra, papel o tijera Marcos SM
## Resumen de jugabilidad
El programa es un piedra, papel o tijera sencillo, con dos dificultades a elegir (fácil y dificil) y dos idiomas (español e inglés).  
Al comenzar el programa veremos una interfaz sencilla que nos da la bienvenida y nos invita a escoger entre 4 opciones:  
1.- Jugar: Esta opción comenzará la partida con configuración establecida.  
2.- Cambiar idioma: Esta opción modificara el archivo de configuración, modificando el idioma al que escoja el usuario.  
3.- Cambiar dificultad: Esta opción modificara el archivo de configuración, modificando la dificultad del juego a la que escoja el usuario.  
4.- Salir: Esta opción cerrará el programa.  

## Configuración inicial
El programa no debería de requerir ningúna modificación para ejecutarse correctamente, en caso de que de algún error de lectura de algún fichero deberás de mover los directorios de dichos ficheros un nivel hacía afuera. (Del directorio PiedraPapelOtijera al de práctica-1-VIMarcosIV).
Además si te salen errores ortográficos deberás cambiar el Encoding de los archivos a UTF8 desde los ajustes de Encoding del IDE.  

## Funcionamiento a nivel técnico
-El programa cuenta con la libreria SLF4J para hacer el traceo del sistema mediante un log.  
Dicho log se almacena en un archivo (applog.log) que viene dado por su configuración almacenada en simplelogger.properties.  

-Para el idioma tenemos dos archivos .properties (Español.properties y English.properties respectivamente), que en función del idioma elegido por el usuario el programa leerá uno u otro (Según lo establecido en el archivo Config.properties).  

-Con la dificultad pasa lo mismo, tenemos dentro del archivo Config.properties dos conjuntos de claves/valor (Una para el idioma a cargar y otra para la dificultad a    cargar), y en función de lo escogido por el usuario cargará una modalidad de juego u otra.

-Y el resto es el juego en sí como tal, es un Piedra, papel o tiejera hecho con switches, en el que jugaremos 4 partidas en cada modalidad y el programa recogerá los resultados en los contadores, empates, derrotas y victorias y los mostrará por pantalla.  


