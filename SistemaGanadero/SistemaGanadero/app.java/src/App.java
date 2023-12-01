import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // declarando variables genericas
        Integer opc = 0;

        // Declarando Variables de usuario

        int intentosMaximos = 3;
        int intentos = 0;
        boolean accesoConcedido = false;
        
        double cantidadARetirar;

        Scanner capturar = new Scanner(System.in);
        //Arraylist para almacenar la informacion de ganado
        ArrayList<modeloGanadero> ganado = new ArrayList<>();
        //Arraylist para almacenar la informacion sobre ventas
        ArrayList<modeloVentas> ventas = new ArrayList<>();

        boolean usuarioAutenticado = false;
       //informacion del Usuario
        System.out.print("Ingresar el Usuario: ");
        String user = capturar.nextLine();

        System.out.print("Ingresar la contraseña: ");
        String password = capturar.nextLine();

        do {

            System.out.println(
                    "\n---------------------------------\n"
                            + "\n BIENVENIDO AL SISTEMA GANADERO ORTEGA \n");

            System.out.print("Ingresar el Usuario: ");
            String inputUser = capturar.nextLine();

            System.out.print("Ingresar la contraseña: ");
            String inputPassword = capturar.nextLine();

            // limpiando la consola
            limpiarPantalla.limpiar();

            if (user.equals(inputUser) && password.equals(inputPassword)) {
                System.out.println("Inicio de sesion de manera exitosa. Bienvenido!");
                usuarioAutenticado = true;

                do {
                    System.out.println(
                            "\n---------------------------------\n"
                                    + "\n DIGITE LA OPCION A ESCOGER \n"
                                    + "\n (1) registrar cabezas de ganado \n"
                                    + "\n (2) visualizar registro del ganado \n"
                                    + "\n (3) Ventas Diarias \n"
                                    + "\n (4) Retiro de dinero\n"
                                    + "\n (5) Salir \n");
                    System.out.print("\n Opcion: ");
                      // solo captura enteros
                    while (!capturar.hasNextInt()) {
                        System.out.println("\n por favor, ingrese un numero valido.");
                        System.out.print("\n Opcion: ");
                        capturar.next();
                    }

                    opc = capturar.nextInt();
                    System.out.println("");

                    switch (opc) {
                        case 1:
                        System.out.println("\n REGISTRANDO LAS CABEZAS DE GANADO \n");
                    
                        Integer cantidad;
                    
                        do {
                            System.out.print("Ingrese la cantidad de vacas: ");
                            while (!capturar.hasNextInt()) {
                                System.out.println("Por favor, ingrese un número entero válido.");
                                capturar.next();
                            }
                            //Almacena la cantidad ingresada en la variable cantidad 
                            cantidad = capturar.nextInt();
                            // verifica si la cantidad ingresada es menor o igual a 0 si es true se vuelve a solisitar la informacion
                        } while (cantidad <= 0);
                         // repite la funcion segun la cantidad ingresada
                        for (int a = 0; a < cantidad; a++) {
                            modeloGanadero ModeloGanadero = new modeloGanadero();
                            double peso = -1; // Reiniciar el peso en cada iteración
                    
                            System.out.println("\n vaca N" + (a + 1) + "\n");
                            // solicitud del color de la vaca
                            System.out.print("ingrese el color: ");
                            //solicitud de la raza de la vaca
                            ModeloGanadero.setColor(capturar.next());// llama al metodo color de la clase modelo ganadero
                            //solicitud de la raza
                            System.out.print("ingrese la raza: ");
                            ModeloGanadero.setRaza(capturar.next());
                           // bucle que verifica que el peso sea un valor valido
                            while (peso < 0) {
                                System.out.print("Ingrese el peso animal: ");
                                if (capturar.hasNextDouble()) {
                                    peso = capturar.nextDouble();
                                    if (peso < 0) {
                                        System.out.println("El peso no puede ser negativo. Intente de nuevo.");
                                    }
                                } else {
                                    System.out.println("Entrada inválida. Intente de nuevo.");
                                    capturar.next(); // Para limpiar el buffer del scanner
                                }
                            }
                            // asigna el peso ingresado al modelo ganadero
                            ModeloGanadero.setPesoAnimal(peso);
                     // agrega el objeto modelo ganadero al arraylist ganado
                            ganado.add(ModeloGanadero);
                        }
                        break;

                        case 2:
                            System.out.println( "VISUALIZAR EL REGISTRO DEL GANADO");
                         // recorre el arraylist ganado para mostrar la informacion de cada vaca
                            for (int a = 0; a < ganado.size(); a++) {
                                modeloGanadero ModeloGanaderoActual = ganado.get(a);
                                System.out.println("\n Informacion de la vaca: " + (a + 1) + ": ");
                                System.out.println("Color: " + ModeloGanaderoActual.getColor()); // muestra el color
                                System.out.println("Raza: " + ModeloGanaderoActual.getRaza());
                                System.out.println("Peso Animal: " + ModeloGanaderoActual.getPesoAnimal());
                            }

                            break;

                        case 3:
                            System.out.println("VENTAS DIARIAS \n");
                          // objeto modelo ventas
                            modeloVentas ModeloVentas = new modeloVentas();

                            // Validación para el precio del litro
                            Integer precioLitro = null;
                            do {
                                System.out.print("Ingrese el precio del litro de leche (entero): ");
                                // valida si el valor es un entero
                                while (!capturar.hasNextInt()) {
                                    System.out.println("Por favor, ingrese un número entero válido.");
                                    capturar.next();
                                }
                                precioLitro = capturar.nextInt(); // almacena precio litro
                            } while (precioLitro == null);//  repite hasta que sea un valor valido

                            ModeloVentas.setPrecioLitro(precioLitro); // litros vendidos en el objeto modelo ventas

                            // Validación para los litros
                            Double litros = null;
                            do {
                                System.out.print("Ingrese los litros de leche (decimal): ");
                                while (!capturar.hasNextDouble()) {
                                    System.out.println("Por favor, ingrese un número decimal válido.");
                                    capturar.next();
                                }
                                litros = capturar.nextDouble();
                            } while (litros == null);

                            ModeloVentas.setLitros(litros);

                            System.out.println("---------------------------------------");

                            ventas.add(ModeloVentas);

                            System.out.println("Precio por litro ingresado: " + ModeloVentas.getPrecioLitro());
                            System.out.println("Litros Ingresados: " + ModeloVentas.getLitros());
                             // calcula la ganancia neta segun  la formula modelo de ventas
                            Double ResultadoFinal = ModeloVentas.formulaGanancia();

                            System.out.println("La ganancia neta es: " + ResultadoFinal);

                            break;
                        case 4:
                            System.out.println("RETIRO DE DINERO");

                            Double capturarGanancia = ventas.get(0).getGananciaNeta();

                            System.out.println("su saldo de la ganancia es de: " + capturarGanancia + "\n");

                            modeloVentas ModeloVentasActual = new modeloVentas();
                            do {
                                System.out.println("Ingrese la cantidad a retirar: ");
                                while (!capturar.hasNextDouble()) {
                                    System.out.println("Por favor, ingrese un número válido: ");
                                    capturar.next(); // Limpia el buffer
                                }
                                cantidadARetirar = capturar.nextDouble();
                            } while (cantidadARetirar <= 0.0);

                            double cantidadRetiradaReal = ModeloVentasActual.retirarGanancia(cantidadARetirar,
                                    capturarGanancia);

                            if (cantidadRetiradaReal > 0.0) {
                                System.out.println("Se retiraron: " + cantidadARetirar + " unidades de ganancia.");
                                 System.out.println("La ganancia restante es: " + cantidadRetiradaReal);
                            } else {
                                System.out.println("No se pudo retirar la cantidad solicitada.");
                            }

                            break;

                        case 5:
                            System.out.println("Gracias por usar el Sistema ganadero Ortega");
                            break;

                        default:
                            System.out.println("");
                            System.out.println("Vuelva a elegir la opcion nuevamente");
                            System.out.println("");
                            break;
                    }
                } while (opc != 5);

            } else {
                intentos++;
                if (intentos < intentosMaximos) {
                    int intentosRestantes = intentosMaximos - intentos;
                    System.out.println(
                            " \n Nombre de usuario o contraseña Incorrecta. Intentos restantes: " + intentosRestantes);
                } else {
                    System.out.println("\n Ha excedido el numero maximo de intentos. Cerrando programa. \n");
                }

            }

        } while (!usuarioAutenticado && intentos < intentosMaximos); // el bucle se repite hasta que el usuario este autenticado
        
        capturar.close();
    }
}
