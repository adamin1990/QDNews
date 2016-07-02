package adamin90.com.qqd;

import android.support.v4.view.MotionEventCompat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by LiTao on 2015-11-28-19:22.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class EncryptionUtil {

    public static final String SHA1(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(s.getBytes());
            return toHexString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static final String toHexString(byte[] keyData) {
        if (keyData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(keyData.length * 2);
        for (byte b : keyData) {
            String hexStr = Integer.toString(b & MotionEventCompat.ACTION_MASK, 16);
            if (hexStr.length() == 1) {
                hexStr = "0" + hexStr;
            }
            sb.append(hexStr);
        }
        return sb.toString();
    }

    public static String getCrc(Map<String, String> params) {
        return SHA1(getMapAppendUrl(params) + "562487d0560a67.08735608");
    }

    public static String getMapAppendUrl(Map<String, String> params) {
        StringBuffer sb1 = new StringBuffer();
        for (String key : params.keySet()) {
            sb1.append(key);
            sb1.append("=");
            sb1.append((String) params.get(key));
            sb1.append("&");
        }
        sb1.deleteCharAt(sb1.length() - 1);
        return sb1.toString();
    }



    public static String getSHA1Str(String var) {
        try {
            MessageDigest sha_1 = MessageDigest.getInstance("SHA-1");
            sha_1.update(var.getBytes());
            return byteToHexString(sha_1.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (byte b2 : b) {
            String hex = Integer.toHexString(b2 & MotionEventCompat.ACTION_MASK);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toLowerCase());
        }
        return hexString.toString();
    }


}
