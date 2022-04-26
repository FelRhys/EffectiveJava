package effective.chapter_02.item_05_dependency_injection;

import java.util.Objects;

public class SpellChecker {

    private final Lexicon dictionary;

    //here the dependency is injected in the constructor
    public SpellChecker(Lexicon dictionary){
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word){
        return true;
    }
}
