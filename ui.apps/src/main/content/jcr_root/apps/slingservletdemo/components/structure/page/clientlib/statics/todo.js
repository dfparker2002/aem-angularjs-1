$('#dd1').text('hello jquery 2018 world');
$('#btn1').click(function() {
  var fname = $('#firstname').val();
  var lname = $('#lastname').val();
  var id = 12345;
  console.log("before subit " + 'id=' + id + '&firstName=' + fname + '&lastName=' + lname);
  $.ajax({
    type: "POST",
    url: "/bin/abcServlet",
    data: 'id=' + id + '&firstName=' + fname + '&lastName=' + lname,
    dataType: "json",
    success: function(msg) {
      console.log("from servlet " + msg["firstname"]);
      $("#dd1").text("after server :" + JSON.stringify(msg));
      $('#firstname').val("");
      $('#lastname').val("");
      
    },
    error: function(jqXhr, textStatus, errorThrown) {
      console.log(errorThrown);
    }
  })
})

$('#btn2').click(function() {
  $.ajax({
    type: "POST",
    url: "/bin/abcServlet",
    data:"firstName=aa&lastName=cao",
    success: function(msg) {
      console.log("from get servlet " + msg);
      $("#dd2").text(msg);
    }
  })
})

$('#btn3').click(function() {
  $.ajax({
    type: "GET",
    url: "/bin/abcServlet",
    success: function(msg) {
      console.log("from get servlet " + msg);
      $("#dd3").text(msg);
    }
  })
})


  var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope,$http) {
    	$scope.result=[];
    	$scope.edtflag=false;
    	$scope.saveflag=true;
    	$http.get('/bin/angularServlet').then(dd=>{
    		$scope.uname = dd.data;
    		console.log(dd);
    	})
    	$scope.submitForm=function(){
    		$scope.newuser=$scope.user;
    		$scope.user="";
    		var userdata={
    				firstName:$scope.newuser.firstName,
    				lastName:$scope.newuser.lastName,
    				id:2018
    		}
    		console.log(userdata);
    		$http.post('/bin/angularServlet',userdata).then(dd2=>{
    			$scope.result.push(dd2.data);
    			$scope.otheruser=dd2.data;
    			});
    	}
    	$scope.deleteOne=function(idx){
    		$scope.result.splice(idx,1);
    		console.log("please delete this index : "+ idx);
    	}
    	$scope.editOne=function(it,idx){
    		$scope.user=it;
    		$scope.edtflag=true;
        	$scope.saveflag=false;
        	$scope.oneindex=idx;
    		console.log("please edit this ine"+it['id']);
    	}
    	$scope.editIt=function(){
    		$scope.result[$scope.oneindex]=$scope.user;
    		$scope.user='';
    		$scope.oneindex=0;
    		$scope.edtflag=false;
        	$scope.saveflag=true;
    	}

    });
