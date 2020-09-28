import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      /*
      Given an array scores [][] = {“jerry”,”65”},{“bob”,”91”}, {“jerry”,”23”}, {“Eric”,”83”}} Find the student with highest average score
      */
        String[][] scores={{"jerry","95"},{"bob","91"}, {"jerry","93"}, {"Eric","83"}};
      
        LinkedHashMap<String, ArrayList<Integer>> map=new LinkedHashMap<String, ArrayList<Integer>>();
      
        for(int i=0;i<scores.length;i++){
            String key = scores[i][0];
            int val=Integer.parseInt(scores[i][1]);
            if(map.containsKey(key))
            {
                ArrayList tmp=map.get(key);
                tmp.add(val);
                map.put(key, tmp);
            }
            else{
                ArrayList tmp=new ArrayList();
                tmp.add(val);
                map.put(key, tmp);
            }
        }
        //map to store avg of scores
        LinkedHashMap<String, Double> mapN=new LinkedHashMap<String, Double>();
        
        for(Map.Entry en: map.entrySet()){
            ArrayList tmp=(ArrayList)en.getValue();
            int n=tmp.size();
            int sum=0;
            System.out.println(tmp);
            Iterator it=tmp.iterator();
            while(it.hasNext()){
                sum+=(int)it.next();
            }
            double avg=sum/n;
            mapN.put((String)en.getKey(), avg);
            
        }
        double maxAvg=0.0;
        String stuName="";
        for(Map.Entry en: mapN.entrySet()){
            if(maxAvg<(double)en.getValue()){
            maxAvg=(double)en.getValue();
            stuName=(String)en.getKey();    
            }
        }
        System.out.println(stuName+"--"+maxAvg);
        
        
    }
}
