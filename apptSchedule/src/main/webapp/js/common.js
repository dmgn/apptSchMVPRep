function formatDate(date){

	var day = date.getDate() < 9 ? "0"+date.getDate() : date.getDate();
	var m = (date.getMonth() + 1);
	var month = m <= 9 ? "0"+ m : m;
	var year = date.getFullYear();
	return year + "-" + month + "-" + day;
}