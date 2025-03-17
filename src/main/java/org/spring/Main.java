package org.spring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        System.out.println("Hello world!");

        String filePath="src/main/resources/f.txt";
        int lineCount=0;
        int wordCount=0;
        int charCount=0;
        Map<String, Integer> wordMap= new HashMap<>();
        //Set<String> wordMap=new HashSet<>();

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

                int pred=0;
                for(int i=0;i<modLine.length();i++){
                    String word = "";
                    if(modLine.charAt(i)==' '){
                        word=modLine.substring(pred,i).trim();
                        pred=i;
                    }
                    else if(i==modLine.length()-1){
                        word=modLine.substring(pred,modLine.length()).trim();
                    }
                    else continue;

                    //Слово выделить удалось, теперь надо грамотно его запихивать в Мапу или любую другую коллекцию
                    if(!wordMap.containsKey(word)){
                        wordMap.put(word,0);
                    }
                    else if(wordMap.containsKey(word)){
                        int val=wordMap.get(word);
                        wordMap.remove(word);
                        val++;
                        wordMap.put(word,val);
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
             ***/
            List<Integer> values=wordMap.values().stream().toList();
            int maxValue= Collections.max(values);
            //ВОт прям чуть чуть доделать. Можно циклом пройтись, но это ебля
            String maxKey=wordMap.
            System.out.println("\n Самое часто повторяющееся слово = ");

            long endTime=System.currentTimeMillis();
            long timeElapsed=endTime-startTime;
            System.out.println("Затраченное время = "+timeElapsed);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}