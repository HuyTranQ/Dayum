package huytranq.dayum.presenters.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.ByteArrayOutputStream;

import huytranq.dayum.models.User;

public class Database extends SQLiteOpenHelper {

    private static final String DEBUG = "Dayum";

    //  TODO    Database Version
    public static final int VERSION = 1;
    //  TODO    Database Name
    public static final String NAME = "dayum.db";

    //  TODO    Helper instance
    private static Database instance;

    //  TODO    Database instance
    private static SQLiteDatabase database;

    private Database(Context context) {
        super(context.getApplicationContext() , NAME , null , VERSION);
        //  TODO    Initialize database file
        copyDatabase(context);
    }

    private void copyDatabase(Context context) {
        String databasePath = Storage.getDatabasePath(context , NAME);
        if (Storage.exists(databasePath)) {
            Log.d(DEBUG , "database already exists");
        }
        else {
            try {
                Storage.copyAsset(context , NAME , databasePath);
            }
            catch (Exception exception) {
                Log.d(DEBUG , "Cannot fucking copy asset! Dude! " + exception.getMessage());
            }
        }
    }

    public static synchronized Database help(Context context) {
        if (instance == null)
            instance = new Database(context.getApplicationContext());
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  TODO    Initialize database on 1st time
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion <= oldVersion) {
            Log.d(DEBUG , "SQLite database is up-to-date");
            return;
        }
        Log.d(DEBUG , "SQLite database is outdated. (" + oldVersion + " < " + newVersion + ")");
        //  TODO    Upgrade database
        Log.d(DEBUG , "SQLite database it upgraded to " + newVersion);
    }

    public User queryUser(String username ,
                          byte[] password) throws Exception{
        User user = null;
        database = getReadableDatabase();
        String[] securityColumns = {User.PASSWORD , User.SALT};
        Cursor cursor = database.query(User.TABLE, securityColumns, User.NAME + " = '" + username + "'", null, null, null, null);
        if (cursor.getCount() == 0) {
            cursor.close();
            throw new Exception("username");
        }
        cursor.moveToFirst();
        byte[] saltedPassword = cursor.getBlob(0);
        byte[] salt = cursor.getBlob(1);
        cursor.close();
        if (!saltedPassword.equals(Security.hash(Security.salt(password, salt))))
            throw new Exception("password");
        String[] otherColumns = {User.ID , User.PHONE , User.AVATAR , User.BACKGROUND};
        cursor = database.query(User.TABLE , otherColumns , User.NAME + " = " + username , null , null , null , null);
        int id = cursor.getInt(0);
        String phone = cursor.getString(1);
        byte[] avatar = cursor.getBlob(2);
        byte[] background = cursor.getBlob(3);
        user = new User(id , username , phone , avatar , background);
        cursor.close();
        return user;
    }

    public boolean insertUser(User user ,
                              byte[] password ,
                              byte[] salt) {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.NAME, user.getName());
        values.put(User.PASSWORD, Security.hash(Security.salt(password , salt)));
        values.put(User.SALT, salt);
        values.put(User.PHONE, user.getPhone());
        values.put(User.AVATAR, Utility.bitmapBytes(user.getAvatar()));
        values.put(User.BACKGROUND, Utility.bitmapBytes(user.getBackground()));
        return (1 == database.insert(User.TABLE , null , values));
    }

    public boolean updateUserInfo(User user) {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.PHONE , user.getPhone());
        values.put(User.AVATAR , Utility.bitmapBytes(user.getAvatar()));
        values.put(User.BACKGROUND , Utility.bitmapBytes(user.getBackground()));
        return (1 == database.update(User.TABLE, values, User.ID + " = " + user.getId(), null));
    }

    public boolean updateUserPassword(int id ,
                                      byte[] password ,
                                      byte[] salt) {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.PASSWORD , Security.hash(Security.salt(password , salt)));
        values.put(User.SALT , salt);
        return (1 == database.update(User.TABLE , values , User.ID + " = " + id , null));
    }
}
