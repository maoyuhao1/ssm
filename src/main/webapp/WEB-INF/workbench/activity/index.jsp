<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="/crm/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="/crm/jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="/crm/jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="/crm/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/crm/jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="/crm/jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>


<%--导入分页插件--%>
<link href="/crm/jquery/bs_pagination/jquery.bs_pagination.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/crm/jquery/bs_pagination/en.js"></script>
<script type="text/javascript" src="/crm/jquery/bs_pagination/jquery.bs_pagination.min.js"></script>
<script type="text/javascript"></script>

		</head>
<body>

	<!-- 创建市场活动的模态窗口 -->
	<div class="modal fade" id="createActivityModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 85%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel1">创建市场活动</h4>
				</div>
				<div class="modal-body">
				
					<form class="form-horizontal" role="form" id="createActivtiyForm">
					
						<div class="form-group">
							<label for="create-marketActivityOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="create-marketActivityOwner">
								</select>
							</div>
                            <label for="create-marketActivityName" class="col-sm-2 control-label">名称<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-marketActivityName">
                            </div>
						</div>
						
						<div class="form-group">
							<label for="create-startTime" class="col-sm-2 control-label">开始日期</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-startTime">
							</div>
							<label for="create-endTime" class="col-sm-2 control-label">结束日期</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-endTime">
							</div>
						</div>
                        <div class="form-group">

                            <label for="create-cost" class="col-sm-2 control-label">成本</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-cost">
                            </div>
                        </div>
						<div class="form-group">
							<label for="create-describe" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10" style="width: 81%;">
								<textarea class="form-control" rows="3" id="create-describe"></textarea>
							</div>
						</div>
						
					</form>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="saveActivityBtn" >保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 修改市场活动的模态窗口 -->
	<div class="modal fade" id="editActivityModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 85%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel2">修改市场活动</h4>
				</div>
				<div class="modal-body">
				
					<form class="form-horizontal" role="form">
						<input id="aid" type="hidden">
						<div class="form-group">
							<label for="edit-marketActivityOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="edit-marketActivityOwner">
								</select>
							</div>
                            <label for="edit-marketActivityName" class="col-sm-2 control-label">名称<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-marketActivityName" value="发传单">
                            </div>
						</div>

						<div class="form-group">
							<label for="edit-startTime" class="col-sm-2 control-label">开始日期</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-startTime" value="2020-10-10">
							</div>
							<label for="edit-endTime" class="col-sm-2 control-label">结束日期</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-endTime" value="2020-10-20">
							</div>
						</div>
						
						<div class="form-group">
							<label for="edit-cost" class="col-sm-2 control-label">成本</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-cost" value="5,000">
							</div>
						</div>
						
						<div class="form-group">
							<label for="edit-describe" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10" style="width: 81%;">
								<textarea class="form-control" rows="3" id="edit-describe">市场活动Marketing，是指品牌主办或参与的展览会议与公关市场活动，包括自行主办的各类研讨会、客户交流会、演示会、新产品发布会、体验会、答谢会、年会和出席参加并布展或演讲的展览会、研讨会、行业交流会、颁奖典礼等</textarea>
							</div>
						</div>
						
					</form>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="ModelUpdateActivity">更新</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	<div>
		<div style="position: relative; left: 10px; top: -10px;">
			<div class="page-header">
				<h3>市场活动列表</h3>
			</div>
		</div>
	</div>
	<div style="position: relative; top: -20px; left: 0px; width: 100%; height: 100%;">
		<div style="width: 100%; position: absolute;top: 5px; left: 10px;">
		
			<div class="btn-toolbar" role="toolbar" style="height: 80px;">
				<form class="form-inline" role="form" style="position: relative;top: 8%; left: 5px;">
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">名称</div>
				      <input class="form-control" type="text" id="name">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">所有者</div>
				      <input class="form-control" type="text" id="owner">
				    </div>
				  </div>


				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">开始日期</div>
					  <input class="form-control" type="text" id="startTime" />
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">结束日期</div>
					  <input class="form-control" type="text" id="endTime" >
				    </div>
				  </div>
				  
				  <button type="button" class="btn btn-default" onclick="queryActivity()">查询</button>
				  
				</form>
			</div>
			<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;top: 5px;">
				<div class="btn-group" style="position: relative; top: 18%;">
				  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createActivityModal" id="createActivity"><span class="glyphicon glyphicon-plus"></span> 创建</button>
				  <button type="button" class="btn btn-default" data-toggle="modal"  id="updateActivity"><span class="glyphicon glyphicon-pencil"></span> 修改</button>
				  <button type="button" class="btn btn-danger" id="deleteActivity"><span class="glyphicon glyphicon-minus" ></span> 删除</button>
				</div>
				
			</div>
			<div style="position: relative;top: 10px;">
				<table class="table table-hover">
					<thead>
						<tr style="color: #B3B3B3;">
							<td><input type="checkbox" id="father"/></td>
							<td>名称</td>
                            <td>所有者</td>
							<td>开始日期</td>
							<td>结束日期</td>
						</tr>
					</thead>
					<tbody id="activityBody">

					</tbody>
				</table>
			</div>

			<%--分页插件--%>
			<div  style="height: 50px; position: relative;top: 30px;">
				<div id="activityPage"></div>
			</div>

		</div>
		
	</div>
