import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class SimuladorViajeInterplanetario {

    // Datos de planetas
    static String[] planetas = {"Marte", "Júpiter", "Saturno","Marcurio","Coruscant","Mustafar","Tatooine"};
    static double[] distancias = {78.34, 628.73, 1284.0,91.3,5011.4,2700.152,4345.4}; // Distancias en millones de kilómetros
    static String [] detalle = {"Marte es el cuarto planeta del sistema solar y conocido como el planeta rojo", 
    "Júpiter es el planeta más grande del sistema solar y uno de los cuerpos más brillantes en el cielo nocturno.",
     "Saturno es otro gigante gaseoso y es famoso por sus impresionantes anillos, formados por partículas de hielo y roca.",
     "Mercurio es el planeta más cercano al Sol y tiene temperaturas extremas debido a su proximidad al Sol.", 
    "El centro político de la galaxia, completamente urbanizado y conocido por su enorme ciudad capital.", 
    "Un planeta volcánico donde Anakin y Obi-Wan tienen su épica batalla en La Venganza de los Sith.", 
    "Un planeta desértico, hogar de Anakin Skywalker y Luke Skywalker."};
    static double velocidad = 100000; // Velocidad de la nave en km/h
    static String planetaDestino = "";
    static double distanciaDestino = 0;
    static boolean naveHangar = false;
    static double recorridoNecesarioDeLaNave = 0;
    static double combustible = 0;
    static double oxigeno = 0;
    static double energia = 0;
    static ArrayList<Pasajero> pasajeros  = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;



        System.out.println("Hace mucho, mucho tiempo en una galaxia muy muy lejana........");

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(" _________________________ __________  ________  _______________   ____");
        System.out.println("/   _____/\\__    ___/  _  \\\\______   \\ \\______ \\ \\_   _____/\\   \\ /   /");
        System.out.println(" \\_____  \\   |    | /  /_\\  \\|       _/  |    |  \\ |    __)_  \\   Y   / ");
        System.out.println(" /        \\  |    |/    |    \\    |   \\  |    `   \\|        \\  \\     /  ");
        System.out.println("/_______  /  |____|\\____|__  /____|_  / /_______  /_______  /   \\___/   ");
        System.out.println("        \\/                 \\/       \\/          \\/        \\/            ");
        System.out.println("--------------------------------------------------------------------------------------");
       
        System.out.println("                 Episodio 1: Dos novatos en la Tierra                    ");
        System.out.println("En una época donde la tecnología avanza ");
        System.out.println("Donde la innovación y la exploración se juntan ");
        System.out.println("llegan dos personas del planeta Tierra para intentar...");
        System.out.println("              programar un código galáctico"); 
        System.out.println("Que el código esté contigo");
        
    
       
        // Presentación del programa

        System.out.println("***********************************************************");
        System.out.println("Bienvenidos al Simulador de Viaje Intergalactico");
        System.out.println("Equipo: Angela Vanessa Zamora Cuan y Angel Santiago Zarta");
        System.out.println("Fecha: 07-12-24\n");
        System.out.println("***********************************************************");

        while (continuar) {
            System.out.println("*******************************************************");
            System.out.println("Menú:");
            System.out.println("1. Seleccionar un planeta de destino");
            System.out.println("2. Seleccionar una nave espacial");
            System.out.println("3 .Ingresar Pasajeros");
            System.out.println("4. Ingresar los recursos para el viaje");
            System.out.println("5. Iniciar la simulación del viaje");
            System.out.println("6. Salir");
            System.out.println("*******************************************************");
            System.out.print("Seleccione una opción: ");

            

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    seleccionarPlaneta(sc);
                    break;
                case 2:
                    seleccionarNave(sc);
                    break;
                case 3:
                    ingresarPasajeros(sc);
                    break;    
                case 4:
                    ingresarRecursos(sc);
                    break;    
                case 5:
                    iniciarViaje(sc);
                    break;
                case 6:
                    System.out.println("Gracias por usar el simulador. ¡Hasta la próxima!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }
        }
        sc.close();
    }
        // seleccionar PLaneta
    static void seleccionarPlaneta(Scanner sc) {
        System.out.println("\nPlanetas disponibles:");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println((i + 1) + ". " + planetas[i] + " - " + distancias[i] + " millones de kilómetros");
        }
        System.out.print("Seleccione el planeta de destino (1-" + planetas.length + "): ");
        int seleccion = sc.nextInt();

        if (seleccion >= 1 && seleccion <= planetas.length) {
            planetaDestino = planetas[seleccion - 1];
            distanciaDestino = distancias[seleccion - 1];
            System.out.println("Ha seleccionado: " + planetas[seleccion - 1]);
            System.out.println("descripcion; " + detalle[seleccion - 1]);
            System.out.println("Distancia: " + distancias[seleccion - 1] + " millones de kilómetros.\n");
            System.out.println("Estas seguro que deseas viajar a " + planetas[seleccion-1]+ "? (S/N)" );
            char opcion = sc.next().charAt(0);

                if (opcion == 's' || opcion == 'S'){
                planetaDestino = planetas[seleccion - 1];
                distanciaDestino = distancias[seleccion - 1];
                System.out.println("Destino confirmado: "+planetaDestino+"\n");
                
                } else {
                        System.out.println("Por favor elige un planeta \n");
                }

        } else {
            System.out.println("Selección inválida. Intente nuevamente.\n");
        }
    }
    //Funcionalidad de la nave
    static void seleccionarNave(Scanner sc) {
        if (planetaDestino.isEmpty()) {
            System.out.println("¡Debe seleccionar un planeta de destino antes de seleccionar una nave!***");
            return;
        }
        System.out.println("\nNaves disponibles:");
        System.out.println("1. Explorador - Velocidad Máxima: 100,000 km/h");
        System.out.println("2. viajero - Velocidad Máxima: 120,000 km/h");
        System.out.println("3. Cometa - Velocidad Máxima: 150,000 km/h");
        System.out.println("4. X-Wing - Velocidad Máxima: 950,000 km/h");
        System.out.println("5. Halcon Milenario - Velocidad Máxima: 2,000,000 km/h");
        System.out.print("Seleccione su nave (1-5): ");
        int seleccion = sc.nextInt();

        switch (seleccion) {
            case 1:
                velocidad = 100000;
                naveHangar = true;
                System.out.println("Ha seleccionado la nave Explorador.\n");
                break;
            case 2:
                velocidad = 120000;
                naveHangar = true;
                System.out.println("Ha seleccionado la nave viajero.\n");
                break;
            case 3:
                velocidad = 150000;
                naveHangar = true;
                System.out.println("Ha seleccionado la nave Cometa.\n");
                break;
            case 4:
                velocidad = 950000;
                naveHangar = true;
                System.out.println("Ha seleccionado la nave  X-Wing.\n");
                break;
            case 5:
                velocidad = 2000000;
                naveHangar = true;
                System.out.println("Ha seleccionado la nave Halcon Milenario.\n");
                break;
            default:
                System.out.println("Selección inválida. Intente nuevamente.\n");
                naveHangar = false;
        }
            naveHangar = true;
            System.out.println("Haz seleccionado la nave de " +velocidad+ "kilometros");
       
            double trayectoEnKilometros = distanciaDestino * 1000000;
            recorridoNecesarioDeLaNave = trayectoEnKilometros/velocidad;
            var dias = (int) recorridoNecesarioDeLaNave/24;
            var tiempoRestante = (int) recorridoNecesarioDeLaNave % 24;

            System.out.printf("Con la velocidad actual el tiempo necesario para llegar al destino es: %d dias y %d horas \n", dias, tiempoRestante);

    
            System.out.println("Estas seguro que deseas utilizar esta nave? (S/N)" );
            char opcion = sc.next().charAt(0);

                if (opcion == 's' || opcion == 'S'){
                naveHangar= true;
                System.out.println("Nave desplegada en el Hangar 01 \n");
                
                } else {
                    naveHangar= false;
                    System.out.println("Por favor selecciones una nave \n");
                }

        }

        //Ingresar Psajeros
    static void ingresarPasajeros(Scanner sc) {

        
        if (planetaDestino.isEmpty()) {
            System.out.println("¡Debes seleccionar un planeta de destino antes de Ingresar los recursos!***");
            return;
        }
        if (!naveHangar) {
            System.out.println("¡Debes seleccionar una nave espacial antes de ingresar los recursos!*****");
            return;
        }    

        System.out.println("¿Cuantos pasajeros iran en la nave?");
        int pickPassengers = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < pickPassengers; i++ ) {
        System.out.print("Cual es el nombre del pasajero" + (i+1) + ":");
        String nombre = sc.nextLine();
        pasajeros.add(new Pasajero(nombre));
        }   
        
        System.out.println("Pasajeros Registrados");
        for (Pasajero pasajero : pasajeros) {

              System.out.println("- "+ pasajero.getNombre());  
        }
    }


    static void ingresarRecursos(Scanner sc){

        if (planetaDestino.isEmpty()) {
            System.out.println("¡Debes seleccionar un planeta de destino antes de Ingresar los recursos!***");
            return;
        }
        if (!naveHangar) {
            System.out.println("¡Debes seleccionar una nave espacial antes de ingresar los recursos!*****");
            return;
        }    
        if (pasajeros.isEmpty()) {
            System.out.println("¡Debes registrar los pasajeros antes de ingresar los recursos!***");
            return;
        }

        System.out.println("Ingrese los recursos para el viaje");
        System.out.println("Cantidad de combustible a Disposicion (litros)");
        combustible = sc.nextDouble();
        System.out.println("Cantidad de Oxigeno a Disposicion(litros)");
        oxigeno = sc.nextDouble();
        System.out.println("Cantidad de energia a Disposicion (Kwh)");
        energia = sc.nextDouble();

        if (combustible >= distanciaDestino * 10 && oxigeno >= distanciaDestino && energia >= distanciaDestino*100){

            System.out.println("Tienes los recuroso suficientes para el viaje!!!");
        }else{
            System.out.println("¡¡¡¡¡Precaucion!!! Recursos insuficientes por favor verificar nuevamente ");
        }
    }
   
    static void iniciarViaje(Scanner sc) {
        if (planetaDestino.isEmpty()) {
            System.out.println("¡Debes seleccionar un planeta de destino antes de iniciar el viaje!***");
            return;
        }
        if (!naveHangar) {
            System.out.println("¡Debes seleccionar una nave espacial antes de iniciar el viaje!*****");
            return;
        }    
        if (pasajeros.isEmpty()) {
            System.out.println("¡Debes registrar los pasajeros antes de iniciar el viaje!***");
            return;
        }
        if (combustible == 0 || oxigeno == 0 || energia == 0 ) {
            System.out.println("¡Debes ingresar recursos para iniciar el viaje!***");
            return;
        }
        System.out.println("\nSimulacion de vieje inciada hacia: "+ planetaDestino + ".......*****");

        System.out.println("Pasajeros en la nave");

        for (Pasajero pasajero : pasajeros) {

            System.out.println("-" +pasajero.getNombre());
        }

        System.out.println("Recursos Envarcados en la nave");
        recursosEnNave();


        System.out.println("\nSimulación del Viaje Iniciada...");



        Random random = new Random();

        for (int progreso = 0; progreso <= 100; progreso += 20) {

            System.out.println("Progreso del viaje: " + progreso + "%");

           
            var numeroRandom = random.nextInt(100);

            if(numeroRandom < 10){

                gasesHirbiendo();
            } else if (numeroRandom < 15){

                hieloIntergalactico();
            }else if (numeroRandom < 20 ){

                purgillGigante();
            }else if (numeroRandom < 25){

                cuerpoErrante();
            }else if (numeroRandom < 30){

                batallaImperio();
            }else  if (numeroRandom < 35){

                errorSistema();
            }


            esperar(1000); // Simula la espera de 1 segundo
        }


        System.out.println("¡El viaje ha sido completado exitosamente!\n");
        recursosEnNave();
        System.out.println("Pasajeros en la nave");

        for (Pasajero pasajero : pasajeros) {

            System.out.println("-" +pasajero.getNombre());
        }
    }



    static void recursosEnNave(){

        System.out.println("Recursos Restantes");
        System.out.println("Combustible: " +combustible);
        System.out.println("Oxigeno: " +oxigeno);
        System.out.println("Energia: " +energia);
    
    }
    

    static void gasesHirbiendo(){

        System.out.println("Se aproxima una nube de gases hirbiendo! Sobrevolando.......");
        combustible -= 50;
        oxigeno -= 100;
        energia -= 120;
    }

    static void hieloIntergalactico(){

        System.out.println("Se aproximan fragmentos de hielo a la nave! Descongelando el casco.......");
        combustible -= 20;
        oxigeno -= 20;
        energia -= 300;
    }
    
    static void purgillGigante(){

        System.out.println("Se aproxima un purgill Gigante! Batallando.......");
        combustible -= 200;
        oxigeno -= 50;
        energia -= 150;
    }
    
    static void cuerpoErrante(){

        System.out.println("Se aproximan objetos no identificados! Esquivando.......");
        combustible -= 200;
        oxigeno -= 200;
        energia -= 200;
    }
    
    static void batallaImperio(){

        System.out.println("Se aproxima el imperio! contraatacando.......");
        combustible -= 500;
        oxigeno -= 500;
        energia -= 500;
    }

    static void errorSistema(){

        System.out.println("El sistema ha sido hackeado! reparando.......");
        combustible -= 20;
        oxigeno -= 20;
        energia -= 100;
    }
    
    


    static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static class Pasajero {
        private String nombre;

        public Pasajero(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

}

}