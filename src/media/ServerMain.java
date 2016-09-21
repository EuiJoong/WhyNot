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
				System.out.println("�������� �����~!");
				Socket client = ss.accept();
				System.out.println(client.getInetAddress()+ " ���ӵ�..");
				InputStream is = client.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				//C:\\Users\\����\\Desktop\\WhyNot_02\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WhyNot\\video\\
				String upDir = "D:\\testvideo\\";
				FileOutputStream fos = null;
				
				
				long data = dis.readLong();
				String fileName = dis.readUTF();
				
				
/*				String[] fileNameE=fileName.split("[.]");//0: ���� ����, 1: ���� Ȯ����
				String ext=fileNameE[fileNameE.length-1];
				System.out.println("Ȯ���� : "+ext);
				String filetitle="";
				
				if(fileNameE.length>2){
					for(int i=0;i<fileNameE.length-1;i++)
						filetitle+=fileNameE[i]+".";
				}
				//���⼭ �����߻� �� ����
				System.out.println("���� �� filetitle : "+filetitle);
				for(int i=0;i<16;i++)
					filetitle+=(int)(Math.random()*9);
				
				filetitle+=".";
				System.out.println("filetitle : "+filetitle);*/
				
				
				
				
				
				
				
				File file = new File(fileName);
				//System.out.println("���������� �޾ƿ� ���� ���� : "+fileName);
				System.out.println("���Ϲ޾ƿ�����..");
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
					System.out.println("�� " + (int)((bytes/(datas*10))) + "% ���ۿϷ�!");
					if(len<0)
						break;
					//System.out.println("len : "+len);
					if(len<2048){
						failtotal++;
						//System.out.println("len :"+len);
					}
					fos.write(buffer,0,len);
				
				}
				System.out.println("��: "+datas+" kbps");
				System.out.println("��ü Ƚ�� : "+total);
				System.out.println("�ս� Ƚ�� : "+failtotal);
				fos.flush();
				fos.close();
				
 
				String[] fileNameE=fileName.split("[.]");//0: ���� ����, 1: ���� Ȯ����
				String ext=fileNameE[fileNameE.length-1];
				System.out.println("Ȯ���� : "+ext);
				String filetitle="";
				
				if(fileNameE.length>2){
					for(int i=0;i<fileNameE.length-1;i++)
						filetitle+=fileNameE[i]+".";
				}
				
				
        		if(ext.equals("mp4"))//mp4�� �� �� ����, mp4�� �ƴϸ� ���ڵ��ؾ��ϴϱ�//fileNameE[1]
        		{
        			return;
        			
        		}//mp4�� �ƴϸ� ���ڵ� ����
        		//� �����̵�, mp4�� ���ڵ�
        		System.out.println("���ڵ� ����");
        		String filedir="D:\\testvideo\\";
        		System.out.println("filedir : "+filedir);
        		System.out.println("filetitle : "+filetitle);
        		File source = new File("D:\\testvideo\\"+filetitle+ext);
        		File target = new File("D:\\testvideo\\"+filetitle+"mp4");//���⼭ �����߻�
        		AudioAttributes audio = new AudioAttributes();
        		VideoAttributes video = new VideoAttributes();
        		audio.setCodec("libmp3lame");
        		audio.setBitRate(new Integer(64000));
        		audio.setChannels(new Integer(1));
        		audio.setSamplingRate(new Integer(22050));
        		System.out.println("����� ���ڵ� �Ϸ�");
        		
        		//video.setCodec("flv");
        		video.setBitRate(new Integer(14745600));
        		//160000
        		video.setFrameRate(new Integer(15));
        		video.setSize(new VideoSize(400, 300));
        		System.out.println("���� ���ڵ� �Ϸ�");
        		EncodingAttributes attrs = new EncodingAttributes();
        		attrs.setFormat("mp4");
        		attrs.setAudioAttributes(audio);
        		attrs.setVideoAttributes(video);
 
        		Encoder encoder = new Encoder();
        		encoder.encode(source, target, attrs);
        		//���ڵ� ��!
        		System.out.println("d���ڵ� ��!");
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