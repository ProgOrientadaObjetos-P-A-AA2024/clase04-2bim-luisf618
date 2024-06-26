/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class EjecutorDos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        int cantidad;
        int opcion;

        System.out.println("Cantidad de arriendos a ingresar");
        cantidad = entrada.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("[1] Arriendo Comercial");
            System.out.println("[2] Arriendo Comida");
            System.out.println("[3] Arriendo Sesiones");
            opcion = entrada.nextInt();
            System.out.println("Ingrese el nombre del arrendatario");
            entrada.nextLine();
            String nom = entrada.nextLine();
            System.out.println("Ingrese la cuota base");
            double cuo = entrada.nextDouble();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor adicional fijo");
                    double vi = entrada.nextDouble();
                    ArriendoLocalComercial arriendoComercial
                            = new ArriendoLocalComercial(nom, cuo);
                    arriendoComercial.establecerValorAdicionalFijo(vi);
                    listaArriendos.add(arriendoComercial);
                    break;
                case 2:
                    System.out.println("Ingrese el valor del agua");
                    double agua = entrada.nextDouble();
                    System.out.println("Ingrese el valor de la luz");
                    double luz = entrada.nextDouble();
                    System.out.println("Ingrese el iva");
                    double iva = entrada.nextDouble();
                    ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                            nom, cuo);
                    arriendoComida.establecerIva(iva);
                    arriendoComida.establecerValorAgua(agua);
                    arriendoComida.establecerValorLuz(luz);
                    listaArriendos.add(arriendoComida);
                    break;
                case 3:
                    System.out.println("Ingrese el valor de las sillas");
                    double sillas = entrada.nextDouble();
                    System.out.println("Ingrese el valor de la amplificacion");
                    double ampli = entrada.nextDouble();
                    ArriendoLocalSesiones arriendoSesiones
                            = new ArriendoLocalSesiones(nom, cuo);
                    arriendoSesiones.establecerValorSillas(sillas);
                    arriendoSesiones.establecerValorAmplificacion(ampli);
                    listaArriendos.add(arriendoSesiones);
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial("La Pradera",
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
