	
	$(document).ready(cambioDivBusqueda);
    $(window).resize(cambioDivBusqueda);
	
    function cambioDivBusqueda() {
        if($(window).width()<1000){
    		//$( "body" ).prepend( "<div>" + $( window ).width() + " Mobile</div>" );
    		 $("#divSearch > div").detach().appendTo('#divSearchMobile');
    	}else{
//    		$( "body" ).prepend( "<div>" + $( window ).width() + " Desktop</div>" );
    		$("#divSearchMobile > div").detach().appendTo('#divSearch');
    	}
    }  


    
    var counter = 0;
    function changeColorClick(){
        var colors = ['#16a085','#ca6f1e','#6c3483','#0000FF','#d4ac0d',' #ff7043','#607d8b','#935116','#004d40'];
        var len = colors.length;
            $('.changeColorCategHome').css({
           	 backgroundImage:"linear-gradient(to bottom,"+colors[counter]+",#ffffff)"
          });
            counter++;
            //reset counter
            if(counter==len)
              counter = 0;
        
   };

   
   function blockPanel(){
		rc();
	}

   
   $(function() {    
	    addInfoViaElement = function() {
	        document.getElementById('search:growlel').show([{severity: 'info', summary: '', detail: 'Producto agregado al carrito'}])
	    };
	});

