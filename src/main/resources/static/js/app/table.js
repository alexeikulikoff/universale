
var table = table || {};

var table1 = null;


var randomString = function(){
	return uuidv4().substr(0, 8).toUpperCase();
}

table.init = function(){
	table1 = $('#table1').DataTable({
		ajax : {
			url : "/getAll?name=Entity1",
			type : "GET",
			dataSrc : "content",
			error : function(e) {
				console.log(e);
			}
		},
		columns : [ 
			{ title : "#" , data : "id" }, 
			{ "title" : "First Name", data : "firstName" },
			{ "title" : "Last Name", data : "lastName" },
			{ title : "Action", data : "id", render : function( data  ){
				 return '<button id="button3" type="button" class="btn btn-danger btn-xs" onclick="table.delete1(\'' + data + '\')">Delete</button>'
			}}
			
		],
		searching : false,
		 info :     false,
		 paging :  false
	});
	
}
table.delete1 = function(id){
	var headers = {};
	var $data = {
			name : "Entity1",
			id : id 
	}
	
	$.ajax({
		  type: "POST",
		  url:  "delete",
		  data: JSON.stringify($data),
		  contentType : 'application/json',
		  dataType: "json",
		  headers : headers ,    	
		  success: function(e){
			  table1.ajax.reload();
			  console.log(e);
			
		  },
		  error : function(e) {
			  console.log(e);
		}
	});
	
}
table.save_record_table1 = function(){
	
	var headers = {};
	var $data = {
			name : "Entity1",
			content : {
				firstName : randomString(),
				lastName : randomString()
			}
	}
	
	$.ajax({
		  type: "POST",
		  url:  "save",
		  data: JSON.stringify($data),
		  contentType : 'application/json',
		  dataType: "json",
		  headers : headers ,    	
		  success: function(e){
			  table1.ajax.reload();
			  console.log(e);
			
		  },
		  error : function(e) {
			  console.log(e);
		}
	});
	
}
$(document).ready(function() {

	table.init();

	$("#button1").click(function() {
	
		table.save_record_table1();
	});

});