<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import ="javax.servlet.http.HttpSession" %>
<%@ page import ="javax.servlet.http.HttpSessionEvent" %>
<html>
  <head>
  </head>
  <body onload="init();" >
    <h1> snapshot of the current student</h1>
   Click on the Start WebCam button.
     <p>
     
    <button onclick="startWebcam();">Start WebCam</button>
    <button onclick="stopWebcam();">Stop WebCam</button> 
       <button onclick="snapshot();">Take Snapshot</button> 
    </p>
    <video onclick="snapshot(this);" width=400 height=400 id="video" controls autoplay></video>
  <p>

        Screenshots : <p>
      <canvas  id="myCanvas" width="400" height="350"></canvas>  
     
     <%

String recordedinsert ="yet_to_takephoto";

HttpSession session1 = request.getSession();
String studIMG= (String) session.getAttribute("studIMG");
if(studIMG!=null)
{
    System.out.println("studentName"+studIMG.toString());
    recordedinsert="studentphotosuccess";
} 

%>
      
      
      </body>
 

 
 
  <script>
      //--------------------
      // GET USER MEDIA CODE
      //--------------------
          navigator.getUserMedia = ( navigator.getUserMedia ||
                             navigator.webkitGetUserMedia ||
                             navigator.mozGetUserMedia ||
                             navigator.msGetUserMedia);
     
      var video;
      var webcamStream;

      function startWebcam() {
        if (navigator.getUserMedia) {
           navigator.getUserMedia (

              // constraints
              {
                 video: true,
                 audio: false
              },

              // successCallback
              function(localMediaStream) {
                  video = document.querySelector('video');
                 video.src = window.URL.createObjectURL(localMediaStream);
                 webcamStream = localMediaStream;
              },

              // errorCallback
              function(err) {
                 console.log("The following error occured: " + err);
              }
           );
        } else {
           console.log("getUserMedia not supported");
        }  
      }

      function stopWebcam() {
          webcamStream.stop();
      }
      //---------------------
      // TAKE A SNAPSHOT CODE
      //---------------------
      var canvas, ctx;

      function init() {
        // Get the canvas and obtain a context for
        // drawing in it
        canvas = document.getElementById("myCanvas");
        ctx = canvas.getContext('2d');

      }

      function snapshot() {
         // Draws current image from the video element into the canvas
       ctx.drawImage(video, 0,0, canvas.width, canvas.height);
       var dataURL = canvas.toDataURL('image/jpeg');
       document.getElementById('field').value= dataURL;
      
      }
  </script>
  
  <form name=imagesave action=Ctakeimage  method=Post > 
 
 
   <input type="text"  name="field" id="field" value=""/>
       
   <input type="submit" name="submit" value="submit">
  
   <label id="other"> <%= recordedinsert %> </label>
  
  <td> <a href="admisiondetailsave.jsp">BACK</a>     
  <td> <a href="studentfees.jsp">NEXT-student-fees</a>     
      
      
  </form>
 
</html>