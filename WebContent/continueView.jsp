<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- <script type='text/javascript'>
<!-- var seekTime = 0; // 이어보기 할 시간을 저장
function initPlayer() {
	flowplayer("player", "/player/flowplayer-3.2.13.swf", {
		log: { level: 'debug', filter: 'org.flowplayer.captions.*' },
		clip: {
			/* url: 'RTMP동영상URL',  */
			url: '/movie/sample2.mp4', 
			provider: 'rtmp',
			autoPlay: false, // 자동 시작 아님
			onStart: function() {
				if (seekTime > 0) {  // 이어보기 시간이 0보다 크면
					$f("player").seek(seekTime); // seek 이용 시간 이동
				}
			}
		},
		plugins:  {
			rtmp: {
				url: "/player/flowplayer.rtmp-3.2.10.swf",
				netConnectionUrl: 'rtmp://wowza.racon.scgs.co.kr:1935/vod'
			},
			controls: {
				url: "flowplayer.controls-3.2.12.swf"
			}
		}
	});
	setTimeout(function() {
		seek();
	},1000);
}
function seek() {
	if (!aleadyViewed) { // aleadyViewed는 처음 보는 영상인지의 여부를 보관
		$f("player").play(); // 첨보는 영상이면 바로 플레이
		return;
	}


	if(confirm("이어보시겠습니까?")) { // 이미 시청했다면
		seekTime = ${elapsedTime}; // 시청한 시간을 seekTime으로 지정
	}
	$f("player").play();
}
</script> -->
 -->

<%-- <div class="flowplayer" data-swf="flowplayer.swf" data-ratio="0.4167">
	<video>

		<source type="video/mp4" src="/movie/sample2.mp4">
		var time = $f("player").getTime(); // 초단위로 값 구함
		${time }
	</video>
</div>
 --%>









<!--  -->
<!DOCTYPE html>
<html>
<!-- 1. skin -->
<link rel="stylesheet"
   href="//releases.flowplayer.org/5.4.6/skin/functional.css">
<!-- 2. jquery library -->
<script src="jquery.min.js"></script>
<!-- 3. flowplayer -->
<script src="flowplayer.min.js"></script>
<script>
   /* flowplayer.conf.adaptiveRatio = false; 
   flowplayer.conf.flashfit = false;
   flowplayer.conf.disabled = false;
   flowplayer.conf.keyboard =true;
   flowplayer.conf.fullscreen = false;
   flowplayer.conf.live = false;
   flowplayer.conf.embed = false;
   flowplayer.conf.speeds = 0.25, 0.5, 1, 1.5, 2;   // -> FMS나 와우자 서버를 사용하지 않는한 안되는듯 함
   flowplayer.conf.splash = false;
   flowplayer.conf.tooltip = false;
   flowplayer.conf.volume = 1; */
/*    var api=flowplayer(); */
/*    flowplayer(function(api,root){
	      api.on("play", function(e) {
	          var time = $f("player").getTime();
	          console.log(e);
	      });
   }); */
   /* flowplayer(function(api, root) {
      api.bind("load", function() {
         console.info("load", api.engine);
      }).bind("ready", function() {
         console.info("ready", api.video.duration);
      });
      api.bind("play", function() {
      });
      api.bind("resume", function() {
      });
      api.bind("stop", function() {
      });
      api.bind("pause", function() {
      });
      api.bind("seek", function() {
      });
   }); */
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body style="margin: 0px">
<script>
	var player=flowplayer("player","../player/flowplayer-3.2.13.swf",{
		
		clip:{
			url:'mp4:'+sample2,
			provider: 'rtmp'
		},plugins:{
			rtmp:{
				url:'../player/flowplayer-3.2.13.swf',
				
				
			}
			
		}
		
	});
	
	player.onStart(function(){
		 var time = $f("player").getTime();
		 out.println(time);
		 System.out.println(time);
		console.log(time);
	})
</script>
   <div id="h-div" class="flowplayer play-button no-hover">
      <video>
         <source type="video/mp4" src="movie/sample2.mp4">

      </video>
   </div>
</html>