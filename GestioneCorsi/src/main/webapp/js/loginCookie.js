// id: nomeadmin, cognomeadmin, codadmin

document.querySelector('#loginForm').addEventListener('submit', () => {
	//setCookie('nome', document.querySelector('#nomeadmin').value, '/')
	//setCookie('cognome', document.querySelector('#cognomeadmin').value, '/')
	setCookie('cod', document.querySelector('#codadmin').cvalue, '/')
})

function setCookie(cname, cvalue, exdays) {
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toUTCString();
	document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
	var name = cname + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}


//function eraseCookie(name) {
	//document.cookie = name + '=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
//}