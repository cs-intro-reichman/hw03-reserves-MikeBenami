
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   
    public static String lowerCase(String s) {
        String result = "";

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >='A' && c <= 'Z'){
                result += (char)(c + 32);
            } else { 
                result += c;
            }
        }
        return result;
    }
}