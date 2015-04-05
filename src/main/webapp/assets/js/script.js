/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function toggleCreateLabel() {
    var obj = $("#create-label");
    if(obj.hasClass("hidden")){
        $("#create-label").removeClass("hidden");
    }else{
        $("#create-label").addClass("hidden");
    }
    
}

//$(document).ready(function(){
//    $("#create-label").hide();
//});
