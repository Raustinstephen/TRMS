 var formHTML = 
 '<div class="card " style="width:70%;margin:0 auto;float:none;top:40px">'
+ '<form id="myForm">'
+     '<div class="card-header" style="text-align:center;font-size:1.6em">New Reimburstment Request</div>'
+     '<div class="card-body">'
+         '<div class="form-group row">'
+             '<label for="f1" class="col-md-5 col-form-label text-md-right">Event Name</label>'
+             '<div class="col-md-3">'
+                 '<input type="text" id="f1" class="form-control" name="eventName">'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f2" class="col-md-5 col-form-label text-md-right">Event Type</label>'
+             '<div class="col-md-3">'
+                 '<select name="eventType" class="form-control" id="f2">'
+                     '<option value="1">University Course</option>'
+                     '<option value="2">Seminar</option>'
+                     '<option value="3">Certification Prepartion</option>'
+                     '<option value="4">Certification</option>'
+                     '<option value="5">Technical Training</option>'
+                     '<option value="6">Other</option>'
+                 '</select>'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f3" class="col-md-5 col-form-label text-md-right">Grade Format</label>'
+             '<div class="col-md-3">'
+                 '<select name="gradeFormat" class="form-control" id="f3">'
+                     '<option value="1">A - F</option>'
+                     '<option value="2">Pass/Fail</option>'
+                     '<option value="3">Percentage</option>'
+                     '<option value="4">Score</option>'
+                     '<option value="5">Does Not Apply</option>'
+                 '</select>'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f9" class="col-md-5 col-form-label text-md-right">Date & Time</label>'
+             '<div class="col-md-3">'
+                 '<input type="text" id="f9" class="form-control" name="date" placeholder="DD/MM/YYYY HH:MM">'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f4" class="col-md-5 col-form-label text-md-right">Event Address</label>'
+             '<div class="col-md-3">'
+                 '<input type="text" id="f4" class="form-control" name="address">'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f5" class="col-md-5 col-form-label text-md-right">Event City</label>'
+              '<div class="col-md-3">'
+                 '<input type="text" id="f5" class="form-control" name="city">'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f6" class="col-md-5 col-form-label text-md-right">Event State</label>'
+             '<div class="col-md-3">'
+                 '<input type="text" id="f6" class="form-control" name="state">'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f7" class="col-md-5 col-form-label text-md-right">Event Cost</label>'
+             '<div class="col-md-3">'
+                 '<input type="text" id="f7" class="form-control" name="eventCost">'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f8" class="col-md-5 col-form-label text-md-right">Approximate hours of work missed</label>'
+             '<div class="col-md-3">'
+                 '<input type="text" id="f8" class="form-control" name="hoursMissed">'
+             '</div>'
+         '</div>'
+         '<div class="form-group row">'
+             '<label for="f10" class="col-md-5 col-form-label text-md-right">Justification of reimburstment</label>'
+             '<div class="col-md-3">'
+                 '<input type="text" id="f10" class="form-control" name="eventJust">'
+             '</div>'
+         '</div>'    
+     '</div>'
+     '<div class="card-footer">'
+         '<button type="submit" id="formButton" class="btn btn-info" style="float:right;width:200px;margin-bottom:30px" id="btnLogin">Submit</button>'
+     '</div>'
+ '</form>'
+'</div>';
 
 var mainMenu = 
 +'<div id="selectPage" class="card" style="width:30%;height:350px;margin:auto;position:absolute;top:0;bottom:0px;left:0;right:0;box-shadow:5px 5px 5px #929191" >'
 +'<div class="card-body">'
 +    '<h5 class="card-title" style="text-align:center;font-size:2em">Welcome</h5>'
 +    '<div class="form-group" style="text-align:center;font-size:2em;top:50px">'
 +        '<button type="button" class="btn btn-info" id="viewReq">View previous Reimburstment requests</button>'
 +    '</div>'
 +    '<div class="form-group" style="text-align:center;font-size:2em">'
 +         '<button type="button" class="btn btn-info" id="newReimburst">Submit new reimburstment request</button>'
 +    '</div>'
 +    '<div class="form-group" style="text-align:center;font-size:2em">'
 +         '<button type="button" class="btn btn-info" id="addGrade">Enter Grade For Request</button>'
 +    '</div>'
 +    '<div class="form-group" style="text-align:center;font-size:2em">'
 +         '<button type="button" class="btn btn-info" id="approve">Approve or deny Applicants</button>'
 +    '</div>'
 +'</div>'
 +'</div>'	 
