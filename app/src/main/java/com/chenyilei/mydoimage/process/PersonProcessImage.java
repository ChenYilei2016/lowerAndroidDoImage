package com.chenyilei.mydoimage.process;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

//�Զ�����ʵ��ͼ�񽻻� ����:�ϴ������桢ȡ�� 
//ԭ����Person����,�������о�������Ƕ༸��Ч��,�������ɱ���
public class PersonProcessImage
{
	private Bitmap mBitmap;
	public String pathPicture;    //ͼƬ·�� ���ݸ�ProcessActivity��MainActivity
	
	//���췽��
	public PersonProcessImage(Bitmap bmp)
	{
		mBitmap = bmp;
	}
	
	/*
	 * 1.ͼ�񱣴浽SD��
	 * ����:Bitmap filePath Ĭ��Ϊʱ������
	 * �������ʧ�ܷ��ش���,����ɹ�Ϊnull
	 */
	public Uri saveBitmapToSD(Bitmap bmp) throws IOException
	{
		//ͼƬʱ������
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(System.currentTimeMillis());
		String filename = format.format(date);
		//�洢��DCIM�ļ�����
		File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		//File path = new File(Environment.getExternalStorageDirectory(), "suishoupai");
		if (!path.exists()) {
	        path.mkdir();
	    }
		File imagePath = new File(path, filename +".jpg");	
		imagePath.createNewFile();
		FileOutputStream fos = new FileOutputStream(imagePath);
		//����ѹ������ ��ʽJPG 100��ʾ��ѹ�� ѹ���󱣴���bos
		bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
		fos.flush();
		fos.close();
		/*
		 * ע��:���ǲ���ʾͼƬ ������Ỻ����� �ֻ����������������ʾͼƬ
		 */
		return Uri.fromFile(imagePath);
	}
	
	/*
	 * 2.ͼ���ϴ� �ȱ�����ϴ�
	 * ����:Bitmap filePath Ĭ��Ϊʱ������
	 * �������ʧ�ܷ��ش���,����ɹ�Ϊnull
	 */
	public Uri loadBitmap(Bitmap bmp) throws IOException
	{
		//ͼƬʱ������
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(System.currentTimeMillis());
		String filename = format.format(date);
		//�洢��DCIM�ļ�����
		File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		//File path = new File(Environment.getExternalStorageDirectory(), "suishoupai");
		if (!path.exists()) {
	        path.mkdir();
	    }
		File imagePath = new File(path, filename +".jpg");	
		imagePath.createNewFile();
		FileOutputStream fos = new FileOutputStream(imagePath);
		//����ѹ������ ��ʽJPG 100��ʾ��ѹ�� ѹ���󱣴���bos
		bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
		fos.flush();
		fos.close();
		//ͼƬ·��
		pathPicture = imagePath.toString();
		/*
		 * ע��:���ǲ���ʾͼƬ ������Ỻ����� �ֻ����������������ʾͼƬ
		 */
		return Uri.fromFile(imagePath);
	}
	
	
}
