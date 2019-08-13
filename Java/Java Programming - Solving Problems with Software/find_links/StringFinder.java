import edu.duke.*;
public class StringFinder {
    public void getYoutubeURL(){
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        URLResource ur = new URLResource(url);
        
        for(String word: ur.words()){
            String currentWord = word.toLowerCase();
            int index = currentWord.indexOf("youtube.com");
            if(index == -1) { continue; }
            int firstQuotes = currentWord.indexOf("\"");
            if(firstQuotes == -1 || firstQuotes > index) {continue;}
            int secondQuotes = currentWord.indexOf("\"", index + 11);
            if(secondQuotes == -1){ continue; }
            System.out.println(word.substring(firstQuotes+1, secondQuotes));
            
        }
    }
}
