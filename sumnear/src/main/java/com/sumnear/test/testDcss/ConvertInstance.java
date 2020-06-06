package test.testDcss;

import java.util.Random;

//import java.awt.Color;
//import java.io.File;
//import application.dcs.Convert;
//import application.dcs.IHtmlConvertor;
//import application.dcs.IPICConvertor;
//import sumnear.dcs.web.bo.ConvertParam;
//import sumnear.dcs.web.cons.DefaultResult;
//import sumnear.dcs.web.cons.EnumConvertType;
//import sumnear.dcs.web.cons.IResult;
//import sumnear.dcs.web.cons.ResultCode;
//import sumnear.dcs.web.listener.Config;
//import sumnear.dcs.web.log.LogUtil;
//import sumnear.dcs.web.service.file.FileService;

public class ConvertInstance {
	private Integer num ; 
	
	
	
	public ConvertInstance(Integer num) {
		super();
		this.num = num;
	}

	@Override
	public String toString() {
		return "ConvertInstance [num=" + num + "]";
	}


	public Integer converTest(){
//		try {
//			Integer sleepTime = new Random().nextInt(8);
//			System.out.println(this.toString()+"睡眠时间：："+sleepTime);
//			Thread.sleep(sleepTime*1000);
//			return 0;
//		} catch (InterruptedException e) {
//			System.out.println(this.toString() +"实例被interrupted");
//			return 15; //被终止
//		}
//		while(!Thread.currentThread().isInterrupted()){
//			System.out.println("我是死循环！！！");
//		}
		int i =1;
		while(i<1000){
			System.out.println(Thread.currentThread().getName()+"老子就是要执行1000次");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
		
	}
//	private Convert converter;
//
//	public ConvertInstance(Integer index) {
//		converter = new Convert();
//		converter.setEmptyCount(50, 50); // 如果50行，或者50列没有数据，就不往后解析了
//		converter.setXlsxMaxRowCol(65536, 256);// 最大转换行，最大转换列
//		// converter.setHtmlEncoding("UTF8");
//		// 设置临时文件路径
//		if (Config.tempDir != null && !"".equals(Config.tempDir)) {
//			converter.setTempPath(Config.tempDir + File.separator + index + File.separator);
//		}
//	}
//	public int queryTimes() {
//		return converter.getTimes();
//	}
//
//	public int queryDays() {
//		return converter.getDays();
//	}
//	//验证授权是否过期,false过期
//	public Boolean verify(){
//		return converter.verify();
//	}
//	
//	public String getRegCode(){
//		return converter.getRegisterCode();
//	}
//	
//	// doc2doc
//	public void convertdoc(String inFile, String outFile, ConvertParam param) {
//		if (param.getBookMark() != null && param.getBookMark().length > 0) {
//			converter.setBookmarks(param.getBookMark());
//		}
//		converter.convert(inFile, outFile);
//	}
//    //每次转换前清空一下
//	public void clearParam(){
//		converter.setOpenPsw(null);//密码
//		converter.setViewAll(false);//是否分页加载
//		//converter.insertPicWaterMark("", 1, false, true); //图片水印
//		converter.setAntiCopy(false);//防复制
//		converter.setShowList(true);//显示目录
//		converter.setShowTitle(true);//黑条
//		//converter.setHtmlEncoding("UTF-8");//默认编码
//		converter.setHtmlTitle("永中文档转换服务");//标题
//		converter.setBookmarks(null);//书签	
//		converter.insertTextWaterMark("","",100,Color.black,true,true,true);//水印
//	}
//	
//	public IResult<Integer> convert(ConvertParam param) {
//		clearParam();//初始化所有参数
//		converter.setAutoDeleteTempFiles(true);
//		converter.setTimeout(Config.convertTimeout);
//		/**
//		 * arg0 内容 arg1 字体 arg2 大小 arg3 颜色 arg4 arg5 arg6
//		 */
//		if (param.getWmContent() != null && !"".equals(param.getWmContent())) {
//			converter.insertTextWaterMark(param.getWmContent(), param.getWmFont(), param.getWmSize(),
//					param.getWmColor(), true, true, true);
//		}
//		//是否显示批注
//		if (param.getAcceptTracks() !=null && param.getAcceptTracks() == 0){
//			converter.setAcceptTracks(true);
//		}else{
//			converter.setAcceptTracks(false);
//		}
//		if (param.getIsShowNum() !=null && param.getIsShowNum() == 0){
//			converter.setShowPageNumber(false);
//		}else{
//			converter.setShowPageNumber(true);
//		}
//		//是否竖排
//		if (param.getIsVertical() !=null && param.getIsVertical() == 1){
//			converter.setConvertForPhone(true);;
//		}else{
//			converter.setConvertForPhone(false);
//		}
//		if(param.getIsPrint() !=null && param.getIsPrint() == 0){
//			converter.setShowPrint(false);
//		}else{
//			converter.setShowPrint(true);
//		}
//		// 加密文档
//		if (param.getPassword() != null && !"".equals(param.getPassword())) {
//			converter.setOpenPsw(param.getPassword());
//		}
//		// 设置转换后文件权限
//		if (Config.filePermission != null && !"".equals(Config.filePermission) && Config.filePermission.equals("true")) {
//			converter.setFilePermission(true);
//		}else{
//			converter.setFilePermission(false);
//		}
//		//显示页脚信息
//		if (param.getShowFooter() !=null && param.getShowFooter() == 0){
//			converter.setShowFooter(false);
//		}else{
//			converter.setShowFooter(true);
//		}
//		// 设置是够分页加载
//		if (param.getIsShowAll() != null && param.getIsShowAll() == 1) {
//			converter.setViewAll(true);
//		}
//		// 设置图片水印
//		if (param.getWmPicPath() != null && !"".equals(param.getWmPicPath())) {
//			converter.insertPicWaterMark(param.getWmPicPath(), 1, false, true);
//		}
//
//		if (param.getIsCopy() != null && param.getIsCopy() == 1) {
//			converter.setAntiCopy(true); // 防复制
//		}
//		
//		if (param.getAntiDownload() != null && param.getAntiDownload() == 1) {
//			converter.setAntiDownload(true); //防下载
//		}
//
//		if (param.getIsShowList() != null && param.getIsShowList() == 0) {
//			converter.setShowList(false);
//		}
//		if (param.getIsHideBlank() != null && param.getIsHideBlank() == 1) {
//			converter.setHideBlank(true);
//		}
//		// 设置转换后 Html的name
//		if (param.getHtmlName() != null && !"".equals(param.getHtmlName())) {
//			converter.setHtmlName(param.getHtmlName());
//		}else{
//			converter.setHtmlName(param.getFileName());
//		}
//		// 设置转换后 黑条
//		if (param.getIsShowTitle() != null && param.getIsShowTitle() == 0) {
//			converter.setShowTitle(false);
//		}
//		if (param.getHtmlPath() != null && !"".equals(param.getHtmlPath())) {
//			converter.setHtmlPath(param.getHtmlPath()+"/"+param.getRelativePath()+"/"+param.getTargetImageFolder()+".files");
//		}
//		//设置是否提供原文档下载
//		if (param.getIsDownload()!=null && param.getIsDownload()==1 && param.getInputUrl() !=null && !"".equals(param.getInputUrl())){
//			converter.setDownloadUrl(param.getInputUrl());
//		}
//		// 设置转换时的编码
//		if (param.getEncoding() != null && !"".equals(param.getEncoding())) {
//			converter.setHtmlEncoding(param.getEncoding());
//		}
////		} else {
////			// converter.setHtmlEncoding("GBK");
////			converter.setHtmlEncoding(System.getProperty("file.encoding"));
////			//converter.setHtmlEncoding("UTF-8");
////		}
//		// 设置htmlTitle
//		if (param.getHtmlTitle() != null && !"".equals(param.getHtmlTitle())) {
//			converter.setHtmlTitle(param.getHtmlTitle());
//		} else if (Config.htmlTitle != null && !"".equals(Config.htmlTitle.trim())) {
//			if ("$name".equals(Config.htmlTitle)) {
//				if (param.getHtmlName() != null && !"".equals(param.getHtmlName())) {
//					converter.setHtmlTitle(param.getHtmlName());
//				} else {
//					converter.setHtmlTitle(param.getFileName());
//				}
//			} else {
//				converter.setHtmlTitle(Config.htmlTitle);
//			}
//		} else {
//			converter.setHtmlTitle("永中文档转换服务");
//		}
//		// 设置bookmark
//		if (param.getBookMark() != null && param.getBookMark().length > 0) {
//			converter.setBookmarks(param.getBookMark());
//		}
//		IPICConvertor image = null;
//		IHtmlConvertor htmlconvertor = null;
//		// 重新封装switch case 结果统一返回
//		// DCC新增result返回值7，表示转换超时，但是可以正常显示。。所以有以下修改
//		Integer re = ResultCode.E_CONVERSION_FAIL.getValue();
//		Integer pagecount = null;
//		try {
//			switch (EnumConvertType.getEnumByType(param.getType())) {
//			case MS_MERGE: {
//				String[] docMergeFile = new String[param.getMergeInput().length+1];
//				System.arraycopy(param.getMergeInput(),0,docMergeFile,1,param.getMergeInput().length);
//				docMergeFile[0] = param.getInput();
//				boolean result = converter.convertForMerge(docMergeFile, param.getOutput());
//				re = result ? ResultCode.E_SUCCES.getValue() : ResultCode.E_CONVERSION_FAIL.getValue();
//				break;
//			}
//			//多pdf文档合并
//			case PDF_MERGE: {
//				String[] pdfMergeFile = new String[param.getMergeInput().length+1];
//				System.arraycopy(param.getMergeInput(),0,pdfMergeFile,1,param.getMergeInput().length);
//				pdfMergeFile[0] = param.getInput();
//				converter.mergePdfFiles(pdfMergeFile, param.getOutput(), true);
//				File file = new File(param.getOutput()==null?"":param.getOutput());
//				boolean result;
//				if(file.exists()){
//					result = true;
//				}else{
//					result = false;
//				}
//				re = result ? ResultCode.E_SUCCES.getValue() : ResultCode.E_CONVERSION_FAIL.getValue();
//				break;
//			}
//			case OFD_HTML_TEMP:
//			case PDF_HTML_TEMP: {
//				// 把源文件复制到输出目录，
//				boolean result = FileService.copyFile(param.getInput(), param.getOutput(), param.getFileName().replaceAll(" ",""));
//				re = result ? ResultCode.E_SUCCES.getValue() : ResultCode.E_CONVERSION_FAIL.getValue();
//				break;
//			}
//			case ZIP_HTML_TEMP: {
//				String addPath;
//				if (param.getHtmlName() != null && !"".equals(param.getHtmlName())) {
//					addPath=param.getHtmlName();
//				}else{
//					addPath = param.getFileName() == null ? "NewFile" : param.getFileName();
//				}
//				String filename = addPath;
//				addPath = addPath.indexOf(".") > 0 ? addPath.substring(0, addPath.lastIndexOf(".")) : addPath;
//				//最后一个 boolean参数 是否DCC生成 JSON文件
//				converter.unCompress(param.getInput(), param.getOutput() + File.separator + addPath, false);
//				FileService.copyFile(param.getInput(), param.getOutput(), filename);
//				// param.setOutput(param.getOutput()+File.separator+addPath);
//				re = ResultCode.E_SUCCES.getValue();
//				break;
//			}
//			case TIF_HTML: {
//				re = converter.convertTifToHtml(param.getInput(), param.getOutput());
//				break;
//
//			}
//			case MS_HTML_SVG: {
////				re = converter.convertMStoHtmlOfSvg(param.getInput(), param.getOutput());
//				re = converter.convertMStoHtmlOfSvg(param.getInput(), param.getOutput(), param.getZoom());
//				break;
//			}
//			//文档转html(图片)
//			case MS_HTMLOFPIC: {
////				re = converter.convertMSToHtmlOfPic(param.getInput(), param.getOutput());
//				re = converter.convertMSToHtmlOfPic(param.getInput(), param.getOutput(), param.getZoom());
//				break;
//			}
//			//文档转ofd
//			case MS_OFD: {
//				re = converter.convertMStoOFD(param.getInput(), param.getOutput());
//				break;
//			}
//
//			case MS_HTML: {
//				re = converter.convertMStoHTML(param.getInput(), param.getOutput());
//				break;
//			}
//			case MS_TXT: {
//				re = converter.convertMStoTxt(param.getInput(), param.getOutput());
//				break;
//			}
//			case MS_PDF: {
//				re = converter.convertMStoPDF(param.getInput(), param.getOutput());
//				break;
//			}
//			case PDF_HTML: {
////				re = converter.convertPdfToHtml(param.getInput(), param.getOutput());
//				re = converter.convertPdfToHtml(param.getInput(), param.getOutput(), param.getZoom());
//				break;
//			}
//			case PDF_TXT: {
//				re = converter.convertPdfToTxt(param.getInput(), param.getOutput());
//				break;
//			}
//			case MS_GIF:
//			case PDF_GIF: {
//				if (param.getType() == EnumConvertType.MS_GIF.getType())
//					image = converter.convertMStoPic(param.getInput());
//				else
//					image = converter.convertPdftoPic(param.getInput());
//				if (image != null && image.resultCode() == 0) {
//					pagecount = image.getPageCount();
//					Integer[] pages = param.getPage(); // 拿到要转换的页码
//					if (pages == null || pages.length < 1) {
//						pages = new Integer[pagecount];
//						for (int i = 0; i < pagecount; i++) {
//							pages[i] = i;
//						}
//					}
//					for (Integer page : pages) {
//						re = image.convertToGIF(page, page, param.getZoom(), param.getOutput());
//						if (!ResultCode.E_SUCCES.getValue().equals(re)) {
//							break;
//						}
//					}
//				}
//				break;
//			}
//			case MS_PNG:
//			case PDF_PNG: {
//				if (param.getType() == EnumConvertType.MS_PNG.getType())
//					image = converter.convertMStoPic(param.getInput());
//				else
//					image = converter.convertPdftoPic(param.getInput());
//				if (image != null && image.resultCode() == 0) {
//					pagecount = image.getPageCount();
//					Integer[] pages = param.getPage(); // 拿到要转换的页码
//					if (pages == null || pages.length < 1) {
//						pages = new Integer[pagecount];
//						for (int i = 0; i < pagecount; i++) {
//							pages[i] = i;
//						}
//					}
//					for (Integer page : pages) {
//						re = image.convertToPNG(page, page, param.getZoom(), param.getOutput());
//						if (!ResultCode.E_SUCCES.getValue().equals(re)) {
//							break;
//						}
//					}
//				}
//				break;
//			}
//			case MS_JPG:
//			case PDF_JPG: {
//				if (param.getType() == EnumConvertType.MS_JPG.getType())
//					image = converter.convertMStoPic(param.getInput());
//				else
//					image = converter.convertPdftoPic(param.getInput());
//				if (image != null && image.resultCode() == 0) {
//					pagecount = image.getPageCount();
//					Integer[] pages = param.getPage(); // 拿到要转换的页码
//					if (pages == null || pages.length < 1) {
//						pages = new Integer[pagecount];
//						for (int i = 0; i < pagecount; i++) {
//							pages[i] = i;
//						}
//					}
//					for (Integer page : pages) {
//						re = image.convertToJPG(page, page, param.getZoom(), param.getOutput());
//						if (!ResultCode.E_SUCCES.getValue().equals(re)) {
//							break;
//						}
//					}
//				}
//				break;
//			}
//			case MS_TIFF:
//			case PDF_TIFF: {
//				if (param.getType() == EnumConvertType.MS_TIFF.getType())
//					image = converter.convertMStoPic(param.getInput());
//				else
//					image = converter.convertPdftoPic(param.getInput());
//				if (image != null && image.resultCode() == 0) {
//					pagecount = image.getPageCount();
//					Integer[] pages = param.getPage(); // 拿到要转换的页码
//					if (pages == null || pages.length < 1) {
//						pages = new Integer[pagecount];
//						for (int i = 0; i < pagecount; i++) {
//							pages[i] = i;
//						}
//					}
//					for (Integer page : pages) {
//						re = image.convertToTIFF(page, page, param.getZoom(), param.getOutput());
//						if (!ResultCode.E_SUCCES.getValue().equals(re)) {
//							break;
//						}
//					}
//				}
//				break;
//			}
//			case MS_BMP:
//			case PDF_BMP: {
//				if (param.getType() == EnumConvertType.MS_BMP.getType())
//					image = converter.convertMStoPic(param.getInput());
//				else
//					image = converter.convertPdftoPic(param.getInput());
//				if (image != null && image.resultCode() == 0) {
//					pagecount = image.getPageCount();
//					Integer[] pages = param.getPage(); // 拿到要转换的页码
//					if (pages == null || pages.length < 1) {
//						pages = new Integer[pagecount];
//						for (int i = 0; i < pagecount; i++) {
//							pages[i] = i;
//						}
//					}
//					for (Integer page : pages) {
//						re = image.convertToBMP(page, page, param.getZoom(), param.getOutput());
//						if (!ResultCode.E_SUCCES.getValue().equals(re)) {
//							break;
//						}
//					}
//				}
//				break;
//			}
//			case HTML_MS: {
//				boolean r = converter.convertHTMLToMS(param.getInput(), param.getOutput());
//				re = r ? ResultCode.E_SUCCES.getValue() : ResultCode.E_CONVERSION_FAIL.getValue();
//				break;
//			}
//				// 这个比较特殊，是高清分页的API，由于业务需要返回值分为 -1表示失败，不然返回 总页数
//			case MS_SVG:
//			case MS_SVG_TEMP: {
//				image = converter.convertMStoPic(param.getInput());
//				if (image != null && image.resultCode() == 0) {
//					pagecount = image.getPageCount();
//					Integer[] pages = param.getPage(); // 拿到要转换的页码
//					if (pages == null || pages.length < 1) {
//						pages = new Integer[pagecount];
//						for (int i = 0; i < pagecount; i++) {
//							pages[i] = i;
//						}
//					}
//					for (Integer page : pages) {
//						int page2 = page;
//						re = image.convertToSVG(page2, page2, 1.0f, param.getOutput());
//						if (!ResultCode.E_SUCCES.getValue().equals(re)) {
//							break;
//						}
//					}
//				}
//				break;
//			}
//				// 方法返回void 如果获取了 pagecount 表示可以转换成功
//			case MS_SVG_PAGE:
//			case MS_HTML_PAGE: {
//				htmlconvertor = converter.convertMStoHtml(param.getInput());
//				if (htmlconvertor == null || htmlconvertor.resultCode() != 0) {
//					break;
//				}
//				pagecount = htmlconvertor.getPageCount(); // 获取文档页码
//				if (pagecount <= 0) {
//					break;
//				}
//				Integer[] pages = param.getPage(); // 拿到要转换的页码
//				if (pages == null || pages.length < 1) {
//					pages = new Integer[pagecount];
//					for (int i = 0; i < pagecount; i++) {
//						pages[i] = i;
//					}
//				}
//				if (EnumConvertType.MS_HTML_PAGE.getType().equals(param.getType())) {
//					htmlconvertor.setNormal(true); // 为TRUE是标准版分页，默认FALSE 高清版分页
//				}
//				for (Integer page : pages) {
//					htmlconvertor.convertToHtml(param.getOutput() + File.separator + (page + 1) + ".html", page);
//				}
//				re = ResultCode.E_SUCCES.getValue();
//				break;
//			}
//			case PIC_HTML: {
//				re = converter.convertPicToHtml(param.getInput(), param.getOutput());
//				break;
//			}
//			case GET_PAGECONUT_MS:
//			case GET_PAGECONUT_PDF: {
//				if (param.getType() == EnumConvertType.GET_PAGECONUT_MS.getType())
//					image = converter.convertMStoPic(param.getInput());
//				else
//					image = converter.convertPdftoPic(param.getInput());
//				if (image != null && image.resultCode() == 0) {
//					pagecount = image.getPageCount();
//					re = ResultCode.E_SUCCES.getValue();
//				}
//				break;
//			}
//			default:
//				re = ResultCode.E_INVALID_PARAM.getValue();
//			}
//			// 封装结果
//			if (ResultCode.E_SUCCES.getValue().equals(re) || ResultCode.E_CONVERSION_TIMEOUT.getValue().equals(re)) {
//				return DefaultResult.successResult(ResultCode.getEnum(re).getInfo(), pagecount);
//			} else {
//				return DefaultResult.failResult(ResultCode.getEnum(re).getInfo(), re);
//			}
//
//		} catch (Exception e) {
//			LogUtil.error(e);
//			return DefaultResult.failResult();
//		} finally {
////			converter.deleteTempFiles();
//			if (image != null) {
//				try {
//					image.close();
//				} catch (Exception e) {
//				}
//			}
//			if (htmlconvertor != null) {
//				try {
//					htmlconvertor.close();
//				} catch (Exception e) {
//				}
//			}
//		}
//	}
}
