$(function(){
	$("#jqGrid").jqGrid({
		datatype : "local",
		height: 385,
		multiselect: true,
		viewrecords: true,
		rownumbers: true, 
		rowNum: 5,
		rowList : [10,30,50],
		autowidth:true,
		pager: "#jqGridPager",
		jsonReader : {
            page: "1",
            total: "6",
            records: "5"
        },
		colModel : [
			{lable:"用户ID",name:"userId",width:45,key:true},
			{lable:"用户名",name:"name",width:80},
			{lable:"手机号",name:"telephone",width:120},
			{lable:"E-mail",name:"email",width:120},
			{lable:"状态",name:"status",width:80}
		],
		gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
	});
	 var mydata = [
         {userId:"1",name:"test",telephone:"note",email:"200.00",status:"10.00"},
         {userId:"2",name:"test2",telephone:"note2",email:"300.00",status:"20.00"},
         {userId:"3",name:"test3",telephone:"note3",email:"400.00",status:"30.00"},
         {userId:"4",name:"test",telephone:"note",email:"200.00",status:"10.00"},
         {userId:"5",name:"test2",telephone:"note2",email:"300.00",status:"20.00"},
         {userId:"6",name:"test3",telephone:"note3",email:"400.00",status:"30.00"},
         {userId:"7",name:"test",telephone:"note",email:"200.00",status:"10.00"},
         {userId:"8",name:"test2",telephone:"note2",email:"300.00",status:"20.00"},
         {userId:"9",name:"test3",telephone:"note3",email:"400.00",status:"30.00"}
         ];
	 
		for(var i=0;i<=mydata.length;i++){
		     $("#jqGrid").jqGrid('addRowData',i+1,mydata[i]);
		};
})

var vm = new Vue({
	el:"#loski",
	data:{
		query:{
			name :null
		},
		show:true,
		title:null,
		user:{
			status:1,
			name :"li",
			telephone : "15761621164",
			email : "823292619@qq.com"
		}
	},
	methods: {
		add : function(){
			vm.show = false;
			vm.title = "添加用户";
			vm.user = {};
		},
		reload : function(){
			vm.show = true;
			$("#jqGrid").jqGrid().trigger();
		},
		update : function(){
			vm.show = false;
			vm.title = "修改";
			vm.user.status = 1,
			vm.user.name = "li";
			vm.user.telephone = "15761621164";
			vm.user.email = "823292619@qq.com";
		},
		insertOrUpdate : function(){
			var url = "/share/main/admin/insert";
			$.ajax({
				type : "POST",
				data : vm.user,
				dataType: "json",
				contentType: "application/json",
			    data: JSON.stringify(vm.user),
			    url : url,
			    success : function(result){
			    	alert("123123");
			    	if(result.status){
			    		alert(result.msg, function(){
							vm.reload();
						});
			    	}else{
			    		alert(result.msg);
			    	}
			    }
			})
		}
	
	}
})