;
function getViewCard(rid,status,eventName,eventType,dateSubmitted,cost,reimb,grade,feedback){
	res =  '<div class="card" id="10083" style="width:80%;margin:0 auto;top:60px;margin-bottom:60px;box-shadow:5px 5px 5px #929191" >'
+    '<div class="card-header">Reimburstment Request ID: '+rid+'<span style="float:right">Status: '+status+'</span></div>'
+    '<div class="card-body">'
+        '<div class="card-rows">'
+            '<div class="card-columns">'
+                '<div>Event Name: '+eventName+'</div>'
+                '<div>Event Type: '+eventType+'</div>'
+                '<div>Date Submitted: '+dateSubmitted+'</div>'
+            '</div>'
+            '<div class="card-columns" style="margin-top:10px">'
+                '<div>Cost: $'+cost+'</div>'
+                '<div>Reimburstment: $'+reimb+'</div>'
+                '<div>Grade: '+grade+'</div>'
+            '</div>'
+            '<div style="margin-top:10px">Feedback: '+feedback+'</div>'
+        '</div>'
+    '</div>'
+'</div>';
	return res;
}

function getGradeCard(rid,status,eventName,eventType,dateSubmitted,cost,reimb,grade,feedback){
	res =  
 '<div class="card" style="width:80%;margin:0 auto;top:60px;margin-bottom:60px;box-shadow:5px 5px 5px #929191" >'
+    '<div class="card-header">Reimburstment Request ID: '+rid+'<span style="float:right">Status: '+status+'</span></div>'
+    '<div class="card-body">'
+        '<div class="card-rows">'
+            '<div class="card-columns">'
+                '<div>Event Name: '+eventName+'</div>'
+                '<div>Event Type: '+eventType+'</div>'
+                '<div>Date Submitted: '+dateSubmitted+'</div>'
+            '</div>'
+            '<div class="card-columns" style="margin-top:10px">'
+                '<div>Cost: $'+cost+'</div>'
+                '<div>Reimburstment: $'+reimb+'</div>'
+                '<div>Grade: '+grade+'</div>'
+            '</div>'
+            '<div style="margin-top:10px">Feedback: '+feedback+'</div>'
+        '</div>'
+    '</div>'
+	 '<div class="card-footer">'
+		'<form id="gradeForm" style="float:right" value="'+rid+'">'
+    		'<input type="text" placeholder="Enter grade here" name="grade">'
+    		'<button type="submit" class="btn btn-success">Submit Grade</button>'
+		'</form>'
+	'</div>'
+'</div>';
	return res;
}

function getCard(reimbId,empId,empName,empTitle,eventName,eventType,eventCost,eventDate,eventTime,eventLocation,eventDesc){	
res= '<div class="card" id="'+reimbId+'" style="width:80%;margin:0 auto;top:40px;box-shadow:5px 5px 5px #929191" >'
+    '<div class="card-header">Reimburstment Request ID: '+reimbId+'</div>'
+    '<div class="card-body">'
+        '<div class="card-rows">'
+            '<div class="card-columns">'
+                '<div>Employee ID: '+empId+'</div>'
+                '<div>Employee Name: '+empName+'</div>'
+                '<div>Title: '+empTitle+'</div>'
+            '</div>'
+           '<div class="card-columns" style="margin-top:10px">'
+                    '<div>Event Name: '+eventName+'</div>'
+                    '<div>Event Type: '+eventType+'</div>'
+                    '<div>Cost: $'+eventCost+'</div>'
+                '</div>'
+            '<div class="card-columns" style="margin-top:10px">'
+                '<div>Event Date: '+eventDate+'</div>'
+                '<div>Time: '+eventTime+'</div>'
+                '<div>Location: '+eventLocation+'</div>'
+            '</div>'
+            '<div style="margin-top:10px">Description: '+eventDesc+'</div>'
+        '</div>'
+    '</div>'
+    '<div class="card-footer" style="margin-top:15px">'
+        '<div style="float:right">'
+            '<button class="btn btn-success" style="width:100px">Approve</button>'
+            '<button class="btn btn-danger" style="width:100px;margin-left: 20px">Reject</button>'   
+        '</div>'
+    '</div>'
+'</div>';
console.log(res);
return res;
}
var table = 
	'<table class="table">'
