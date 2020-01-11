package com.vincent.jetpackdemo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word")
public class EntityWord {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "chinese_meaning")
    private String chinesMeaning;
    @ColumnInfo(name = "english_meaing")
    private String word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChinesMeaning() {
        return chinesMeaning;
    }

    public void setChinesMeaning(String chinesMeaning) {
        this.chinesMeaning = chinesMeaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public EntityWord( String chinesMeaning, String word) {
        this.chinesMeaning = chinesMeaning;
        this.word = word;
    }

    @Override
    public String toString() {
        return "EntityWord{" +
                "id=" + id +
                ", chinesMeaning='" + chinesMeaning + '\'' +
                ", word='" + word + '\'' +
                "}\n";
    }
}