</body>
</html>
<script>

	//全选
	$('#father').click(function () {
		$('.son').each(function () {
			$(this).prop('checked', $('#father').prop('checked'))
		});
	})

	$('.son').each(function () {
		$(this).click(function () {
			var selectAll = $('.son:checked');
			if (selectAll.length == $('.son').length) {
				$('#father').prop('checked', true);
			} else {
				$('#father').prop('checked', false);
			}
		})
	});

	//点击删除按钮
	$('#deleteActivity').click(function () {
		if ($('.son:checked').length == 0) {
			alert("至少选择一条记录");
		} else {
			if (confirm("您确定删除这些数据吗？")) {
				//定义一个数据，用于存放勾中的id号
				var idArray = [];
				//获取勾中的复选框
				$('.son:checked').each(function () {
					idArray.push($(this).val());
				});
				//join:将数组内容通过制定分隔符进行分割，并且拼接成字符串，默认的分隔符是,号
				//向后台发出删除请求idArray.join()
				//location.href = "/ssm/deleteBatch?fids=" + idArray.join();
				$.ajax({
					url: '/crm/workbench/activity/deleteActivity',
					data:{
						'ids':idArray.join()
					},
					type: 'get',
					dataType: 'json',
					success: function (data) {
						alert(data.mess)
						//调用pageList刷新页面
						pageList(1,2);
					}
				})
			}
		}

	})

	//点击更新按钮
	$('#ModelUpdateActivity').click(function () {
		//更新活动
		$.ajax({
			url: '/crm/workbench/activity/updateActivity',
			data:{
				'id':$('#aid').val(),
				'owner' : $('#edit-marketActivityOwner').val(),
				'name'  : $('#edit-marketActivityName').val(),
				'start_date' : $('#edit-startTime').val(),
				'end_date'  : $('#edit-endTime').val(),
				'cost' :$('#edit-cost').val(),
				'description' : $('#edit-describe').val()
			},
			type: 'get',
			dataType: 'json',
			success: function (data) {
				alert(data.mess)
				$('#editActivityModal').modal('hide');

				//调用pageList刷新页面
				pageList(1,2);
			}
		})
	})



	//点击修改按钮
	$('#updateActivity').click(function () {
		if ($('.son:checked').length != 1) {
			alert("请选择一条记录");
		} else {
			$('#editActivityModal').modal('show')
			$.ajax({
				url: '/crm/workbench/activity/queryActivityById',
				data:{"activityId":$('.son:checked').val()},
				type: 'get',
				dataType: 'json',
				success: function (updatedata) {
					$('#aid').val(updatedata[0].id)
					$('#edit-marketActivityName').val(updatedata[0].name)
					$('#edit-startTime').val(updatedata[0].start_date)
					$('#edit-endTime').val(updatedata[0].end_date)
					$('#edit-cost').val(updatedata[0].cost)
					$('#edit-describe').val(updatedata[0].description)
					document.getElementById('edit-marketActivityOwner').options.length = 0
					$.ajax({
						url: '/crm/workbench/activity/queryAllOwner',
						type: 'get',
						dataType: 'json',
						success: function (data) {
							for (var i = 0 ;i < data.length;i++){

								$('#edit-marketActivityOwner').append("<option value="+data[i].id+">"+data[i].name+"</option>")

							}
							//将owner回显
							$('#edit-marketActivityOwner option').each(function () {
								if ($(this).val() == updatedata[0].owner) {
									$(this).prop('selected', true)
								}
							})
						}
					})

				}
			})

		}


	})



	//点击保存按钮
	$('#saveActivityBtn').click(function () {
		if ($('#create-marketActivityName').val() == '' ){
			alert("请输入名称")
		}else {
			//插入活动
			$.ajax({
				url: '/crm/workbench/activity/createActivity',
				data:{
					'owner' : $('#create-marketActivityOwner').val(),
					'name'  : $('#create-marketActivityName').val(),
					'start_date' : $('#create-startTime').val(),
					'end_date'  : $('#create-endTime').val(),
					'cost' :$('#create-cost').val(),
					'description' : $('#create-describe').val()
				},
				type: 'get',
				dataType: 'json',
				success: function (data) {
					alert(data.mess)
					$('#createActivtiyForm')[0].reset();
					$('#createActivityModal').modal('hide');

					//调用pageList刷新页面
					pageList(1,2);
				}
			})
		}
	})


	//创建活动异步查询
	$('#createActivity').click(function () {
		document.getElementById('create-marketActivityOwner').options.length = 0
		$.ajax({
			url: '/crm/workbench/activity/queryAllOwner',
			type: 'get',
			dataType: 'json',
			success: function (data) {
				for (var i = 0 ;i < data.length;i++){

					$('#create-marketActivityOwner').append("<option value="+data[i].id+">"+data[i].name+"</option>")
				}
			}
		})
	})

	//点击查询按钮
	function queryActivity(){
		pageList(1,2);
	}

	pageList(1,2)

	function pageList(page,pageSize) {
		$('#activityBody').html("")
		$.ajax({
			url: '/crm/workbench/activity/queryList',
			data:{
				'page':page,
				'pageSize':pageSize,
				'name':$('#name').val(),
				'owner':$('#owner').val(),
				'start_date':$('#startTime').val(),
				'end_date':$('#endTime').val(),
			},
			type: 'get',
			dataType: 'json',
			success: function (data) {
				var dataList = data.pageInfo.list;
				for (var i = 0; i < dataList.length; i++) {
					var list = dataList[i]
					$('#activityBody').append("<tr class=\"active\">\n" +
							"<td><input type=\"checkbox\" class=\"son\" value=\""+list.id+"\"+/></td>\n" +
							"<td><a style=\"text-decoration: none; cursor: pointer;\" href=/crm/workbench/activity/queryActivityDetailById?id="+list.id+">" + list.name + "</a></td>\n" +
							"<td>" + list.uname + "</td>\n" +
							"<td>" + list.start_date + "</td>\n" +
							"<td>" + list.end_date + "</td>\n" +
							"</tr> ");
				}

				/*将分页信息传入*/
				$("#activityPage").bs_pagination({
					currentPage: data.page, // 页码
					rowsPerPage: data.pageSize, // 每页显示的记录条数
					maxRowsPerPage: 20, // 每页最多显示的记录条数
					totalPages: data.totalPages, // 总页数
					totalRows: data.totalRows, // 总记录条数
					visiblePageLinks: 3, // 显示几个卡片
					showGoToPage: true,
					showRowsPerPage: true,
					showRowsInfo: true,
					showRowsDefaultInfo: true,
					//回调函数
					onChangePage: function (event, obj) {
						pageList(obj.currentPage, obj.rowsPerPage);
					}
				})
			}
		})
	}


	//条件查询日历插件
	$("#startTime").datetimepicker({
		language:  "zh-CN",
		format: "yyyy-mm-dd",//显示格式
		minView: "month",//设置只显示到月份
		initialDate: new Date(),//初始化当前日期
		autoclose: true,//选中自动关闭
		todayBtn: true, //显示今日按钮
		clearBtn : true,
		pickerPosition: "bottom-left"
	});

	$("#endTime").datetimepicker({
		language:  "zh-CN",
		format: "yyyy-mm-dd",//显示格式
		minView: "month",//设置只显示到月份
		initialDate: new Date(),//初始化当前日期
		autoclose: true,//选中自动关闭
		todayBtn: true, //显示今日按钮
		clearBtn : true,
		pickerPosition: "bottom-left"
	});

	//创建市场活动日期
	$("#create-startTime").datetimepicker({
		language:  "zh-CN",
		format: "yyyy-mm-dd",//显示格式
		minView: "month",//设置只显示到月份
		initialDate: new Date(),//初始化当前日期
		autoclose: true,//选中自动关闭
		todayBtn: true, //显示今日按钮
		clearBtn : true,
		pickerPosition: "bottom-left"
	});
	$("#create-endTime").datetimepicker({
		language:  "zh-CN",
		format: "yyyy-mm-dd",//显示格式
		minView: "month",//设置只显示到月份
		initialDate: new Date(),//初始化当前日期
		autoclose: true,//选中自动关闭
		todayBtn: true, //显示今日按钮
		clearBtn : true,
		pickerPosition: "bottom-left"
	});

	//修改市场活动日期
	$("#edit-startTime").datetimepicker({
		language:  "zh-CN",
		format: "yyyy-mm-dd",//显示格式
		minView: "month",//设置只显示到月份
		initialDate: new Date(),//初始化当前日期
		autoclose: true,//选中自动关闭
		todayBtn: true, //显示今日按钮
		clearBtn : true,
		pickerPosition: "bottom-left"
	});
	$("#edit-endTime").datetimepicker({
		language:  "zh-CN",
		format: "yyyy-mm-dd",//显示格式
		minView: "month",//设置只显示到月份
		initialDate: new Date(),//初始化当前日期
		autoclose: true,//选中自动关闭
		todayBtn: true, //显示今日按钮
		clearBtn : true,
		pickerPosition: "bottom-left"
	});
</script>