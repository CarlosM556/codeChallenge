/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoretoconsole;

/**
 *
 * @author cm304
 */
public class Generate {
    String[] mayusculas = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] minusculas =  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
    String[] caracteres =  {"@","#","$","%","&","/","?","+","-"};
    String[] numeros =     {"0","1","2","3","4","5","6","7","8","9"};
    String[] types = {"mayusculas","minusculas", "caracteres","numeros"};
    StringBuilder password = new StringBuilder();
    boolean correctPwd = false;
    
    public String generarContraseña(int te){
        password.setLength(0);
        for (int i = 0; i < te; i++){
               // generating the index using Math.random()
                int index = (int)(Math.random() * types.length);
                String type = types[index];//se selecciona que tipo de caracter de la sucecion
//              Se crea la contraseña
                switch(type){
                    case "mayusculas":
                        int idx = (int)(Math.random() * mayusculas.length);
                        password.append(mayusculas[idx]);
                        break;
                    case "minusculas":
                        int idx1 = (int)(Math.random() * minusculas.length);
                        password.append(minusculas[idx1]);
                        break;
                    case "numeros":
                        int idx2 = (int)(Math.random() * numeros.length);
                        password.append(numeros[idx2]);
                        break;
                    case "caracteres":
                        int idx3 = (int)(Math.random() * caracteres.length);
                        password.append(caracteres[idx3]);
                        break;
                }

            }
        
        return password.toString();
    }
    
    public String comprobarContraseña(String pass){
        //utilities
        String pdw = pass;
        char[] arr = pdw.toCharArray();
        String[] arr2 = new String[pdw.length()];
        int number=0;
        int number2=0;
        boolean canContinue1=false;   
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = String.valueOf(arr[i]);
        }
            
        if(arr2.length<8 || arr2.length>20){
            return "lenghtError";
        }else{
            for (int i = 0; i < arr2.length; i++) {//numeros consecutivos
//                System.out.println(arr2[i]);
                String a = arr2[i];
                String b = ((i-1)==-1)?arr2[i]:arr2[i-1];
                try {
                    number = Integer.parseInt(a);
                    number2 = Integer.parseInt(b);
                    int c = number-number2;
                    if(c==1||c==-1){
//                        System.out.println("son consecutivos");
                        canContinue1 = true;
                    }else{
//                        System.out.println("no son consecutivos");
                        canContinue1 = false;
                    }

                }
                catch (NumberFormatException e) {
                    canContinue1 = false;
                }
                if(canContinue1) break;
            }
            if(canContinue1){
               return "secNum";
            }else{//validacion letras consecutivas
                canContinue1=false;
                String pwduc = pdw.toUpperCase();
                String[] nums = {"1h","2h","3h","4h","5h","6h","7h","8h","9h","10h","11h","12h","13h","14h","15h","16h","17h","18h","19h","20h","21h","22h","23h","24h","25h","26h","27h"};
                char[] arruc = pwduc.toCharArray();
                String[] arruc2 = new String[pwduc.length()];
                String aux2 = "";

                for (int i = 0; i < arruc2.length; i++) {
                    arruc2[i] = String.valueOf(arruc[i]);
                }

                for (int i = 0; i < arruc2.length; i++) {
                    for (int j = 0; j < mayusculas.length; j++) {
                        String aa=arruc2[i];
                        String bb=mayusculas[j];
                        if(aa.equals(bb)) { 
                            arruc2[i]=String.valueOf(nums[j]);
                            aux2 += arruc2[i];
                            break;
                        }
                    }
                }
                String[] parts = aux2.split("h");
                for (int i = 0; i < parts.length; i++) {
                    String a = parts[i];
                    String b = ((i-1)==-1)?parts[i]:parts[i-1];

                    int c = Integer.parseInt(a)-Integer.parseInt(b);
                    canContinue1 = c==1||c==-1;//IF true son consecutivos
                    
                    if(canContinue1) break;
                }
                if(canContinue1){
                    return "secuensiaLetras";
                }else{
                    canContinue1=false;
                    String pwd2 = pdw;
                    int aux3=0;
                    boolean aux4=false;
                    char[] arrc = pwd2.toCharArray();
                    String[] arrc2 = new String[pwduc.length()];

                    for (int i = 0; i < arrc2.length; i++) {
                        arrc2[i] = String.valueOf(arrc[i]);
                    }

                    for (int i = 0; i < arrc2.length; i++) {
                        for (int j = 0; j < mayusculas.length; j++) {
                            String aa=arrc2[i], bb=mayusculas[j];
                            if(aa.equals(bb)) { 
                                aux3++;
                                aux4=true;
                                break;
                            }
                        }
                        if(aux4) break;
                    }
                    aux4=false;
                    for (int i = 0; i < arrc2.length; i++) {
                        for (int j = 0; j < minusculas.length; j++) {
                            String aa=arrc2[i], bb=minusculas[j];
                            if(aa.equals(bb)) { 
                                aux3++;
                                aux4=true;
                                break;
                            }
                        }
                        if(aux4) break;
                    }
                    aux4=false;
                    for (int i = 0; i < arrc2.length; i++) {
                        for (int j = 0; j < caracteres.length; j++) {
                            String aa=arrc2[i], bb=caracteres[j];
                            if(aa.equals(bb)) { 
                                aux3++;
                                aux4=true;
                                break;
                            }
                        }
                        if(aux4) break;
                    }
                    aux4=false;
                    for (int i = 0; i < arrc2.length; i++) {
                        for (int j = 0; j < numeros.length; j++) {
                            String aa=arrc2[i], bb=numeros[j];
                            if(aa.equals(bb)) { 
                                aux3++;
                                aux4=true;
                                break;
                            }
                        }
                        if(aux4) {canContinue1=true; break;}
                    }
//                    System.out.println("aux3: "+aux3);
                    if(aux3!=4){
                        return "incomplete";
                    }else{
                        return "correcto";
                    }

                }

            }
        }
        
    }
}
