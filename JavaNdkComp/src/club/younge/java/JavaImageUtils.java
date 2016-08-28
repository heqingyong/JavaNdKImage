/** 
 * @projectName:JavaNdkComp 
 * @fileName:JavaImageUtils.java 
 * @packageName:club.younge.java 
 * @date:2016年8月28日下午11:12:57 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.java;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;

/** 
 * @className:JavaImageUtils 
 * @function: TODO ADD FUNCTION.  
 * @reason:   TODO ADD REASON. 
 * @date:     2016年8月28日 下午11:12:57
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class JavaImageUtils {
	public static Bitmap getBitMap(Bitmap bitmap){
		if(bitmap == null) return null;
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		Bitmap result = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		int color, a, r, g, b, rt, gt, bt;
		float bright = 0.2f;
		float contrast = 0.2f;
		int bri = (int)(256*bright);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				color = bitmap.getPixel(x, y);
				a = Color.alpha(color);
				r = Color.red(color);
				g = Color.green(color);
				b = Color.blue(color);
				//更改亮度，统一增加一个值，变得更白更亮
			    rt = r + bri;
			    gt = g + bri;
			    bt = b + bri;
			    
			    r = rt > 255 ? 255:(rt < 0 ? 0: rt); //事实在目前情况下，不会出现rt小于0的情况，此处这么写是为了统一后边
			    g = gt > 255 ? 255:(gt < 0 ? 0: gt);
			    b = bt > 255 ? 255:(bt < 0 ? 0: bt);
			    
			    //更改对比度, 以128中间值为分界点，白的更白，黑的更黑，增加对比度
			    
			    r = r - 128;
			    g = g - 128;
			    b = b - 128;
			    
			    rt = (int) (r*(1 + contrast)) + 128;
			    gt = (int) (g*(1 + contrast)) + 128;
			    bt = (int) (b*(1 + contrast)) + 128;
			    
			    r = rt > 255 ? 255:(rt < 0 ? 0: rt); 
			    g = gt > 255 ? 255:(gt < 0 ? 0: gt);
			    b = bt > 255 ? 255:(bt < 0 ? 0: bt);
			    
			    color = Color.argb(a, r, g, b);	
			    
			    result.setPixel(x, y, color);
			}
			
		}
		
		return result;
	}
}

