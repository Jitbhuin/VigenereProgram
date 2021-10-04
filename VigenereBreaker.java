import java.util.*;
import edu.duke.*;
import java.io.*;

/*public class VigenereBreaker {
    //private int max=0;
     /*HashMap<String,Integer>map;
     public
     VigenereBreaker()
     {
         map=new HashMap<String,Integer>();
        }
     
    public String sliceString(String message, int whichSlice, int totalSlices) {
       
        String str="";
        for(int i=whichSlice;i+totalSlices<message.length();i+=totalSlices)
        {
            str=str+message.charAt(i);
        }
        return str;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        
        for(int i=0;i<klength;i++)
        {
          String s= sliceString(encrypted,i,klength);
        CaesarCracker c= new CaesarCracker(mostCommon);
         key[i]=c.getKey(s);
    }
        return key;
    }

    /*public void breakVigenere () {
        //WRITE YOUR CODE HERE
       FileResource f=new FileResource();
      // URLResource u=new URLResource("https://www.dukelearntoprogram.com//java/secretmessage1.txt");
        String encrypted=f.asString();
        int[]key=tryKeyLength(encrypted,4,'e');
        VigenereCipher v=new VigenereCipher(key);
        for(int i=0;i<key.length;i++)
        System.out.println(key[i]);
     String ans=v.decrypt(encrypted);
     
     System.out.println(ans);
        
    }
    public HashSet<String> readDictionary(FileResource f)
    {
        HashSet<String> h=new HashSet<String>();
        for(String line:f.lines())
        {
         line=line.toLowerCase();
          h.add(line);
        }
       // System.out.println("dicionary: ::::"+h);
        return h;
    }
    public int countWords(String message,HashSet<String> d)
    {
       int c=0; 
       ArrayList<String> onlywords=new ArrayList<String>(Arrays.asList(message.split("\\W+")));
    	//System.out.println("the total word count is:"+onlywords.size());
       for(String word:onlywords)
        {
          word=word.toLowerCase();
          if(d.contains(word))
          c++;
        }
        //System.out.println("hhh:"+c);
        return c;
    }
    public  String breakForLanguage(String encrypted,HashSet<String>d)
    {
        char ch= mostCommonChar(d);
      System.out.println("most common charcter=\t"+ch); 
       int m=0,k=0;String ans="";
      for(int i=1;i<=100;i++)
      {
         
         int []key=tryKeyLength(encrypted,i,ch);
         //for(int y=0;y<key.length;y++)
         //System.out.println(key[y]);
                     VigenereCipher q=new VigenereCipher( key);
          String message= q.decrypt(encrypted);
         //System.out.println(message);
           int wordcount=countWords(message,d);
          if(wordcount>m)
          {
              m=wordcount;
               ans=message;
               k=i;
            }
            
        }
        System.out.println("max valid words:\t"+m+" keylength:"+k);
    
    return ans;
}   
    
   /* public void breakVigenere2()
    {
        FileResource f=new FileResource();
        HashSet<String>dictionary=readDictionary(f);
//FileResource w=new FileResource();
URLResource w=new URLResource("https://www.dukelearntoprogram.com//java/secretmessage2.txt");
        String encrypted=w.asString();
        String ans=breakForLanguage(encrypted,dictionary);
       System.out.println(ans.substring(0,100));
     }
     public char mostCommonChar(HashSet<String> d)
     {
         HashMap<Character,Integer> h=new HashMap<Character,Integer>();
    for(String i:d)
    {
       for(char c:i.toCharArray())
       {
           if(!d.contains(c))
           h.put(c,1);
           else
           {
               int value=h.get(c);
               h.put(c,value+1);
            }
           
        }
    }
    int max=0;
    char ch='\0';
    for(Character c:h.keySet())
    {
        int cha=h.get(c);
        if(max==0)
        {
            max=cha;
            ch=c;
        }
        else{
            
        if(cha>max)
       {
           max=cha;
           ch=c;
        }
    }
    }
      
    return ch;  
     
     }
     public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> language)
     {
       int max=0;
       String ans="";
       String dl="";
       for(String lan:language.keySet())
       {
           //System.out.println("language:;;;;"+lan);
           ans= breakForLanguage(encrypted,language.get(lan));
            int curr=countWords(ans,language.get(lan));
            if(curr>max)
            {
                max=curr;
      dl=lan;
      
        }
    }
        System.out.println("language= "+dl);
        System.out.println("decrypted message+\n"+ans.substring(0,200));
        
        }
        public void breakVigenere2()
    {
        DirectoryResource f=new DirectoryResource();
       HashMap<String,HashSet<String>> dictionary=readAllDictionary(f);
//FileResource w=new FileResource("athens_keyflute.txt");
URLResource w=new URLResource("https://www.dukelearntoprogram.com//java/athens_keyflute.txt");
        String encrypted=w.asString();
       breakForAllLangs(encrypted,dictionary);
      //System.out.println("decrypted message:;;;;;;;;;;;;;\n"+ans.substring(0,200));
      //System.out.println(ans.substring(0,100));
      /*int max=0;String ans="";
      for(String str:map.keySet())
      {
          if(map.get(str)>max)
          {
              max=map.get(str);
              ans=str;
            }
          
        }
        
     }
     public HashMap<String,HashSet<String>> readAllDictionary(DirectoryResource f)
    {
       HashMap<String,HashSet<String>> h=new HashMap<String,HashSet<String>>();
       for(File file: f.selectedFiles())
       {
          FileResource fil=new FileResource(file);
          String name=file.getName();
             HashSet<String> list=readDictionary(fil);
             
             h.put(name,list);
            
            }
    for(String dic:h.keySet())
    {
        System.out.println("language="+dic+"words="+h.get(dic));
    }
       // System.out.println("dicionary: ::::"+h);
        return h;
    }
}
*/

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slicedMessage = new StringBuilder();
        
        for (int i = whichSlice; i < message.length(); i+= totalSlices) {
            slicedMessage.append(message.charAt(i));
        } 
        
        return slicedMessage.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        
        for (int i = 0; i < klength; i++) {
            String slicedMessage = sliceString(encrypted, i, klength);
            CaesarCracker cc = new CaesarCracker();
            key[i] = cc.getKey(slicedMessage);
        }
        
        return key;
    }

    public void breakVigenere() {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        int[] key = tryKeyLength(encrypted, 5, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted = vc.decrypt(encrypted);
        System.out.println("Decrypted message = " + decrypted);
    }
    
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> wordList = new HashSet<String>();
        
        for (String word : fr.lines()) {
            word = word.toLowerCase();
            wordList.add(word);
        }
        
        return wordList;
    }
    
    public int countWords(String message, HashSet<String> dictionary) {
        String[] wordList = message.split("\\W+");
        int totalOccurences = 0;
        
        for (String word : wordList) {
            if (dictionary.contains(word.toLowerCase())) {
                totalOccurences++;
            }
        }
        
        return totalOccurences;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        String finalMessage = "";
        int maxOccurences = Integer.MIN_VALUE;
        
        for (int i = 1; i <= 100; i++) {
            /*
             * Code for break vigenere with unknown key using english language: 
             * int[] key = tryKeyLength(encrypted, i, 'e');
            */
            int[] key = tryKeyLength(encrypted, i, mostCommonCharIn(dictionary));
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int currOccurences = countWords(decrypted, dictionary);
            
            if (currOccurences > maxOccurences) {
                maxOccurences = currOccurences;
                finalMessage = decrypted;
            }
        }
        
        return finalMessage;
    }
    
    public void breakVigenereUnknownKey() {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        FileResource dictResource = new FileResource("dictionaries/English");
        HashSet<String> dictionary = readDictionary(dictResource);
        String decrypted = breakForLanguage(encrypted, dictionary);
        System.out.println("Decrypted message = " + decrypted);
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
        
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                
                if (!charCounts.containsKey(currChar)) {
                    charCounts.put(currChar, 1);
                } else {
                    charCounts.put(currChar, charCounts.get(currChar) + 1);
                }
            }
        }
        
        char mostCommon = '\0';
        int maxOccurences = Integer.MIN_VALUE;
        
        for (char key : charCounts.keySet()) {
            int currCount = charCounts.get(key);
            
            if (currCount > maxOccurences) {
                maxOccurences = currCount;
                mostCommon = key;
            }
        }
        
        return mostCommon;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages) {
        int maxOccurences = Integer.MIN_VALUE;
        String detectedLanguage = "";
        String decrypted = "";
        
        for (String language : languages.keySet()) {
            HashSet<String> dictionary = languages.get(language);
            
            decrypted = breakForLanguage(encrypted, dictionary);
            int currentOccurences = countWords(decrypted, dictionary);
            
            if (currentOccurences  > maxOccurences) {
                detectedLanguage = language;
                maxOccurences = currentOccurences;
            }
        }
        
        System.out.println("Language = " + detectedLanguage);
        System.out.println("Decrypted message = " + decrypted);
    }
    
    public void breakVigenereUnknownKeyAndLanguage() {
         DirectoryResource dr = new DirectoryResource();
       
        
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        //String[] languageList = {"Danish", "Dutch", "English", "French", "German", "Italian", "Portuguese", "Spanish"};
        //FileResource dictResource;
        
        for (File f:dr.selectedFiles()) {
            FileResource file=new FileResource(f);
            String language=f.getName();
            languages.put(language, readDictionary(file));
            System.out.println("Finished reading " + language + " dictionary");
        }
        URLResource e=new URLResource("https://www.dukelearntoprogram.com//java/secretmessage4.txt");
        String encrypted=e.asString();
        breakForAllLangs(encrypted, languages);}
    }
