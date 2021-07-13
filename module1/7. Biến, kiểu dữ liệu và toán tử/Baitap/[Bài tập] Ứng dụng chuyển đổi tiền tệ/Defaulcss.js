'use strict'
var $ = function(id){
    return document.getElementById(id);
};
function Calculate(){
    var typeElement = $('typefrom');
    var moneyElement = parseFloat($('money').value);
    var toElement = $('typeto');
    var totalElement = $('total');
    if(!isNaN(moneyElement)){
        switch(typeElement.value) {
            case "Vietnam" : {
                if(toElement.value =='USD'){
                    totalElement.value = parseFloat(moneyElement/23000).toLocaleString();
                }
                else if(toElement.value =='Batthailan'){
                    totalElement.value = parseFloat(moneyElement/740).toLocaleString();
                }
                else if(toElement.value =='dong'){
                    totalElement.value = parseFloat(moneyElement=moneyElement).toLocaleString();
                }
                break;
            }
            case "My" : {
                if(toElement.value =='dong'){
                    totalElement.value = parseFloat(moneyElement*23000).toLocaleString();
                }
                else if(toElement.value =='Batthailan'){
                    totalElement.value = parseFloat(moneyElement*31.04).toLocaleString();
                }
                else if(toElement.value =='USD'){
                    totalElement.value = parseFloat(moneyElement=moneyElement).toLocaleString();
                }
                break;
            }
            case "ThaiLan" : {
                if(toElement.value =='dong'){
                    totalElement.value = parseFloat(moneyElement*740).toLocaleString();
                }
                else if(toElement.value =='Batthailan'){
                    totalElement.value = parseFloat(moneyElement=moneyElement).toLocaleString();
                }
                else if(toElement.value =='USD'){
                    totalElement.value = parseFloat(moneyElement/31.04).toLocaleString();
                }
                break;
            }
            $('total').innerHTML = totalElement;
        }

    }

}