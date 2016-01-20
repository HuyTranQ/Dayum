package huytranq.dayum.presenters.utilities;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Created by huytr on 18-01-2016.
 */
public final class Utility {
    public static byte[] bitmapBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG , 100 , stream);
        return stream.toByteArray();
    }
}
