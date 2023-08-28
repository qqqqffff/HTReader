package com.apollo.htreader.utilities;

import java.util.Scanner;

public class HTMLParser {
    public static String parseTag(String line, Scanner sc){
        if(line.contains("<p>") && !line.contains("</p>")) {
            StringBuilder sb = new StringBuilder();
            sb.append(line).append(" ");
            while(sc.hasNext()){
                line = sc.nextLine();
                if(line.contains("</p>")){
                    sb.append(line);
                    return sb.toString();
                }
                sb.append(line).append(" ");
            }
        }
        else if(line.contains("<p>") && line.contains("</p>")){
            return line;
        }
        return "";
    }
    public static String removeTags(String line){
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '>' && index == -1){
                index = i;
            }
            else if(index != -1 && line.charAt(i) == '<'){
                sb.append(line, index + 1, i);
                break;
            }
        }
        return sb.toString()
                .replaceAll("&#8217;", "'")
                .replaceAll("&#8221;","\"")
                .replaceAll("&#8220;", "\"")
                .replaceAll("&#8230;","...");
    }
}
