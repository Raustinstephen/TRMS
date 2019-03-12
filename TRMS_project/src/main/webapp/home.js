    var formHTML =         
    '<div class="card" style="margin:50px 50px 20px 50px">'
+    '<div class="card-body">'
+		 '<form id="myForm">'
+        '<h5 class="card-title" style="text-align:center;font-size:2em">New Reimburstment Request</h5>'
+        '<div class="form-group">'
+            '<label for="f1">Event Name</label>'
+            '<input type="text" name="eventName" id="f1">'
+        '</div>'
+        '<div class="form-group">'
+            '<label for="f2">Event Address</label>'
+            '<input type="text" name="address" id="f2">'
+        '</div>'
+        '<div class="form-group">'
+            '<label for="f3">Event City</label>'
+            '<input type="text" name="city" id="f3">'
+        '</div>'
+        '<div class="form-group">'
+            '<label for="f4">Event State</label>'
+            '<input type="text" name="state" id=f4>'
+        '</div>'
+        '<div class="form-group">'
+            '<label for="f5">Event Description</label>'
+            '<input type="text" name="eventDesc" id="f5">'
+        '</div>'
+        '<div class="form-group">'
+            '<label for="f6">Event Justification</label>'
+            '<input type="text" name="justification" id="f6">'
+        '</div>'
+        '<div class="form-group">'
+            '<label for="f7">Event Cost</label>'
+            '<input type="text" name="eventCost" id="f7">'
+        '</div>'
+        '<div class="form-group">'
+            '<label for="f8">Grading Format</label>'
+            '<select name="gradeFormat" id="f8">'
+                '<option value="1">A - F</option>'
+                '<option value="2">Pass/Fail</option>'
+                '<option value="3">Percentage</option>'
+                '<option value="4">Score</option>'
+                '<option value="5">Does Not Apply</option>'
+            '</select>'
+        '</div>'
+        '<div class="form-group">'
+                '<label for="f9">Grading Format</label>'
+                '<select name="eventType" id="f9">'
+                        '<option value="1">University Course</option>'
+                        '<option value="2">Seminar</option>'
+                        '<option value="3">Certification Prepartion</option>'
+                        '<option value="4">Certification</option>'
+                        '<option value="5">Technical Training</option>'
+                        '<option value="6">Other</option>'
+                '</select>'
+        '</div>'
+        '<div class="form-group">'
+                '<label for="f9">Hours of work missed</label>'
+                '<input type="text" name="hoursMissed" id="f9">'
+        '</div>' 
+        '<button type="submit" id="formButton" class="btn btn-info float-right" style="margin:20px 20px 0px 0px;width:20%" id="btnLogin">Submit</button>'
+		 '</form>'
+    '</div>'
+'</div>';

var table = 
	'<table class="table">'
+		'<thead>'
+			'<tr>'
+				'<th scope="col">Event Name</th>'
+				'<th scope="col">Event Type</th>'
+				'<th scope="col">Cost</th>'
+				'<th scope="col">Grade Format</th>'
+				'<th scope="col">Status</th>'
+				'<th scope="col">Date Submitted</th>'
+			'</tr>'
+		'</thead>'
+		'<tbody>'
+		'</tbody>'
+	'</table>';

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
        success: function(data){console.log("yayyy");},
        error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
          }
      });
      
    });
});
 
 $(function() {
	    $('#viewReq').click(function() {
	      $('#selectPage').remove();
	      $('#content').append(table);
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
	        		tr = $('<tr/>');
	                tr.append("<td>" + element.eventName + "</td>");
	                tr.append("<td>" + element.eventType + "</td>");
	                tr.append("<td>" + element.eventCost + "</td>");
	                tr.append("<td>" + element.gradeFormat + "</td>");
	                tr.append("<td>" + element.reimbStatus + "</td>");
	                tr.append("<td>" + element.timeStamp + "</td>");
	                $('table').append(tr);
	        	});
	        	
	        	
	        }
	        
	      });
	      
	    });
	});
 

$(function() {
	$("#newReimburst").click(function(){
		$("#selectPage").remove();
		$("#content").append(formHTML);
})});


