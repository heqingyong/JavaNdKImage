/** 
 * @projectName:JavaNdkComp 
 * @fileName:NdkImageUtils.java 
 * @packageName:club.younge.ndk 
 * @date:2016年8月28日下午11:13:12 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.ndk;

/** 
 * @className:NdkImageUtils 
 * @function: TODO ADD FUNCTION.  
 * @reason:   TODO ADD REASON. 
 * @date:     2016年8月28日 下午11:13:12
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class NdkImageUtils {
	static{
		System.loadLibrary("Image");
	}
	public static native int[] getImage(int[] buffer, int width, int height);
}

