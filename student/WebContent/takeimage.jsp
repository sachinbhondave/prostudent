<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  
     String Course=null;
     String studentname=null;

     String Coursepaidfee=null;

     String Hobby=null;

 
     Course =(String)request.getAttribute("Course");
     studentname =(String)	 request.getAttribute("studentname");
     Coursepaidfee =(String)	 request.getAttribute("Coursepaidfee");
     Hobby =(String)	 request.getAttribute("Hobby");

     
     
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
     
     <h4>Admiting student- <%=studentname  %> </h4>
    
      <input type="hidden" name="Course" id="Course" value= <%= Course %>>
      <input type="hidden" name="studentname"  id="studentname" value=<%= studentname %>>
      <input type="hidden"  name="Coursepaidfee"  id="Coursepaidfee" value=<%= Coursepaidfee %>>
      <input type="hidden"  name="Hobby" id="Hobby" value=<%= Hobby %>>
      <input type="hidden"  name="field" id="field" value=""/>
       
      
      <input type="submit" name="submit" value="submit">
  </form>
 
</html>