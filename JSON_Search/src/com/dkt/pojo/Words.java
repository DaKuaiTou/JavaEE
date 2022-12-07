package com.dkt.pojo;

/**
 * @author: dkt
 * @Pcakage: com.dkt.pojo.Words
 * @Date: 2022年11月05日 09:16
 * @Description:
 */
public class Words {
    private int id;
    private String word;

    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }

    public Words() {
    }

    public Words(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
