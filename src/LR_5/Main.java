package LR_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main{
    public static void main(String[] args) {
        try{
            System.out.println(NumberFinder("The1 quic4k b7rown fox jumps over the lazy3 dog"));
            System.out.println(CorrectPassword("pAssword"));
            System.out.println(CorrectPassword("pA1ssword"));
            System.out.println(CorrectPassword("psswordddd"));
            System.out.println(CorrectPassword("a111111111"));
            System.out.println(UppercaseAfterLowercase("aaaWbbzSb"));
            System.out.println(FindWord("Hello my dear friends today IS morning Figma", "f"));
            System.out.println(CorrectIP("1.243.54.0"));
            System.out.println(CorrectIP("1.263.54.0"));
        }
        catch(PatternSyntaxException e){
            System.out.println("Incorrect template syntax"+ e);
        }
    }

    //№1
    public static String NumberFinder(String text){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        String res = "";
        while (matcher.find()) {
            res += matcher.group();
        }
        return res;
    }

    //№2
    public static String CorrectPassword(String text){
        Pattern pattern = Pattern.compile("[a-z](?=.*[A-Z])(?=.*[0-9]){8,16}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()){
            return "Correct Password";
        } else {
            return "Incorrect Password!!!";
        }
    }

    //№3
    public static String UppercaseAfterLowercase(String text) {
        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);
        String res = matcher.replaceAll("!$1$2!");
        return res;
    }

    //№4
    public static String CorrectIP(String text) {
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()){
            return "Correct IP";
        } else {
            return "Incorrect IP";
        }
    }

    //№5
    public static String FindWord(String text, String f) {
        Pattern pattern = Pattern.compile("(?i)\\b" + f + "\\w*\\b");
        Matcher matcher = pattern.matcher(text);
        String res = "";
        while (matcher.find()){
            res += matcher.group() + " ";
        }
        return res;
    }
}
