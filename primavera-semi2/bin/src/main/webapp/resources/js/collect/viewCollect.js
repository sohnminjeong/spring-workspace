//contents
function _class(name){
	  return document.getElementsByClassName(name);
	}

	let tabPanes = _class("tab-header")[0].getElementsByTagName("div");

	for(let i=0;i<tabPanes.length;i++){
	  tabPanes[i].addEventListener("click",function(){
	    _class("tab-header")[0].getElementsByClassName("active")[0].classList.remove("active");
	    tabPanes[i].classList.add("active");
	    
	    _class("tab-indicator")[0].style.top = `calc(95px + ${i*53}px)`;
	    
	    _class("tab-content")[0].getElementsByClassName("active")[0].classList.remove("active");
	    _class("tab-content")[0].getElementsByTagName("div")[i].classList.add("active");
	    
	  });
	}
	
// button
document.querySelectorAll('button').forEach(a => a.innerHTML = '<div><span>' + a.textContent.trim().split('').join('</span><span>') + '</span></div>');