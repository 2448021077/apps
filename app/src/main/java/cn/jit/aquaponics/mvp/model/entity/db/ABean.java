package cn.jit.aquaponics.mvp.model.entity.db;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "test_table")
public class ABean {
    //主键自增长 @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "time")
    private long time;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "tag_id")
    private String tag_id;

    //如果实体中包含你不想持久化的字段
    @Ignore
    Bitmap picture;

    public ABean(long id) {
        this.id = id;
    }

    public ABean() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }
}
