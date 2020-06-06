package test.testdcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class TestDcs {
	private static final String  eni="?[property]\r\n"+
"version_name=REGULAR_VERSION\r\n"+
"version_code=DCS3.0_6.1.1388.101ZH\r\n"+
"caption=永中Office\r\n"+
"full_caption=永中Office 2013\r\n"+
"trail_suffix=\r\n"+
"limited_times=-1\r\n"+
"limited_days=-1\r\n"+
"email=support@yozosoft.com\r\n"+
"website=http://www.yozosoft.com\r\n"+
"company_name=无锡永中软件有限公司\r\n"+
"telephone=(0510) 85381608\r\n"+
"has_ceb=0\r\n"+
"online_template=http://www.yozosoft.com/zypt/Template.jsp\r\n"+
"online_symbols=http://www.yozosoft.com/zypt/Symbols.jsp\r\n"+
"backup_for_ms=1\r\n"+
"write_undo_list=1\r\n"+
"has_sep=0\r\n"+
"clipboard=1\r\n"+
"appletEnv=1\r\n"+
"online_shopping=http://www.yozosoft.com/shopping/index.jsp\r\n"+
"version_type=1\r\n"+
"online_template_index=http://www.yozosoft.com/zypt/TemplateIndex.xml\r\n"+
"hot_news=http://forum.yozosoft.com/forum.xml\r\n"+
"product_year_id=19\r\n"+
"product_language_id=1\r\n"+
"product_class_id=10\r\n"+
"product_series_id=11\r\n"+
"product_accredit_id=14\r\n"+
"help_download=http://www.yozosoft.com/techsupport/upgrade.jsp\r\n"+
"sciedu_type=0\r\n"+
"default_ui=1\r\n"+
"choose_ui=0\r\n"+
"assis_info=7;6;9\r\n"+
"ad_banner=0\r\n"+
"edu_special_license_version=0\r\n"+
"edu_need_register=1\r\n"+
"web_url_service=http://www.iyocloud.com/static/\r\n"+
"online_template_zip = http://www.yozosoft.com/zypt/Templates.zip\r\n"+
"show_worning_for_ms=1\r\n"+
"source_file_name=all\r\n"+
"target_file_name=all\r\n"+
"machine_code=-1\r\n"+
"desktop_limited_times=-1\r\n"+
"isauthorized_company_name=Near开源";
	
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
//		d("config.eni");
		d("C:\\Users\\Near\\Desktop\\2.eni");
//		e();
	}
	private static void e() throws UnsupportedEncodingException, IOException {
		File output = new File("C:\\Users\\Near\\Desktop\\Near.eni");
		FileOutputStream fos = new FileOutputStream(output);
		byte[] result = eni.getBytes("UTF-8");
			for (int i2 = 0; i2 < result.length; ++i2) {
				int tmp123_121 = i2;
				byte[] tmp123_120 = result;
				tmp123_120[tmp123_121] = (byte) (tmp123_120[tmp123_121] - 16);
			}
		fos.write(result);
		fos.flush();
		fos.close();
		
	}
	private static String d(String x) {
		String X =x;
		FileInputStream localFileInputStream = null;
		try {
			File localFile = new File(X);
			if (!(localFile.exists())) {
				System.out.println("File is not exists：" + X);
				return null;
			}
			StringBuffer localStringBuffer = new StringBuffer();
			localFileInputStream = new FileInputStream(localFile);
			byte[] arrayOfByte = new byte[4096];
			for (int i1 = localFileInputStream.read(arrayOfByte); i1 > 0; i1 = localFileInputStream.read(arrayOfByte)) {
				for (int i2 = 0; i2 < arrayOfByte.length; ++i2) {
					int tmp123_121 = i2;
					byte[] tmp123_120 = arrayOfByte;
					tmp123_120[tmp123_121] = (byte) (tmp123_120[tmp123_121] + 16);
				}
				String str1 = new String(arrayOfByte, 0, i1, "UTF-8");
				localStringBuffer.append(str1);
			}
			String str2 = localStringBuffer.toString();
			System.out.println(str2);
			return str2;
		} catch (IOException localIOException1) {
			return null;
		} finally {
			try {
				if (localFileInputStream != null)
					localFileInputStream.close();
			} catch (IOException localIOException4) {
			}
		}
	}
	private static String d2(String x) {
		String X =x;
		FileInputStream localFileInputStream = null;
		try {
			File localFile = new File(X);
			if (!(localFile.exists())) {
				System.out.println("File is not exists：" + X);
				return null;
			}
			StringBuffer localStringBuffer = new StringBuffer();
			localFileInputStream = new FileInputStream(localFile);
			byte[] arrayOfByte = new byte[4096];
			for (int i1 = localFileInputStream.read(arrayOfByte); i1 > 0; i1 = localFileInputStream.read(arrayOfByte)) {
				for (int i2 = 0; i2 < arrayOfByte.length; ++i2) {
					int tmp123_121 = i2;
					byte[] tmp123_120 = arrayOfByte;
					tmp123_120[tmp123_121] = (byte) (tmp123_120[tmp123_121] + 16);
				}
				String str1 = new String(arrayOfByte, 0, i1, "UTF-8");
				localStringBuffer.append(str1);
			}
			String str2 = localStringBuffer.toString();
			System.out.println(str2);
			return str2;
		} catch (IOException localIOException1) {
			return null;
		} finally {
			try {
				if (localFileInputStream != null)
					localFileInputStream.close();
			} catch (IOException localIOException4) {
			}
		}
	}
}
