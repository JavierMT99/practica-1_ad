import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    static FileReader reader;
    static Scanner sc = new Scanner(System.in);
    static Properties properties = new Properties();
    static Properties propertiesConfig = new Properties();
    static File config = new File("config/Config.properties");
    static File español = new File("languages/Español.properties");
    static File english = new File("languages/English.properties");
    static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.trace("Comienza el programa");
        String opcion = "";
        while (true) {
            try {
                log.trace("Leemos el archivo de configuración");
                reader = new FileReader(config);
                propertiesConfig.load(reader);
                log.trace("Leemos la configuración de idioma y la cargamos");
                if (propertiesConfig.getProperty("Idioma").equals("es")) {
                    // Español
                    reader = new FileReader(español);
                    properties.load(reader);
                } else if (propertiesConfig.getProperty("Idioma").equals("en")) {
                    // Inglés
                    reader = new FileReader(english);
                    properties.load(reader);
                }
                log.trace("Entramos en el menú inicial");
                System.out.println(properties.getProperty("Bienvenida"));
                System.out.println(properties.getProperty("SeleccionaUnaOpcion"));
                System.out.println(properties.getProperty("Jugar"));
                System.out.println(properties.getProperty("CambiarIdioma"));
                System.out.println(properties.getProperty("CambiarDificultad"));
                System.out.println(properties.getProperty("Salir"));
                opcion = sc.nextLine();
                log.trace("Entramos en el juego con la última configuración estabecida");
                log.warn("Si el usuario introduce un número mayor de 4 o algo que no sea un entero el programa crasheara");
                if (Integer.parseInt(opcion) == 1) {
                    int opcionIA = 0;
                    int victorias = 0;
                    int derrotas = 0;
                    int empates = 0;
                    log.trace("Comienza la partida en dificultad fácil");
                    if (propertiesConfig.getProperty("Dificultad").equals("Facil")) {
                        for (int i = 0; i < 4; i++) {
                            opcionIA = (int) (Math.random() * 3 + 1);
                            System.out.println(properties.getProperty("SeleccionaUnaOpcion"));
                            System.out.println(properties.getProperty("Piedra"));
                            System.out.println(properties.getProperty("Papel"));
                            System.out.println(properties.getProperty("Tijera"));
                            opcion = sc.nextLine();
                            // Lógica del juego
                            log.warn("Si el usuario introduce un número mayor de 3 o algo que no sea un entero el programa crasheara");
                            switch (Integer.parseInt(opcion)) {
                                case 1://Piedra
                                    if (opcionIA == 1) {
                                        empates++;
                                    } else if (opcionIA == 2) {
                                        derrotas++;
                                    } else if (opcionIA == 3) {
                                        victorias++;
                                    }
                                    mostrarResultados(derrotas, victorias, empates);
                                    break;
                                case 2://Papel
                                    if (opcionIA == 1) {
                                        victorias++;
                                    } else if (opcionIA == 2) {
                                        empates++;
                                    } else if (opcionIA == 3) {
                                        derrotas++;
                                    }
                                    mostrarResultados(derrotas, victorias, empates);
                                    break;
                                case 3://Tijera
                                    if (opcionIA == 1) {
                                        derrotas++;
                                    } else if (opcionIA == 2) {
                                        victorias++;
                                    } else if (opcionIA == 3) {
                                        empates++;
                                    }
                                    mostrarResultados(derrotas, victorias, empates);
                                    break;
                            }
                            log.trace("Acaba la partida");
                        }
                    } else if (propertiesConfig.getProperty("Dificultad").equals("Dificil")) {
                        log.trace("Comienza la partida en dificultad dificil");
                        log.warn("Si el usuario introduce un número mayor de 3 o algo que no sea un entero el programa crasheara");
                        for (int i = 0; i < 4; i++) {
                            opcionIA = (int) (Math.random() * 3 + 1);
                            System.out.println(properties.getProperty("SeleccionaUnaOpcion"));
                            System.out.println(properties.getProperty("Piedra"));
                            System.out.println(properties.getProperty("Papel"));
                            System.out.println(properties.getProperty("Tijera"));
                            opcion = sc.nextLine();
                            if (i > 1) {
                                if (Integer.parseInt(opcion) != 3) {
                                    opcionIA = Integer.parseInt(opcion) + 1;
                                } else {
                                    opcionIA = 1;
                                }
                            }
                            // Lógica del juego
                            switch (Integer.parseInt(opcion)) {
                                case 1://Piedra
                                    if (opcionIA == 1) {
                                        empates++;
                                    } else if (opcionIA == 2) {
                                        derrotas++;
                                    } else if (opcionIA == 3) {
                                        victorias++;
                                    }
                                    mostrarResultados(derrotas, victorias, empates);
                                    break;
                                case 2://Papel
                                    if (opcionIA == 1) {
                                        victorias++;
                                    } else if (opcionIA == 2) {
                                        empates++;
                                    } else if (opcionIA == 3) {
                                        derrotas++;
                                    }
                                    mostrarResultados(derrotas, victorias, empates);
                                    break;
                                case 3://Tijera
                                    if (opcionIA == 1) {
                                        derrotas++;
                                    } else if (opcionIA == 2) {
                                        victorias++;
                                    } else if (opcionIA == 3) {
                                        empates++;
                                    }
                                    mostrarResultados(derrotas, victorias, empates);
                                    break;
                            }
                        }
                        log.trace("Acaba la partida");
                    }
                } else if (Integer.parseInt(opcion) == 2) {
                    log.trace("Entramos en el menu de cambiar idioma");
                    log.warn("Si el usuario introduce un número mayor de 2 o algo que no sea un entero el programa crasheara");
                    System.out.println(properties.getProperty("SeleccionaUnaOpcion"));
                    System.out.println(properties.getProperty("Español"));
                    System.out.println(properties.getProperty("Ingles"));
                    opcion = sc.nextLine();
                    log.trace("Cambiamos el idioma a Español");
                    if (Integer.parseInt(opcion) == 1) {
                        propertiesConfig.setProperty("Idioma", "es");
                        propertiesConfig.store(new BufferedWriter(new FileWriter(config)), "");
                        log.trace("Cambiamos el idioma a Inglés");
                    } else if (Integer.parseInt(opcion) == 2) {
                        propertiesConfig.setProperty("Idioma", "en");
                        propertiesConfig.store(new BufferedWriter(new FileWriter(config)), "");
                    }
                    log.warn("Si el usuario introduce un número mayor de 4 o algo que no sea un entero el programa crasheara");
                } else if (Integer.parseInt(opcion) == 3) {
                    log.warn("Si el usuario introduce un número mayor de 2 o algo que no sea un entero el programa crasheara");
                    System.out.println(properties.getProperty("SeleccionaUnaOpcion"));
                    System.out.println(properties.getProperty("Facil"));
                    System.out.println(properties.getProperty("Dificil"));
                    opcion = sc.nextLine();
                    log.trace("Cambiamos la dificultad a Fácil");
                    if (Integer.parseInt(opcion) == 1) {
                        propertiesConfig.setProperty("Dificultad", "Facil");
                        propertiesConfig.store(new BufferedWriter(new FileWriter(config)), "");
                        log.trace("Cambiamos la dificultad a Dificil");
                    } else if (Integer.parseInt(opcion) == 2) {
                        propertiesConfig.setProperty("Dificultad", "Dificil");
                        propertiesConfig.store(new BufferedWriter(new FileWriter(config)), "");
                    }
                } else if (Integer.parseInt(opcion) == 4) {
                    log.trace("Salimos del programa");
                    log.warn("Si el usuario introduce un número mayor de 4 o algo que no sea un entero el programa crasheara");
                    break;
                }
            } catch (FileNotFoundException e) {
                log.error("Error de ejecución, ya que no se encontro un archivo");
                throw new RuntimeException(e);
            } catch (IOException e) {
                log.error("Error durante el tiempo de ejecucion");
                throw new RuntimeException(e);
            } catch (Exception e) {
                log.error("Error del programa, probablemente debido a un input mal introducicdo");
                throw new RuntimeException(e);
            }
        }
    }

    private static void mostrarResultados(int derrotas, int victorias, int empates) {
        System.out.println(properties.getProperty("Victorias") + " = " + victorias);
        System.out.println(properties.getProperty("Derrotas") + " = " + derrotas);
        System.out.println(properties.getProperty("Empates") + " = " + empates);
    }
}