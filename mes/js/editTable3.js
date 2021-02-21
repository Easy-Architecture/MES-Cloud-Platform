function createRow(){
	var editTable=document.getElementById("tbody");
	var tr=document.createElement("tr");
	var td0=document.createElement("td");
	var checkbox=document.createElement("input");
	checkbox.type="checkbox";
	checkbox.name="checkRow";
	td0.appendChild(checkbox);
	var td1=document.createElement("td");
	td1.innerHTML="编号";
	var td2=document.createElement("td");
	td2.innerHTML="名称";
	var td3=document.createElement("td");
	td3.innerHTML="制作";
    var td4=document.createElement("td");
	td4.innerHTML="快递";
    var td5=document.createElement("td");
	td5.innerHTML="地址";
	tr.appendChild(td0);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
	editTable.appendChild(tr);
}
 
function delRow(){
	var editTable=document.getElementById("tbody");
	if(confirm("确认删除所选?")){
		var checkboxs=document.getElementsByName("checkRow");
		for(var i=0;i<checkboxs.length;i++){
			if(checkboxs[i].checked){
				var n=checkboxs[i].parentNode.parentNode;
				editTable.removeChild(n);
				i--;
			}
		}
		
	}
}