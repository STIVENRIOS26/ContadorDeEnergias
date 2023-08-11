package org.example;

import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random generador= new Random();
        //se declaran variables

        Boolean esAdmin;
        String respuestaPerfil;
        Double tarifaEnergia;
        Integer opcion;
        final String contraseña="admin123*"; //CONSTANTE
        String contrasenaUsuario;            //VARIABLE DE LA CONSTANTE
        Integer contadorEnergia=0;


        System.out.println("BIENVENIDO");
        System.out.println("⚡⚡⚡⚡⚡⚡⚡⚡⚡");
        System.out.println("Eres administrador: ");
        respuestaPerfil=teclado.nextLine();

        //PROCESO PARA EL LOGIN
        if(respuestaPerfil.equalsIgnoreCase("si")){ //"".equalsIgnoreCase( anotherString"" sirve para aceptar la palabra con tildes o mezcla de mayus y minus
            //admin y me van a pedir la contraseña
            System.out.print("Digita tu contraseña: ");
            contrasenaUsuario= teclado.nextLine();
            //COMPARAMOS LA CONTRASEÑA QUE ESCRIBIERON CON LA CONSTANTE ALMACENADA
            if (contrasenaUsuario.equals(contraseña)){
                //FELICIDADES USTED ES ADMINISTRADOR
                System.out.println("Usted es un admin");
                //puedo actualizar la tarifa de energia
                System.out.println("Ingresa el valor del KWH: ");
                tarifaEnergia= teclado.nextDouble();
                System.out.println("La tarifa de energia quedó en: $"+tarifaEnergia);

                //Generando datos para una empresa
                //generar un ciclo que me de 30 vueltas
                Integer numeroVueltas=0; //contador
                Integer contadorPicos=0;
                do{
                    numeroVueltas=numeroVueltas+1;
                    Integer numeroGenerado=generador.nextInt(401); //se puede (bound: 401) o (bound: 400)+1;
                    System.out.println(numeroGenerado);
                    contadorEnergia=contadorEnergia+numeroGenerado;

                    if (numeroGenerado>300){
                        System.out.println("Pico detectado.");
                        contadorPicos=contadorPicos+1;
                    }else{
                        System.out.println("Operando normalmente.");
                    }

                }while(numeroVueltas<=30);
                System.out.println(numeroVueltas);
                System.out.println(contadorPicos);

                //MENU
                System.out.println("1. ver tarifa");
                System.out.println("2. mostrar consumo promedio");
                System.out.println("3. mostrar consumo picos");
                System.out.println("4. mostra factura");
                System.out.println("5. SALIR");

                //REPITIENDO EL MENU

                do{
                    System.out.println("Apreciado cliente, digita una opcion: ");
                    opcion=teclado.nextInt();

                    switch (opcion){
                        case 1:
                            System.out.println("la tarifa KWH es: "+tarifaEnergia);
                            break;

                        case 2:
                            System.out.println("El consumo total fue: "+contadorEnergia);
                            Double promedioConsumo=contadorEnergia/30.0;
                            System.out.println("Consumo promedio es: "+promedioConsumo);
                            break;
                        case 3:
                            System.out.println("La cantidad de picos fue: "+contadorPicos);
                            break;
                        case 4:
                            System.out.println("El resumen de tu factura es: ");
                            Double totalAPagar=contadorEnergia*tarifaEnergia;
                            System.out.println("$......"+totalAPagar);
                            break;
                        default:
                            System.out.println("opcion invalida");
                            break;
                    }

                }while(opcion!=5);



            }else{
                System.out.println("Usted es hacker.....");
            }
        }else{
            System.out.println("usted es una empresa");

            //empresa
        }

    }
}