+		'<thead>'
+			'<tr>'
+				'<th scope="col">Reimburstment ID</th>'
+				'<th scope="col">Event Name</th>'
+				'<th scope="col">Event Type</th>'
+				'<th scope="col">Cost</th>'
+				'<th scope="col">Grade Format</th>'
+				'<th scope="col">Status</th>'
+				'<th scope="col">Date Submitted</th>'
+				'<th scope="col">Grade</th>'
+			'</tr>'
+		'</thead>'
+		'<tbody>'
+		'</tbody>'
+	'</table>';


var table2 = 
	'<table class="table">'
+		'<thead>'
+			'<tr>'
+				'<th scope="col">Reimburstment ID</th>'
+				'<th scope="col">Employee Name</th>'
+				'<th scope="col">Event Name</th>'
+				'<th scope="col">Event Type</th>'
+				'<th scope="col">Event Description</th>'
+				'<th scope="col">Cost</th>'
+				'<th scope="col">Grade Format</th>'
+				'<th scope="col">Date Submitted</th>'
+				'<th scope="col">Grade</th>'
+			'</tr>'
+		'</thead>'
+		'<tbody>'
+		'</tbody>'
+	'</table>';



var inputGrade = 
	'<div id="selectPage" class="card" style="width:20%;height:200px;margin:auto;position:absolute;top:0;bottom:0px;left:0;right:0;box-shadow:5px 5px 5px #929191" >'
	+    '<div class="card-body">'
	+		'<form id="gradeForm">'
	+		'<div class="form-group" style="text-align:center;font-size:1em">'
	+                '<label for="rn">Reimburstment ID</label>'
	+                '<input type="text" name="reimbID" id="rn">'
	+        '</div>' 
	+		'<div class="form-group" style="text-align:center;font-size:1em">'
	+                '<label for="gr">Grade</label>'
	+                '<input type="text" name="grade" id="gr">'
	+        '</div>' 
	+        '<button type="submit" id="gradeSubmit" class="btn btn-info float-right">Submit Grade</button>'
	+		 '</form>'
	+    '</div>'
	+'</div>';	


var approveDeny = 
	'<div id="selectPage" class="card" style="width:20%;height:150px;margin:auto;position:absolute;top:0;bottom:0px;left:0;right:0;box-shadow:5px 5px 5px #929191" >'
	+    '<div class="card-body">'
	+		'<form id="appDen">'
	+		'<div class="form-group" style="text-align:center;font-size:1em">'
	+                '<label for="rn">Reimburstment ID</label>'
	+                '<input type="text" name="reimbID" id="rn">'
	+        '</div>' 
	+        '<button type="submit" name="approve" id="approve" class="btn btn-success float-right">Approve</button>'
	+        '<button type="submit" name="deny" id="deny" class="btn btn-danger float-right">Deny</button>'
	+		 '</form>'
	+    '</div>'
	+'</div>';	

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if(o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
        o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
 };
//submit form handler
 $(function() {
    $('#content').on('submit','#myForm', function(e) {
      e.preventDefault();
      console.log("in handler");
      var formData = $(this).serializeObject();
      console.log(JSON.stringify(formData));
      $.ajax({
        type: "POST",
        url: "SubmitServlet",
        datatype: "json",
        data: JSON.stringify(formData),
        success: function(data){
        	alert("Submission successful, remember to enter your grade upon completion");
        	$("#contents").removeChild($("#contents").childNodes[0]);
        	$("#contents").append(mainMenu);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
          }
      });
      
    });
});
 
