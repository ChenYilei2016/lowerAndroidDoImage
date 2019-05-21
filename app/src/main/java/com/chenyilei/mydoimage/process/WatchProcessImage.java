package com.chenyilei.mydoimage.process;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

//�Զ�����ʵ��ͼ��鿴���� ����:��ת ��ֱ��ת ˮƽ��ת ���� ��ͼ ˮӡ
public class WatchProcessImage
{
	private Bitmap mBitmap;

	//���췽��
	public WatchProcessImage(Bitmap bmp)
	{
		mBitmap = bmp;
	}
	/*
	 * 1.ͼƬ��ת 45��һ����ת
	 * flag=1��ʾ��ת45�� flag=2��ʾ��ת90�� flag*45Ϊ����
	 */
	//��תͼƬ
	public Bitmap TurnImage(Bitmap bmp, int flag)
	{
		Matrix matrix = new Matrix();
		int turnRotate = flag * 45;
		//ѡ��Ƕ� ��(0,0)��ѡ�� ����˳ʱ�� ������ʱ�� ������ת
		matrix.setRotate(turnRotate, bmp.getWidth()/2, bmp.getHeight()/2);
		Bitmap createBmp = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());
		Canvas canvas = new Canvas(createBmp);
		Paint paint = new Paint();
		canvas.drawBitmap(bmp, matrix, paint);
		return createBmp;
	}
	/*
	 * 2.ͼƬˮƽ��ת -> ����
	 * flag=0��ʾ��һ�η�ת flag=1��ʾ��ת��ԭͼ �����л�
	 */
	public Bitmap FlipHorizontalImage(Bitmap bmp, int flag)
	{
		if(flag == 0) { //ˮƽ��ת
			//����9��ֵ ��������Խ�� ArrayIndexOutOfBoundsException
			float[] floats = new float[] {
					-1f, 0f, 0f,
					 0f, 1f, 0f,
					 0f, 0f, 1f
				};
			if(floats != null) {
				Matrix matrix = new Matrix();
				matrix.setValues(floats);
				return Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
			}
		}
		else if(flag == 1) {
			return bmp;
		}
		return bmp;
	}

	/*
	 * 3.ͼƬ��ֱ��ת
	 * flag=0��ʾ��һ�η�ת flag=1��ʾ��ת��ԭͼ �����л�
	 */
	public Bitmap FlipVerticalImage(Bitmap bmp, int flag)
	{
		if(flag == 0) { //��ֱ��ת
			//����9��ֵ
			float[] floats = new float[] {
					1f,  0f, 0f,
					0f, -1f, 0f,
					0f,  0f, 1f
				};
			if(floats != null) {
				Matrix matrix = new Matrix();
				matrix.setValues(floats);
				return Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
			}
		}
		else if(flag ==1 ) {
			return bmp;
		}
		return bmp;
	}



}
