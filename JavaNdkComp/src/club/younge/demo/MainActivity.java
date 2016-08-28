/** 
 * @projectName:JavaNdkComp 
 * @fileName:MainActivity.java 
 * @packageName:club.younge.demo 
 * @date:2016年8月28日下午11:10:29 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */

package club.younge.demo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import club.younge.java.JavaImageUtils;
import club.younge.ndk.NdkImageUtils;

/**
 * @className:MainActivity
 * @function: TODO ADD FUNCTION.
 * @reason: TODO ADD REASON.
 * @date: 2016年8月28日 下午11:10:29
 * @author Younge
 * @version
 * @since JDK 1.8
 * @see
 */
public class MainActivity extends Activity {
	private ImageView imageView;
	private Bitmap mBitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		imageView = (ImageView) findViewById(R.id.imageView);
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xy);
	}

	public void srcImage(View view) {
		imageView.setImageBitmap(mBitmap);
	}

	public void javaImage(View view) {
		long start = System.currentTimeMillis();
		Bitmap bitmap = JavaImageUtils.getBitMap(mBitmap);
		imageView.setImageBitmap(bitmap);
		long end = System.currentTimeMillis();
		Toast.makeText(this, "耗时："+ (end -start) +"ms", Toast.LENGTH_SHORT).show();
	}

	public void ndkImage(View view) {
		int width = mBitmap.getWidth();
		int height = mBitmap.getHeight();
		int[] buffer = new int[width*height];
		mBitmap.getPixels(buffer, 0, width, 0, 0, width, height);
		long start = System.currentTimeMillis();
		int[] result = NdkImageUtils.getImage(buffer, width, height);
		Bitmap bitmap = Bitmap.createBitmap(result, 0, width, width, height, Config.ARGB_8888);
		imageView.setImageBitmap(bitmap);
		long end = System.currentTimeMillis();
		Toast.makeText(this, "耗时："+ (end -start) +"ms", Toast.LENGTH_SHORT).show();
	}
}
