
package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        String nombre, contrasena;
        int intentos = 0;
        boolean login = false;
        java.util.HashMap<String, Integer> orden = new java.util.HashMap<>();

        System.out.println("Bienvenido al Restaurante de Rigoberto");

        while (intentos < 3 && !login) {
            System.out.print("Usuario: ");
            nombre = lea.nextLine();
            System.out.print("Contraseña: ");
            contrasena = lea.nextLine();

            if (nombre.equals("mariana") && contrasena.equals("321")) {
                System.out.println("Inicio de sesión exitoso.");
                login = true;
            } else {
                intentos++;
                System.out.println("Usuario o contraseña incorrectos. Intentos restantes: " + (3 - intentos));
            }
        }

        if (login) {
            int opcion;
            double total = 0;

            do {
                System.out.println("\nMenú Principal");
                System.out.println("1: Ingresar orden");
                System.out.println("2: Modificar orden");
                System.out.println("3: Terminar orden y calcular total");
                System.out.println("4: Salir");
                System.out.print("Seleccione una opción: ");
                opcion = lea.nextInt();
                lea.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\nListado de Platos:");
                        System.out.println("1. Entrada de cangrejo de urrao $28000");
                        System.out.println("2. Escalopes a la rigo $35000");
                        System.out.println("3. Filete tour de Francia $150000");
                        System.out.println("4. Corvina de rigo $80000");
                        System.out.println("5. Coctel michelle $20000");
                        System.out.println("6. Jugos de urrao $18500");
                        System.out.print("Seleccione el número del plato: ");
                        int plato = lea.nextInt();
                        lea.nextLine(); // Limpiar el buffer del lea
                        int cantidad;
                        do {
                            System.out.print("Ingrese la cantidad: ");
                            cantidad = lea.nextInt();
                            lea.nextLine(); // Limpiar el buffer del lea
                            if (cantidad <= 0) {
                                System.out.println("La cantidad debe ser mayor que cero.");
                            }
                        } while (cantidad <= 0);
                        String nombrePlato;
                        switch (plato) {
                            case 1:
                                nombrePlato = "Entrada de cangrejo de urrao";
                                break;
                            case 2:
                                nombrePlato = "Escalopes a la rigo";
                                break;
                            case 3:
                                nombrePlato = "Filete tour de Francia";
                                break;
                            case 4:
                                nombrePlato = "Corvina de rigo";
                                break;
                            case 5:
                                nombrePlato = "Coctel michelle";
                                break;
                            case 6:
                                nombrePlato = "Jugos de urrao";
                                break;
                            default:
                                nombrePlato = null;
                                break;
                        }
                        if (nombrePlato != null) {
                            orden.put(nombrePlato, orden.getOrDefault(nombrePlato, 0) + cantidad);
                            System.out.println("Plato agregado: " + nombrePlato + ", Cantidad: " + cantidad);
                        } else {
                            System.out.println("Plato no válido.");
                        }
                        break;
                    case 2:
                        // Implementar la lógica para modificar la orden
                        break;
                    case 3:
                        total = 0;
                        for (java.util.Map.Entry<String, Integer> entry : orden.entrySet()) {
                            String nombrePlatoOrden = entry.getKey();
                            int cantidadOrden = entry.getValue();
                            total += obtenerPrecioPlato(nombrePlatoOrden) * cantidadOrden;
                        }
                        System.out.println("Total a pagar: $" + total);
                        break;
                    case 4:
                        System.out.println("Gracias por visitarnos");
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                }
            } while (opcion != 4);
        } else {
            System.out.println("Demasiados intentos fallidos. Saliendo del programa.");
        }

        lea.close();
    }

    private static double obtenerPrecioPlato(String nombrePlato) {
        switch (nombrePlato) {
            case "Entrada de cangrejo de urrao":
                return 28000;
            case "Escalopes a la rigo":
                return 35000;
            case "Filete tour de Francia":
                return 150000;
            case "Corvina de rigo":
                return 80000;
            case "Coctel michelle":
                return 20000;
            case "Jugos de urrao":
                return 18500;
            default:
                return 0;
        }


            }
        }


