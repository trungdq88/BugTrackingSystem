/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function toggleCreateLabel() {
    var obj = $("#create-label");
    if (obj.hasClass("hidden")) {
        $("#create-label").removeClass("hidden");
    } else {
        $("#create-label").addClass("hidden");
    }
    var color = generateLabel();
    var value = color.bg + "|" + color.text;
    $("#demo-color").attr("style", "background-color: " + color.bg + ";" + "color:" + color.text);
    $("#label-color").val(value);
}

function toggleCreateMilestone() {
    var obj = $("#create-milstone");
    if (obj.hasClass("hidden")) {
        $("#create-milstone").removeClass("hidden");
    } else {
        $("#create-milstone").addClass("hidden");
    }   
}