// view req handler 
 $(function() {
	    $('#viewReq').click(function() {
	      $.ajax({
	        type: "POST",
	        url: "ViewServlet",
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          },
	        success: function(data){
	        	console.log(data);
	        	$("#selectPage").remove();
	        	$.each(data, function(i,element){
	        		$('#content').append(getViewCard(
	        				element.rid,
	        				element.status,
	        				element.eventName,
	        				element.eventType,
	        				element.dateSubmitted,
	        				element.cost,
	        				element.reimb,
	        				element.grade,
	        				element.feedback));
	        	});
	        	
	        	
	        }
	        
	      });
	      
	    });
	});
 
 
 
 //Enter grade handler
 $(function() {
	    $('#addGrade').click(function() {
	    	console.log('grade clicked');
	      $.ajax({
	        type: "POST",
	        url: "ViewServlet",
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          },
	        success: function(data){
	        	$('#selectPage').remove();
	        	console.log(data);    	
	        	$.each(data, function(i,element){
	        		if(element.grade == "In Progress"){
	        			$('#content').append(getGradeCard(
	        				element.rid,
	        				element.status,
	        				element.eventName,
	        				element.eventType,
	        				element.dateSubmitted,
	        				element.cost,
	        				element.reimb,
	        				element.grade,
	        				element.feedback
	        			));
	        		}
	        	});        	        	
	        }       
	      });    
	});
 });
 //grade Form handler
 $(function() {
	    $('#content').on('submit','#gradeForm', function(e) {
	      e.preventDefault();
	      var gradeUpdate = { "grade" 	: $('#gradeForm').find('input[name="grade"]').val(),
	    		  			  "rid"		: $('#gradeForm').attr('value')};
	      console.log(JSON.stringify(gradeUpdate));
	      $.ajax({
	        type: "POST",
	        url: "GradeServlet",
	        datatype: "json",
	        data: JSON.stringify(gradeUpdate),
	        success: function(data){
	        	alert("Grade Updated")
	        	$('#gradeForm').parent().parent().remove();
	        },
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          }
	      });
	      
	    });
	});
 
 
 //aprroveDeny button handler
 $(function() {
	    $('#approve').click(function() {
	      $.ajax({
	        type: "POST",
	        url: "ViewRequestServlet",
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          },
	        success: function(data){
	        	console.log(data);
	        	$("#selectPage").remove();   
	        	var card;
	        	$.each(data, function(i,element){
	        		card= getCard(	element.reimbId,
	        						element.firstName+" "+element.lastName,
	        						element.eventName,
	        						element.eventType,
	        						element.eventCost,
	        						element.eventDate,
	        						element.eventTime,
	        						element.location,
	        						element.eventDesc);
	        		$("$content").append(card); 		
	        	});
	        	
	        	reimbId,empId,empName,empTitle,eventName,eventType,eventCost,eventDate,eventTime,eventLocation,eventDesc
	        }
	        
	      });
	      
	    });
	});

 
 
 $(function() {
	    $('#appDen').on('submit','#appDen', function(e) {
	      e.preventDefault();
	      console.log("in handler approve");
	      var formData = $(this).serializeObject();
	      console.log("json"+JSON.stringify(formData));
	      $.ajax({
	        type: "POST",
	        url: "ApproveServlet",
	        datatype: "json",
	        data: JSON.stringify(formData),
	        success: function(data){alert("Approved")},
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          }
	      });
	      
	    });
	});
 
 $(function() {
	    $('#content').on('click','#deny', function(e) {
	      e.preventDefault();
	      console.log("in handler deny");
	      var formData = $(this).serializeObject();
	      console.log(JSON.stringify(formData));
	      $.ajax({
	        type: "POST",
	        url: "DenyServlet",
	        datatype: "json",
	        data: JSON.stringify(formData),
	        success: function(data){alert("Denied")},
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          }
	      });
	      
	    });
	});
 
//new reimb request handler
$(function() {
	$("#newReimburst").click(function(){
		$("#selectPage").remove();
		$("#content").append(formHTML);
	});
});

