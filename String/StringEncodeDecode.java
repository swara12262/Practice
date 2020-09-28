public class MyClass {
    public static void main(String args[]) {

        System.out.println(secureChannel(1, "open", "123"));
        System.out.println(secureChannel(2, "Oppeeennnn", "1234"));
        System.out.println(secureChannel(2, "open", "aad"));
      
    }
    public static String secureChannel(int i, String msg, String key){
        int intKey=0;
        try{
        intKey = Integer.parseInt(key);
            
        }catch(Exception e){
            return "-1";
        }
        switch(i){
            case 1: return encode(msg, key);
           case 2: return decode(msg, key);
            default:
                return "-1";
        }
    }
    public static String encode(String msg, String key){
        char[] keya= key.toCharArray();
        int index=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<keya.length;i++){
            
            int j= keya[i]-'0';
            while(index<msg.length() && j-->0){
                sb.append(msg.charAt(index));
            }
            index++;
        }
        while(index<msg.length()){
            sb.append(msg.charAt(index));
            index++;            
        }
        return sb.toString();
    }
     public static String decode(String msg, String key){
        char[] keya= key.toCharArray();
        int index=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<keya.length;i++){
            
            int j= keya[i]-'0';
            
            while(j-->1)index++;
           // System.out.println(j+"*"+index);
            sb.append(msg.charAt(index));
        }
        
        return sb.toString();
        
   }
    
}
