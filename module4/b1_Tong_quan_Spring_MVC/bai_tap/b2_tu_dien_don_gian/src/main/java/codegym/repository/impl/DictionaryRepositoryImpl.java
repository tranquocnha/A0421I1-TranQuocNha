package codegym.repository.impl;

import codegym.model.Dictionary;
import codegym.repository.DictionaryRepository;
import org.springframework.stereotype.Repository;



import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {
    static Map<String,String> wordMap;
    static {
        wordMap=new HashMap<>();
        Dictionary dictionary1= new Dictionary("red","mau do");
        Dictionary dictionary2=new Dictionary("yellow","mau vang");
        Dictionary dictionary3=new Dictionary("blue","xanh nuoc bien");
        Dictionary dictionary4=new Dictionary("green","xanh la cay");
        Dictionary dictionary5=new Dictionary("white","trang");
        Dictionary dictionary6=new Dictionary("black","đen");
        Dictionary dictionary7=new Dictionary("orange","mau cam");

        wordMap.put(dictionary1.getEnglish(),dictionary1.getVietnam());
        wordMap.put(dictionary2.getEnglish(),dictionary2.getVietnam());
        wordMap.put(dictionary3.getEnglish(),dictionary3.getVietnam());
        wordMap.put(dictionary4.getEnglish(),dictionary4.getVietnam());
        wordMap.put(dictionary5.getEnglish(),dictionary5.getVietnam());
        wordMap.put(dictionary6.getEnglish(),dictionary6.getVietnam());
        wordMap.put(dictionary7.getEnglish(),dictionary7.getVietnam());
    }
    @Override
    public String findEnglish(String english) {
        String word="khong tim thay tu nay";
        if (wordMap.get(english)!=null){
            return  wordMap.get(english);
        }
        return word;
    }
}
