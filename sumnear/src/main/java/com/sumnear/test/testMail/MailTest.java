//package test.testMail;
//import java.util.Date;
//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.Message.RecipientType;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
///**
// * �����ʼ��Ĳ��Գ���
// *
// * @author lwq
// *
// */
//public class MailTest {
//
//    public static void main(String[] args) throws MessagingException {
//    	long a =  System.currentTimeMillis();
//        // ���÷����ʼ��Ļ�������
//        final Properties props = new Properties();
//        /*
//         * ���õ����ԣ� mail.store.protocol / mail.transport.protocol / mail.host /
//         * mail.user / mail.from
//         */
//        // ��ʾSMTP�����ʼ�����Ҫ���������֤
//        props.setProperty("mail.smtp.port", "465");
//        props.setProperty("mail.smtp.socketFactory.port", "465");
//        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.setProperty("mail.smtp.starttls.enable","true");
//        props.setProperty("mail.smtp.auth", "true");
//        props.setProperty("mail.smtp.socketFactory.fallback", "false");
////        props.put("mail.smtp.host", "mail.yozosoft.com");
////        // �����˵��˺�
////        props.put("mail.user", "dcs@yozosoft.com");
////        // ����SMTP����ʱ��Ҫ�ṩ������
////        props.put("mail.password", "yozodcs2016");
//        props.put("mail.smtp.host", "smtp.qq.com");
//        // �����˵��˺�
//        props.put("mail.user", "370968424@qq.com");
//        // ����SMTP����ʱ��Ҫ�ṩ������
////        props.put("mail.password", "zw1989919");
//        props.put("mail.password", "iauhpaicyodgcafd");
////        props.put("mail.smtp.host", "smtp.qq.com");
////        // �����˵��˺�
////        props.put("mail.user", "472191496@qq.com");
////        // ����SMTP����ʱ��Ҫ�ṩ������
////        props.put("mail.password", "85132792xiao");
//
//        // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
//        Authenticator authenticator = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                // �û���������
//                String userName = props.getProperty("mail.user");
//                String password = props.getProperty("mail.password");
//                return new PasswordAuthentication(userName, password);
//            }
//        };
//        // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
//        Session mailSession = Session.getInstance(props, authenticator);
//        // �����ʼ���Ϣ
//        MimeMessage message = new MimeMessage(mailSession);
//        // ���÷�����
//        InternetAddress form = new InternetAddress(
//                props.getProperty("mail.user"));
//        message.setFrom(form);
//
//        // �����ռ���
//        InternetAddress to1 = new InternetAddress("402347012@qq.com");
//        InternetAddress to2 = new InternetAddress("513829633@qq.com");
////        message.setRecipient(RecipientType.TO, to1);
//        message.setRecipients(RecipientType.TO, new InternetAddress[]{to1,to2});
//        // ���ó���
////        InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
////        message.setRecipient(RecipientType.CC, cc);
//
//        // �������ͣ��������ռ��˲��ܿ������͵��ʼ���ַ
////        InternetAddress bcc = new InternetAddress("aaaaa@163.com");
////        message.setRecipient(RecipientType.CC, bcc);
//
//        // �����ʼ�����
//        message.setSubject("�����ʼ�11");
//
//        // �����ʼ���������
//        message.setContent("<a href='http://www.dcsapi.com'>���Ե�HTML�ʼ�</a>", "text/html;charset=UTF-8");
//
//        // �����ʼ�
//        Transport.send(message);
//        System.out.println(new Date());
//        System.out.println((System.currentTimeMillis()-a)/1000);
//    }
//}