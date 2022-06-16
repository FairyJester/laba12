package com.company;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String reg = "\\b((((25[0-5])|(2[0-4]\\d))|((1\\d{2})|(\\d{1,2})))\\.){3}(((25[0-5])|(2[0-4]\\d))|((1\\d{2})|(\\d{1,2})))\\b";
        Scanner in = new Scanner(System.in);
        System.out.print("Enter IP address: ");
        String ip = in.nextLine();
        Pattern pat = Pattern.compile(reg);
        Matcher match = pat.matcher(ip);

        String incorrect = "Correct IP address not found";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ip.txt"))){
            if(match.find()){
                bw.write("Correct IP address: " + match.group());
                bw.flush();
            }
            else{
                bw.write(incorrect);
                bw.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
