package huytranq.dayum.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by huytr on 18-01-2016.
 */
public class User {

    public static final String TABLE = "User";
    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String PASSWORD = "Password";
    public static final String SALT = "Salt";
    public static final String PHONE = "Phone";
    public static final String AVATAR = "Avatar";
    public static final String BACKGROUND = "BACKGROUND";

    private int id;
    private String name;
    private String phone;
    private Bitmap avatar;
    private Bitmap background;

    public User(int id, String name, String phone, byte[] avatar, byte[] background) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.avatar = BitmapFactory.decodeByteArray(avatar , 0 , avatar.length);
        this.background = BitmapFactory.decodeByteArray(background , 0 , background.length);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public Bitmap getBackground() {
        return background;
    }

    public void setBackground(Bitmap background) {
        this.background = background;
    }
}
