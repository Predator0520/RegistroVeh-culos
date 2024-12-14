import java.util.ArrayList;
import java.util.Scanner;

public class app {
    static class Vehiculo {
        String placa;
        String modelo;
        String propietario;

        public Vehiculo(String placa, String modelo, String propietario) {
            this.placa = placa;
            this.modelo = modelo;
            this.propietario = propietario;
        }

        @Override
        public String toString() {
            return "--> "+"PLACA: " + placa + ", MODELO: " + modelo + ", DUEÑO: " + propietario;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Sistema de Parqueo ===");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Consultar vehículos");
            System.out.println("3. Actualizar vehículo");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            if (opcion == 1) {
                // Registrar un vehículo
                System.out.print("Ingrese la placa: ");
                String placa = scanner.nextLine();
                System.out.print("Ingrese el modelo: ");
                String modelo = scanner.nextLine();
                System.out.print("Ingrese el propietario: ");
                String propietario = scanner.nextLine();

                Vehiculo vehiculo = new Vehiculo(placa, modelo, propietario);
                vehiculos.add(vehiculo);
                System.out.println("Vehículo registrado exitosamente.");
            } else if (opcion == 2) {
                // Consultar vehículos
                if (vehiculos.isEmpty()) {
                    System.out.println("No hay vehículos registrados.");
                } else {
                    System.out.println("\nLista de vehículos:");
                    for (Vehiculo v : vehiculos) {
                        System.out.println(v);
                    }
                }
            } else if (opcion == 3) {
                // Actualizar un vehículo
                System.out.print("Ingrese la placa del vehículo a actualizar: ");
                String placaBuscada = scanner.nextLine();

                boolean encontrado = false;

                for (Vehiculo v : vehiculos) {
                    if (v.placa.equals(placaBuscada)) {
                        encontrado = true;

                        // Pedir nuevos datos para el vehículo (sin permitir modificar la placa)
                        System.out.println("Vehículo encontrado. Ingrese los nuevos datos:");
                        System.out.print("Nuevo modelo (actual: " + v.modelo + "): ");
                        v.modelo = scanner.nextLine();
                        System.out.print("Nuevo propietario (actual: " + v.propietario + "): ");
                        v.propietario = scanner.nextLine();

                        System.out.println("Vehículo actualizado exitosamente.");
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Vehículo no encontrado.");
                }

            } else if (opcion == 4) {
                // Salir
                System.out.println("!Gracias por preferirnos!");
                break;
            } else {
                System.out.println("Opción no válida, intenta nuevamente.");
            }
        }
        scanner.close();
    }
}
