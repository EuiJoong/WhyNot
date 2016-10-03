package controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import category.model.CategoryDBBean;
import event.poll.model.CurrPollDBBean;
import notice.model.*;
import onlinecontent.model.OnlineContentDBBean;

@Controller
public class NoticeController {

   private NoticeBoardDAO noticeDAO;

   public void setNoticeDAO(NoticeBoardDAO noticeDAO) {
      this.noticeDAO = noticeDAO;
   }

   @RequestMapping(value = "/listNoticeEvent.notice")
   public ModelAndView listNoticeEvent(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_listNoticeEvent() ����");
      ModelAndView mav=new ModelAndView();
      
      NoticeBoardDBBean dto = new NoticeBoardDBBean();
      List<NoticeBoardDBBean> list = noticeDAO.listNoticeEvent();
      mav.addObject("listNoticeEvent",list);
      System.out.println("�̺�Ʈ �������� list size : "+list.size());
      mav.addObject("size",list.size());
      mav.setViewName("notice/noticeListEvent.jsp");
      return mav;
   }//listNoticeNormal.notice

   @RequestMapping(value = "/listNoticeNormal.notice")
   public ModelAndView listNoticeNormal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_listNoticeNormal() ����");
      ModelAndView mav=new ModelAndView();
      
      NoticeBoardDBBean dto = new NoticeBoardDBBean();
      List<NoticeBoardDBBean> list = noticeDAO.listNoticeNormal();
      mav.addObject("listNoticeNormal",list);
      System.out.println("�Ϲ� �������� list size : "+list.size());
      mav.addObject("size",list.size());
      mav.setViewName("notice/noticeListNormal.jsp");
      return mav;
   }
   //list.notice
   
   @RequestMapping(value = "/list.notice")
   public ModelAndView listNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_listNotice() ����");
      ModelAndView mav=new ModelAndView();
      
      NoticeBoardDBBean dto = new NoticeBoardDBBean();
      List<NoticeBoardDBBean> list = noticeDAO.listNoticeAll();
      mav.addObject("listNotice",list);
      System.out.println("��ü �������� list size : "+list.size());
      mav.addObject("size",list.size());
      mav.setViewName("admin/notice/listNotice.jsp");
      return mav;
   }
   
   //insert.notice
   @RequestMapping(value = "/insert.notice")
   public ModelAndView insertNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_insertNotice() ����");
      ModelAndView mav=new ModelAndView();
      
      List list=noticeDAO.listEventNum();
      mav.addObject("eventnumList",list);
      System.out.println("����� �� �ִ� �̺�Ʈ(��ǥ) select! "+list.size());
      mav.setViewName("admin/notice/insertNotice.jsp");
      
      return mav;
   }
   
   //insertPro.notice
   @RequestMapping(value = "/insertPro.notice")
   public ModelAndView insertProNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_insertProNotice() ����");

      ModelAndView mav=new ModelAndView();
      //======================================
        NoticeBoardDBBean ndto = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

        if (isMultipart) {
           File temporaryDir = new File(arg0.getServletContext().getRealPath("/temp"));// ������
                                                        // �ӽ���������
           DiskFileItemFactory factory = new DiskFileItemFactory();
           System.out.println("factory ��������");
           factory.setSizeThreshold(1 * 1024 * 1024);// �޸� �ӽ����� ���ѿ뷮
           factory.setRepository(temporaryDir);
           ServletFileUpload upload = new ServletFileUpload(factory);
           System.out.println("ServletFileUpload ��������");
           upload.setSizeMax(3 * 1024 * 1024 * 1024);// �����ִ� ���ѿ뷮
           List items = null;
           try {
              items = upload.parseRequest(arg0);
           } catch (FileUploadException fe) {
              System.out.println(fe);
              fe.printStackTrace();
           }
           if (items != null) {
              Iterator iter = items.iterator();
              ndto = new NoticeBoardDBBean();
              while (iter.hasNext()) {
                 FileItem fileItem = (FileItem) iter.next();
                 if (fileItem.isFormField()) {
                    // ������ ������ ������ �Ķ���� ó��
                    String name = fileItem.getFieldName();
                    System.out.println("���϶� : " + name);
                    String value = fileItem.getString("UTF-8");
                    System.out.println("���϶� : " + value);
                    if(value==null || value.equals(""))
                       value="0";

                    switch (name) {
                    case "mnum":
                       ndto.setMnum(Integer.parseInt(value));
                       break;
                    case "title":
                       ndto.setTitle(value);
                       break;
                    case "content":
                       ndto.setContent(value);
                       System.out.println(value);
                       break;
                    case "eventnum":
                        ndto.setEventnum(Integer.parseInt(value));
                        break;
                    }

                 }else{
                    //���� ���ε�!
                  String name = fileItem.getFieldName();
                  System.out.println("�����϶� : " + name + "/ " + fileItem.getName());
                  
                     System.out.println("���������϶� : " + name);
                     String[] nameArr = fileItem.getName().split("[.]");
                     String upPath = arg0.getServletContext().getRealPath("/images");
                     System.out.println(upPath);
                     ndto.setNoticeimage(fileItem.getName());
                     File imageFile = new File(upPath + "\\" + fileItem.getName());
                     fileItem.write(imageFile);
                    
                    }
                   
                }

               }
              }
           
        noticeDAO.insertNotice(ndto);
        //=====================================================
      mav.setViewName("list.notice");
      return mav;
   }
   
   //detail.notice
   @RequestMapping(value = "/detail.notice")
   public ModelAndView detailNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_detailNotice() ����");
      ModelAndView mav=new ModelAndView();
      int ntnum=Integer.parseInt(arg0.getParameter("ntnum"));
      int isEvent=Integer.parseInt(arg0.getParameter("isEvent"));
      int eventnum;
      List nomineeList=null;
      if(isEvent==1){//event. ��ǥ�� �ִ� ����������!
         eventnum=Integer.parseInt(arg0.getParameter("eventnum"));
         nomineeList=noticeDAO.getNominees(eventnum);
      }
      System.out.println("ntnum : "+ntnum);
      NoticeBoardDBBean ndto=noticeDAO.detailNotice(ntnum);//���⼭ ���޾ƿ���.../
      
      mav.addObject("ndto",ndto);//���� �󼼳���
      mav.addObject("nlist",nomineeList);//������ ���� ��ǥ �����ڵ� ���
      //System.out.println("���� �󼼺��� ������! "+nomineeList.size());
      mav.setViewName("notice/detailNotice.jsp");
      
      return mav;
   }
   
   //Vote.notice
      @RequestMapping(value = "/Vote.notice")
      public ModelAndView doVoteUpdate(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
         System.out.println("NoticeController_doVote() ����");
         ModelAndView mav=new ModelAndView();
         int eventnum=Integer.parseInt(arg0.getParameter("eventnum"));
         int mnum=Integer.parseInt(arg0.getParameter("mnum"));
         int nominee=Integer.parseInt(arg0.getParameter("nominee"));
         String name=arg0.getParameter("name");
         System.out.println("�α� name : "+name);
         System.out.println("eventnum : "+eventnum);
         
         //currpoll���� ���!
         CurrPollDBBean cdto=new CurrPollDBBean();
         cdto.setEventnum(eventnum);
         cdto.setNominum(nominee);
         cdto.setMembermail(name);//id. mail
         
         ////
         
         boolean isvote=noticeDAO.isVote(cdto);
         System.out.println("��ǥ�߳�? "+isvote);
         if(!isvote){//��ǥ���߾�!
            noticeDAO.insertCurrPoll(cdto);
            noticeDAO.doVoteUpdate(eventnum,nominee);
         }
         
         mav.addObject("isvote",isvote);
         mav.setViewName("listNoticeEvent.notice");
         
         return mav;
      }
   
   //detailForAdmin.notice
   @RequestMapping(value = "/detailForAdmin.notice")
   public ModelAndView detailNoticeForAdmin(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_detailNoticeForAdmin() ����");
      ModelAndView mav=new ModelAndView();
      int ntnum=Integer.parseInt(arg0.getParameter("ntnum"));
      int isEvent=Integer.parseInt(arg0.getParameter("isEvent"));
      int eventnum;
      List nomineeList=null;
      if(isEvent==1){//event. ��ǥ�� �ִ� ����������!
         eventnum=Integer.parseInt(arg0.getParameter("eventnum"));
         nomineeList=noticeDAO.getNominees(eventnum);
      }
      System.out.println("ntnum : "+ntnum);
      NoticeBoardDBBean ndto=noticeDAO.detailNotice(ntnum);//���⼭ ���޾ƿ���.../
      
      mav.addObject("ndto",ndto);//���� �󼼳���
      mav.addObject("nlist",nomineeList);//������ ���� ��ǥ �����ڵ� ���
      //System.out.println("���� �󼼺��� ������! "+nomineeList.size());
      mav.setViewName("admin/notice/detailNoticeForAdmin.jsp");
      
      return mav;
   }
   
   //delete.notice
   
   @RequestMapping(value = "/delete.notice")
   public ModelAndView deleteNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_deleteNotice() ����");
      ModelAndView mav=new ModelAndView();
      int ntnum=Integer.parseInt(arg0.getParameter("ntnum"));
   
      noticeDAO.deleteNotice(ntnum);//���⼭ ���޾ƿ���.../

      mav.setViewName("list.notice");
      
      return mav;
   }
}