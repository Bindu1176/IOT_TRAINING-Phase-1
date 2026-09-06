import java.util.*;
public class FirstNonRepeating{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        char answer='\0';
        for(char ch:str.toCharArray()){
            if(map.get(ch)==1){
                answer=ch;
                break;
            }
        }
        if(answer=='\0'){
            System.out.println("No non-repeating character");
        }else{
            System.out.println("First Non-Repeating Character="+answer);
        }
        sc.close();
    }
}
