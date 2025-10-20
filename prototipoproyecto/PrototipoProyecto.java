/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipoproyecto;

import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author paulasteller
 */
public class PrototipoProyecto {

    public static void main(String[] args) {
      // Este Scanner lo usamos Scanner para ingresar los datos del usuario desde la consola
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- SIMULACIÓN DE GESTIÓN DE TIQUETES ---\n");
        
        // CREACIÓN DE USUARIOS (Empleado y Técnico)
        // --- 1. INGRESO DE DATOS DEL EMPLEADO QUE REPORTA ---

        System.out.println("\n--- 1. INGRESO DE DATOS DEL EMPLEADO QUE REPORTA ---");
        System.out.print("Ingrese ID del Empleado (Ej: E105): ");
        String empId = scanner.nextLine();
        
        System.out.print("Ingrese Nombre del Empleado: ");
        String empNombre = scanner.nextLine();
        
        System.out.print("Ingrese Apellido del Empleado: ");
        String empApellido = scanner.nextLine();
        
        System.out.print("Ingrese Correo del Empleado: ");
        String empCorreo = scanner.nextLine();
        
        System.out.print("Ingrese Departamento del Empleado (Ej: Ventas): ");
        String empDepto = scanner.nextLine();
        
        // Se usa el constructor de la clase Empleado.java que subiste
        Empleado empleadoReportando = new Empleado(empId, empNombre, empApellido, empCorreo, empDepto);
        System.out.println(" Empleado Creado: " + empleadoReportando.getNombre() + " (" + empleadoReportando.getDepartamento() + ")");

        // ------------------------------------------------------------------
        // --- 2. INGRESO DE DATOS DEL TÉCNICO ASIGNADO ---
        System.out.println("\n--- 2. INGRESO DE DATOS DEL TÉCNICO ASIGNADO ---");
        System.out.print("Ingrese ID del Técnico (Ej: T003): ");
        String tecId = scanner.nextLine();
        
        System.out.print("Ingrese Nombre del Técnico: ");
        String tecNombre = scanner.nextLine();
        
        System.out.print("Ingrese Apellido del Técnico: ");
        String tecApellido = scanner.nextLine();
        
        System.out.print("Ingrese Especialidad del Técnico (Ej: Redes): ");
        String tecEspecialidad = scanner.nextLine();

        // Se usa el constructor de la clase Tecnico
        Tecnico tecnicoAsignado = new Tecnico(tecId, tecNombre, tecApellido, tecEspecialidad);
        System.out.println(" Técnico Creado: " + tecnicoAsignado.getNombre() + " (" + tecnicoAsignado.getEspecialidad() + ")");
        
        // ------------------------------------------------------------------
        // --- 2. CREACIÓN DEL TIQUETE DE SOPORTE ---
        System.out.println("\n--- 3. CREACIÓN DEL TIQUETE DE SOPORTE ---");
        System.out.print("Ingrese ID del Tiquete (Ej: HT-001): ");
        String tqId = scanner.nextLine();
        
        System.out.print("Ingrese Título del Tiquete: ");
        String tqTitulo = scanner.nextLine();
        
        System.out.print("Ingrese Descripción del Tiquete: ");
        String tqDescripcion = scanner.nextLine();
        
        System.out.print("Ingrese Prioridad (Baja/Media/Alta): ");
        String tqPrioridad = scanner.nextLine();
        
        // Estado inicial y fecha de creación del chat
        String tqEstadoInicial = "Abierto"; 
        LocalDateTime fechaCreacion = LocalDateTime.now();
        
        // Se usa el constructor de la clase Tiquete
        Tiquete nuevoTiquete = new Tiquete(tqId, tqTitulo, tqDescripcion, tqPrioridad, tqEstadoInicial, fechaCreacion);
        
        System.out.println("\n Tiquete Creado Exitosamente:");
        System.out.println("   ID: " + nuevoTiquete.getIdTiquete() + " | Título: " + nuevoTiquete.getTitulo());
        System.out.println("   Reportado por: " + empleadoReportando.getNombre() + " " + empleadoReportando.getApellido());
        System.out.println("   Estado Inicial: " + nuevoTiquete.getEstado() + " | Prioridad: " + nuevoTiquete.getPrioridad());
        
        // ------------------------------------------------------------------
        // --- 3. SIMULACIÓN DE CHAT ---
        
        System.out.println("\n--- 4. SIMULACIÓN DE GESTIÓN Y CHAT ---");
        
        // El técnico asigna el tiquete
        nuevoTiquete.setEstado("En Progreso"); 
        System.out.println("🔧 Tiquete Asignado a " + tecnicoAsignado.getNombre() + ". Nuevo Estado: " + nuevoTiquete.getEstado());

        // Mensaje del Técnico
        System.out.println("\n--- CHAT ---");
        System.out.print("Ingrese el Contenido del Primer Mensaje del Técnico: ");
        String chatContenido1 = scanner.nextLine();
        
        Chat chatMsg1 = new Chat(
            "C-" + tqId + "-MSG1", 
            chatContenido1, 
            tecnicoAsignado.getIdTecnico(), 
            LocalDateTime.now().plusMinutes(1)
        );
        System.out.println(" Mensaje de Chat Enviado (Técnico):\n   Contenido: \"" + chatMsg1.getContenido() + "\"");

        // Mensaje del Empleado
        System.out.print("Ingrese la Respuesta del Empleado: ");
        String chatContenido2 = scanner.nextLine();
        
        Chat chatMsg2 = new Chat(
            "C-" + tqId + "-MSG2", 
            chatContenido2, 
            empleadoReportando.getIdEmpleado(), 
            LocalDateTime.now().plusMinutes(2)
        );
        System.out.println(" Mensaje de Chat Enviado (Empleado):\n   Contenido: \"" + chatMsg2.getContenido() + "\"");

        // Cierre del tiquete
        nuevoTiquete.setEstado("Resuelto");
        System.out.println("\n Tiquete Resuelto y Cerrado. Estado Final: " + nuevoTiquete.getEstado());
        
        // Cerrar el objeto Scanner ya que ya no vamos a ingresar datos
        scanner.close();
    }
}
