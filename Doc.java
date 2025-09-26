package engine;

import java.util.List;

public class Doc {
    private List<Word> title;
    private List<Word> body;
    public Doc(String content){
        String[] line = content.split("",2);
    }
    public List<Word> getTitle(){
        return title;
    }
    public List<Word> getBody(){
        return body;
    }
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Doc)) return false;
        Doc otherO = (Doc) o;
        return this.title.equals(otherO.title) && this.body.equals(otherO.body);
    }
    //can them 1 doan sua text
}
