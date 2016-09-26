package controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import category.model.CategoryDAO;
import category.model.CategoryDBBean;
import category.mybatis.CategoryMybatis;
import offlinecontent.model.OfflineContentDAO;
import onlinecontent.model.OnlineContentDAO;
import onlinecontent.model.OnlineContentDBBean;
import onlinecontent.mybatis.OnlineContentMybatis;
import onlinecurriculum.model.OnlineCurriculumDAO;
import onlinecurriculum.qna.model.OnlineCurriculumQNADAO;
import payment.model.OnlinePaymentDBBean;
import payment.model.PaymentDAO;
import payment.mybatis.PaymentMybatis;
import attachfile.*;

@Controller
public class OffContentController {

   private OfflineContentDAO offlineContentDAO;
   private CategoryDAO categoryDAO;
   private PaymentDAO paymentDAO;

   public void setCategoryDAO(CategoryDAO categoryDAO) {
      this.categoryDAO = categoryDAO;
   }

   public void setOfflineContentDAO(OfflineContentDAO offlineContentDAO) {
      this.offlineContentDAO = offlineContentDAO;
   }

   public void setPaymentDAO(PaymentDAO paymentDAO) {
      this.paymentDAO = paymentDAO;
   }
   

   // -------------- ������ -----------------------------------
      public VideoDBBean insertVideo(FileItem fileItem, HttpServletRequest arg0) throws Exception {
    	  return null;
         }
   
    //----------------------------- �������� ������ (�Ŀ�) --------------------------------    
      
   @RequestMapping(value = "/list.offcont")
   public ModelAndView listContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("OffContentController_listContent() ����");
      return new ModelAndView("");

   }

   @RequestMapping(value = "/cont_insert.offcont") // �Ŀ����Form
   public ModelAndView insertFormContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("OffContentController_insertFormContent() ����");
      return new ModelAndView("");

   }

   @RequestMapping(value = "/cont_insertPro.offcont") // �Ŀ����Pro
    public ModelAndView insertProContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	   System.out.println("OffContentController_insertProContent() ����");
	   return new ModelAndView("");
   }

   @RequestMapping(value = "/cont_detail.offcont") // �Ŀ� �󼼺���
   public ModelAndView detailContent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("OffContentController_detailContent() ����");
      return new ModelAndView("");
   }
}