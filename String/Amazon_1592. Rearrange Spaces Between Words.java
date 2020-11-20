class Solution {
    public String reorderSpaces(String text) {
         int spaceCount = 0;
        int wordCount = 0;
        List<String> words = new ArrayList<>();
        for(int i = 0; i<text.length();) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
                i++;
            } else {
                int j = i;
                while (i<text.length() && text.charAt(i) != ' ') {
                    i++;
                }
                words.add(text.substring(j, i));     
                wordCount++;
            }
        }
        if(spaceCount == 0) {
            return text;
        }
        
        if(wordCount == 1) {
            return words.get(0) + " ".repeat(spaceCount);
        }
        int spaceBetweenWords = spaceCount / (wordCount-1);
        int extraSpace = 0;
        if (spaceCount % (wordCount-1) != 0) {
            extraSpace = spaceCount % (wordCount-1);
        }
        String result = "";
        for (int i = 0; i<words.size();i++) {
            result += words.get(i);
            if (i != words.size()-1) {
               result += " ".repeat(spaceBetweenWords); 
            } else {
                result += " ".repeat(extraSpace);
            }
         
        }
        return result;
    }
}
