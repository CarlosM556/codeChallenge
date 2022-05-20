/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoretoconsole;

import java.io.*;
import java.util.Scanner;

/**
 *
// * @author cm304
 */
public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String option="";
        int longitud=0;
        boolean vale=false;
        Generate gen = new Generate();
        String pass;
        String res;
        String passToVerify;
        do {            
            System.out.println("------- Code Challenge -------");
            System.out.println("Seleccione que desea hacer:");
            System.out.println("a) Generar Contraseña.");
            System.out.println("b) Validar Contraseña.");
            System.out.println("e) Para salir.");
            do{
                System.out.println("Escriba la letra de la opcion que desea realizar:");
                option = scr.next();
                if(option!="a" || option!="A" || option!="b" || option!="B")
                    vale=true;
            }while(!vale);

            if("a".equals(option) || "A".equals(option)){
                String opt;
                boolean regresarMain=false;
                do {  
                    System.out.println("Desea regresar: (S/N)");
                    opt = scr.next();
                    if("S".equals(opt)||"s".equals(opt)){
                        regresarMain=true;
                    }else{
                        do{
                            System.out.println("Seleccione la longitud:");
                            longitud = scr.nextInt();
                            if(longitud<8 || longitud >20)
                                System.out.println("La longitud debe ser entre 8 y 20");
                        }while(longitud<8 || longitud >20);
                        do{
                            pass=gen.generarContraseña(longitud);//genera
                            res=gen.comprobarContraseña(pass);//verifica
                            System.out.println("password: "+ pass);
                            if(!"correcto".equals(res)) pass="";
                        }while(!"correcto".equals(res));
                    }
                } while (!regresarMain);
            }else if("b".equals(option) || "B".equals(option)){
                boolean regresarMain=false;
                do{
                    System.out.println("Escriba 'e' para regresar");
                    System.out.println("Introduce la contraseña a comprobar:");
                    passToVerify = scr.next();

                    if("e".equals(passToVerify)||"E".equals(passToVerify)){
                        regresarMain=true;
                    }else{
                        res=gen.comprobarContraseña(passToVerify);//verifica
                        if("correcto".equals(res)){
                            System.out.println("Su contraseña es segura");
                            System.out.println("password: "+ passToVerify+" res: "+res);                    
                        }else if("incomplete".equals(res)){
                            System.out.println("Debe de contener al menos:\n ● Una letra mayuscula\n ● Una letra minuscula\n ● Un caracte especial \n ● Un numero.");
                            System.out.println("password: "+ passToVerify+" res: "+res);
                        }else if("secuensiaLetras".equals(res)){
                            System.out.println("Su contraseña tiene una secuencia de letras");
                            System.out.println("password: "+ passToVerify+" res: "+res);
                        }else if("secNum".equals(res)){
                            System.out.println("Su contraseña tiene una secuencia de numeros");
                            System.out.println("password: "+ passToVerify+" res: "+res);
                        }else if("lenghtError".equals(res)){
                            System.out.println("Su contraseña no cumple con una longitud correcta. Recuerda que debe de ser entre 8 y 20 caracteres");
                            System.out.println("password: "+ passToVerify+" res: "+res);
                        }
                    }

                }while(!regresarMain);
            };
        } while ("e".equals(option)||"E".equals(option));
        
        
//        System.out.println("Seleccion: "+option+" Longitud: "+longitud);
        System.exit(0);
    }
    
}
