 var formHTML = 
 '<div class="card " style="width:70%;margin:0 auto;float:none;top:40pxbackground-color:whitesmoke;">'
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

function getViewCard(rid,status,eventName,eventType,dateSubmitted,cost,reimb,grade,feedback){
	res =  
		 '<div class="card" style="width:80%;margin:0 auto;top:60px;margin-bottom:60px;box-shadow:5px 5px 5px #929191;background-color:whitesmoke;" >'
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
 '<div class="card" style="width:80%;margin:0 auto;top:60px;margin-bottom:60px;box-shadow:5px 5px 5px #929191;background-color:whitesmoke;" >'
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

function getApproveDenyCard(rid,dateSubmitted,empName,empTitle,empDept,eventName,eventType,gradeFormat,location,date,grade,cost,estReimb,workMissed,justification){	
res=                 
'<div class="card" id="reimbId" style="width:80%;margin:0 auto;top:40px;margin-bottom:40px;box-shadow:5px 5px 5px #929191;background-color:whitesmoke;" >'
+'<div class="card-header">Reimburstment Request ID: '+rid+'<span style="float:right">Date Submitted: '+dateSubmitted+'</span></div>'
+'<div class="card-body">'
+    '<div class="card-rows">'
+        '<div class="card-columns">'
+            '<div>Employee Name: '+empName+'</div>'
+            '<div>Title: '+empTitle+'</div>'
+            '<div>Department: '+empDept+'</div>'
+        '</div>'
+       '<div class="card-columns" style="margin-top:10px">'
+                '<div>Event Name: '+eventName+'</div>'
+                '<div>Event Type: '+eventType+'</div>'
+                '<div>Grading Format: '+gradeFormat+'</div>'
+            '</div>'
+        '<div class="card-columns" style="margin-top:10px">'
+            '<div>Location: '+location+'</div>'
+            '<div>Date: '+date+'</div>'
+            '<div>Grade: '+grade+'</div>'
+        '</div>'
+        '<div class="card-columns" style="margin-top:10px">'
+                '<div>Cost: $'+cost+'</div>'
+                '<div>Maximum Reimburstment: $'+estReimb+'</div>'
+                '<div>Hours of work missed: '+workMissed+'</div>'
+            '</div>'
+        '<div style="margin-top:10px">Justification: '+justification+'</div>'
+    '</div>'
+'</div>'
+'<div class="card-footer" style="margin-top:15px">'
+    '<div style="float:right">'
+        '<button class="btn btn-success approve" value="'+rid+'" style="width:100px">Approve</button>'
+        '<button class="btn btn-danger reject" value="'+rid+'" style="width:100px;margin-left: 20px">Reject</button>'   
+    '</div>'
+'</div>'
+'</div>';
return res;
}

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
//Opens new Submit Form
 $(function() {
		$("#newReimburst").click(function(){
			$("#selectPage").remove();
			$("#content").append(formHTML);
		});
	});
 
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
 
// view request handler 
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
 
 
 
 //Opens Enter Grade page
 $(function() {
	    $('#addGrade').click(function() {
	      $.ajax({
	        type: "POST",
	        url: "ViewServlet",
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          },
	        success: function(data){
	        	$('#selectPage').remove();   	
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
	        	if($('#content').children().length === 0){
	        		alert("No action needed");
	        	}

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
	      $.ajax({
	        type: "POST",
	        url: "GradeServlet",
	        datatype: "json",
	        data: JSON.stringify(gradeUpdate),
	        success: function(data){
	        	alert("Grade Updated")
	        	$('#gradeForm').parent().parent().remove();
	        	if($('#content').children().length === 0){
	        		alert("No action needed");
	        	}
	        },
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          }
	      });
	      
	    });
	});
 
 
 //Open Approve Reject Page
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
	        	$("#selectPage").remove();   
	        	var card;
	        	$.each(data, function(i,element){
	        		card= getApproveDenyCard(	
	        			element.rid,
	        			element.dateSubmitted,
	        			element.empName,
	        			element.empTitle,
	        			element.empDept,
	        			element.eventName,
	        			element.eventType,
	        			element.gradeFormat,
	        			element.location,
	        			element.date,
	        			element.grade,
	        			element.cost,
	        			element.estReimb,
	        			element.hrsMissed,
	        			element.justification);
	        		$("#content").append(card); 		
	        	});
	        	if($('#content').children().length === 0){
	        		alert("No action needed");
	        	}
	        }   
	      });
	      
	    });
	});

 
 //approve button handler
 $(function() {
	    $('#content').on('click','.approve', function(e) {
	      e.preventDefault();
	      var approveUpdate = {"rid" : $(this).attr('value')};
	      $.ajax({
	        type: "POST",
	        url: "ApproveServlet",
	        datatype: "json",
	        data: JSON.stringify(approveUpdate),
	        success: function(data){	        	
	        	if($('#content').children().length === 0){
        		alert("No action needed");
	        	}
	        },
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          }
	      });
	    });
	});
 //reject button handler
 $(function() {
	    $('#content').on('click','.reject', function(e) {
	      e.preventDefault();
	      var denyUpdate = { 	"reason" 	: prompt("Enter your reason for rejection","No Feedback"),
	    		  				"rid"		: $(this).attr('value')};
	      $.ajax({
	        type: "POST",
	        url: "DenyServlet",
	        datatype: "json",
	        data: JSON.stringify(denyUpdate),
	        success: function(data){$(this).parent().parent().parent().remove();
        	if($('#content').children().length === 0){
        		alert("No action needed");
        	}},
	        error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	          }
	      });
	    });
	});

