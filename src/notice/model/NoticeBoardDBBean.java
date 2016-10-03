package notice.model;

import java.util.Date;

public class NoticeBoardDBBean {
   Integer ntnum;
   Integer eventnum;
   Integer mnum;
   String title;
   String content;
   Date reg_date;
   String noticeimage;
   
   public String getNoticeimage() {
      return noticeimage;
   }
   public void setNoticeimage(String noticeimage) {
      this.noticeimage = noticeimage;
   }
   public Integer getNtnum() {
      return ntnum;
   }
   public void setNtnum(Integer ntnum) {
      this.ntnum = ntnum;
   }
   public Integer getEventnum() {
      return eventnum;
   }
   public void setEventnum(Integer eventnum) {
      this.eventnum = eventnum;
   }

   public Integer getMnum() {
      return mnum;
   }
   public void setMnum(Integer mnum) {
      this.mnum = mnum;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public Date getReg_date() {
      return reg_date;
   }
   public void setReg_date(Date reg_date) {
      this.reg_date = reg_date;
   }
   
   
   
}