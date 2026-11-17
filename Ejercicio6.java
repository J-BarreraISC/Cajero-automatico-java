/*
 * TICKET 4: TERMINAL BANCARIA ATM CORE (Ejercicio6.java)
 *
 * OBJETIVO:
 * Construir el núcleo de un Cajero Automático integrando control de acceso,
 * manipulación de bits, cálculos matemáticos financieros, formateo de moneda
 * y ciclos de control anidados/secuenciales.
 *
 * LIBRERÍAS REQUERIDAS:
 * - java.util.Scanner
 * - java.text.DecimalFormat
 * (La clase Math pertenece a java.lang y se usa directo sin import).
 *
 * -------------------------------------------------------------------------
 * MÓDULO 1: AUTENTICACIÓN Y TOKEN DE HARDWARE (while, String, Bits)
 * -------------------------------------------------------------------------
 * 1. Variables de seguridad:
 *    - Clave maestra del sistema: "JAVA2026" (String).
 *    - Contador de intentos: 0 (int).
 *    - Bandera de acceso: false (boolean).
 * 2. Solicita al usuario su Número de Cliente (int idCliente).
 * 3. Ciclo de validación (while):
 *    - Debe repetirse MIENTRAS acceso sea falso Y (&&) intentos < 3.
 *    - Pide la contraseña (String), limpia espacios con .trim() y compárala
 *      con la clave maestra usando .equals().
 *    - Si coincide: cambia la bandera de acceso a true.
 *    - Si falla: incrementa el contador de intentos y muestra cuántos quedan.
 * 4. Evaluación de bloqueo (if-else):
 *    - Si tras salir del while el acceso sigue siendo false, imprime alerta
 *      de "TARJETA RETENIDA POR SEGURIDAD" y cierra el programa.
 *    - Si el acceso es true: genera un "Token de Sesión" aplicando un
 *      desplazamiento de bits a la izquierda de 3 posiciones sobre el
 *      idCliente (idCliente << 3) y muéstralo en la bienvenida.
 *
 * -------------------------------------------------------------------------
 * MÓDULO 2: NÚCLEO TRANSACCIONAL (while, switch, DecimalFormat, Math)
 * -------------------------------------------------------------------------
 * Solo se ejecuta si el acceso fue concedido:
 * 1. Estado inicial:
 *    - Saldo inicial: 2500.00 (double - Acumulador principal).
 *    - Total retirado hoy: 0.0 (double - Acumulador de auditoría).
 *    - Operaciones exitosas: 0 (int - Contador).
 *    - Opción del menú: 0 (int).
 *    - Instancia DecimalFormat con patrón "$#,##0.00" para toda cifra de dinero.
 * 2. Ciclo operativo (while opcion != 5):
 *    Despliega el menú y enruta con switch (no olvides tus break):
 *    - Opción 1 (Consultar Estado): Muestra saldo actual formateado, total
 *      retirado hoy y el Token de Sesión generado por bits.
 *    - Opción 2 (Depositar): Pide monto (double). Valida con if-else que sea
 *      mayor a 0; súmalo al saldo e incrementa el contador de operaciones.
 *    - Opción 3 (Retirar): Pide monto (double). Valida con if-else que sea
 *      mayor a 0 y que alcance el saldo. Si procede: réstalo del saldo,
 *      súmalo al acumulador de total retirado e incrementa operaciones.
 *    - Opción 4 (Simulador de Inversión - Clase Math): Pide un monto a
 *      invertir y un plazo en meses (int). Calcula el rendimiento compuesto
 *      al 2% mensual usando Math.pow(1.02, meses) multiplicado por el monto.
 *      Muestra la ganancia proyectada usando DecimalFormat. (No modifica saldo).
 *    - Opción 5 (Salir): Muestra resumen final de operaciones realizadas y
 *      despide al usuario.
 *    - default: Mensaje de opción inválida.
 *
 * REGLAS DE AUDITORÍA:
 * - Cero código copiado, todo escrito a mano desde cero.
 * - Cierra tu Scanner al finalizar el main.
 * - Compilar: javac -encoding UTF-8 Ejercicio6.java
 * - Ejecutar: java "-Dfile.encoding=UTF-8" Ejercicio6
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Ejercicio6 {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in,"UTF-8");

    // MÓDULO 1: AUTENTICACIÓN Y TOKEN DE HARDWARE (while, String, Bits)

    final int MAX_INTENTOS = 3;
    final String CLAVE_MAESTRA = "JAVA2026";
    int contadorIntentos = 0;
    boolean banderaAcceso = false;

    System.out.print("\n Ingrese su Número de Cliente: ");
    int idCliente = entrada.nextInt();
    entrada.nextLine();

    while (!banderaAcceso && contadorIntentos < MAX_INTENTOS) {
      System.out.print("\n Ingrese su contraseña: ");
      String con = entrada.nextLine().trim();
      if (CLAVE_MAESTRA.equals(con)) {
        banderaAcceso = true;
        System.out.println("\n\tContraseña correcta y verificada. ¡Bienvenid@!\n");
      } else {
          contadorIntentos++;
          System.out.println("\n\t\t¡CONTRASEÑA INCORRECTA!");
          int numIntentos = MAX_INTENTOS - contadorIntentos;
          if (numIntentos >= 2) {
            System.out.println("Te quedan " + numIntentos + " intentos, después de " + MAX_INTENTOS + " intentos serás bloquedo temporalmente.");
          } else if (numIntentos == 1) {
	      System.out.println("¡Te queda " + numIntentos + " último intento! Ingresa correctamente la contraseña o serás bloquado. ");
          } else {
	      System.out.println("\n\tTARJETA RETENIDA Y BLOQUEADA POR SEGURIDAD");
	  }
        }
    }

    if (banderaAcceso) {
      int tokenSesion = idCliente << 3;
      System.out.print(" Su token de sesión del día es: " + tokenSesion + "\n");

      // MÓDULO 2: NÚCLEO TRANSACCIONAL (while, switch, DecimalFormat, Math)
      
      double saldo = 2500.00, totalRetirado = 0.0;
      int operaciones = 0, opc = 0;
      final double TASA_MENSUAL = 1.02;

      DecimalFormat df = new DecimalFormat("$#,##0.00");

      while (opc != 5) {

      }

    }

    entrada.close();
  }
}
