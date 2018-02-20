package xspeedit.domain;

import java.util.ArrayList;
import java.util.List;

public class Crate {

    private List<Integer> articles;
    
    private int takenRoom;
    
    public Crate() {
	super();
    }

    public Crate(Integer article) {
	this.articles = new ArrayList<>();
	this.addArticle(article);
    }
    
    public void addArticle(Integer article) {
	this.articles.add(article);
	takenRoom += article;
    }
    
    public int getTakenRoom() {
	return takenRoom;
    }
}

