package com.sumnear;

import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

import java.io.File;
import java.util.List;

/**
 * @authore sumnear
 * @create 2019-7-26 8:32
 */
public class TestDocx4j
{
    public static void main(String[] args)
    {
        String filePath = "C:\\Users\\Near\\Desktop\\helloworld.docx";
        createDocx(filePath);
    }
    /**
     * 创建一个简单的docx
     */
    private static void createDocx(String targetPath) {
        // Create the package
        WordprocessingMLPackage wordMLPackage;
        try {
            wordMLPackage = WordprocessingMLPackage.createPackage();
            // 另存为新的文件
            wordMLPackage.save(new File(targetPath));
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (Docx4JException e) {
            e.printStackTrace();
        }
    }
    /**
     * 增加一个段落，增加完成记得保存，否则不生效
     */
    private static void addParagraph() {
        WordprocessingMLPackage wordprocessingMLPackage;
        try {
            wordprocessingMLPackage = WordprocessingMLPackage
                    .load(new File("C:/Users/liqiang/Desktop/docx4j/helloworld.docx"));
            wordprocessingMLPackage.getMainDocumentPart().addParagraphOfText("Hello Word!");
            wordprocessingMLPackage.getMainDocumentPart().addStyledParagraphOfText("Title", "Hello Word!");
            wordprocessingMLPackage.getMainDocumentPart().addStyledParagraphOfText("Subtitle", " a subtitle!");
            wordprocessingMLPackage.save(new File("C:/Users/liqiang/Desktop/docx4j/helloworld.docx"));
        } catch (Docx4JException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加一个段落，增加完成记得保存，否则不生效
     */
    private static void addParagraph2(String simpleText) {

        try {
            WordprocessingMLPackage wordprocessingMLPackage = WordprocessingMLPackage
                    .load(new File("C:/Users/liqiang/Desktop/docx4j/helloworld.docx"));
            org.docx4j.wml.ObjectFactory factory = Context.getWmlObjectFactory();
            org.docx4j.wml.P para = factory.createP();
            if (simpleText != null) {
                org.docx4j.wml.Text t = factory.createText();
                t.setValue(simpleText);
                org.docx4j.wml.R run = factory.createR();
                run.getContent().add(t);
                para.getContent().add(run);
            }
            wordprocessingMLPackage.getMainDocumentPart().getContent().add(para);
            wordprocessingMLPackage.save(new File("C:/Users/liqiang/Desktop/docx4j/helloworld.docx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void readParagraph() {
        try {
            WordprocessingMLPackage wordprocessingMLPackage = WordprocessingMLPackage
                    .load(new File("C:/Users/liqiang/Desktop/docx4j/helloworld.docx"));

            String contentType = wordprocessingMLPackage.getContentType();
            System.out.println(("contentType -> {}" + contentType));

            MainDocumentPart mainDocumentPart = wordprocessingMLPackage.getMainDocumentPart();
            List<Object> content = mainDocumentPart.getContent();
            for (Object ob : content) {
                System.out.println(("ob -> {}"+ob));
            }
        } catch (Docx4JException e) {
            e.printStackTrace();
        }
    }
}
