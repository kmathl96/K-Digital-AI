function login() {
	var id = $("#id").val();
	var pw = $("#pw").val();
	alert(id+":"+pw);
	$.ajax({
		type: "post",
		dataType: "text",
		async: false,
		url: "http://localhost:8090/homework4/ajax",
		data: {
			id: id
		},
		success: function (data, textStatus) {
			alert("Data: "+ data + "\nStatus: " + textStatus);
		},
		error: function (data, textStatus) {
			alert("에러가 발생했습니다." + textStatus);
		},
		complete: function (data, textStatus) {
		}
	});
}