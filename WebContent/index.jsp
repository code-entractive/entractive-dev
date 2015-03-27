<!DOCTYPE html>
<html>
<head>
<title>jTable Pagination in Java Web Applications</title>

<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />

<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#StudentTableContainer').jtable({
			title : 'Students List',
			paging : true, //Enable paging
			pageSize : 3, //Set page size (default: 10)   
			actions : {
				listAction : 'hello/listAction',
				createAction : 'createAction',
				updateAction : 'updateAction',
				deleteAction : 'deleteAction'
			},

			fields : {
				studentId : {
					title : 'Student Id',
					width : '30%',
					key : true,
					list : true,
					edit : false,
					create : true
				},
				name : {
					title : 'Name',
					width : '30%',
					edit : true
				},
				department : {
					title : 'Department',
					width : '30%',
					edit : true
				},
				emailId : {
					title : 'Email',
					width : '20%',
					edit : true
				}
			}
		});
		$('#StudentTableContainer').jtable('load');
	});
</script>

</head>
<body>
	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h3>jTable Pagination in Java Web Applications</h3>
		<div id="StudentTableContainer"></div>
	</div>
</body>
</html>