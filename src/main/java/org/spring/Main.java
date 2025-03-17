package org.spring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        System.out.println("Hello world!");

        String filePath="src/main/resources/f.txt";
        int lineCount=0;
        int wordCount=0;
        int charCount=0;
        Map<String, Integer> wordMap= new HashMap<>();

        try(BufferedReader reader=new BufferedReader(
                new FileReader(filePath))){

            String line;
            String modLine = "";
            while((line=reader.readLine())!=null) {

                lineCount++;
                char[] lineArr=line.toCharArray();

                for(int i=0;i<line.length();i++){

                    charCount++;
                    if(lineArr[i]==' '){
                        wordCount++;
                        charCount--;
                    }
                }
                wordCount++;

                modLine=line.replaceAll(Arrays.toString(new String[]{":",";",".",","})," ").toLowerCase(Locale.ROOT);
                if(modLine.length()>1 && modLine.charAt(modLine.length()-1)==' '){
                    modLine=modLine.substring(0,modLine.length()-1);
                }

                for(int i=0;i<modLine.length();i++){
                    if(modLine.charAt(i)==' '){
                        String removedModLine=modLine.substring(0,i+1);
                        if(wordMap.containsKey(removedModLine)){
                            //wordMap.va
                        }
                        wordMap.put(removedModLine,0);
                    }
                }
            }


            System.out.println("\n Число строк = "+lineCount);
            System.out.println("\n Число слов = "+wordCount);
            System.out.println("\n Число символов без пробелов = "+charCount);
            /***
             * Из вариантов:
             * 1) Изучить работу Java HashMap и постараться что-то сделать с ней
             * 2) Реализовать свою коллекцию с нужной функцией(возможно удобнее
             * в использовании, но дольше в реализации)
             */
            System.out.println("\n Самое часто повторяющееся слово = ");

            long endTime=System.currentTimeMillis();
            long timeElapsed=endTime-startTime;
            System.out.println("Затраченное время = "+timeElapsed);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}