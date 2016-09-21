package media;
 
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
import org.springframework.web.servlet.ModelAndView;
 
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;
 
public class ServerMain implements Runnable{
	
	public void run() {
			try {
				ServerSocket ss = new ServerSocket(12345);
				System.out.println("서버열고 대기중~!");
				Socket client = ss.accept();
				System.out.println(client.getInetAddress()+ " 접속됨..");
				InputStream is = client.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				//C:\\Users\\고경숙\\Desktop\\WhyNot_02\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WhyNot\\video\\
				String upDir = "D:\\testvideo\\";
				FileOutputStream fos = null;
				
				
				long data = dis.readLong();
				String fileName = dis.readUTF();
				
				
/*				String[] fileNameE=fileName.split("[.]");//0: 파일 네임, 1: 파일 확장자
				String ext=fileNameE[fileNameE.length-1];
				System.out.println("확장자 : "+ext);
				String filetitle="";
				
				if(fileNameE.length>2){
					for(int i=0;i<fileNameE.length-1;i++)
						filetitle+=fileNameE[i]+".";
				}
				//여기서 난수발생 및 저장
				System.out.println("난수 전 filetitle : "+filetitle);
				for(int i=0;i<16;i++)
					filetitle+=(int)(Math.random()*9);
				
				filetitle+=".";
				System.out.println("filetitle : "+filetitle);*/
				
				
				
				
				
				
				
				File file = new File(fileName);
				//System.out.println("서버측에서 받아온 파일 네임 : "+fileName);
				System.out.println("파일받아오는중..");
				fos = new FileOutputStream(upDir+fileName);
				
				long datas = data;
				byte[] buffer = new byte[2048];
				int len;
				int total=0;
				int failtotal=0;
				int bytes = 0;
				for(;data>=0;data--){
					//fos.flush();
					total++;
					len = is.read(buffer);
					bytes += len;
					System.out.println("약 " + (int)((bytes/(datas*10))) + "% 전송완료!");
					if(len<0)
						break;
					//System.out.println("len : "+len);
					if(len<2048){
						failtotal++;
						//System.out.println("len :"+len);
					}
					fos.write(buffer,0,len);
				
				}
				System.out.println("약: "+datas+" kbps");
				System.out.println("전체 횟수 : "+total);
				System.out.println("손실 횟수 : "+failtotal);
				fos.flush();
				fos.close();
				
 
				String[] fileNameE=fileName.split("[.]");//0: 파일 네임, 1: 파일 확장자
				String ext=fileNameE[fileNameE.length-1];
				System.out.println("확장자 : "+ext);
				String filetitle="";
				
				if(fileNameE.length>2){
					for(int i=0;i<fileNameE.length-1;i++)
						filetitle+=fileNameE[i]+".";
				}
				
				
        		if(ext.equals("mp4"))//mp4면 할 거 없고, mp4가 아니면 인코딩해야하니까//fileNameE[1]
        		{
        			return;
        			
        		}//mp4가 아니면 인코딩 시작
        		//어떤 파일이든, mp4로 인코딩
        		System.out.println("인코딩 시작");
        		String filedir="D:\\testvideo\\";
        		System.out.println("filedir : "+filedir);
        		System.out.println("filetitle : "+filetitle);
        		File source = new File("D:\\testvideo\\"+filetitle+ext);
        		File target = new File("D:\\testvideo\\"+filetitle+"mp4");//여기서 난수발생
        		AudioAttributes audio = new AudioAttributes();
        		VideoAttributes video = new VideoAttributes();
        		audio.setCodec("libmp3lame");
        		audio.setBitRate(new Integer(64000));
        		audio.setChannels(new Integer(1));
        		audio.setSamplingRate(new Integer(22050));
        		System.out.println("오디오 인코딩 완료");
        		
        		//video.setCodec("flv");
        		video.setBitRate(new Integer(14745600));
        		//160000
        		video.setFrameRate(new Integer(15));
        		video.setSize(new VideoSize(400, 300));
        		System.out.println("비디오 인코딩 완료");
        		EncodingAttributes attrs = new EncodingAttributes();
        		attrs.setFormat("mp4");
        		attrs.setAudioAttributes(audio);
        		attrs.setVideoAttributes(video);
 
        		Encoder encoder = new Encoder();
        		encoder.encode(source, target, attrs);
        		//인코딩 끝!
        		System.out.println("d인코딩 끝!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerMain sm = new ServerMain();
		Thread t1 = new Thread(sm);
		t1.start();
	}
 
}