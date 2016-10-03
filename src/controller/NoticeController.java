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
      System.out.println("NoticeController_listNoticeEvent() 실행");
      ModelAndView mav=new ModelAndView();
      
      NoticeBoardDBBean dto = new NoticeBoardDBBean();
      List<NoticeBoardDBBean> list = noticeDAO.listNoticeEvent();
      mav.addObject("listNoticeEvent",list);
      System.out.println("이벤트 공지사항 list size : "+list.size());
      mav.addObject("size",list.size());
      mav.setViewName("notice/noticeListEvent.jsp");
      return mav;
   }//listNoticeNormal.notice

   @RequestMapping(value = "/listNoticeNormal.notice")
   public ModelAndView listNoticeNormal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_listNoticeNormal() 실행");
      ModelAndView mav=new ModelAndView();
      
      NoticeBoardDBBean dto = new NoticeBoardDBBean();
      List<NoticeBoardDBBean> list = noticeDAO.listNoticeNormal();
      mav.addObject("listNoticeNormal",list);
      System.out.println("일반 공지사항 list size : "+list.size());
      mav.addObject("size",list.size());
      mav.setViewName("notice/noticeListNormal.jsp");
      return mav;
   }
   //list.notice
   
   @RequestMapping(value = "/list.notice")
   public ModelAndView listNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_listNotice() 실행");
      ModelAndView mav=new ModelAndView();
      
      NoticeBoardDBBean dto = new NoticeBoardDBBean();
      List<NoticeBoardDBBean> list = noticeDAO.listNoticeAll();
      mav.addObject("listNotice",list);
      System.out.println("전체 공지사항 list size : "+list.size());
      mav.addObject("size",list.size());
      mav.setViewName("admin/notice/listNotice.jsp");
      return mav;
   }
   
   //insert.notice
   @RequestMapping(value = "/insert.notice")
   public ModelAndView insertNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_insertNotice() 실행");
      ModelAndView mav=new ModelAndView();
      
      List list=noticeDAO.listEventNum();
      mav.addObject("eventnumList",list);
      System.out.println("등록할 수 있는 이벤트(투표) select! "+list.size());
      mav.setViewName("admin/notice/insertNotice.jsp");
      
      return mav;
   }
   
   //insertPro.notice
   @RequestMapping(value = "/insertPro.notice")
   public ModelAndView insertProNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_insertProNotice() 실행");

      ModelAndView mav=new ModelAndView();
      //======================================
        NoticeBoardDBBean ndto = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(arg0);

        if (isMultipart) {
           File temporaryDir = new File(arg0.getServletContext().getRealPath("/temp"));// 동영상
                                                        // 임시저장폴더
           DiskFileItemFactory factory = new DiskFileItemFactory();
           System.out.println("factory 생성성공");
           factory.setSizeThreshold(1 * 1024 * 1024);// 메모리 임시저장 제한용량
           factory.setRepository(temporaryDir);
           ServletFileUpload upload = new ServletFileUpload(factory);
           System.out.println("ServletFileUpload 생성성공");
           upload.setSizeMax(3 * 1024 * 1024 * 1024);// 파일최대 제한용량
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
                    // 파일을 제외한 나머지 파라미터 처리
                    String name = fileItem.getFieldName();
                    System.out.println("값일때 : " + name);
                    String value = fileItem.getString("UTF-8");
                    System.out.println("값일때 : " + value);
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
                    //파일 업로드!
                  String name = fileItem.getFieldName();
                  System.out.println("파일일때 : " + name + "/ " + fileItem.getName());
                  
                     System.out.println("사진파일일때 : " + name);
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
      System.out.println("NoticeController_detailNotice() 실행");
      ModelAndView mav=new ModelAndView();
      int ntnum=Integer.parseInt(arg0.getParameter("ntnum"));
      int isEvent=Integer.parseInt(arg0.getParameter("isEvent"));
      int eventnum;
      List nomineeList=null;
      if(isEvent==1){//event. 투표가 있는 공지사항임!
         eventnum=Integer.parseInt(arg0.getParameter("eventnum"));
         nomineeList=noticeDAO.getNominees(eventnum);
      }
      System.out.println("ntnum : "+ntnum);
      NoticeBoardDBBean ndto=noticeDAO.detailNotice(ntnum);//여기서 못받아오네.../
      
      mav.addObject("ndto",ndto);//공지 상세내역
      mav.addObject("nlist",nomineeList);//공지에 딸린 투표 참여자들 목록
      //System.out.println("공지 상세보기 가져옴! "+nomineeList.size());
      mav.setViewName("notice/detailNotice.jsp");
      
      return mav;
   }
   
   //Vote.notice
      @RequestMapping(value = "/Vote.notice")
      public ModelAndView doVoteUpdate(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
         System.out.println("NoticeController_doVote() 실행");
         ModelAndView mav=new ModelAndView();
         int eventnum=Integer.parseInt(arg0.getParameter("eventnum"));
         int mnum=Integer.parseInt(arg0.getParameter("mnum"));
         int nominee=Integer.parseInt(arg0.getParameter("nominee"));
         String name=arg0.getParameter("name");
         System.out.println("로그 name : "+name);
         System.out.println("eventnum : "+eventnum);
         
         //currpoll에도 등록!
         CurrPollDBBean cdto=new CurrPollDBBean();
         cdto.setEventnum(eventnum);
         cdto.setNominum(nominee);
         cdto.setMembermail(name);//id. mail
         
         ////
         
         boolean isvote=noticeDAO.isVote(cdto);
         System.out.println("투표했나? "+isvote);
         if(!isvote){//투표안했어!
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
      System.out.println("NoticeController_detailNoticeForAdmin() 실행");
      ModelAndView mav=new ModelAndView();
      int ntnum=Integer.parseInt(arg0.getParameter("ntnum"));
      int isEvent=Integer.parseInt(arg0.getParameter("isEvent"));
      int eventnum;
      List nomineeList=null;
      if(isEvent==1){//event. 투표가 있는 공지사항임!
         eventnum=Integer.parseInt(arg0.getParameter("eventnum"));
         nomineeList=noticeDAO.getNominees(eventnum);
      }
      System.out.println("ntnum : "+ntnum);
      NoticeBoardDBBean ndto=noticeDAO.detailNotice(ntnum);//여기서 못받아오네.../
      
      mav.addObject("ndto",ndto);//공지 상세내역
      mav.addObject("nlist",nomineeList);//공지에 딸린 투표 참여자들 목록
      //System.out.println("공지 상세보기 가져옴! "+nomineeList.size());
      mav.setViewName("admin/notice/detailNoticeForAdmin.jsp");
      
      return mav;
   }
   
   //delete.notice
   
   @RequestMapping(value = "/delete.notice")
   public ModelAndView deleteNotice(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
      System.out.println("NoticeController_deleteNotice() 실행");
      ModelAndView mav=new ModelAndView();
      int ntnum=Integer.parseInt(arg0.getParameter("ntnum"));
   
      noticeDAO.deleteNotice(ntnum);//여기서 못받아오네.../

      mav.setViewName("list.notice");
      
      return mav;
   }
}