function readCookie(name) {
            var nameEQ = name + "=";
            var ca = document.cookie.split(';');
            for (var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) == ' ') c = c.substring(1, c.length);
                if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
            }
            return null;
        }

function numCookies(nameHtml) {
	var output = document.getElementById(nameHtml);
	var ca = document.cookie.split(';');
    var cont=0;
    for (var i = 0; i < ca.length; i++) {
    	if (ca[i].startsWith(" codProd_")||ca[i].startsWith("codProd_")) {
        	cont ++;
        } 
    }
    output.innerHTML = cont;
    if(cont==0){
    	document.getElementById('numProdCookieTem').innerHTML='';
    }
    
    	
}