class Solution {
  public String removeDuplicates(String s) {
    //Generate HAshset of duplicate chars from aa to zz
      
      HashSet<String> set=new HashSet();
      for(int i=0;i<26;i++)
      {
          String tmp="";
          tmp=tmp+(char)(i+97)+(char)(i+97);
          set.add(tmp);
      }
      int l=-1;
      while(l!=s.length())
      {
            l=s.length();
          for(String tmp: set)
          {
              s=s.replace(tmp,"");
            }   
      }
      
      return s;
    }
}
